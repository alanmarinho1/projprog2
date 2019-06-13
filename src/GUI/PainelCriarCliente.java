package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.PessoaJaExisteException;
import Negocios.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PainelCriarCliente extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereco;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private JTextField textFieldDataNasc;
	private JTextField textFieldID;

	/**
	 * Create the panel.
	 */
	public PainelCriarCliente() {
		setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 40, 59, 25);
		add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(79, 40, 140, 20);
		add(textFieldNome);
		
		JLabel label_1 = new JLabel("Email:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 65, 59, 21);
		add(label_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(79, 63, 140, 20);
		add(textFieldEmail);
		
		JLabel label_2 = new JLabel("Endere\u00E7o:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 86, 71, 25);
		add(label_2);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(79, 86, 140, 20);
		add(textFieldEndereco);
		
		JLabel label_3 = new JLabel("CPF:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 108, 34, 30);
		add(label_3);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setText("");
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(79, 111, 122, 20);
		add(textFieldCPF);
		
		JLabel label_4 = new JLabel("RG:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(294, 13, 23, 30);
		add(label_4);
		
		textFieldRG = new JTextField();
		textFieldRG.setColumns(10);
		textFieldRG.setBounds(327, 20, 86, 20);
		add(textFieldRG);
		
		JLabel label_5 = new JLabel("Data de Nascimento:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(10, 132, 128, 30);
		add(label_5);
		
		textFieldDataNasc = new JTextField();
		textFieldDataNasc.setColumns(10);
		textFieldDataNasc.setBounds(148, 139, 99, 20);
		add(textFieldDataNasc);
		
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
				DateFormat f = DateFormat.getDateInstance();
				PainelCriarCliente painelcriarcliente = new PainelCriarCliente();
				painelcriarcliente.setVisible(true);
				
				Cliente cliente = new Cliente();
				
				cliente.setNome(textFieldNome.getText());
				cliente.setEmail(textFieldEmail.getText());
				cliente.setEndereco(textFieldEndereco.getText());
				cliente.setCpf(textFieldCPF.getText());
				try {
					cliente.getNascimento().setTime(f.parse(textFieldDataNasc.getText()));
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
				painelcriarcliente.setVisible(false);
				break;
				}
				
			}
		});
		btnSalvar.setBounds(305, 138, 89, 23);
		add(btnSalvar);
		
		JLabel lblddmmaaaa = new JLabel("(dd/mm/aaaa)");
		lblddmmaaaa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblddmmaaaa.setBounds(23, 159, 86, 14);
		add(lblddmmaaaa);

	}
}
