package ru.rsreu.tryinkin0718;

import com.prutzkow.resourcer.Resourcer;

public final class NetworkEquipment implements Comparable<NetworkEquipment> {

	private String macAddress = "";
	private String description = "";
	private String type = "";

	NetworkEquipment(String macAddress, String description, String type) {
		this.macAddress = macAddress;
		this.description = description;
		this.type = type;
	}
	
	public NetworkEquipment() {
		// constructor needed in initializer
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		String temp;
		temp = String.format("%-20s", Resourcer.getString("message.part.MACaddress"));
		output.append(temp);
		temp = String.format("%-20s", this.macAddress);
		output.append(temp);
		output.append("\n");
		
		temp = String.format("%-20s", Resourcer.getString("message.part.description"));
		output.append(temp);
		temp = String.format("%-20s", this.description);
		output.append(temp);
		output.append("\n");
		
		temp = String.format("%-20s", Resourcer.getString("message.part.type"));
		output.append(temp);
		temp = String.format("%-20s", this.type);
		output.append(temp);
		output.append("\n");

		return output.toString();
	}
	
	public int compareTo(NetworkEquipment o) {
		return this.macAddress.compareTo(o.macAddress);
	}
	
	public int compareTo(NetworkEquipment device1, NetworkEquipment device2) {
		int descriptionCompare = device1.getDescription().compareTo(device2.getDescription());
		if (descriptionCompare != 0) {
            return descriptionCompare;
        }		
        return device1.getType().compareTo(device2.getType());
    }

	public String getMACaddress() {
		return this.macAddress;
	}

	public String getDescription() {
		return this.description;
	}

	public String getType() {
		return this.type;
	}	
}
