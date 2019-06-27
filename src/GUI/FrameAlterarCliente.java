package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocios.Cliente;
import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.Pessoa;
import Negocios.PessoaJaExisteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAlterarCliente extends JFrame {

	
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereco;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldTelefone;
	private Cliente cliente;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAlterarCliente frame = new FrameAlterarCliente();
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
	public FrameAlterarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 21, 71, 25);
		contentPane.add(label);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEnabled(false);
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(79, 21, 86, 20);
		contentPane.add(textFieldCodigo);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 45, 59, 25);
		contentPane.add(label_1);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(79, 45, 140, 20);
		contentPane.add(textFieldNome);
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 70, 59, 21);
		contentPane.add(label_2);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(79, 68, 140, 20);
		contentPane.add(textFieldEmail);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(79, 91, 140, 20);
		contentPane.add(textFieldEndereco);
		
		JLabel label_3 = new JLabel("Endere\u00E7o:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 91, 71, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("CPF:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 113, 34, 30);
		contentPane.add(label_4);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setText("");
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(79, 116, 122, 20);
		contentPane.add(textFieldCPF);
		
		textFieldRG = new JTextField();
		textFieldRG.setColumns(10);
		textFieldRG.setBounds(79, 147, 86, 20);
		contentPane.add(textFieldRG);
		
		JLabel label_5 = new JLabel("RG:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(10, 140, 33, 30);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Data de Nascimento:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(10, 176, 128, 25);
		contentPane.add(label_6);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setColumns(10);
		textFieldDataNascimento.setBounds(149, 180, 99, 20);
		contentPane.add(textFieldDataNascimento);
		
		JLabel label_7 = new JLabel("(dd/mm/aaaa)");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(162, 166, 86, 14);
		contentPane.add(label_7);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(79, 217, 89, 20);
		contentPane.add(textFieldTelefone);
		
		JLabel label_8 = new JLabel("Telefone:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(10, 215, 64, 21);
		contentPane.add(label_8);
		
		
		
		JButton button = new JButton("Alterar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateFormat f = DateFormat.getDateInstance();
				Cliente cliente = new Cliente();
				cliente.setCodigo(textFieldCodigo.getText());
				cliente.setNome(textFieldNome.getText());
				cliente.setEmail(textFieldEmail.getText());
				cliente.setEndereco(textFieldEndereco.getText());
				cliente.setCpf(textFieldCPF.getText());
				cliente.setTelefone(textFieldTelefone.getText());
				try {
					cliente.getNascimento().setTime(f.parse(textFieldDataNascimento.getText()));
				} catch (ParseException e1) {
					e1.printStackTrace();
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
						Fachada.getInstance().alterarCliente(cliente);
					} catch (InserirException e1) {
						JOptionPane.showMessageDialog(null, "Digite um CPF válido");
						e1.printStackTrace();
						break;
					} catch (PessoaJaExisteException e1) {
						JOptionPane.showMessageDialog(null, "Ja existe Cliente com este CPF");
						e1.printStackTrace();
					}
				JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso!");
				dispose();
				break;
				}
				
				
			}
		});
		button.setBounds(226, 227, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Excluir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Fachada.getInstance().removerCliente(textFieldCodigo.getText());
				JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso!");
				
				PrimeiraTelaCliente telacliente = new PrimeiraTelaCliente();
				telacliente.setVisible(true);
			}
		});
		button_1.setBounds(335, 227, 89, 23);
		contentPane.add(button_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(335, 24, 89, 23);
		contentPane.add(btnVoltar);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public JTextField getTextFieldCodigo() {
		return textFieldCodigo;
	}

	public void setTextFieldCodigo(JTextField textFieldCodigo) {
		this.textFieldCodigo = textFieldCodigo;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	public JTextField getTextFieldEndereco() {
		return textFieldEndereco;
	}

	public void setTextFieldEndereco(JTextField textFieldEndereco) {
		this.textFieldEndereco = textFieldEndereco;
	}

	public JTextField getTextFieldCPF() {
		return textFieldCPF;
	}

	public void setTextFieldCPF(JTextField textFieldCPF) {
		this.textFieldCPF = textFieldCPF;
	}

	public JTextField getTextFieldRG() {
		return textFieldRG;
	}

	public void setTextFieldRG(JTextField textFieldRG) {
		this.textFieldRG = textFieldRG;
	}

	public JTextField getTextFieldDataNascimento() {
		return textFieldDataNascimento;
	}

	public void setTextFieldDataNascimento(JTextField textFieldDataNascimento) {
		this.textFieldDataNascimento = textFieldDataNascimento;
	}

	public JTextField getTextFieldTelefone() {
		return textFieldTelefone;
	}

	public void setTextFieldTelefone(JTextField textFieldTelefone) {
		this.textFieldTelefone = textFieldTelefone;
	}
	
}
