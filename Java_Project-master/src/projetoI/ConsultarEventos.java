package projetoI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import classes.Curso;
import classes.Cursos;
import classes.Evento;
import classes.GeralEvento;
import classes.TipoEvento;
import classes.TipoEventos;
import classes.Sala;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class ConsultarEventos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<String> dcmf = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<String> dcmg = new DefaultComboBoxModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarEventos frame = new ConsultarEventos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
			String datas = xnxx.getDatadia() + "/" + xnxx.getDatames() + "/" + xnxx.getDataano();
			String a = xnxx.getHora() + ":" + xnxx.getMinutos();
			String b = xnxx.getDatalimdia() + "/" + xnxx.getDatalimmes() + "/" + xnxx.getDatalimano();
			Object[] data = { responsavel, nome, Tipoevento, curso, preço, sala, datas, a, b };
			tableModel.addRow(data);
		}
	}

	/**
	 * Create the frame.
	 */
	public ConsultarEventos() {
		setTitle("Consultas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1229, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(67, 552, 97, 45);
		contentPane.add(btnVoltar);

		String[] columns = { "Responsavel", "Nome", "Tipo Evento", "Curso", "Custo", "Sala", "Data", "Hora",
				"Data Limite" };
		tableModel = new DefaultTableModel(columns, 0);
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		refreshTable("");
		table.setModel(tableModel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 35, 829, 562);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		JLabel lblTipoDeEvento = new JLabel("Tipo de Evento :");
		lblTipoDeEvento.setBounds(56, 92, 97, 16);
		contentPane.add(lblTipoDeEvento);

		JLabel lblCurso = new JLabel("Curso :");
		lblCurso.setBounds(84, 194, 56, 16);
		contentPane.add(lblCurso);

		JComboBox<String> eventos = new JComboBox(dcm);
		eventos.setBounds(12, 140, 201, 22);
		contentPane.add(eventos);
		for (int i = 0; i < TipoEventos.getInventos().size(); i++) {
			TipoEvento ola = TipoEventos.getInventos().get(i);
			String tipoev = ola.getEvento();
			eventos.addItem(tipoev);

		}

		JComboBox<String> cursos = new JComboBox<String>(dcmf);
		cursos.setBounds(12, 228, 201, 22);
		contentPane.add(cursos);
		
		for (int i = 0; i < Cursos.getCursosESMAD().size(); i++) {
			Curso o = Cursos.getCursosESMAD().get(i);
			String curs = o.getNome();
			cursos.addItem(curs);

		}

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Eventoo = String.valueOf(eventos.getSelectedItem());
				String Cursooo = String.valueOf(cursos.getSelectedItem());
				
				String[] columns = { "Responsavel", "Nome", "Tipo Evento", "Curso", "Custo", "Sala", "Data", "Hora",
				"Data Limite" };
				
				DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
				
				
				for(int i = 0; i<TipoEventos.getInventos().size();i++)
				{
				//	Evento f = TipoEventos.getInventos().get(i);
					String fogo = "";
					for(Curso cursos : Cursos.getCursosESMAD())
					{
					//	if(cursos.getNome().equals(f.getCursoo().toString()));
						{
							fogo = cursos.getNome();
						}
					}
					for(TipoEvento tipoEventus: TipoEventos.getInventos())
					{
					//	if (tipoEventus.getEvento().equals(f.getTipoEvent().toString()))
						{
					//		f = tipoEventus.getEvento();
						}
					}
					
					//String fogo1 = f.getTipoEvent();
					//String fogo2 = f.getCursoo();
					
				}
				
				
				
				
			}
		});
		btnProcurar.setBounds(47, 455, 135, 60);
		contentPane.add(btnProcurar);

		JLabel lblConsultasDeEventos = new JLabel("Consultas de Eventos");
		lblConsultasDeEventos.setForeground(new Color(255, 69, 0));
		lblConsultasDeEventos.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblConsultasDeEventos.setBounds(23, 40, 208, 22);
		contentPane.add(lblConsultasDeEventos);

		JLabel lblSala = new JLabel("Sala :");
		lblSala.setBounds(84, 291, 56, 16);
		contentPane.add(lblSala);

		JComboBox<String> salas = new JComboBox<String>(dcmg);
		salas.setBounds(36, 319, 140, 22);
		contentPane.add(salas);
		for (int i = 0; i < GeralEvento.getEvents().size(); i++) {
			Evento oi = GeralEvento.getEvents().get(i);
			String sals = oi.getSalaa();
			eventos.addItem(sals);

		}
	}
}
