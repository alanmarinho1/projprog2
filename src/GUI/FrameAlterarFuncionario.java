package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocios.Funcionario;
import Negocios.InserirException;
import Negocios.PessoaJaExisteException;
import Negocios.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAlterarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldProfissão;
	private JTextField textFieldCPF;
	private JTextField textFieldSalario;
	private JTextField textFieldCodigo;
	private JTextField textFieldUsuario;
	private JTextField textFieldSenha;
	private JTextField textFieldComissao;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JButton button;
	private JButton button_1;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAlterarFuncionario frame = new FrameAlterarFuncionario();
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
	public FrameAlterarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(79, 16, 86, 20);
		getContentPane().add(textFieldCodigo);
		
		JLabel lblComissao = new JLabel("Comiss\u00E3o:");
		lblComissao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComissao.setBounds(10, 161, 71, 14);
		getContentPane().add(lblComissao);
		
		textFieldComissao = new JTextField();
		textFieldComissao.setEditable(false);
		textFieldComissao.setBounds(79, 160, 59, 20);
		contentPane.add(textFieldComissao);
		textFieldComissao.setColumns(10);
		
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(272, 67, 59, 14);
		contentPane.add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(272, 94, 46, 14);
		contentPane.add(lblSenha);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(326, 64, 71, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(326, 91, 71, 20);
		contentPane.add(textFieldSenha);
		
		button = new JButton("Alterar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario = new Funcionario();
				
				funcionario.setCodigo(textFieldCodigo.getText());
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
						Fachada.getInstance().alterarFuncionario(funcionario);
					} catch (InserirException e1) {
						JOptionPane.showMessageDialog(null, "Digite um CPF válido");
						e1.printStackTrace();
						break;
					} catch (PessoaJaExisteException e1) {
						JOptionPane.showMessageDialog(null, "Ja existe Colaborador com este CPF");
						e1.printStackTrace();
					}
				JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com Sucesso!");
				dispose();
				break;
				}
				
			}
		});
		button.setBounds(226, 219, 89, 23);
		contentPane.add(button);
		
		button_1 = new JButton("Excluir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fachada.getInstance().removerFuncionario(textFieldCodigo.getText());
				JOptionPane.showMessageDialog(null, "Funcionario Excluido com Sucesso!");
				
				PrimeiraTelaFunc telafuncionario = new PrimeiraTelaFunc();
				telafuncionario.setVisible(true);
			}
		});
		button_1.setBounds(335, 219, 89, 23);
		contentPane.add(button_1);
		
		button_2 = new JButton("Voltar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setBounds(335, 16, 89, 23);
		contentPane.add(button_2);
		
		
		
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextFieldEndereco() {
		return textFieldEndereco;
	}

	public void setTextFieldEndereco(JTextField textFieldEndereco) {
		this.textFieldEndereco = textFieldEndereco;
	}

	public JTextField getTextFieldProfissão() {
		return textFieldProfissão;
	}

	public void setTextFieldProfissão(JTextField textFieldProfissão) {
		this.textFieldProfissão = textFieldProfissão;
	}

	public JTextField getTextFieldCPF() {
		return textFieldCPF;
	}

	public void setTextFieldCPF(JTextField textFieldCPF) {
		this.textFieldCPF = textFieldCPF;
	}

	public JTextField getTextFieldSalario() {
		return textFieldSalario;
	}

	public void setTextFieldSalario(JTextField textFieldSalario) {
		this.textFieldSalario = textFieldSalario;
	}

	public JTextField getTextFieldCodigo() {
		return textFieldCodigo;
	}

	public void setTextFieldCodigo(JTextField textFieldCodigo) {
		this.textFieldCodigo = textFieldCodigo;
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public void setTextFieldUsuario(JTextField textFieldUsuario) {
		this.textFieldUsuario = textFieldUsuario;
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public void setTextFieldSenha(JTextField textFieldSenha) {
		this.textFieldSenha = textFieldSenha;
	}

	public JTextField getTextFieldComissao() {
		return textFieldComissao;
	}

	public void setTextFieldComissao(JTextField textFieldComissao) {
		this.textFieldComissao = textFieldComissao;
	}

	
}
