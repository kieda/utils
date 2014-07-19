package org.zkieda.util.string;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

public class StringUtil {
	// the line number, starts at 1.

	/**
	 * Finds the line number of an index of a character sequence. Useful for
	 * error/program output.
	 *
	 * @param s
	 *            the CharSequence we are finding the line from.
	 * @param idx
	 *            the index of the charsequence
	 * @return the line number of the char at index idx in s since this is
	 *         mainly meant for error output, we start from line 1 (and not line
	 *         0).
	 *
	 */
	public static int getLineNum(CharSequence s, int idx) {
		int lines = 0;

		char c;

		while (idx != -1) {
			do {
				idx--;
			} while (idx != -1 && (c = s.charAt(idx)) != '\n' && c != '\r');
			lines++;
		}

		return lines;
	}

	/**
	 * returns the line numbers of an index of a char sequence.
	 *
	 * The int[] indices should be sequentially ordered, such that the minimum
	 * element is at index 0, and the largest element is at index
	 * indices.length-1
	 *
	 * @param s
	 *            the charsequence we are analyzing. Must start at index 0.
	 * @param indices
	 *            the sequential list of indices of s we want to find the line
	 *            numbers of
	 * @return a list of line numbers, such that the i^th line number from
	 *         result represents the line number from the i^th index from
	 *         indices.
	 *
	 *         throws NullPointerException if indices or s is null throws
	 *         InvalidArgumentException if indices is not ordered. may throw an
	 *         IndexOutOfBoundsException iff s throws it for indices out of
	 *         bounds.
	 *
	 * @ensures indices is not modified
	 */
	public static int[] getLineNum(CharSequence s, int[] indices) {
		int[] ret = new int[indices.length];
		int line_count = 1;// start on the first line
		int idx = 0;// we keep track of the index of s

		int cur_idx = 0;// we're assuming a charsequence starts at index 0
		// index indices[i]

		char c;// the current char in s

		for (int i = 0; i < indices.length; i++) {
			if (cur_idx > (cur_idx = indices[i]))
				throw new IllegalArgumentException(
						"indices are not well ordered, at index " + (i - 1));
			// if our current index is less than the next element, we know that
			// the indices cannot be ordered. We also set the current index.

			while (idx != cur_idx) {// we get to the current index
				if ((c = s.charAt(idx++)) == '\n' || c == '\r')
					line_count++;
			}
			indices[i] = line_count;// set the line count.
		}

		return ret;
	}

	/**
	 * Return the entire line a specific index belongs to in a charsequence.
	 * Useful for error output in a file.
	 */
	public static CharSequence grabLineOf(CharSequence s, int idx) {
		// idx is our lower bound.

		char c;
		int upper = idx;

		// calculate lower bound
		while (idx != -1 && (c = s.charAt(idx)) != '\n' && c != '\r') {
			idx--;
		}

		idx++;

		while (upper != s.length() && (c = s.charAt(upper)) != '\n'
				&& c != '\r') {
			upper++;
		}

		return s.subSequence(idx, upper);
	}

	/**
	 * flattens a list of CharSequences into one large one. The returned value
	 * is of type SharedChars.
	 */
	public static CharSequence flatten(LinkedList<CharSequence> strs) {
		int len = 0;
		for (CharSequence s : strs) {
			len += s.length();
		}

		char[] ret = new char[len];
		len = 0;
		int k;
		for (CharSequence s : strs) {
			for (k = 0; k < s.length(); k++) {
				ret[len++] = s.charAt(k);
			}
		}

		return new SharedChars(ret).getChars();
	}

	// writes a string list to the stream as if it were flattened.
	public static void write(LinkedList<String> strs, OutputStream os)
			throws IOException {
		try {
			for (String s : strs)
				os.write(s.getBytes());
		} finally {
			os.close();
		}
	}

	/**
	 * returns a new String[] that contains all of the non-null elements of
	 * items, such that the order is preserved.
	 * 
	 * @param items
	 * @return
	 */
	public static String[] filterNull(String[] items) {
		int i = 0;
		for (String e : items) {
			if (e == null)
				i++;
		}
		String[] s = new String[items.length - i];// first calculate the length.

		String g;
		int c = 0;
		for (i = 0; i < items.length; i++) {
			if ((g = items[i]) != null)
				s[c++] = g;
		}
		return s;
	}

	/**
	 * converts a char sequence into a new character array.
	 * 
	 * @param seq
	 * @return
	 * @throws NullPointerException
	 *             if seq is null
	 */
	public static char[] toCharArray(CharSequence seq) {
		char[] c = new char[seq.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = seq.charAt(i);
		}
		return c;
	}
}
