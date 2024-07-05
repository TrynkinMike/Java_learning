package ru.rsreu.tryinkin0718;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.prutzkow.resourcer.Resourcer;

public final class EquipmentInformationSorterDeleterSearcherAndPrinter {
	
	private EquipmentInformationSorterDeleterSearcherAndPrinter() {
		
	}
	
	public static String print(List<NetworkEquipment> equipment) {
		StringBuilder result = new StringBuilder();
		Iterator<NetworkEquipment> iterator = equipment.iterator();
		while (iterator.hasNext()) {
			String info = iterator.next().toString();
			result.append(info);
			result.append("\n");
		}
		return result.toString();
	}
	
	public static String printDefaultSorted(List<NetworkEquipment> equipment) {
		equipment.sort(null);
		StringBuilder result = new StringBuilder();
		Iterator<NetworkEquipment> iterator = equipment.iterator();
		while (iterator.hasNext()) {
			String info = iterator.next().toString();
			result.append(info);
			result.append("\n");
		}
		return result.toString();
	}
	
	public static String printDescriptionSet(List<NetworkEquipment> equipment) {
		Set<String> descriptions = new HashSet<String>();
		Iterator<NetworkEquipment> iterator = equipment.iterator();
		while (iterator.hasNext()) {
			descriptions.add(iterator.next().getDescription());
		}			
		return descriptions.toString();
	}
	
	public static List<NetworkEquipment> removeDevicesOfCurrentType(List<NetworkEquipment> equipment, String type) {
		Iterator<NetworkEquipment> iterator = equipment.iterator();
		while (iterator.hasNext()) {
			if (type.hashCode() == iterator.next().getType().hashCode()) {
				iterator.remove();
			}				
		}
		return equipment;
	}
	
	public static Map<String, NetworkEquipment> makeMapFromList(List<NetworkEquipment> equipment) {
		Map<String, NetworkEquipment> map = new HashMap<String, NetworkEquipment>();
		Iterator<NetworkEquipment> iterator = equipment.iterator();
		NetworkEquipment temp;
		while (iterator.hasNext()) {
			temp = iterator.next();
			map.put(temp.getMACaddress(), temp);
		}
		return map;
	}
	
	public static String findValue(Map<String, NetworkEquipment> map, String key) {
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
