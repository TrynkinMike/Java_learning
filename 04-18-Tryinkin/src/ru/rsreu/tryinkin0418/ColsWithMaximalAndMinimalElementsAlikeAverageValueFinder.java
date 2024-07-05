package ru.rsreu.tryinkin0418;

import com.prutzkow.resourcer.Resourcer;
import com.prutzkow.twodimarray.Matrix;
/**
 * 
 * A container of methods to find the indices of columns with alike elements of matrix.
 *
 */
public class ColsWithMaximalAndMinimalElementsAlikeAverageValueFinder extends Matrix {
/**
 * The percentage by which an element may differ.
 */
	public final int PERCENT_DIFFERENCE = 50;
	/**
	 * 
	 * @param sizes An array of two elements: matrix size X and Y
	 * @throws IllegalArgumentException
	 */
	public ColsWithMaximalAndMinimalElementsAlikeAverageValueFinder(int[] sizes) 
		throws IllegalArgumentException{
			super(sizes[0], sizes[1]);
	}
	/**
	 * Finds indices of matrix columns containing minimal and maximal elements alike average value.
	 * @return the indices of found columns of the matrix
	 */
	public String getValidColsIndices() {
		StringBuilder result = new StringBuilder();

		result.append(makeStringOfValidIndices());
				
		if (result.length() == 0) {
			return(Resourcer.getString("message.noValidCols"));	
		}
		else {
			return result.insert(0,(Resourcer.getString("message.foundCols"))).toString();
		}
	}
	/**
	 * Fills the matrix with random values in range [minValue,maxValue].
	 * @param minValue A minimal value of matrix
	 * @param maxValue A maximal value of matrix
	 */
	public void fill(int minValue, int maxValue) {
		for(int i = 0; i < super.getRowCount(); i++) {
			for (int j = 0; j < super.getRowLength(0); j++) {
				super.arrayBody[i][j] = (int)((Math.random() * (maxValue - minValue)) + minValue);
			}
		}
	}
	/**
	 * Converts a matrix to a string for a better output.
	 * @return Formatted string containing all matrix elements
 	 */
	public String toString() {
		StringBuilder result = new StringBuilder(Resourcer.getString("message.maxElementOfFirstRowIs")).append(this.getMaxValue(super.arrayBody[0])).append("\n");
		
		for(int i = 0; i < super.getRowCount(); i++) {
			for (int j = 0; j < super.getRowLength(0); j++) {
				result.append(super.arrayBody[i][j]).append(" ");
			}
			result.append("\n");
		}
		
		return result.toString();
	}
	/**
	 * Finds the maximal value of a column of matrix.
	 * @param col An one-dimensional array of elements of a column of matrix
	 * @return Maximal value of the column
	 */
	private int getMaxValue(int[] col) {
		int max = col[0];

		for (int element : col) {
			if (max < element) {
				max = element;
			}
		}
		return max;
	}
	/**
	 * Finds the minimal value of a column of matrix.
	 * @param col An one-dimensional array of elements of a column of matrix
	 * @return Minimal value of the column
	 */
	private int getMinValue(int[] col) {
		int min = col[0];

		for (int element : col) {
			if (min > element) {
				min = element;
			}
		}
		return min;
	}
	/**
	 * Finds the average value of a column of matrix.
	 * @param col An one-dimensional array of elements of a column of matrix
	 * @return Average value of the column
	 */
	private float getAverageValue(int[] col) {
		float average = 0;
		for (int element : col) {
			average += element;
		}
		average /= col.length;
		return average;
	}
	/**
	 * Finds out if the maximal element differs less then PERCENT_DIFFERENCE from the average one.
	 * @param max Maximal value of the column
	 * @param average Average value of the column
	 * @return true if the maximal element of the column is alike the average value of the column
	 * 			false otherwise
	 */
	private boolean checkMaxAlikeAverage(int max, float average) {
		return ((average / max * 100) >= PERCENT_DIFFERENCE);
	}
	/**
	 * Finds out if the minimal element differs less then PERCENT_DIFFERENCE from the average one
	 * @param min Minimal value of the column
	 * @param average Average value of the column
	 * @return true if the minimal element of the column is alike the average value of the column.
	 * 			false otherwise
	 */
	private boolean checkMinAlikeAverage(int min, float average) {
		return ((min / average * 100) >= PERCENT_DIFFERENCE);
	}
	/**
	 * Finds out if the column of matrix consists minimal and maximal elements alike average.
	 * @param col An one-dimensional array of elements of a column of matrix
	 * @return true if the minimal and maximal elements of the column are alike the average value of the column
	 * 			false otherwise
	 */
	private boolean isColValid(int[] col) {
		int max = this.getMaxValue(col);
		int min = this.getMinValue(col);
		float average = this.getAverageValue(col);
		
		return ((this.checkMaxAlikeAverage(max, average)) && (this.checkMinAlikeAverage(min, average)));
	}
	/**
	 * Creates a string containing valid indices values.
	 * @return String with valid columns indices
	 */
	private StringBuilder makeStringOfValidIndices() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < super.getRowCount(); i++) {
			int[] col = new int[super.getRowLength(i)];
			for (int j = 0; j < super.getRowLength(i); j++) {
				col[j] = this.arrayBody[j][i];
			}
			if (this.isColValid(col)) {
				result.append(i + " ");
			}
		}
		return result;
	}

}
