package ru.rsreu.tryinkin0718;

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
		List<NetworkEquipment> equipment = new ArrayList<NetworkEquipment>();
		List<NetworkEquipment> equipmentShortened;
		Comparator<NetworkEquipment> temp = new NetworkEquipmentComparator();

		for (int i = 0; i < DEVICES_COUNT; i++) {
			equipment.add(DeviceInitializer.initializeRandomDevice());
		}

		output.append(EquipmentInformationSorterDeleterSearcherAndPrinter.print(equipment));

		equipment.sort(null);
		output.append(Resourcer.getString("message.output.defaultSortedList"));
		output.append(EquipmentInformationSorterDeleterSearcherAndPrinter.print(equipment));
		
		equipment.sort(temp);
		output.append(Resourcer.getString("message.output.twoFieldsSortedList"));
		output.append(EquipmentInformationSorterDeleterSearcherAndPrinter.print(equipment));

		Map<String, NetworkEquipment> map = EquipmentInformationSorterDeleterSearcherAndPrinter
				.makeMapFromList(equipment);
		output.append(
				EquipmentInformationSorterDeleterSearcherAndPrinter.findValue(map, DeviceInitializer.getMacAdress(0)));
		output.append(
				EquipmentInformationSorterDeleterSearcherAndPrinter.findValue(map, DeviceInitializer.getNotUsedMacAdress()));

		output.append(Resourcer.getString("message.output.listOfDescriptions"));
		output.append(EquipmentInformationSorterDeleterSearcherAndPrinter.printDescriptionSet(equipment));

		output.append(Resourcer.getString("message.output.shortenedList"));
		equipmentShortened = EquipmentInformationSorterDeleterSearcherAndPrinter.removeDevicesOfCurrentType(equipment,
				Resourcer.getString("enum.DeviceTypes.ROUTER"));
		output.append(EquipmentInformationSorterDeleterSearcherAndPrinter.print(equipmentShortened));

		System.out.print(output);
	}
}
