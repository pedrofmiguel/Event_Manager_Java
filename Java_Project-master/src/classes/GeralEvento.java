package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GeralEvento {
	public static ArrayList<Evento> events = new ArrayList<Evento>();
	public static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();

	public static ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public static void setUtilizadores(ArrayList<Utilizador> utilizadores) {
		GeralEvento.utilizadores = utilizadores;
	}

	public static ArrayList<Evento> getEvents() {
		return events;
	}

	public static void setEvents(ArrayList<Evento> events) {
		GeralEvento.events = events;
	}

	public static Evento addEvento(String responsavel, String nome, String tipoEvent, String cursoo, String precoo,
			String salaa, String datadia, String datames, String dataano, String hora, String minutos,
			String datalimdia, String datalimmes, String datalimano) {

		Evento newEv = new Evento(responsavel, nome, tipoEvent, cursoo, precoo, salaa, datadia, datames, dataano, hora,
				minutos, datalimdia, datalimmes, datalimano);
		events.add(newEv);
		return newEv;
	}

	public static void GuardarEventos() {
		PrintWriter out = null;
		try {
			out = new PrintWriter("evento.txt");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Ficheiro criado");
		}
		for (int i = 0; i < events.size(); i++) {
			Evento e = events.get(i);
			String linha = e.getResponsavel() + "#" + e.getNome() + "#" + e.getTipoEvent() + "#" + e.getCursoo() + "#"
					+ e.getPrecoo() + "#" + e.getSalaa() + "#" + e.getDatadia() + "#" + e.getDatames() + "#"
					+ e.getDataano() + "#" + e.getHora() + "#" + e.getMinutos() + "#" + e.getDatalimdia() + "#"
					+ e.getDatalimmes() + "#" + e.getDatalimano();
			out.println(linha);
		}
		out.close();

	}

	public static void loadEvento() {
		Path path = Paths.get("evento.txt");
		Scanner inputFile = null;

		try {
			if (Files.exists(path)) {

				inputFile = new Scanner(new File("evento.txt"));
				events.clear();
				while (inputFile.hasNextLine()) {

					String line = inputFile.nextLine();

					String[] fields = line.split("#");

					Evento e = new Evento(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6],
							fields[7], fields[8], fields[9], fields[10], fields[11], fields[12], fields[13]);

					events.add(e);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (Files.notExists(path)) {
			File file = new File("evento.txt");
			PrintWriter out = null;
			try {
				out = new PrintWriter("evento.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
