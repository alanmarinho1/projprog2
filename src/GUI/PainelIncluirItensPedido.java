package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import Negocios.Fachada;
import Negocios.NaoLocalizadoProdutoException;
import Negocios.Produtos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class PainelIncluirItensPedido extends JPanel {

	
	private JTextField textFieldCodigo;
	/**
	 * Create the panel.
	 */
	public PainelIncluirItensPedido() {
		setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo do Produto:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 11, 125, 22);
		add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(145, 14, 48, 20);
		add(textFieldCodigo);
		
		PainelIncluirItens painelincluirtens = new PainelIncluirItens();
		painelincluirtens.setBounds(10, 44, 475, 169);
		add(painelincluirtens);
		painelincluirtens.setLayout(null);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produtos achouProduto = null;
				try {
					achouProduto = Fachada.getInstance().procurarProduto(textFieldCodigo.getText());
				} catch (NaoLocalizadoProdutoException e1) {
					JOptionPane.showMessageDialog(null, "O Produto não existe.");
					e1.printStackTrace();
					
				 }
				
				
				painelincluirtens.setVisible(true);
				
				painelincluirtens.getTextFieldCodigo2().setText(achouProduto.getCodigo());
				painelincluirtens.getTextFieldDescricao2().setText(achouProduto.getDescricao());
				painelincluirtens.getTextFieldValor2().setText(String.valueOf(achouProduto.getValorvenda()));
				((JTextComponent) painelincluirtens.getComboBoxDiadaSemana2().getSelectedItem()).setText(achouProduto.getDiadasemana());
				
				
			}
		});
		bntProcurar.setBounds(203, 13, 89, 23);
		add(bntProcurar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 238, 472, 214);
		add(textArea);
	}
}
