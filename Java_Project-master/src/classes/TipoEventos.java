package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




public class TipoEventos {
	private static ArrayList<TipoEvento> Inventos = new ArrayList<TipoEvento>();

	public static ArrayList<TipoEvento> getInventos() {
		return Inventos;
	}

	public static void setInventos(ArrayList<TipoEvento> Inventos) {
		TipoEventos.Inventos = Inventos;
	}
	
	
	
	public static TipoEvento addCategory(String name) {
				
		TipoEvento newCategory = new TipoEvento(name);
		Inventos.add(newCategory);
		return newCategory;
	}
	
	public static void removeCategory(TipoEvento c) {
		// TODO need to update all the movies with this category (remove film or put it to 0)
		Inventos.remove(c);
	}
	
	
	
	

	public static void loadFile() throws FileNotFoundException {
		File file = new File("tipoEventos.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine())
		{
			String line = input.nextLine();
			String[] fields = line.split("#");
		  Inventos.add(new TipoEvento(fields[1]));
		}
		input.close();
	}

	public static void saveFile() {

		PrintWriter out = null;
		try {
			out = new PrintWriter("tipoEventos.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (TipoEvento String : Inventos) {
			out.println();
		}
		out.close();

	}

}
