package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sala {
	private static ArrayList<String> Salinhas = new ArrayList<String>();

	public static ArrayList<String> getSalinhas() {
		return Salinhas;
	}

	public static void setSalinhas(ArrayList<String> Salinhas) {
		Sala.Salinhas = Salinhas;
	}

	public static void loadFile() throws FileNotFoundException {
		File file = new File("salas.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine())
		{
			String line = input.nextLine();
			String[] fields = line.split("#");
		Salinhas.add(new String(fields[1]));
		}
		input.close();
	}

	public static void saveFile() {

		PrintWriter out = null;
		try {
			out = new PrintWriter("salas.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String String : Salinhas) {
			out.println();
		}
		out.close();

}
}



