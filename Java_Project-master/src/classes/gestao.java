package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class gestao {
	public static ArrayList<login> logins = new ArrayList<login>();

	public static ArrayList<login> getUtilizadores() {
		return logins;

	}

	public static void setUtilizadores(ArrayList<login> logins) {
		gestao.logins = logins;

	}

	// adicionar novo utilizador

	public static login addUtilizadores(String id, String password) {
		login newlogin = new login(id, password);
		logins.add(newlogin);
		return newlogin;
	}

	public static void loadFile() throws FileNotFoundException {
		// carrega o login do ficheiro para a memoria arraylist
		File file = new File("utilizadores.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] fields = line.split("#");
			logins.add(new login(fields[0], fields[1]));
		}
		input.close();
	}

	public static void saveFile() throws FileNotFoundException {
		// carrega utilizador do array list par ao ficheiro
		PrintWriter out = new PrintWriter("utilizadores.txt");
		for (login login : logins) {
			out.println(login.getId() + "#" + login.getPassword() + "#");
		}
		out.close();
	}

}
