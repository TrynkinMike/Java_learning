package ru.rsreu.tryinkin0218;

import com.prutzkow.resourcer.Resourcer;

public class StringToStateNumberMatcher {
	public static String matchesStateNumber(String string) {
		String result;
		String StateNumberExample = "[авекмнорстух]\\d{3}[авекмнорстух]{2}\\d{2}rus";

		if (string.matches(StateNumberExample)) {
			result = Resourcer.getString("message.matchesStateNumber");
		} else {
			result = Resourcer.getString("message.dontMatchStateNumber");
		}

		return Resourcer.getString("message.matchingCheck") + result + "\n";
	}
}