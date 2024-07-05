package ru.rsreu.tryinkin0618;

import java.io.IOException;
import java.util.Scanner;

import com.prutzkow.resourcer.Resourcer;

public final class Runner {
	public static final int DEVICE_COUNT = 5;

	private Runner() {

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int deviceCount = 0;
		short moveOrNot = -1;
		StringBuilder output = new StringBuilder();

		NetworkEquipment[] equipment = new NetworkEquipment[Runner.DEVICE_COUNT];
		NetworkEquipment[] equipmentFromCopy;
		NetworkEquipment[] equipmentFromMove;

		for (int i = 0; i < Runner.DEVICE_COUNT; i++) {
			equipment[i] = DeviceInitializer.initializeRandomDevice();
		}

		/* creating folders */
		FileProcessor.makeDirectories();

		/* creating file */
		try {
			FileProcessor.makeFileInSourceDirectory(equipment);
		}  catch (IOException e) {
			System.out.print(Resourcer.getString("message.file.error.fileNotCreated"));
		}

		/* copying file */
		try {
			FileProcessor.makeFileInCopyDirectory();
		} catch (ClassNotFoundException | IOException e) {
			System.out.print(Resourcer.getString("message.file.error.fileNotCopied"));
			in.close();
			return;
		}

		/* moving file */
		System.out.print(Resourcer.getString("message.input.decisionToMove"));
		while (true) {
			try {
				moveOrNot = in.nextShort();
				if (moveOrNot == 0) {
					FileProcessor.moveFileFromSourceToMove();
					break;
				} else if (moveOrNot == 1) {
					return;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.print(Resourcer.getString("message.error.invalidDecisionToMove"));
				continue;
			} catch (IOException e) {
				System.out.print(Resourcer.getString("message.file.error.fileNotMoved"));
			}
		}
		in.close();

		/* reading file from Copy */
		equipmentFromCopy = new NetworkEquipment[deviceCount];
		try {
			equipmentFromCopy = FileProcessor.getDataFromCopiedFile();
		} catch (ClassNotFoundException | IOException e) {
			System.out.print(Resourcer.getString("message.file.error.fileNotRead"));
		}
		/* reading file from Move */
		equipmentFromMove = new NetworkEquipment[deviceCount];
		try {
			equipmentFromMove = FileProcessor.getDataFromMovedFile();
		} catch (ClassNotFoundException | IOException e) {
			System.out.print(Resourcer.getString("message.file.error.fileNotRead"));
		}

		/* making table */
		output.append("\n");
		for (int i = 0; i < Runner.DEVICE_COUNT; i++) {
			if (!equipment[i].compareTo(equipmentFromCopy[i], equipmentFromMove[i])) {
				System.out.print(Resourcer.getString("message.output.file.uncomparable"));
				return;
			}
			output.append("\n").append(Resourcer.getString("message.part.number")).append(i + 1);
			output.append("\n");
			output.append(NetworkEquipment.getFirstStringOfDeviceDescription());
			output.append("\n");
			output.append(NetworkEquipment.getStringWithAllMacAdresses(equipment[i], equipmentFromCopy[i],
					equipmentFromMove[i]));
			output.append("\n");
			output.append(NetworkEquipment.getStringWithAllDescriptions(equipment[i], equipmentFromCopy[i],
					equipmentFromMove[i]));
			output.append("\n");
			output.append(
					NetworkEquipment.getStringWithAllTypes(equipment[i], equipmentFromCopy[i], equipmentFromMove[i]));
			output.append("\n");
		}
		output.append(Resourcer.getString("message.output.file.comparable"));
		System.out.print(output);
	}

}
