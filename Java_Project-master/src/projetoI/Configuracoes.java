package projetoI;

import java.awt.BorderLayout;
import classes.Curso;
import classes.Cursos;
import classes.TipoEventos;
import classes.TipoEvento;
import classes.TipoEvento;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Configuracoes extends JFrame {

	private JPanel contentPane;
	private JTextField txtEvento;
	private JTextField txtCurso;
	private DefaultListModel<TipoEvento> dlm = new DefaultListModel<TipoEvento>();
	private DefaultListModel<Curso> dlmf = new DefaultListModel<Curso>();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracoes frame = new Configuracoes();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Configuracoes() {
		setTitle("Configura\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTiposDeEventos = new JLabel("Tipo de Evento :");
		lblTiposDeEventos.setBounds(26, 24, 132, 16);
		contentPane.add(lblTiposDeEventos);
		
		txtEvento = new JTextField();
		txtEvento.setBounds(130, 21, 143, 22);
		contentPane.add(txtEvento);
		txtEvento.setColumns(10);
		
		
	
		
		
		JList<TipoEvento> listEvento = new JList<TipoEvento>();
		listEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEvento.setText(listEvento.getSelectedValue().getEvento().toString());
			}
		});
		
		listEvento.setBorder(new LineBorder(new Color(0, 0, 0)));
		listEvento.setBounds(10, 79, 286, 144);
		
		for (TipoEvento tipoEvento : TipoEventos.getInventos()) 
		{
			dlm.addElement(tipoEvento);
		}
		
		listEvento.setModel(dlm);
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listEvento.getSelectedIndex() == -1) {
					TipoEvento c = TipoEventos.addCategory(txtEvento.getText());
					dlm.addElement(c);				
				}
				// Caso contrário, trata-se de uma atualização da categoria selecionada
				else {
					TipoEvento c = listEvento.getSelectedValue();
					c.setEvento(txtEvento.getText());
					dlm.setElementAt(c, listEvento.getSelectedIndex());
				
				
				
				
			}
		}
			});
		
		btnGuardar.setBounds(140, 53, 97, 25);
		contentPane.add(btnGuardar);
		
		contentPane.add(listEvento);
		
		JLabel lblListaD = new JLabel("Lista dos tipos de evento :");
		lblListaD.setBounds(26, 91, 169, 16);
		contentPane.add(lblListaD);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listEvento.getSelectedIndex()!=-1) {
					TipoEvento c = listEvento.getSelectedValue();
					TipoEventos.removeCategory(c);
					dlm.removeElement(c);
					txtEvento.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Tem de selecionar um evento");
				}
				
				
				
				
				
				
				
				
				
			}
		});
		btnRemover.setBounds(61, 304, 97, 25);
		contentPane.add(btnRemover);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(574, 297, 107, 39);
		contentPane.add(btnVoltar);
		
		JLabel lblCursos = new JLabel("Cursos :");
		lblCursos.setBounds(320, 24, 56, 16);
		contentPane.add(lblCursos);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(381, 21, 153, 22);
		contentPane.add(txtCurso);
		txtCurso.setColumns(10);
		
		
		
		JLabel lblListaDosCursos = new JLabel("Lista dos cursos :");
		lblListaDosCursos.setBounds(381, 91, 107, 16);
		contentPane.add(lblListaDosCursos);
		
		
		
		
		
		JList<Curso> listCurso = new JList<Curso>();
		listCurso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCurso.setText(listCurso.getSelectedValue().getNome().toString());
			}
		});
		
		listEvento.setBorder(new LineBorder(new Color(0, 0, 0)));
		listCurso.setBounds(381, 120, 314, 165);
		
		
		
		for (Curso curso : Cursos.getCursosESMAD()) 
		{
			dlmf.addElement(curso);
		}
		
		listCurso.setModel(dlmf);
		
		contentPane.add(listCurso);
		
		
		
		
		
		
		
		
		
		
		
		
		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listCurso.getSelectedIndex() == -1) {
					Curso c = Cursos.addCurso(txtCurso.getText());
					dlmf.addElement(c);				
				}
				// Caso contrário, trata-se de uma atualização da categoria selecionada
				else {
					Curso c = listCurso.getSelectedValue();
					c.setNome(txtCurso.getText());
					dlmf.setElementAt(c, listCurso.getSelectedIndex());
				}				
				
				
			}
		});
		
		btnGuardar_1.setBounds(391, 53, 97, 25);
		contentPane.add(btnGuardar_1);
		
		
		
		
		
		
		
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listCurso.getSelectedIndex()!=-1) {
					Curso c = listCurso.getSelectedValue();
					Cursos.removeCurso(c);
					dlmf.removeElement(c);
					txtCurso.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Tem de selecionar um curso");
				}
				
				
				
				
			}
		});
		btnRemover_1.setBounds(381, 311, 97, 25);
		contentPane.add(btnRemover_1);
	}
}
