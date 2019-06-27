package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocios.Cliente;
import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.PessoaJaExisteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class FrameCriarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereco;
	private JTextField textFieldCPF;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldRG;
	private JTextField textFieldTelefone;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCriarCliente frame = new FrameCriarCliente();
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
	public FrameCriarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 14, 71, 25);
		contentPane.add(label);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(79, 14, 86, 20);
		contentPane.add(textFieldCodigo);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 38, 59, 25);
		contentPane.add(label_1);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(79, 38, 140, 20);
		contentPane.add(textFieldNome);
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 63, 59, 21);
		contentPane.add(label_2);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(79, 61, 140, 20);
		contentPane.add(textFieldEmail);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(79, 84, 140, 20);
		contentPane.add(textFieldEndereco);
		
		JLabel label_3 = new JLabel("Endere\u00E7o:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 84, 71, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("CPF:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 106, 34, 30);
		contentPane.add(label_4);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setText("");
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(79, 109, 122, 20);
		contentPane.add(textFieldCPF);
		
		JLabel label_5 = new JLabel("Data de Nascimento:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(10, 169, 133, 25);
		contentPane.add(label_5);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setColumns(10);
		textFieldDataNascimento.setBounds(149, 173, 99, 20);
		contentPane.add(textFieldDataNascimento);
		
		JLabel label_6 = new JLabel("(dd/mm/aaaa)");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(162, 159, 86, 14);
		contentPane.add(label_6);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat f = DateFormat.getDateInstance();
							
				Cliente cliente = new Cliente();
				
				cliente.setNome(textFieldNome.getText());
				cliente.setEmail(textFieldEmail.getText());
				cliente.setEndereco(textFieldEndereco.getText());
				cliente.setCpf(textFieldCPF.getText());
				cliente.setTelefone(textFieldTelefone.getText());
				
				try {
					cliente.getNascimento().setTime(f.parse(textFieldDataNascimento.getText()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				while(true) {
				try {
					cliente.setRg(Integer.parseInt(textFieldRG.getText()));
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo RG)");
					e2.printStackTrace();
					break;
				}
				
					try {
						Fachada.getInstance().cadastrarCliente(cliente);
					} catch (InserirException e1) {
						JOptionPane.showMessageDialog(null, "Digite um CPF válido");
						e1.printStackTrace();
						break;
					} catch (PessoaJaExisteException e) {
						JOptionPane.showMessageDialog(null, "Ja existe Cliente com este CPF");
						e.printStackTrace();
					}
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
				dispose();
				PrimeiraTelaCliente painelcliente = new PrimeiraTelaCliente();
				painelcliente.setVisible(true);
				break;
				}
			}
		});
		button.setBounds(245, 209, 89, 23);
		contentPane.add(button);
		
		textFieldRG = new JTextField();
		textFieldRG.setColumns(10);
		textFieldRG.setBounds(79, 140, 86, 20);
		contentPane.add(textFieldRG);
		
		JLabel label_7 = new JLabel("RG:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(10, 133, 33, 30);
		contentPane.add(label_7);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 208, 64, 21);
		contentPane.add(lblNewLabel);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(79, 210, 89, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PrimeiraTelaCliente painelcliente = new PrimeiraTelaCliente();
				painelcliente.setVisible(true);
				
			}
		});
		btnCancelar.setBounds(348, 209, 89, 23);
		contentPane.add(btnCancelar);
	}
}
