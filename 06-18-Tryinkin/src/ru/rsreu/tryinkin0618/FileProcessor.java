package ru.rsreu.tryinkin0618;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.prutzkow.resourcer.Resourcer;

public class FileProcessor {
	private FileProcessor() {
		
	}
	
	public static void makeDirectories() {
		String currentDirectory = System.getProperty("user.dir");

		String name = currentDirectory + "\\" + Resourcer.getString("files.folder.source.name");
		new File(name).mkdirs();
		System.out.print("Directory " + name + " has been made\n");

		name = currentDirectory + "\\" + Resourcer.getString("files.folder.move.name");
		new File(name).mkdirs();
		System.out.print("Directory " + name + " has been made\n");

		currentDirectory += ("\\" + Resourcer.getString("files.folder.move.name"));
		name = currentDirectory + "\\" + Resourcer.getString("files.folder.copy.name");
		new File(name).mkdirs();
		System.out.print("Directory " + name + " has been made\n");
	}

	public static void makeFileInSourceDirectory(NetworkEquipment[] equipment) throws IOException {
		String currentDirectory = System.getProperty("user.dir");
		String fileName = currentDirectory + "\\" + Resourcer.getString("files.folder.source.name") + "\\"
				+ Resourcer.getString("files.file.data.name") + ".ser";

		FileOutputStream out = new FileOutputStream(fileName);

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(out);
			outputStream.writeObject(equipment);
			System.out.print("File " + fileName + " has been made\n");
			outputStream.close();
		} finally {
			out.close();
		}	
	}

	public static void makeFileInCopyDirectory() throws ClassNotFoundException, IOException {
		/* copying */
		String currentDirectory = System.getProperty("user.dir");
		String fileName = currentDirectory + "\\" + Resourcer.getString("files.folder.source.name") + "\\"
				+ Resourcer.getString("files.file.data.name") + ".ser";

		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
		NetworkEquipment[] temp = (NetworkEquipment[]) inputStream.readObject();

		/* pasting */
		currentDirectory = System.getProperty("user.dir");
		fileName = currentDirectory + "\\" + Resourcer.getString("files.folder.move.name") + "\\"
				+ Resourcer.getString("files.folder.copy.name") + "\\" + Resourcer.getString("files.file.data.name")
				+ Resourcer.getString("files.file.backup.extension");
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(temp);
			System.out.print("File " + fileName + " has been made\n");
			outputStream.close();
		} finally {
			inputStream.close();
		}
	}

	public static void moveFileFromSourceToMove() throws IOException {
		String currentDirectory = System.getProperty("user.dir");
		String sourceDirectory = currentDirectory + "\\" + Resourcer.getString("files.folder.source.name") + "\\"
				+ Resourcer.getString("files.file.data.name") + ".ser";
		String targetDirectory = currentDirectory + "\\" + Resourcer.getString("files.folder.move.name") + "\\"
				+ Resourcer.getString("files.file.data.name") + ".ser";
		Files.move(Paths.get(sourceDirectory), Paths.get(targetDirectory), StandardCopyOption.REPLACE_EXISTING);
		System.out.print("File " + targetDirectory + " has been made\n");
	}

	public static NetworkEquipment[] getDataFromCopiedFile()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		String currentDirectory = System.getProperty("user.dir");
		String fileName = currentDirectory + "\\" + Resourcer.getString("files.folder.move.name") + "\\"
				+ Resourcer.getString("files.folder.copy.name") + "\\" + Resourcer.getString("files.file.data.name")
				+ Resourcer.getString("files.file.backup.extension");

		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
		NetworkEquipment[] temp = (NetworkEquipment[]) inputStream.readObject();
		inputStream.close();
		return temp;

	}

	public static NetworkEquipment[] getDataFromMovedFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		String currentDirectory = System.getProperty("user.dir");
		String fileName = currentDirectory + "\\" + Resourcer.getString("files.folder.move.name") + "\\"
				+ Resourcer.getString("files.file.data.name") + ".ser";

		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
		NetworkEquipment[] temp = (NetworkEquipment[]) inputStream.readObject();

		inputStream.close();
		return temp;
	}
}
