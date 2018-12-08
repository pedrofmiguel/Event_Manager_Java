package projetoI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class PagamentosIncriçoes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagamentosIncriçoes frame = new PagamentosIncriçoes();
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
	public PagamentosIncriçoes() {
		setTitle("Pagamentos e Incri\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPagamentosEIncries = new JLabel("Pagamentos e inscri\u00E7\u00F5es");
		lblPagamentosEIncries.setForeground(new Color(255, 69, 0));
		lblPagamentosEIncries.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblPagamentosEIncries.setBounds(35, 45, 229, 22);
		contentPane.add(lblPagamentosEIncries);
		
		JLabel lblEvento = new JLabel("Nome do Evento :");
		lblEvento.setBounds(39, 109, 117, 16);
		contentPane.add(lblEvento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(186, 106, 127, 22);
		contentPane.add(comboBox);
		
		JLabel lblNome = new JLabel("N\u00BA estudante :");
		lblNome.setBounds(37, 157, 97, 16);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(186, 154, 127, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu(null);
				frame.setVisible(true);
				dispose();
				
				
			}
		});
		btnVoltar.setBounds(12, 321, 97, 38);
		contentPane.add(btnVoltar);
		
		JButton btnInscrever = new JButton("Inscrever");
		btnInscrever.setBounds(164, 288, 97, 38);
		contentPane.add(btnInscrever);
		
		JRadioButton radioG = new JRadioButton("Gratuito");
		radioG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioG.isSelected());
				txtM.setEnabled(false);
				
				
			}
		});
		radioG.setBounds(29, 210, 80, 25);
		contentPane.add(radioG);
		
		JLabel lblMontante = new JLabel("Montante :");
		lblMontante.setBounds(167, 214, 97, 16);
		contentPane.add(lblMontante);
		
		txtM = new JTextField();
		txtM.setBounds(239, 211, 56, 22);
		contentPane.add(txtM);
		txtM.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(307, 214, 56, 16);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Eventos Inscritos");
		btnNewButton.setBounds(431, 157, 152, 73);
		contentPane.add(btnNewButton);
	}
}
