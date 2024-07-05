package ru.rsreu.tryinkin0218;

import java.util.Scanner;
import com.prutzkow.resourcer.Resourcer;

public class Runner {
	
	public static final char SEPARATING_CHAR = ' ';

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int substringLength;

		System.out.print(Resourcer.getString("message.stringCountInput"));
		int stringCount = Integer.parseInt(in.next());
		if (!InputValidator.isStringCountVerified(stringCount)) {
			System.out.print(Resourcer.getString("message.invalidStringCount"));
			in.close();
			return;
		}

		in.nextLine();

		String[] stringArray = new String[stringCount];
		for (int i = 0; i < stringArray.length; i++) {
			System.out.print(Resourcer.getString("message.enterTheString") + (i + 1) + " :");
			stringArray[i] = in.nextLine();
		}

		System.out.print(Resourcer.getString("message.substringLengthInput"));
		substringLength = Integer.parseInt(in.next());
		if (!InputValidator.isSubstringLengthVerified(substringLength)) {
			System.out.print(Resourcer.getString("message.invalidSubstringLength"));
			in.close();
			return;
		}
		in.close();

		String[] stringArraySeparated = stringArray;
		String[] stringArrayDeleted = stringArray;
		String[] stringArrayMatched = stringArray;

		for (int i = 0; i < stringCount; i++) {
			result.append("\nСтрока " + (i + 1) + ":\n")
					.append(StringIntoSubstringsWithLengthOfNoMoreThanSpecifiedSeparator.separateStringBySeparatingChar(stringArraySeparated[i], substringLength, Runner.SEPARATING_CHAR))
					.append(StringWordsWithCharsNotInAlphabetOrderDeleter.deleteInvalidWords(stringArrayDeleted[i]))
					.append(StringToStateNumberMatcher.matchesStateNumber(stringArrayMatched[i]));
		}

		System.out.print(result.toString());

	}

}