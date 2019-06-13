package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;

public class PainelBoasVindas extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelBoasVindas() {
		setLayout(null);
		
		JLabel lblFastFood = new JLabel("Fast Food");
		lblFastFood.setForeground(new Color(255, 0, 0));
		lblFastFood.setFont(new Font("Verdana", Font.BOLD, 39));
		lblFastFood.setBounds(128, 11, 260, 69);
		add(lblFastFood);
		
		JTextPane txtpnBemVindoAo = new JTextPane();
		txtpnBemVindoAo.setText("Bem vindo ao sistema de pedidos do Fast Food, aqui ser\u00E1 feito o pedido para o seu cliente.\r\nPara criar o pedido, escolha o menu Negocios > Pedido\r\nPara solicitar compra de um produto para nosso estoque, escolha o menu Negocios > Compra");
		txtpnBemVindoAo.setBounds(20, 169, 496, 56);
		add(txtpnBemVindoAo);

	}
}
