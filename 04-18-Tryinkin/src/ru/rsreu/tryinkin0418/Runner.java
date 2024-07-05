package ru.rsreu.tryinkin0418;

/**
 * 
 * @author Tryinkin Mikhail
 * 
 * A main class of program.
 */
public class Runner {
	public static void main(String[] args) {
		
		int[] sizes = {4,4};
		ColsWithMaximalAndMinimalElementsAlikeAverageValueFinder matrix = new ColsWithMaximalAndMinimalElementsAlikeAverageValueFinder(sizes);
		StringBuilder output = new StringBuilder();
		
		matrix.fill(0, 10);
		
		output.append(matrix.toString()).append(matrix.getValidColsIndices());		
		System.out.print(output);
	}
}
