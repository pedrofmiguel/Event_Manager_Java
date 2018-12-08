package projetoI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Cursos;
import classes.GeralEvento;
import classes.Sala;
import classes.TipoEventos;
import classes.gestao;
import classes.login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private static ArrayList<login> users = new ArrayList<login>();
	private static ArrayList<login> perms = new ArrayList<login>();
	private static login currentuser;

	/**
	 * Launch the application.
	 */
	
	//pi
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					gestao.loadFile();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public Login() throws FileNotFoundException {
		GeralEvento.loadEvento();
		TipoEventos.loadFile();
		Sala.loadFile();
		Cursos.loadFile();
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel foto = new JLabel("");
		foto.setBounds(158, -1, 259, 175);
		
		ImageIcon imagem = new ImageIcon(Main.class.getResource("/logo/LOGO FINAL.png"));
		Image imag = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);
		
		foto.setIcon(new ImageIcon(imag));
		
		
		
		contentPane.add(foto);
		
		JLabel lblEmail = new JLabel("Nome :");
		lblEmail.setBounds(134, 174, 56, 16);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(228, 171, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(134, 232, 73, 16);
		contentPane.add(lblPassword);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				boolean logged = false;
				
				String user = textField.getText();
				String pw = passwordField.getText();
				
				for (int i = 0; i < gestao.logins.size(); i++) {
					
					login test = new login(user, pw);

					if (test.equals(gestao.logins.get(i))) {
						logged = true;
						currentuser = test;
						
					}
				}
				if (logged == false) {
					JOptionPane.showMessageDialog(null, "ID ou Password não existentes");
				} else {
					JOptionPane.showMessageDialog(null, "Login confirmado");
					setVisible(false);
					new Menu(user).setVisible(true);
					
				}
				
			}
});
		btnEntrar.setBounds(93, 300, 97, 25);
		contentPane.add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(340, 300, 97, 25);
		contentPane.add(btnSair);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 229, 116, 22);
		contentPane.add(passwordField);
		
		JButton btnRegisto = new JButton("Registar");
		btnRegisto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new mockups().setVisible(true);
			}
		});
		btnRegisto.setBounds(219, 300, 97, 25);
		contentPane.add(btnRegisto);
	}
}
