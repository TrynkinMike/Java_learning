package ru.rsreu.tryinkin0309;

import java.util.Arrays;

public class ArrayElementsWithoutRepetitionsPrinter {
	private int[] arrayBody;

	public ArrayElementsWithoutRepetitionsPrinter(int... args) {
		this.arrayBody = new int[args.length];
		setArrayElements(args);
	}

	public String toString() {
		String separatingString = ", ";
		StringBuilder result = new StringBuilder();
		
		for (int element : this.arrayBody) {
			result.append(element).append(separatingString);
		}
		result.setLength(result.length() - 2);
		return result.toString();
	}

	public String printOnlyUniqueElements() {
		StringBuilder result = new StringBuilder();

		if (this.areAllElementsUnique()) {
			result.append(this.toString());
		} else {
			ArrayElementsWithoutRepetitionsPrinter tempArray = new ArrayElementsWithoutRepetitionsPrinter();
			tempArray.arrayBody = ArrayElementsWithoutRepetitionsPrinter.getIntArrayWithOnlyUniqueElements(this);
			result.append(tempArray.toString());
		}

		return result.toString();
	}
	
	public int[] getArrayBody() {
		return arrayBody;
	}

	public void setArrayBody(int[] arrayBody) {
		this.arrayBody = arrayBody;
	}

	private boolean areAllElementsUnique() {
		return this.arrayBody.length == ArrayElementsWithoutRepetitionsPrinter.countUniqueElements(this);
	}

	private static int[] getIntArrayWithOnlyUniqueElements(ArrayElementsWithoutRepetitionsPrinter argument) {
		if (argument == null || argument.arrayBody.length == 0) {
			return argument.arrayBody;
		}
		Arrays.sort(argument.arrayBody);

		int[] result = new int[ArrayElementsWithoutRepetitionsPrinter.countUniqueElements(argument)];
		int uniqueElementsCount = 1;

		result[0] = argument.arrayBody[0];

		for (int i = 1; i < argument.arrayBody.length; i++) {
			if (argument.arrayBody[i] != argument.arrayBody[i - 1]) {
				result[uniqueElementsCount++] = argument.arrayBody[i];
			}
		}

		return result;
	}

	private static int countUniqueElements(ArrayElementsWithoutRepetitionsPrinter argument) {
		Arrays.sort(argument.arrayBody);
		int uniqueElementsCount = 1;
		for (int i = 1; i < argument.arrayBody.length; i++) {
			if (argument.arrayBody[i] != argument.arrayBody[i - 1]) {
				uniqueElementsCount++;
			}
		}
		return uniqueElementsCount;
	}

	private void setArrayElements(int... args) {
		for (int i = 0; i < args.length; i++) {
			this.arrayBody[i] = args[i];
		}
	}

}
