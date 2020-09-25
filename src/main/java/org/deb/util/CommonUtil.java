/**
 * 
 */
package org.deb.util;

import java.io.File;

/**
 * @author Debmalya
 *
 */
public class CommonUtil {

	private CommonUtil() {

	}

	public static String getTitle(String fileName) {
		String title = "Media Player Tutorial";
		if (null != fileName) {
			int fileNameStartingPosition = fileName.lastIndexOf(File.separator);
			if (fileNameStartingPosition > -1) {
				title = fileName.substring(fileNameStartingPosition + 1);
			} else {
				fileNameStartingPosition = fileName.lastIndexOf("/");
				if (fileNameStartingPosition > -1) {
					title = fileName.substring(fileNameStartingPosition + 1);
				}
			}
		}
		return title;
	}

	public static String getTitleFromFile(String fileName) {
		if (null != fileName) {
			File file = new File(fileName);
			return file.getName();
		}
		return "";
	}

	public static Integer a2i(String str) {
		Integer n = null;
		try {
			n = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
            System.err.println(String.format("'%s' is not a number. Please provide a numeric value.",str));
		}
		return n;
	}

}
