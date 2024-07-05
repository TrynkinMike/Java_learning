package ru.rsreu.tryinkin0718;

import java.util.Comparator;

public class NetworkEquipmentComparator implements Comparator<NetworkEquipment> {
	public int compare(NetworkEquipment device1, NetworkEquipment device2) {
		int descriptionCompare = device1.getDescription().compareTo(device2.getDescription());
		if (descriptionCompare != 0) {
            return descriptionCompare;
        }		
        return device1.getType().compareTo(device2.getType());
    }
}
