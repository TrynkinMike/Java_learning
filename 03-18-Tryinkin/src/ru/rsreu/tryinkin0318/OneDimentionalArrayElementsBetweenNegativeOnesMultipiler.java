package ru.rsreu.tryinkin0318;

import com.prutzkow.resourcer.Resourcer;

public class OneDimentionalArrayElementsBetweenNegativeOnesMultipiler {
	private static final int UNNECESSARY_CHARS_COUNT = 2;
	
	private int[] arrayBody;

	public OneDimentionalArrayElementsBetweenNegativeOnesMultipiler(int... args) {
		this.arrayBody = new int[args.length];
		setArrayElements(args);
	}
	
	public StringBuilder getStringWithElementsBetweenNegativesMultiplicationResult(int[] negativeElementIndices) {
		StringBuilder output = new StringBuilder();
		if (this.areTwoNegativeElementsInArray(negativeElementIndices)) {
			if (this.areAnyElementsBetweenNegatives(negativeElementIndices)) {
				output.append(Resourcer.getString("message.multiplyingCompleted"))
						.append(this.multiplyArrayElementsBetweenNegatives(negativeElementIndices));
			} else {
				output.append(Resourcer.getString("message.noElementsBetweenNegatives"));
			}
		} else {
			output.append(Resourcer.getString("message.notEnoughNegativeElements"));
		}
		return output;
	}
	
	public int[] findNegativeElementIndices() {
		int [] result = new int[] {-1, -1};
		int negativeElementsCounter = 0;
		
		for (int i = 0; i < arrayBody.length; i++) {
			if (this.arrayBody[i] < 0) {
				negativeElementsCounter += 1;
				if (negativeElementsCounter == 1) {
					result[0] = i;
				} else if (negativeElementsCounter == 2) {
					result[1] = i;
				}
			}
		}		
		return result;
	}
	
	public String toString() {
		String separatingString = ", ";
		
		StringBuilder result = new StringBuilder(Resourcer.getString("message.existingArray"));
		
		for (int element: this.arrayBody) {
			result.append(element).append(separatingString);			
		}
		result.setLength(result.length() - OneDimentionalArrayElementsBetweenNegativeOnesMultipiler.UNNECESSARY_CHARS_COUNT);
		return result.toString();
	}

	private void setArrayElements(int... args) {
		for (int i = 0; i < args.length; i++) {
			this.arrayBody[i] = args[i];
		}
	}
	
	private boolean areTwoNegativeElementsInArray(int[] negativeElementIndices) {
		return (negativeElementIndices[0] != -1) && (negativeElementIndices[1] != -1);
	}

	private boolean areAnyElementsBetweenNegatives(int[] negativeElementIndices) {
		return (negativeElementIndices[1] - negativeElementIndices[0] >= 2);
	}

	private int multiplyArrayElementsBetweenNegatives(int[] negativeElementIndices) {
		int result = 1;
		for (int i = negativeElementIndices[0] + 1; i < negativeElementIndices[1]; i++) {
			result *= arrayBody[i];
		}
		return result;
	}
	
	public int[] getArrayBody() {
		return arrayBody;
	}

	public void setArrayBody(int[] arrayBody) {
		this.arrayBody = arrayBody;
	}
}
