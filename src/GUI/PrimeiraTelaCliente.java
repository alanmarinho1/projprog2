package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
		
		PainelResultadoPesquisaCliente painelResultadopesquisacliente = new PainelResultadoPesquisaCliente();
		painelResultadopesquisacliente.setBounds(10, 44, 475, 202);
		add(painelResultadopesquisacliente);
		painelResultadopesquisacliente.setLayout(null);
		painelResultadopesquisacliente.setVisible(false);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelcriarcliente.setVisible(true);
				painelprocurarcliente.setVisible(false);
				painelResultadopesquisacliente.setVisible(false);
			}
		});
		btnCriar.setBounds(363, 13, 89, 23);
		add(btnCriar);
		btnCriar.setVisible(true);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PainelResultadoPesquisaCliente tabelaClientes = new PainelResultadoPesquisaCliente();
				
				Cliente achouCliente = null;
				try {
					achouCliente = Fachada.getInstance().procurarCliente(textFieldCCliente.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Favor inserir somente numeros");
					e1.printStackTrace();
				} catch (NaoLocalizadaPessoaException e1) {
					JOptionPane.showMessageDialog(null, "O Cliente não existe.");
					e1.printStackTrace();
					btnCriar.setVisible(true);
				 }
				
				painelcriarcliente.setVisible(false);
				painelprocurarcliente.setVisible(false);
				painelResultadopesquisacliente.setVisible(true);
				
				ArrayList linhas = new ArrayList();
				String [] colunas = new String[] {"Codigo", "Nome", "Email", "Endereco", "CPF", "RG", "Data de Nascimento"};
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				linhas.add(new Object [] {achouCliente.getCodigo(), achouCliente.getNome(), achouCliente.getEmail(),
						achouCliente.getEndereco(), achouCliente.getCpf(), achouCliente.getRg(), sdf.format(achouCliente.getNascimento().getTime())} );
				ModeloTabela modelo = new ModeloTabela(linhas, colunas);
				
				/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				 painelprocurarcliente.getTextFieldCodigo2().setText(achouCliente.getCodigo());
				 painelprocurarcliente.getTextFieldNome2().setText(achouCliente.getNome());
				 painelprocurarcliente.getTextFieldRG2().setText(String.valueOf(achouCliente.getRg()));
				 painelprocurarcliente.getTextFieldEndereco2().setText(achouCliente.getEndereco());
				 painelprocurarcliente.getTextFieldEmail2().setText(achouCliente.getEmail());
				 painelprocurarcliente.getTextFieldCPF2().setText(achouCliente.getCpf());
				 painelprocurarcliente.getTextFieldDataNasc2().setText(sdf.format(achouCliente.getNascimento().getTime()));
				*/
			}
		});
		bntProcurar.setBounds(220, 13, 89, 23);
		add(bntProcurar);
		
		

	}
	
}
