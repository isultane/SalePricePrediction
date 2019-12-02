package csv.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadCSVs {

	static BufferedWriter writer = null;
	static BufferedReader br = null;
	static File file = new File("dataset.csv");

	public static void ReadWriteFile(String csv_file) throws IOException {
		String comma = ",";
		File fin = new File(csv_file);
		FileInputStream fis = new FileInputStream(fin);
		BufferedReader in = new BufferedReader(new InputStreamReader(fis));

		FileWriter fstream = new FileWriter(file, true);
		BufferedWriter out = new BufferedWriter(fstream);

		String aLine = null;
		// combine all data (1443 to 1438) into one file. 
		while ((aLine = in.readLine()) != null) {
			String[] line = aLine.split(comma);
			out.write(line[5] + "," + line[7]);
			out.newLine();
		}

		// Closing the buffer reader
		in.close();

		// Closing the buffer writer
		out.close();

	}

	public static void main(String[] args) throws IOException {
		File dataset_folder = new File(
				"PATH TO DATASET");

		for (File fileEntry : dataset_folder.listFiles()) {
			if (fileEntry.getName().contains(".csv")) {
				System.out.println("Reading and analyzing file name "
						+ fileEntry.getName() + " ...");
				ReadWriteFile(fileEntry.getAbsolutePath());
			}
		}
	}
}
