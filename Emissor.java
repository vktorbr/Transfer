package Transfer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Emissor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel lblPorta;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JLabel lblTamanho;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emissor frame = new Emissor();
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
	public Emissor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Arquivo Selecionado");
		lblNewLabel.setBounds(10, 11, 97, 23);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Escolher arquivo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(10, 145, 124, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 61, 212, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 114, 212, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_1 = new JLabel("IP:");
		lblNewLabel_1.setBounds(10, 64, 14, 14);
		contentPane.add(lblNewLabel_1);
		
		lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(10, 89, 46, 14);
		contentPane.add(lblPorta);
		
		lblNewLabel_2 = new JLabel("Onde salvar:");
		lblNewLabel_2.setBounds(10, 117, 73, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(89, 86, 212, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(144, 149, 58, 14);
		contentPane.add(lblTamanho);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(317, 214, 89, 23);
		contentPane.add(btnNewButton);
	}
}
