package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocios.Fachada;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.Cliente;

public class PrimeiraTelaCliente extends JPanel {

	private JTextField textFieldCCliente;

	/**
	 * Create the panel.
	 */
	public PrimeiraTelaCliente() {
		setLayout(null);
		
		JLabel lblCCliente = new JLabel("Cliente:");
		lblCCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCCliente.setBounds(10, 11, 63, 22);
		add(lblCCliente);
		
		textFieldCCliente = new JTextField();
		textFieldCCliente.setColumns(10);
		textFieldCCliente.setBounds(53, 14, 148, 20);
		add(textFieldCCliente);
		
		PainelCriarCliente painelcriarcliente = new PainelCriarCliente();
		painelcriarcliente.setBounds(10, 44, 475, 202);
		add(painelcriarcliente);
		painelcriarcliente.setLayout(null);
		painelcriarcliente.setVisible(false);
		
		PainelProcurarCliente painelprocurarcliente = new PainelProcurarCliente();
		painelprocurarcliente.setBounds(10, 44, 475, 202);
		add(painelprocurarcliente);
		painelprocurarcliente.setLayout(null);
		painelprocurarcliente.setVisible(false);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelcriarcliente.setVisible(true);
				painelprocurarcliente.setVisible(false);
			}
		});
		btnCriar.setBounds(363, 13, 89, 23);
		add(btnCriar);
		btnCriar.setVisible(false);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente achouCliente = null;
				try {
					achouCliente = (Cliente) Fachada.getInstance().procurarCliente(textFieldCCliente.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Favor inserir somente numeros");
					e1.printStackTrace();
				} catch (NaoLocalizadaPessoaException e1) {
					JOptionPane.showMessageDialog(null, "O Cliente não existe.");
					e1.printStackTrace();
					btnCriar.setVisible(true);
				 }
				
				painelcriarcliente.setVisible(false);
				painelprocurarcliente.setVisible(true);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				 painelprocurarcliente.getTextFieldCodigo2().setText(achouCliente.getCodigo());
				 painelprocurarcliente.getTextFieldNome2().setText(achouCliente.getNome());
				 painelprocurarcliente.getTextFieldRG2().setText(String.valueOf(achouCliente.getRg()));
				 painelprocurarcliente.getTextFieldEndereco2().setText(achouCliente.getEndereco());
				 painelprocurarcliente.getTextFieldEmail2().setText(achouCliente.getEmail());
				 painelprocurarcliente.getTextFieldCPF2().setText(achouCliente.getCpf());
				 painelprocurarcliente.getTextFieldDataNasc2().setText(sdf.format(achouCliente.getNascimento().getTime()));
				
			}
		});
		bntProcurar.setBounds(220, 13, 89, 23);
		add(bntProcurar);
		
		

	}
}
