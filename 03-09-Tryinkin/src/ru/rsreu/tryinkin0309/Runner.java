package ru.rsreu.tryinkin0309;

import com.prutzkow.resourcer.Resourcer;

public class Runner {
	private Runner() {

	}

	public static void main(String[] args) {

		StringBuilder output = new StringBuilder();

		ArrayElementsWithoutRepetitionsPrinter arrayObject = new ArrayElementsWithoutRepetitionsPrinter(1, 9, 1, 9);
		output.append(Resourcer.getString("message.existingArray")).append(arrayObject.toString()).append("\n");

		output.append(Resourcer.getString("message.elementsWithoutRepetitions"))
				.append(arrayObject.printOnlyUniqueElements());

		System.out.println(output);
	}
}
