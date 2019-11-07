package com.akp.design_patterns.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializationTest {
	static DemoSingleton instanceOne = DemoSingleton.getInstance();

	public static void main(String[] args)
			throws FileNotFoundException, FileNotFoundException, IOException, ClassNotFoundException {
		String filePath = "C:\\Users\\ashish_patel3\\Desktop\\Temp\\SerializationTestFile.txt";

		System.out.println("object : " + instanceOne);

		// Serialization
		//sserializeObject(filePath);

		// De-Serialization
		deSerializeObject(filePath);
	}

	private static void serializeObject(String filePath) throws FileNotFoundException, IOException {
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
		out.writeObject(instanceOne);
		out.close();
	}

	private static void deSerializeObject(String filePath)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInput in = new ObjectInputStream(new FileInputStream(new File(filePath)));
		DemoSingleton obj = (DemoSingleton) in.readObject();
		System.out.println("Deserialized object : " + obj);
		in.close();
	}
}
