package ru.rsreu.tryinkin0618;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.prutzkow.resourcer.Resourcer;

public class DeviceInitializer {
	private static Set<String> usedMacAdresses = new HashSet<String>();
	private static String[] macAdresses = {"8A:9A:68:8A:75:FE", "8A:0A:4F:D7:81:B2", "8A:0B:25:59:F3:08", "8A:2C:B3:BF:59:22", "8A:67:71:B8:DA:90"};
	private static final String NOT_USED_MAC_ADRESS = "3D:F2:C9:A6:B3:4F";
	private static String[] descriptions = 
		{"Сервер в комнате 1", "Сервер в комнате 2", "Сервер на цокольном этаже", "Сервер Петрова", "Запасной элемент"};
	private static int[] types = {0, 1, 2};
	
	private DeviceInitializer() {
		
	}
	
	public static NetworkEquipment initializeRandomDevice() {
		Random random = new Random();
		String macAdress;
		String description;
		int type;
		
		while (true) {
			macAdress = DeviceInitializer.macAdresses[random.nextInt(DeviceInitializer.macAdresses.length)];
			if (!DeviceInitializer.usedMacAdresses.contains(macAdress)) {
				DeviceInitializer.usedMacAdresses.add(macAdress);
				break;
			}
		}
		description = DeviceInitializer.descriptions[random.nextInt(DeviceInitializer.descriptions.length)];
		type = DeviceInitializer.types[random.nextInt(DeviceInitializer.types.length)];
		NetworkEquipment temp = new NetworkEquipment(macAdress, description, DeviceInitializer.getDeviceTypeByNumber(type));
		return temp;
	}
	
	public static String getMacAdress(int index) {
		return DeviceInitializer.macAdresses[index];
	}
	
	public static String getNotUsedMacAdress() {
		return DeviceInitializer.NOT_USED_MAC_ADRESS;
	}
	
	private static String getDeviceTypeByNumber(int type) {
		if (type == DeviceTypes.AMPLIFIER.ordinal()) {
			return Resourcer.getString("enum.DeviceTypes.AMPLIFIER");
		} else if (type == DeviceTypes.ROUTER.ordinal()) {
			return Resourcer.getString("enum.DeviceTypes.ROUTER");
		} else {
			return Resourcer.getString("enum.DeviceTypes.CONCENTRATOR");
		}
	}
}
