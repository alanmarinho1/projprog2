package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocios.Fachada;
import Negocios.Funcionario;
import Negocios.InserirException;
import Negocios.PessoaJaExisteException;

public class FrameCriarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldProfissão;
	private JTextField textFieldCPF;
	private JTextField textFieldSalario;
	private JTextField textFieldID;
	private JTextField textFieldComissao;
	private JButton btnCancelar;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JTextField textFieldUsuario;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCriarFuncionario frame = new FrameCriarFuncionario();
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
	public FrameCriarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 40, 59, 25);
		getContentPane().add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(79, 40, 140, 20);
		getContentPane().add(textFieldNome);
		
		JLabel label_1 = new JLabel("Endereco:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 65, 71, 21);
		getContentPane().add(label_1);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(79, 63, 140, 20);
		getContentPane().add(textFieldEndereco);
		
		JLabel lblProfissao = new JLabel("Profiss\u00E3o:");
		lblProfissao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfissao.setBounds(10, 86, 71, 25);
		getContentPane().add(lblProfissao);
		
		textFieldProfissão = new JTextField();
		textFieldProfissão.setColumns(10);
		textFieldProfissão.setBounds(79, 86, 140, 20);
		getContentPane().add(textFieldProfissão);
		
		JLabel label_3 = new JLabel("CPF:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 108, 34, 30);
		getContentPane().add(label_3);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setText("");
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(79, 111, 122, 20);
		getContentPane().add(textFieldCPF);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalario.setBounds(10, 132, 59, 30);
		getContentPane().add(lblSalario);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(79, 135, 86, 20);
		getContentPane().add(textFieldSalario);
		
		JLabel label_6 = new JLabel("C\u00F3digo:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(10, 16, 71, 25);
		getContentPane().add(label_6);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(79, 16, 86, 20);
		getContentPane().add(textFieldID);
		
		JLabel lblComissao = new JLabel("Comiss\u00E3o:");
		lblComissao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComissao.setBounds(10, 161, 71, 14);
		getContentPane().add(lblComissao);
		
		textFieldComissao = new JTextField();
		textFieldComissao.setEnabled(false);
		textFieldComissao.setBounds(79, 160, 47, 20);
		getContentPane().add(textFieldComissao);
		textFieldComissao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
				Funcionario funcionario = new Funcionario();
				
				funcionario.setNome(textFieldNome.getText());
				funcionario.setEndereco(textFieldEndereco.getText());
				funcionario.setProfissao(textFieldProfissão.getText());
				funcionario.setCpf(textFieldCPF.getText());
				funcionario.setUsuario(textFieldUsuario.getText());
				funcionario.setSenha(textFieldSenha.getText());
				
				while(true) {
				try {
					funcionario.setSalario(Integer.parseInt(textFieldSalario.getText()));
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Salario)");
					e2.printStackTrace();
					break;
				}
				
					try {
						Fachada.getInstance().cadastrarFuncionario(funcionario);
					} catch (InserirException e1) {
						JOptionPane.showMessageDialog(null, "Digite um CPF válido");
						e1.printStackTrace();
						break;
					} catch (PessoaJaExisteException e) {
						JOptionPane.showMessageDialog(null, "Ja existe Colaborador com este CPF");
						e.printStackTrace();
					}
				JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com Sucesso!");
				dispose();
				PrimeiraTelaFunc painelfunc = new PrimeiraTelaFunc();
				painelfunc.setVisible(true);
				break;
				}
				
			}
		});
		btnSalvar.setBounds(229, 210, 89, 23);
		getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PrimeiraTelaFunc painelfunc = new PrimeiraTelaFunc();
				painelfunc.setVisible(true);
			}
		});
		btnCancelar.setBounds(338, 210, 89, 23);
		contentPane.add(btnCancelar);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(272, 43, 59, 14);
		contentPane.add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(272, 70, 46, 14);
		contentPane.add(lblSenha);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(326, 40, 71, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(326, 67, 71, 20);
		contentPane.add(textFieldSenha);
		
		
	}
	

}
