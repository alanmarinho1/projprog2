package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.PessoaJaExisteException;
import Negocios.Funcionario;

public class PainelProcurarFunc extends JPanel {
	private JTextField textFieldCodigo2;
	private JTextField textFieldNome2;
	private JTextField textFieldEndereco2;
	private JTextField textFieldCPF2;
	private JTextField textFieldSalario2;
	private JTextField textFieldProfissao2;	
	private JTextField textFieldComissao;


	/**
	 * Create the panel.
	 */
	public PainelProcurarFunc() {
		setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 11, 71, 25);
		add(label);
		
		textFieldCodigo2 = new JTextField();
		textFieldCodigo2.setEditable(false);
		textFieldCodigo2.setColumns(10);
		textFieldCodigo2.setBounds(72, 18, 86, 20);
		add(textFieldCodigo2);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 35, 59, 25);
		add(label_1);
		
		textFieldNome2 = new JTextField();
		textFieldNome2.setEditable(false);
		textFieldNome2.setColumns(10);
		textFieldNome2.setBounds(72, 42, 140, 20);
		add(textFieldNome2);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereo.setBounds(10, 60, 71, 21);
		add(lblEndereo);
		
		textFieldEndereco2 = new JTextField();
		textFieldEndereco2.setEditable(false);
		textFieldEndereco2.setColumns(10);
		textFieldEndereco2.setBounds(72, 65, 140, 20);
		add(textFieldEndereco2);
		
		JLabel lblProfissao = new JLabel("Profiss\u00E3o:");
		lblProfissao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfissao.setBounds(10, 81, 71, 25);
		add(lblProfissao);
		
		JLabel label_4 = new JLabel("CPF:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 103, 34, 30);
		add(label_4);
		
		textFieldCPF2 = new JTextField();
		textFieldCPF2.setText("");
		textFieldCPF2.setEditable(false);
		textFieldCPF2.setColumns(10);
		textFieldCPF2.setBounds(72, 113, 122, 20);
		add(textFieldCPF2);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalario.setBounds(10, 127, 59, 30);
		add(lblSalario);
		
		textFieldSalario2 = new JTextField();
		textFieldSalario2.setEditable(false);
		textFieldSalario2.setColumns(10);
		textFieldSalario2.setBounds(72, 137, 86, 20);
		add(textFieldSalario2);
		
		textFieldProfissao2 = new JTextField();
		textFieldProfissao2.setEditable(false);
		textFieldProfissao2.setColumns(10);
		textFieldProfissao2.setBounds(72, 88, 140, 20);
		add(textFieldProfissao2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(textFieldNome2.getText());
				funcionario.setEndereco(textFieldEndereco2.getText());
				funcionario.setProfissao(textFieldProfissao2.getText());
				funcionario.setCpf(textFieldCPF2.getText());
				while(true) {
					try {
						funcionario.setSalario(Integer.parseInt(textFieldSalario2.getText()));
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
						JOptionPane.showMessageDialog(null, "Já existe um funcionario com esse CPF");
						e1.printStackTrace();
						break;
					}
				JOptionPane.showMessageDialog(null, "Funcionario Alterado com Sucesso!");
				btnSalvar.setVisible(false);
				break;
				}
				
			}
		});
		btnSalvar.setBounds(240, 152, 89, 23);
		add(btnSalvar);
		btnSalvar.setVisible(false);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodigo((textFieldCodigo2.getText()));
				Fachada.getInstance().removerFuncionario((funcionario.getCodigo()));
				JOptionPane.showMessageDialog(null, "Funcionario Excluido com Sucesso!");
			}
		});
		btnExcluir.setBounds(349, 152, 89, 23);
		add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome2.setEditable(true);
				textFieldEndereco2.setEditable(true);
				textFieldProfissao2.setEditable(true);
				textFieldSalario2.setEditable(true);
				textFieldCPF2.setEditable(true);
				
				btnAlterar.setVisible(false);
				btnExcluir.setVisible(false);
				btnSalvar.setVisible(true);
			}
		});
		btnAlterar.setBounds(240, 152, 89, 23);
		add(btnAlterar);
		
		JLabel lblComissao = new JLabel("Comiss\u00E3o:");
		lblComissao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComissao.setBounds(10, 161, 71, 14);
		add(lblComissao);
		
		textFieldComissao = new JTextField();
		textFieldComissao.setEditable(false);
		textFieldComissao.setBounds(72, 160, 45, 20);
		add(textFieldComissao);
		textFieldComissao.setColumns(10);
		
		
	}

	public JTextField getTextFieldCodigo2() {
		return textFieldCodigo2;
	}

	public void setTextFieldCodigo2(JTextField textFieldCodigo2) {
		this.textFieldCodigo2 = textFieldCodigo2;
	}

	public JTextField getTextFieldNome2() {
		return textFieldNome2;
	}

	public void setTextFieldNome2(JTextField textFieldNome2) {
		this.textFieldNome2 = textFieldNome2;
	}

	public JTextField getTextFieldEndereco2() {
		return textFieldEndereco2;
	}

	public void setTextFieldEndereco2(JTextField textFieldEndereco2) {
		this.textFieldEndereco2 = textFieldEndereco2;
	}

	public JTextField getTextFieldCPF2() {
		return textFieldCPF2;
	}

	public void setTextFieldCPF2(JTextField textFieldCPF2) {
		this.textFieldCPF2 = textFieldCPF2;
	}

	public JTextField getTextFieldSalario2() {
		return textFieldSalario2;
	}

	public void setTextFieldSalario2(JTextField textFieldSalario2) {
		this.textFieldSalario2 = textFieldSalario2;
	}

	public JTextField getTextFieldProfissao2() {
		return textFieldProfissao2;
	}

	public void setTextFieldProfissao2(JTextField textFieldEndereco2) {
		this.textFieldProfissao2 = textFieldEndereco2;
	}

	public JTextField getTextFieldComissao() {
		return textFieldComissao;
	}

	public void setTextFieldComissao(JTextField textFieldComissao) {
		this.textFieldComissao = textFieldComissao;
	}
	
	

}
