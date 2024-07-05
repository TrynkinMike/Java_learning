package ru.rsreu.tryinkin0318;

public class Runner {
	private Runner() {
		
	}

	public static void main(String[] args) {

		StringBuilder output = new StringBuilder();

		OneDimentionalArrayElementsBetweenNegativeOnesMultipiler arrayObject = new OneDimentionalArrayElementsBetweenNegativeOnesMultipiler(
				3, -2, 4, -1, -1);
		
		int[] negativeElementsIndices = arrayObject.findNegativeElementIndices();		
		
		output.append(arrayObject.toString()).append("\n");

		output.append(arrayObject.getStringWithElementsBetweenNegativesMultiplicationResult(negativeElementsIndices));

		System.out.println(output);
	}
}
