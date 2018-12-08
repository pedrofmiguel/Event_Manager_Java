package projetoI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.gestao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class mockups extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField pass;
	private JTextField pass1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mockups frame = new mockups();
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
	public mockups() {
		setTitle("MADeVENTS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmail = new JLabel("Nome :");
		lblEmail.setBounds(95, 162, 56, 16);
		contentPane.add(lblEmail);

		textField = new JTextField();
		textField.setBounds(163, 159, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(72, 197, 74, 16);
		contentPane.add(lblPassword);

		pass = new JTextField();
		pass.setBounds(163, 194, 116, 22);
		contentPane.add(pass);
		pass.setColumns(10);

		JLabel lblLogin = new JLabel("Registo");
		lblLogin.setFont(new Font("Cambria", Font.BOLD, 20));
		lblLogin.setForeground(new Color(255, 69, 0));
		lblLogin.setBackground(new Color(255, 69, 0));
		lblLogin.setBounds(174, 88, 94, 34);
		contentPane.add(lblLogin);

		JLabel lblRepetirPassword = new JLabel("Repetir Password :");
		lblRepetirPassword.setBounds(41, 232, 122, 16);
		contentPane.add(lblRepetirPassword);

		pass1 = new JTextField();
		pass1.setBounds(163, 229, 116, 22);
		contentPane.add(pass1);
		pass1.setColumns(10);

		JButton btnRegistar = new JButton("Registar");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pass.getText().equals(pass1.getText())) {
					String id = textField.getText();
					String pw = pass.getText();
					gestao.addUtilizadores(id, pw);
					try {
						gestao.loadFile();
						gestao.saveFile();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Registado com sucesso");
					dispose();
					try {
						new Login().setVisible(true);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Passwords não são iguais");
				}

			}
		});
		btnRegistar.setBounds(174, 295, 97, 25);
		contentPane.add(btnRegistar);

		JLabel foto = new JLabel("");
		foto.setBounds(251, 39, 323, 270);

		ImageIcon imagem = new ImageIcon(Main.class.getResource("/logo/LOGO FINAL.png"));
		Image imag = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);

		foto.setIcon(new ImageIcon(imag));

		contentPane.add(foto);
	}
}
