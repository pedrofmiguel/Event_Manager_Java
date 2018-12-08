package projetoI;

import java.awt.BorderLayout;

import classes.GeralEvento;
import classes.Utilizador;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestaoDeUtilizadores extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPassword;
	private JTextField txtPermissao;
	private DefaultListModel<Utilizador> dlm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestaoDeUtilizadores frame = new GestaoDeUtilizadores();
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
	public GestaoDeUtilizadores() {
		setTitle("GestaoDeUtilizadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdDoUtilizador = new JLabel("ID do utilizador :");
		lblIdDoUtilizador.setBounds(270, 113, 105, 16);
		contentPane.add(lblIdDoUtilizador);
		
		txtNome = new JTextField();
		txtNome.setBounds(387, 110, 116, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(337, 256, 97, 45);
		contentPane.add(btnGravar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(513, 280, 97, 45);
		contentPane.add(btnVoltar);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(270, 160, 80, 16);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(387, 157, 116, 22);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblPermisso = new JLabel("Permiss\u00E3o :");
		lblPermisso.setBounds(270, 203, 87, 16);
		contentPane.add(lblPermisso);
		
		txtPermissao = new JTextField();
		txtPermissao.setBounds(387, 199, 116, 22);
		contentPane.add(txtPermissao);
		txtPermissao.setColumns(10);
		
		JList<Utilizador> list = new JList<Utilizador>();
		dlm = new DefaultListModel<Utilizador>();
		list.setModel(dlm);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNome.setText(list.getSelectedValue().getNome());
				txtPassword.setText(list.getSelectedValue().getPassword());
				txtPermissao.setText(String.valueOf(list.getSelectedValue().getPermissao()));
				
				
			}
		});
		
		list.setBounds(25, 42, 183, 283);
		
		
		for (Utilizador utilizador : GeralEvento.getUtilizadores()) {
			dlm.addElement(utilizador);
		}
		contentPane.add(list);
		
		
		
		JLabel lblListaDeUtilizadores = new JLabel("Lista de utilizadores :");
		lblListaDeUtilizadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListaDeUtilizadores.setBounds(25, 13, 168, 16);
		contentPane.add(lblListaDeUtilizadores);
		
		JLabel lblPermisses = new JLabel("Permiss\u00F5es :");
		lblPermisses.setBounds(274, 14, 101, 16);
		contentPane.add(lblPermisses);
		
		JLabel lblUtilizador = new JLabel("1 - Utilizador comum");
		lblUtilizador.setBounds(378, 14, 125, 16);
		contentPane.add(lblUtilizador);
		
		JLabel lblGestor = new JLabel("2 - Gestor de Eventos");
		lblGestor.setBounds(378, 43, 125, 16);
		contentPane.add(lblGestor);
		
		JLabel lblAdministrador = new JLabel("3 - Administrador");
		lblAdministrador.setBounds(378, 72, 125, 16);
		contentPane.add(lblAdministrador);
	}
}
