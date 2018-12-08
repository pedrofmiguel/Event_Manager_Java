package projetoI;

import java.awt.EventQueue;
import classes.Evento;
import classes.GeralEvento;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Curso;
import classes.Cursos;
import classes.Evento;
import classes.GeralEvento;
import classes.Sala;
import classes.TipoEvento;
import classes.TipoEventos;
import classes.gestao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.ScrollPane;
import java.awt.Point;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class CriarEventos extends JFrame {

	private JPanel contentPane;
	private JTextField response;
	private JTextField nomeEvento;
	private JTextField preco;
	DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<String> dcmf = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<String> dcmg = new DefaultComboBoxModel<String>();
	private JTable tabela;
	DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sala.loadFile();
					Cursos.loadFile();
					TipoEventos.loadFile();
					CriarEventos frame = new CriarEventos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// public void adicionareventos(){
	// for (String t: TipoEventos.getInventos()) {
	// dcm.addElement(t);
	// }
	// }

	public void adicionarcursos() {
		for (Curso t : Cursos.getCursosESMAD()) {
			// dcmf.addElement(t);
		}
	}

	public void adicionarsalas() {
		for (String t : Sala.getSalinhas()) {
			dcmg.addElement(t);
		}
	}

	/**
	 * Create the frame.
	 */
	public CriarEventos() {
		setTitle("Criar Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCriarEventos = new JLabel("Criar Eventos");
		lblCriarEventos.setForeground(new Color(255, 69, 0));
		lblCriarEventos.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblCriarEventos.setBounds(44, 29, 116, 16);
		contentPane.add(lblCriarEventos);

		JLabel lblNewLabel = new JLabel("Respons\u00E1vel :");
		lblNewLabel.setBounds(64, 87, 116, 16);
		contentPane.add(lblNewLabel);

		response = new JTextField();
		response.setBounds(159, 84, 116, 22);
		contentPane.add(response);
		response.setColumns(10);

		JLabel lblNomeDoEvento = new JLabel("Nome do Evento :");
		lblNomeDoEvento.setBounds(64, 122, 110, 16);
		contentPane.add(lblNomeDoEvento);

		nomeEvento = new JTextField();
		nomeEvento.setBounds(186, 119, 116, 22);
		contentPane.add(nomeEvento);
		nomeEvento.setColumns(10);

		JLabel lblTipoDeEvento = new JLabel("Tipo de Evento :");
		lblTipoDeEvento.setBounds(64, 165, 96, 16);
		contentPane.add(lblTipoDeEvento);

		JLabel lblCurso = new JLabel("Curso :");
		lblCurso.setBounds(64, 213, 56, 16);
		contentPane.add(lblCurso);

		JComboBox<String> eventos = new JComboBox(dcm);
		eventos.setBounds(186, 162, 116, 22);
		contentPane.add(eventos);
		for (int i = 0; i < TipoEventos.getInventos().size(); i++) {
			TipoEvento ola = TipoEventos.getInventos().get(i);
			String tipoev = ola.getEvento();
			eventos.addItem(tipoev);

		}

		JLabel lblCusto = new JLabel("Custo :");
		lblCusto.setBounds(64, 262, 56, 16);
		contentPane.add(lblCusto);

		JComboBox<String> cursos = new JComboBox<String>(dcmf);
		cursos.setBounds(114, 210, 311, 22);
		contentPane.add(cursos);

		for (int i = 0; i < Cursos.getCursosESMAD().size(); i++) {
			Curso o = Cursos.getCursosESMAD().get(i);
			String curs = o.getNome();
			cursos.addItem(curs);

		}

		JComboBox<String> salas = new JComboBox<String>(dcmg);
		salas.setBounds(125, 308, 140, 22);
		contentPane.add(salas);
		for (int i = 0; i < GeralEvento.getEvents().size(); i++) {
			Evento oi = GeralEvento.getEvents().get(i);
			String sals = oi.getSalaa();
			eventos.addItem(sals);

		}

		JComboBox diadata = new JComboBox();
		int dia = 31;
		for (int i = 1; i < dia + 1; i++) {
			diadata.addItem(new Integer(i));
		}
		diadata.setBounds(149, 357, 45, 22);
		contentPane.add(diadata);

		JComboBox mesdata = new JComboBox();
		mesdata.addItem("Janeiro");
		mesdata.addItem("Fevereiro");
		mesdata.addItem("Março");
		mesdata.addItem("Abril");
		mesdata.addItem("Maio");
		mesdata.addItem("Junho");
		mesdata.addItem("Julho");
		mesdata.addItem("Agosto");
		mesdata.addItem("Setembro");
		mesdata.addItem("Outubro");
		mesdata.addItem("Novembro");
		mesdata.addItem("Dezembro");

		mesdata.setBounds(236, 356, 95, 22);
		contentPane.add(mesdata);

		JComboBox anodata = new JComboBox();
		anodata.addItem("2017");
		anodata.addItem("2018");
		anodata.addItem("2019");
		anodata.addItem("2020");
		anodata.addItem("2021");
		anodata.addItem("2022");
		anodata.addItem("2023");
		anodata.addItem("2024");
		anodata.addItem("2025");
		anodata.addItem("2025");
		anodata.addItem("2026");
		anodata.addItem("2027");

		anodata.setBounds(385, 357, 82, 22);
		contentPane.add(anodata);

		JComboBox hora = new JComboBox();
		hora.addItem("00");
		hora.addItem("01");
		hora.addItem("02");
		hora.addItem("03");
		hora.addItem("04");
		hora.addItem("05");
		hora.addItem("06");
		hora.addItem("07");
		hora.addItem("08");
		hora.addItem("09");
		hora.addItem("10");
		hora.addItem("11");
		hora.addItem("12");
		hora.addItem("13");
		hora.addItem("14");
		hora.addItem("15");
		hora.addItem("16");
		hora.addItem("17");
		hora.addItem("18");
		hora.addItem("19");
		hora.addItem("20");
		hora.addItem("21");
		hora.addItem("22");
		hora.addItem("23");
		hora.setBounds(159, 415, 45, 22);
		contentPane.add(hora);

		JComboBox minutos = new JComboBox();
		minutos.addItem("00");
		minutos.addItem("01");
		minutos.addItem("02");
		minutos.addItem("03");
		minutos.addItem("04");
		minutos.addItem("05");
		minutos.addItem("06");
		minutos.addItem("07");
		minutos.addItem("08");
		minutos.addItem("09");
		minutos.addItem("10");
		minutos.addItem("11");
		minutos.addItem("12");
		minutos.addItem("13");
		minutos.addItem("14");
		minutos.addItem("15");
		minutos.addItem("16");
		minutos.addItem("17");
		minutos.addItem("18");
		minutos.addItem("19");
		minutos.addItem("20");
		minutos.addItem("21");
		minutos.addItem("22");
		minutos.addItem("23");
		minutos.addItem("24");
		minutos.addItem("25");
		minutos.addItem("26");
		minutos.addItem("27");
		minutos.addItem("28");
		minutos.addItem("29");
		minutos.addItem("30");
		minutos.addItem("31");
		minutos.addItem("32");
		minutos.addItem("33");
		minutos.addItem("34");
		minutos.addItem("35");
		minutos.addItem("36");
		minutos.addItem("37");
		minutos.addItem("38");
		minutos.addItem("39");
		minutos.addItem("40");
		minutos.addItem("41");
		minutos.addItem("42");
		minutos.addItem("43");
		minutos.addItem("44");
		minutos.addItem("45");
		minutos.addItem("46");
		minutos.addItem("47");
		minutos.addItem("48");
		minutos.addItem("49");
		minutos.addItem("50");
		minutos.addItem("51");
		minutos.addItem("52");
		minutos.addItem("53");
		minutos.addItem("54");
		minutos.addItem("55");
		minutos.addItem("56");
		minutos.addItem("57");
		minutos.addItem("58");
		minutos.addItem("59");
		minutos.setBounds(266, 415, 45, 22);
		contentPane.add(minutos);

		JComboBox diadata1 = new JComboBox();
		int diaa = 31;
		for (int i = 1; i < diaa + 1; i++) {
			diadata1.addItem(new Integer(i));
		}

		diadata1.setBounds(186, 464, 45, 22);
		contentPane.add(diadata1);

		JComboBox meslimite = new JComboBox();
		meslimite.addItem("Janeiro");
		meslimite.addItem("Fevereiro");
		meslimite.addItem("Março");
		meslimite.addItem("Abril");
		meslimite.addItem("Maio");
		meslimite.addItem("Junho");
		meslimite.addItem("Julho");
		meslimite.addItem("Agosto");
		meslimite.addItem("Setembro");
		meslimite.addItem("Outubro");
		meslimite.addItem("Novembro");
		meslimite.addItem("Dezembro");
		meslimite.setBounds(277, 464, 75, 22);
		contentPane.add(meslimite);

		JComboBox anolimite = new JComboBox();
		anolimite.addItem("2017");
		anolimite.addItem("2018");
		anolimite.addItem("2019");
		anolimite.addItem("2020");
		anolimite.addItem("2021");
		anolimite.addItem("2022");
		anolimite.addItem("2023");
		anolimite.addItem("2024");
		anolimite.addItem("2025");
		anolimite.addItem("2025");
		anolimite.addItem("2026");
		anolimite.addItem("2027");

		anolimite.setBounds(395, 464, 96, 22);
		contentPane.add(anolimite);

		JRadioButton gratis = new JRadioButton("Gratuito");
		gratis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (gratis.isSelected())
					;
				preco.setEnabled(false);

			}
		});
		gratis.setBounds(112, 258, 82, 25);
		contentPane.add(gratis);

		JLabel lblPreo = new JLabel("Pre\u00E7o :");
		lblPreo.setBounds(209, 262, 70, 16);
		contentPane.add(lblPreo);

		preco = new JTextField();
		preco.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar(); // cada vez que o utilizador
												// escreve algo é guardado na
												// variavel
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume(); // se o utilizador digitar algo que nao esta
									// entre 0 e 9 o programa nao deixa escrever
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos");

				}
			}
		}

		);
		preco.setBounds(266, 259, 82, 22);
		contentPane.add(preco);
		preco.setColumns(10);

		JLabel lblSala = new JLabel("Sala :");
		lblSala.setBounds(64, 311, 56, 16);
		contentPane.add(lblSala);

		JButton btnCriar = new JButton("Criar Evento");
		btnCriar.setForeground(UIManager.getColor("CheckBox.foreground"));
		btnCriar.setBackground(UIManager.getColor("Button.shadow"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tabela.getSelectedRow() == -1) {
					Evento ev = GeralEvento.addEvento(response.getText(), nomeEvento.getText(),
							eventos.getSelectedItem().toString(), cursos.getSelectedItem().toString(), preco.getText(),
							salas.getSelectedItem().toString(), diadata.getSelectedItem().toString(),
							mesdata.getSelectedItem().toString(), anodata.getSelectedItem().toString(),
							hora.getSelectedItem().toString(), minutos.getSelectedItem().toString(),
							diadata1.getSelectedItem().toString(), meslimite.getSelectedItem().toString(),
							anolimite.getSelectedItem().toString());
					Object[] data = { ev.getResponsavel(), ev.getNome(), ev.getTipoEvent(), ev.getCursoo(),
							ev.getPrecoo(), ev.getSalaa(), ev.getDatadia(), ev.getDatames(), ev.getDataano(),
							ev.getHora(), ev.getMinutos(), ev.getDatalimdia(), ev.getDatalimmes(), ev.getDatalimano() };
					tableModel.addRow(data);
				}

				Evento newEvento = new Evento(response.getText(), nomeEvento.getText(),
						eventos.getSelectedItem().toString(), cursos.getSelectedItem().toString(), preco.getText(),
						salas.getSelectedItem().toString(), diadata.getSelectedItem().toString(),
						mesdata.getSelectedItem().toString(), anodata.getSelectedItem().toString(),
						hora.getSelectedItem().toString(), minutos.getSelectedItem().toString(),
						diadata1.getSelectedItem().toString(), meslimite.getSelectedItem().toString(),
						anolimite.getSelectedItem().toString());
				GeralEvento.getEvents().add(newEvento);

				JOptionPane.showMessageDialog(null, "Evento Criado");
				GeralEvento.GuardarEventos();

			}
		});
		btnCriar.setBounds(186, 548, 110, 41);
		contentPane.add(btnCriar);

		JLabel lblData = new JLabel("Data limite de inscri\u00E7\u00E3o :");
		lblData.setBounds(12, 467, 162, 16);
		contentPane.add(lblData);

		JLabel lblHora = new JLabel("Hora :");
		lblHora.setBounds(114, 418, 56, 16);
		contentPane.add(lblHora);

		// adicionareventos();

		// adicionarcursos();

		JLabel lblH = new JLabel("Horas :");
		lblH.setBounds(64, 418, 62, 16);
		contentPane.add(lblH);

		JLabel lblM = new JLabel("Minutos :");
		lblM.setBounds(209, 418, 56, 16);
		contentPane.add(lblM);

		JLabel lblData_1 = new JLabel("Data :");
		lblData_1.setBounds(64, 360, 56, 16);
		contentPane.add(lblData_1);

		JLabel lblDia = new JLabel("Dia :");
		lblDia.setBounds(118, 360, 56, 16);
		contentPane.add(lblDia);

		JLabel lblMs = new JLabel("M\u00EAs :");
		lblMs.setBounds(198, 360, 56, 16);
		contentPane.add(lblMs);

		JLabel lblDia_1 = new JLabel("Dia :");
		lblDia_1.setBounds(159, 467, 56, 16);
		contentPane.add(lblDia_1);

		JLabel lblMs_1 = new JLabel("M\u00EAs :");
		lblMs_1.setBounds(236, 467, 56, 16);
		contentPane.add(lblMs_1);

		JLabel lblAno = new JLabel("Ano :");
		lblAno.setBounds(344, 360, 56, 16);
		contentPane.add(lblAno);

		JLabel lblAno_1 = new JLabel("Ano :");
		lblAno_1.setBounds(360, 467, 56, 16);
		contentPane.add(lblAno_1);

		String[] columns = { "Responsavel", "Nome", "Tipo Evento", "Curso", "Custo", "Sala", "Data", "Hora",
				"Data Limite" };
		tableModel = new DefaultTableModel(columns, 0);
		tabela = new JTable(tableModel);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabela.setFillsViewportHeight(true);
		refreshTable("");
		tabela.setModel(tableModel);
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowIndex = tabela.getSelectedRow();
				response.setText(tabela.getValueAt(rowIndex, 1).toString());
				nomeEvento.setText(tabela.getValueAt(rowIndex, 2).toString());
				eventos.setSelectedItem(tabela.getValueAt(rowIndex, 3).toString());
				cursos.setSelectedItem(tabela.getValueAt(rowIndex, 4).toString());
				preco.setText(tabela.getValueAt(rowIndex, 5).toString());
				salas.setSelectedItem(tabela.getValueAt(rowIndex, 6));
				diadata.setSelectedItem(tabela.getValueAt(rowIndex, 7));
				mesdata.setSelectedItem(tabela.getValueAt(rowIndex, 7));
				anodata.setSelectedItem(tabela.getValueAt(rowIndex, 7));
				hora.setSelectedItem(tabela.getValueAt(rowIndex, 8));
				minutos.setSelectedItem(tabela.getValueAt(rowIndex, 8));
				diadata1.setSelectedItem(tabela.getValueAt(rowIndex, 9));
				meslimite.setSelectedItem(tabela.getValueAt(rowIndex, 9));
				anolimite.setSelectedItem(tabela.getValueAt(rowIndex, 9));

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(503, 62, 669, 494);
		scrollPane.setViewportView(tabela);
		contentPane.add(scrollPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(12, 587, 97, 41);
		contentPane.add(btnVoltar);

		adicionarsalas();

	}

	private void refreshTable(String string) {
		tableModel.setRowCount(0);
		for (Evento xnxx : GeralEvento.getEvents()) {
			String responsavel = xnxx.getResponsavel();
			String nome = xnxx.getNome();
			String Tipoevento = xnxx.getTipoEvent();
			String curso = xnxx.getCursoo();
			String preço = xnxx.getPrecoo();
			String sala = xnxx.getSalaa();
			String datas = xnxx.getDatadia() + "/" + xnxx.getDatames() + "/"  + xnxx.getDataano();
			String a = xnxx.getHora() + ":" + xnxx.getMinutos();
			String b = xnxx.getDatalimdia() + "/" + xnxx.getDatalimmes() + "/" + xnxx.getDatalimano();
			Object[] data = { responsavel, nome, Tipoevento, curso, preço, sala, datas, a, b };
			tableModel.addRow(data);
		}
	}
}
