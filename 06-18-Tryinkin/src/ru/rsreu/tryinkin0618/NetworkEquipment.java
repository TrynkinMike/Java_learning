package ru.rsreu.tryinkin0618;

import java.io.Serializable;

import com.prutzkow.resourcer.Resourcer;

public final class NetworkEquipment implements Serializable {
	private static final long serialVersionUID = 1L;

	private String macAddress = "";
	private String description = "";
	private String type = "";

	public NetworkEquipment(String macAddress, String description, String type) {
		this.macAddress = macAddress;
		this.description = description;
		this.type = type;
	}

	public NetworkEquipment() {
	}

	public String getmacAddress() {
		return this.macAddress;
	}

	public String getDescription() {
		return this.description;
	}

	public String getType() {
		return this.type;
	}

	public String toString() {
		StringBuilder output = new StringBuilder();
		String temp;
		temp = String.format("%-35s", Resourcer.getString("message.part.macAddress"));
		output.append(temp);
		temp = String.format("%-35s", this.macAddress);
		output.append(temp);
		output.append("\n");

		temp = String.format("%-35s", Resourcer.getString("message.part.description"));
		output.append(temp);
		temp = String.format("%-35s", this.description);
		output.append(temp);
		output.append("\n");

		temp = String.format("%-35s", Resourcer.getString("message.part.type"));
		output.append(temp);
		temp = String.format("%-35s", this.type);
		output.append(temp);
		output.append("\n");

		return output.toString();
	}

	public boolean compareTo(NetworkEquipment deviceCopied, NetworkEquipment deviceMoved) {
		if (this.getHashCode() != deviceCopied.getHashCode() || this.getHashCode() != deviceMoved.getHashCode()) {
			return false;
		}
		if (!(this.macAddress.equals(deviceCopied.macAddress) && this.macAddress.equals(deviceMoved.macAddress)
				&& deviceCopied.macAddress.equals(deviceMoved.macAddress))) {
			return false;
		}
		if (!(this.description.equals(deviceCopied.description) && this.description.equals(deviceMoved.description)
				&& deviceCopied.description.equals(deviceMoved.description))) {
			return false;
		}
		if (!(this.type.equals(deviceCopied.type) && this.type.equals(deviceMoved.type)
				&& deviceCopied.type.equals(deviceMoved.type))) {
			return false;
		}

		return true;
	}

	public static String getStringWithAllMacAdresses(NetworkEquipment devices, NetworkEquipment deviceCopied,
			NetworkEquipment deviceMoved) {
		StringBuilder output = new StringBuilder();
		String temp = "";

		temp = String.format("%-35s", Resourcer.getString("message.part.macAddress"));
		output.append(temp);

		temp = String.format("%-35s", devices.getmacAddress());
		output.append(temp);

		temp = String.format("%-35s", deviceCopied.getmacAddress());
		output.append(temp);

		temp = String.format("%-35s", deviceMoved.getmacAddress());
		output.append(temp);

		return output.toString();
	}

	public static String getFirstStringOfDeviceDescription() {
		StringBuilder output = new StringBuilder();
		String temp = "";

		temp = String.format("%-35s", " ");
		output.append(temp);

		temp = String.format("%-35s", Resourcer.getString("message.part.fileSource.created"));
		output.append(temp);

		temp = String.format("%-35s", Resourcer.getString("message.part.fileSource.copied"));
		output.append(temp);

		temp = String.format("%-35s", Resourcer.getString("message.part.fileSource.moved"));
		output.append(temp);

		return output.toString();
	}

	public static String getStringWithAllDescriptions(NetworkEquipment devices, NetworkEquipment deviceCopied,
			NetworkEquipment deviceMoved) {
		StringBuilder output = new StringBuilder();
		String temp = "";

		temp = String.format("%-35s", Resourcer.getString("message.part.description"));
		output.append(temp);

		temp = String.format("%-35s", devices.getDescription());
		output.append(temp);

		temp = String.format("%-35s", deviceCopied.getDescription());
		output.append(temp);

		temp = String.format("%-35s", deviceMoved.getDescription());
		output.append(temp);

		return output.toString();
	}

	public static String getStringWithAllTypes(NetworkEquipment devices, NetworkEquipment deviceCopied,
			NetworkEquipment deviceMoved) {
		StringBuilder output = new StringBuilder();
		String temp = "";

		temp = String.format("%-35s", Resourcer.getString("message.part.type"));
		output.append(temp);

		temp = String.format("%-35s", devices.getType());
		output.append(temp);

		temp = String.format("%-35s", deviceCopied.getType());
		output.append(temp);

		temp = String.format("%-35s", deviceMoved.getType());
		output.append(temp);

		return output.toString();
	}

	public int getHashCode() {
		return (this.macAddress.hashCode() + this.description.hashCode() + this.type.hashCode());
	}

	public String getMacAddress() {
		return this.macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getThisDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.macAddress = description;
	}

	public String getThisType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
