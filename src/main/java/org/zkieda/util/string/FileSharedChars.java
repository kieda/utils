package org.zkieda.util.string;

import java.io.File;
import java.io.FileReader;

/**
 * a SharedChars charsequence that is instantiated by opening a file.
 *
 * TODO move to IO
 * @author zkieda
 */
public class FileSharedChars extends SharedChars {
	/**
	 * requires path.isFile()
	 */
	private static char[] getChars(File path) {
		try {
			char[] ret = new char[(int) path.length()];
			FileReader r = new FileReader(path);
			r.read(ret);
			r.close();
			return ret;
		} catch (Exception e) {
			throw new IllegalArgumentException(path
					+ " is not a file, or is invalid.");
		}
	}

	/**
	 * generates a sharedchars object from a file path
	 *
	 * requires path.isFile()
	 *
	 * throws IllegalArgumentException if path is null, or if path is invalid or
	 * unreadable.
	 */
	public FileSharedChars(File path) {
		super(getChars(path));
	}
}
