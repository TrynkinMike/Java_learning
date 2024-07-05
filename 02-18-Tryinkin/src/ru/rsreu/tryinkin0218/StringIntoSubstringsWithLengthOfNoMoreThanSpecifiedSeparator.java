package ru.rsreu.tryinkin0218;

import com.prutzkow.resourcer.Resourcer;

public class StringIntoSubstringsWithLengthOfNoMoreThanSpecifiedSeparator {

	public static String separateStringBySeparatingChar(String string, int substringLength, char separatingChar) {
		StringBuilder result = new StringBuilder();
		StringBuilder tempString = new StringBuilder(string);

		tempString = StringIntoSubstringsWithLengthOfNoMoreThanSpecifiedSeparator
				.startSeparating(substringLength, separatingChar, tempString);

		result.append(Resourcer.getString("message.separatedString")).append(tempString).append("\n");

		return result.toString();
	}

	private static StringBuilder startSeparating(int substringLength, char separatingChar,
			StringBuilder tempString) {
		int counter = 0;
		int i = 0;
		while (i < tempString.length()) {
			if (tempString.charAt(i) == separatingChar) {
				counter++;
			}
			if (counter >= substringLength && tempString.charAt(i) == separatingChar) {
				tempString.setCharAt(i, '\n');
				i++;
				counter = 0;
			} else {
				i++;
				counter++;
			}
		}
		return tempString;
	}
}
