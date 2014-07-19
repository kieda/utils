package org.zkieda.util.string;

/**
 * This class is useful for when we want to have multiple sub-sequences of one
 * large char sequence.
 *
 * A single SharedChars object may create multiple CharSequences that are
 * subsequences of the original char[] array.
 *
 * Note that we do not copy the array on arrival, so modifying the array's
 * contents allows for SharedChar's data to be modified across all char
 * sequences.
 *
 * It is not possible to directly change the char data from an instance of
 * SharedChars.
 *
 * @author zkieda
 */
public class SharedChars {
	/**
	 * the shared data
	 */
	private final char[] data;

	public final int length;

	/**
	 *
	 * @param data
	 *            the data that will be the super-sequence of all sequences in
	 *            this char array.
	 */
	public SharedChars(final char[] data) {
		this.data = data;
		this.length = data.length;
	}

	/**
	 * returns a new CharSequence that is a subsequence of the super-sequence.
	 *
	 * @param pos
	 *            the position in the array to start
	 * @param len
	 *            the length of the charsequence
	 * @return a new CharSequence.
	 */
	public final CharSequence subSequence(final int pos, final int len) {
		return new Chars(pos, len);
	}

	public final CharSequence getChars() {
		return new Chars(0, length);
	}

	/**
	 * A CharSequence that is directly backed by char[] data. this will not
	 * explicitely throw any errors if a person passes in incorrect information
	 */
	private final class Chars implements CharSequence {
		private final int pos, len;

		private Chars(final int pos, final int len) {
			this.pos = pos;
			this.len = len;
		}

		@Override
		public final int length() {
			return len;
		}

		@Override
		public final char charAt(int index) {
			if (index < 0 || index >= pos + len)
				throw new IndexOutOfBoundsException("index = " + index
						+ ", len = " + len);
			return data[index + pos];
		}

		@Override
		public final CharSequence subSequence(int start, int end) {
			if (start < 0 || end > len || end < start)
				throw new IndexOutOfBoundsException("start = " + start
						+ ", end = " + end + ", len = " + len);
			return new Chars(start + pos, end - start);
		}

		private String s = null;

		@Override
		public String toString() {
			if (s == null)
				s = new String(data, pos, len);
			return s;
		}
	}
}
