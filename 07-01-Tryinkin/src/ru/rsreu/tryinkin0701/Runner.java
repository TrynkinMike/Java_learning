package ru.rsreu.tryinkin0701;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.prutzkow.resourcer.Resourcer;

public final class Runner {
	public static final int DEVICES_COUNT = 5;

	private Runner() {

	}

	public static void main(String[] args) {
		StringBuilder output = new StringBuilder();
		List<MethodologicalGuidelines> methodologicalGuidelines = new ArrayList<MethodologicalGuidelines>();
		List<MethodologicalGuidelines> equipmentShortened;
		Comparator<MethodologicalGuidelines> temp = new MethodologicalGuidelinesComparator();

		for (int i = 0; i < DEVICES_COUNT; i++) {
			methodologicalGuidelines.add(MethodologicalGuidelineInitializer.initializeRandomMethodologicalGuideline());
		}

		output.append(
				MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter.print(methodologicalGuidelines));

		methodologicalGuidelines.sort(null);
		output.append(Resourcer.getString("message.output.defaultSortedList"));
		output.append(
				MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter.print(methodologicalGuidelines));

		methodologicalGuidelines.sort(temp);
		output.append(Resourcer.getString("message.output.twoFieldsSortedList"));
		output.append(
				MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter.print(methodologicalGuidelines));

		Map<String, MethodologicalGuidelines> map = MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter
				.makeMapFromList(methodologicalGuidelines);
		output.append(MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter.findValue(map,
				MethodologicalGuidelineInitializer.getNumber(0)));
		output.append(MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter.findValue(map,
				MethodologicalGuidelineInitializer.getNotUsedNumber()));

		output.append(Resourcer.getString("message.output.listOfDescriptions"));
		output.append(MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter
				.printDescriptionSet(methodologicalGuidelines));

		output.append(Resourcer.getString("message.output.shortenedList"));
		equipmentShortened = MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter
				.removeMethodologicalGuidelineOfCurrentDiscipline(methodologicalGuidelines,
						Resourcer.getString("enum.Disciplines.MATH"));
		output.append(MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter.print(equipmentShortened));

		System.out.print(output);
	}
}
