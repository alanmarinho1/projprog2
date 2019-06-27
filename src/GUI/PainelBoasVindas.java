package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;

import Negocios.Fachada;
import Negocios.Funcionario;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.NaoLocalizadoUsuarioException;

public class PainelBoasVindas extends JPanel {

	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public PainelBoasVindas() {
		setLayout(null);
	
		Funcionario funcionario = null;
		
			try {
				funcionario = Fachada.getInstance().procurarUsuario(Login.getInstance().getTextFieldUsuario().getText(), Login.getInstance().getPasswordField().getText());
			} catch (NaoLocalizadoUsuarioException e) {
				e.printStackTrace();
			}
		
		
		
		JLabel lblFastFood = new JLabel("Sistema de Pedidos - Fast Food");
		lblFastFood.setForeground(new Color(255, 0, 0));
		lblFastFood.setFont(new Font("Verdana", Font.BOLD, 32));
		lblFastFood.setBounds(35, 53, 574, 69);
		add(lblFastFood);
		
		JTextPane txtpnBemVindoAo = new JTextPane();
		txtpnBemVindoAo.setText("Bem vindo, " + funcionario.getNome() + ". ao Sistema de Pedidos do Fast Food. \r\n\r\nAqui ser\u00E1 feito o processo do pedido para o seu cliente. Para criar o pedido, escolha o menu Negocios > Pedido\r\nCertifique-se que temos produtos em Estoque, e caso n\u00E3o tenha solicite a compra do produto no nosso proprio sistema.\r\nPara solicitar compra de um produto , escolha o menu Negocios > Compra\r\nVoce tamb\u00E9m pode consultar o saldo no nosso caixa, no meno Financeiro > Caixa\r\n\r\nCaso tenha algum problema de sistema ou deseja reportar algum bug, entre em contato com o Administrador do Sistema.");
		txtpnBemVindoAo.setBounds(10, 152, 612, 222);
		add(txtpnBemVindoAo);

	}
	
}
