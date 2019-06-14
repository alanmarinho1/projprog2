package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;

import Negocios.Cliente;
import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.PessoaJaExisteException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PainelProcurarCliente extends JPanel {
	private JTextField textFieldCodigo2;
	private JTextField textFieldNome2;
	private JTextField textFieldEmail2;
	private JTextField textFieldCPF2;
	private JTextField textFieldRG2;
	private JTextField textFieldDataNasc2;
	private JTextField textFieldEndereco2;	


	/**
	 * Create the panel.
	 */
	public PainelProcurarCliente() {
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
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 60, 59, 21);
		add(label_2);
		
		textFieldEmail2 = new JTextField();
		textFieldEmail2.setEditable(false);
		textFieldEmail2.setColumns(10);
		textFieldEmail2.setBounds(72, 65, 140, 20);
		add(textFieldEmail2);
		
		JLabel label_3 = new JLabel("Endere\u00E7o:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 81, 71, 25);
		add(label_3);
		
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
		
		JLabel label_5 = new JLabel("RG:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(306, 8, 23, 30);
		add(label_5);
		
		textFieldRG2 = new JTextField();
		textFieldRG2.setEditable(false);
		textFieldRG2.setColumns(10);
		textFieldRG2.setBounds(349, 15, 86, 20);
		add(textFieldRG2);
		
		JLabel label_6 = new JLabel("Data de Nascimento:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(10, 133, 128, 30);
		add(label_6);
		
		textFieldDataNasc2 = new JTextField();
		textFieldDataNasc2.setEditable(false);
		textFieldDataNasc2.setColumns(10);
		textFieldDataNasc2.setBounds(144, 140, 86, 20);
		add(textFieldDataNasc2);
		
		textFieldEndereco2 = new JTextField();
		textFieldEndereco2.setEditable(false);
		textFieldEndereco2.setColumns(10);
		textFieldEndereco2.setBounds(72, 88, 140, 20);
		add(textFieldEndereco2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat f = DateFormat.getDateInstance();
				Cliente cliente = new Cliente();
				cliente.setNome(textFieldNome2.getText());
				cliente.setEmail(textFieldEmail2.getText());
				cliente.setEndereco(textFieldEndereco2.getText());
				cliente.setCpf(textFieldCPF2.getText());
				try {
					cliente.getNascimento().setTime(f.parse(textFieldDataNasc2.getText()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				while(true) {
					try {
						cliente.setRg(Integer.parseInt(textFieldRG2.getText()));
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
				Cliente cliente = new Cliente();
				cliente.setCodigo((textFieldCodigo2.getText()));
				Fachada.getInstance().removerCliente((cliente.getCodigo()));
				JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso!");
			}
		});
		btnExcluir.setBounds(349, 152, 89, 23);
		add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome2.setEditable(true);
				textFieldDataNasc2.setEditable(true);
				textFieldEmail2.setEditable(true);
				textFieldEndereco2.setEditable(true);
				textFieldRG2.setEditable(true);
				textFieldCPF2.setEditable(true);
				
				btnAlterar.setVisible(false);
				btnExcluir.setVisible(false);
				btnSalvar.setVisible(true);
			}
		});
		btnAlterar.setBounds(240, 152, 89, 23);
		add(btnAlterar);
		
		
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

	public JTextField getTextFieldEmail2() {
		return textFieldEmail2;
	}

	public void setTextFieldEmail2(JTextField textFieldEmail2) {
		this.textFieldEmail2 = textFieldEmail2;
	}

	public JTextField getTextFieldCPF2() {
		return textFieldCPF2;
	}

	public void setTextFieldCPF2(JTextField textFieldCPF2) {
		this.textFieldCPF2 = textFieldCPF2;
	}

	public JTextField getTextFieldRG2() {
		return textFieldRG2;
	}

	public void setTextFieldRG2(JTextField textFieldRG2) {
		this.textFieldRG2 = textFieldRG2;
	}

	public JTextField getTextFieldDataNasc2() {
		return textFieldDataNasc2;
	}

	public void setTextFieldDataNasc2(JTextField textFieldDataNasc2) {
		this.textFieldDataNasc2 = textFieldDataNasc2;
	}

	public JTextField getTextFieldEndereco2() {
		return textFieldEndereco2;
	}

	public void setTextFieldEndereco2(JTextField textFieldEndereco2) {
		this.textFieldEndereco2 = textFieldEndereco2;
	}

}
