package ru.rsreu.tryinkin0701;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.prutzkow.resourcer.Resourcer;

public class MethodologicalGuidelineInitializer {
	private static Set<String> usedNumbers = new HashSet<String>();
	private static String[] numbers = { "12-06-58", "33-08-69", "85-09-00", "12-20-02", "77-82-19" };
	private static final String NOT_USED_NUMBER = "00-00-00";
	private static String[] authors = { "Власов Егор Анатольевич", "Шульгин Дмитрий Вячеславович",
			"Зимина Елизавета Кирилловна", "Жданова Ника Артёмовна", "Савельева Анна Алексеевна" };
	private static int[] disciplines = { 0, 1, 2 };

	private MethodologicalGuidelineInitializer() {

	}

	public static MethodologicalGuidelines initializeRandomMethodologicalGuideline() {
		Random random = new Random();
		String number;
		String author;
		int discipline;

		while (true) {
			number = MethodologicalGuidelineInitializer.numbers[random
					.nextInt(MethodologicalGuidelineInitializer.numbers.length)];
			if (!MethodologicalGuidelineInitializer.usedNumbers.contains(number)) {
				MethodologicalGuidelineInitializer.usedNumbers.add(number);
				break;
			}
		}
		author = MethodologicalGuidelineInitializer.authors[random
				.nextInt(MethodologicalGuidelineInitializer.authors.length)];
		discipline = MethodologicalGuidelineInitializer.disciplines[random
				.nextInt(MethodologicalGuidelineInitializer.disciplines.length)];
		MethodologicalGuidelines temp = new MethodologicalGuidelines(number, author,
				MethodologicalGuidelineInitializer.getDisciplineByDigit(discipline));
		return temp;
	}

	public static String getNumber(int index) {
		return MethodologicalGuidelineInitializer.numbers[index];
	}

	public static String getNotUsedNumber() {
		return MethodologicalGuidelineInitializer.NOT_USED_NUMBER;
	}

	private static String getDisciplineByDigit(int type) {
		if (type == Disciplines.MATH.ordinal()) {
			return Resourcer.getString("enum.Disciplines.MATH");
		} else if (type == Disciplines.CHEMISTRY.ordinal()) {
			return Resourcer.getString("enum.Disciplines.CHEMISTRY");
		} else {
			return Resourcer.getString("enum.Disciplines.PROGRAMMING");
		}
	}
}
