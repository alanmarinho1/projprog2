package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import Negocios.Fachada;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.NaoLocalizadoProdutoException;

import Negocios.Produtos;

public class PrimeiraTelaProduto extends JPanel {

	private JTextField textFieldCodigo;
	/**
	 * Create the panel.
	 */
	public PrimeiraTelaProduto() {
		setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 11, 63, 22);
		add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(62, 14, 148, 20);
		add(textFieldCodigo);
		
		PainelCriarProduto painelcriarproduto = new PainelCriarProduto();
		painelcriarproduto.setBounds(10, 44, 475, 202);
		add(painelcriarproduto);
		painelcriarproduto.setLayout(null);
		painelcriarproduto.setVisible(false);
		
		PainelProcurarProduto painelprocuraproduto = new PainelProcurarProduto();
		painelprocuraproduto.setBounds(10, 44, 475, 202);
		add(painelprocuraproduto);
		painelprocuraproduto.setLayout(null);
		painelprocuraproduto.setVisible(false);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelcriarproduto.setVisible(true);
				painelprocuraproduto.setVisible(false);
			}
		});
		btnCriar.setBounds(363, 13, 89, 23);
		add(btnCriar);
		btnCriar.setVisible(false);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produtos achouProduto = null;
				try {
					achouProduto = Fachada.getInstance().procurarProduto(textFieldCodigo.getText());
				} catch (NaoLocalizadoProdutoException e1) {
					JOptionPane.showMessageDialog(null, "O Produto não existe.");
					e1.printStackTrace();
					btnCriar.setVisible(true);
				 }
				
				painelcriarproduto.setVisible(false);
				painelprocuraproduto.setVisible(true);
				
				painelprocuraproduto.getTextFieldCodigo2().setText(achouProduto.getCodigo());
				painelprocuraproduto.getTextFieldDescricao2().setText(achouProduto.getDescricao());
				painelprocuraproduto.getTextFieldValorVenda2().setText(String.valueOf(achouProduto.getValorvenda()));
				painelprocuraproduto.getTextFieldValorCompra2().setText(String.valueOf(achouProduto.getValorcompra()));
				painelprocuraproduto.getTextFieldQuantidade2().setText(String.valueOf(achouProduto.getQuantidade()));
				((JTextComponent) painelprocuraproduto.getComboBoxDiadaSemana2().getSelectedItem()).setText(achouProduto.getDiadasemana());
				
				
			}
		});
		bntProcurar.setBounds(220, 13, 89, 23);
		add(bntProcurar);
		
	}

}
