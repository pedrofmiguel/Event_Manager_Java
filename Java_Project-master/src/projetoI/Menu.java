package projetoI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Menu extends JFrame {

	private JPanel contentPane;
	private static String user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(user);
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
	public Menu(String user) {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel foto = new JLabel("");
		foto.setBackground(new Color(192, 192, 192));
		foto.setBounds(96, 34, 514, 394);
		
		ImageIcon imagem = new ImageIcon(Main.class.getResource("/logo/LOGO FINAL.png"));
		Image imag = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);
		
		foto.setIcon(new ImageIcon(imag));
		
		
		
		contentPane.add(foto);
		
		JButton btnPagamentos = new JButton("Pagamentos e Inscri\u00E7\u00F5es\r\n");
		btnPagamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PagamentosIncriçoes().setVisible(true);
			}
		});
		btnPagamentos.setBackground(UIManager.getColor("Button.background"));
		btnPagamentos.setBounds(12, 34, 187, 54);
		contentPane.add(btnPagamentos);
		
		JButton btnConsultaDosEventos = new JButton("Consulta dos Eventos");
		btnConsultaDosEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new ConsultarEventos().setVisible(true);
			}
		});
		btnConsultaDosEventos.setBackground(UIManager.getColor("Button.background"));
		btnConsultaDosEventos.setBounds(217, 34, 170, 54);
		contentPane.add(btnConsultaDosEventos);
		
		JButton btnCriarEventos = new JButton("Criar Eventos");
		btnCriarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new CriarEventos().setVisible(true);
			}
		});
		btnCriarEventos.setBackground(UIManager.getColor("Button.background"));
		btnCriarEventos.setBounds(411, 34, 121, 54);
		contentPane.add(btnCriarEventos);
		
		JButton btnDivulgao = new JButton("Divulga\u00E7\u00E3o");
		btnDivulgao.setBackground(UIManager.getColor("Button.background"));
		btnDivulgao.setBounds(544, 34, 112, 54);
		contentPane.add(btnDivulgao);
		
		JLabel lblBemVindo = new JLabel("Bem vindo");
		lblBemVindo.setBounds(12, 13, 78, 16);
		contentPane.add(lblBemVindo);
		
		JLabel nome = new JLabel("");
		nome.setBounds(86, 13, 56, 16);
		nome.setText(user);
		contentPane.add(nome);
		
		JButton btnNewButton = new JButton("Configura\u00E7\u00F5es");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Configuracoes().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(502, 194, 135, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gest\u00E3o de utilizadores");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new GestaoDeUtilizadores().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(12, 194, 170, 54);
		contentPane.add(btnNewButton_1);
	}
}
