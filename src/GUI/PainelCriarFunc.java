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

public class PainelCriarFunc extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldProfissão;
	private JTextField textFieldCPF;
	private JTextField textFieldSalario;
	private JTextField textFieldID;
	private JTextField textFieldComissao;

	/**
	 * Create the panel.
	 */
	public PainelCriarFunc() {
		setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 40, 59, 25);
		add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(79, 40, 140, 20);
		add(textFieldNome);
		
		JLabel label_1 = new JLabel("Endereco:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 65, 59, 21);
		add(label_1);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(79, 63, 140, 20);
		add(textFieldEndereco);
		
		JLabel lblProfissao = new JLabel("Profiss\u00E3o:");
		lblProfissao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfissao.setBounds(10, 86, 71, 25);
		add(lblProfissao);
		
		textFieldProfissão = new JTextField();
		textFieldProfissão.setColumns(10);
		textFieldProfissão.setBounds(79, 86, 140, 20);
		add(textFieldProfissão);
		
		JLabel label_3 = new JLabel("CPF:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 108, 34, 30);
		add(label_3);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setText("");
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(79, 111, 122, 20);
		add(textFieldCPF);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalario.setBounds(10, 132, 59, 30);
		add(lblSalario);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(79, 135, 86, 20);
		add(textFieldSalario);
		
		JLabel label_6 = new JLabel("C\u00F3digo:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(10, 16, 71, 25);
		add(label_6);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(79, 16, 86, 20);
		add(textFieldID);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelCriarFunc painelcriarfunc = new PainelCriarFunc();
				painelcriarfunc.setVisible(true);
				
				Funcionario funcionario = new Funcionario();
				
				funcionario.setNome(textFieldNome.getText());
				funcionario.setEndereco(textFieldEndereco.getText());
				funcionario.setProfissao(textFieldProfissão.getText());
				funcionario.setCpf(textFieldCPF.getText());
				
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
						JOptionPane.showMessageDialog(null, "Ja existe Cliente com este CPF");
						e.printStackTrace();
					}
				JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com Sucesso!");
				break;
				}
				painelcriarfunc.setVisible(false);
			}
		});
		btnSalvar.setBounds(305, 138, 89, 23);
		add(btnSalvar);
		
		JLabel lblComissao = new JLabel("Comiss\u00E3o:");
		lblComissao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComissao.setBounds(10, 161, 71, 14);
		add(lblComissao);
		
		textFieldComissao = new JTextField();
		textFieldComissao.setEnabled(false);
		textFieldComissao.setBounds(79, 160, 47, 20);
		add(textFieldComissao);
		textFieldComissao.setColumns(10);

	}
}
