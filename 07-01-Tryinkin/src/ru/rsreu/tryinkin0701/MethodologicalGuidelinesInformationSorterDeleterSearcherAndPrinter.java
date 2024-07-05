package ru.rsreu.tryinkin0701;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.prutzkow.resourcer.Resourcer;

public final class MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter {

	private MethodologicalGuidelinesInformationSorterDeleterSearcherAndPrinter() {

	}

	public static String print(List<MethodologicalGuidelines> equipment) {
		StringBuilder result = new StringBuilder();
		Iterator<MethodologicalGuidelines> iterator = equipment.iterator();
		while (iterator.hasNext()) {
			String info = iterator.next().toString();
			result.append(info);
			result.append("\n");
		}
		return result.toString();
	}

	public static String printDefaultSorted(List<MethodologicalGuidelines> equipment) {
		equipment.sort(null);
		StringBuilder result = new StringBuilder();
		Iterator<MethodologicalGuidelines> iterator = equipment.iterator();
		while (iterator.hasNext()) {
			String info = iterator.next().toString();
			result.append(info);
			result.append("\n");
		}
		return result.toString();
	}

	public static String printDescriptionSet(List<MethodologicalGuidelines> equipment) {
		Set<String> descriptions = new HashSet<String>();
		Iterator<MethodologicalGuidelines> iterator = equipment.iterator();
		while (iterator.hasNext()) {
			descriptions.add(iterator.next().getAuthor());
		}
		return descriptions.toString();
	}

	public static List<MethodologicalGuidelines> removeMethodologicalGuidelineOfCurrentDiscipline(
			List<MethodologicalGuidelines> equipment, String discipline) {
		Iterator<MethodologicalGuidelines> iterator = equipment.iterator();
		while (iterator.hasNext()) {
			if (discipline.hashCode() == iterator.next().getDiscipline().hashCode()) {
				iterator.remove();
			}
		}
		return equipment;
	}

	public static Map<String, MethodologicalGuidelines> makeMapFromList(
			List<MethodologicalGuidelines> methodologicalGuideline) {
		Map<String, MethodologicalGuidelines> map = new HashMap<String, MethodologicalGuidelines>();
		Iterator<MethodologicalGuidelines> iterator = methodologicalGuideline.iterator();
		MethodologicalGuidelines temp;
		while (iterator.hasNext()) {
			temp = iterator.next();
			map.put(temp.getNumber(), temp);
		}
		return map;
	}

	public static String findValue(Map<String, MethodologicalGuidelines> map, String key) {
		StringBuilder result = new StringBuilder();
		if (map.containsKey(key)) {
			result.append(Resourcer.getString("message.result.elementFond") + key + "\n");
			result.append(map.get(key).toString());
		} else {
			result.append(Resourcer.getString("message.result.elementNotFond") + key + "\n");
		}
		return result.toString();
	}
}
