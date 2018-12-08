package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;





public class Cursos {
	private static ArrayList<Curso> CursosESMAD = new ArrayList<Curso>();

	public static ArrayList<Curso> getCursosESMAD() {
		return CursosESMAD;
	}

	public static void setCursosESMAD(ArrayList<Curso> CursosESMAD) {
		Cursos.CursosESMAD = CursosESMAD;
	}
	
	public static Curso addCurso(String name) {
			
		Curso newCurso = new Curso(name);
		CursosESMAD.add(newCurso);
		return newCurso;
	}
	
	public static void removeCurso(Curso c) {
		// TODO need to update all the movies with this category (remove film or put it to 0)
		CursosESMAD.remove(c);
	}
	
	
	
	

	public static void loadFile() throws FileNotFoundException {
		File file = new File("cursos.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine())
		{
			String line = input.nextLine();
			String[] fields = line.split("#");
		CursosESMAD.add(new Curso(fields[1]));
		}
		input.close();
	}

	public static void saveFile() {

		PrintWriter out = null;
		try {
			out = new PrintWriter("cursos.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Curso String : CursosESMAD) {
			out.println();
		}
		out.close();

}
}
