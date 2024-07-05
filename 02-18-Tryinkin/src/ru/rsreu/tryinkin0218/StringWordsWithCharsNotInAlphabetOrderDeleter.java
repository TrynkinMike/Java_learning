package ru.rsreu.tryinkin0218;

import com.prutzkow.resourcer.Resourcer;

public class StringWordsWithCharsNotInAlphabetOrderDeleter {
	static final String SEPARATING_CHAR = " ";
	
	public static String deleteInvalidWords(String string) {
		StringBuilder result = new StringBuilder();
		result.append(Resourcer.getString("message.shortenedString")).append(StringWordsWithCharsNotInAlphabetOrderDeleter.startDeletingWords(string)).append("\n");
		return result.toString();
	}

	private static StringBuilder startDeletingWords(String string) {
		StringBuilder result = new StringBuilder();
		String[] words = string.split(SEPARATING_CHAR);
		for (String word : words) {
			if (StringWordsWithCharsNotInAlphabetOrderDeleter.isWordValid(word)) {
				result.append(word).append(SEPARATING_CHAR);
			}
		}
		return result;
	}
	
	private static boolean isWordValid(String word) {
		char[] chars = word.toCharArray();
		for (int i = chars.length - 1; i > 0; --i) {
			if ((chars[i] <= chars[i - 1]) && word.length() != 1) {
				return true;
			}
		}
		return false;
	}
}
