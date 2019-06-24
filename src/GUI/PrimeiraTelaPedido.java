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
import Negocios.NaoLocalizadoPedidoException;
import Negocios.Pedido;
import Negocios.PedidoException;

public class PrimeiraTelaPedido extends JPanel {

	private JTextField textFieldID;
	/**
	 * Create the panel.
	 */
	public PrimeiraTelaPedido() {
		setLayout(null);
		
		JLabel lblID = new JLabel("N° Pedido:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(10, 11, 89, 22);
		add(lblID);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(93, 14, 108, 20);
		add(textFieldID);
		
		PainelProcurarPedido painelprocurapedido = new PainelProcurarPedido();
		painelprocurapedido.setBounds(10, 44, 462, 202);
		add(painelprocurapedido);
		painelprocurapedido.setLayout(null);
		painelprocurapedido.setVisible(false);
		
		PainelCriarPedido painelcriarpedido = new PainelCriarPedido();
		painelcriarpedido.setBounds(10, 44, 462, 202);
		add(painelcriarpedido);
		painelcriarpedido.setLayout(null);
		painelcriarpedido.setVisible(false);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido pedido = new Pedido();
				
				try {
					Fachada.getInstance().cadastrarPedido(pedido);
				} catch (PedidoException e1) {
					e1.printStackTrace();
				}
				
				painelcriarpedido.setVisible(true);
				painelprocurapedido.setVisible(false);
			}
		});
		btnCriar.setBounds(363, 13, 89, 23);
		add(btnCriar);
		btnCriar.setVisible(false);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pedido achouPedido = null;
				try {
					achouPedido = (Pedido) Fachada.getInstance().procurarPedido(textFieldID.getText());
				} catch (NaoLocalizadoPedidoException e1) {
					JOptionPane.showMessageDialog(null, "O Pedido não existe.");
					e1.printStackTrace();
					btnCriar.setVisible(true);
				 }
				
				painelcriarpedido.setVisible(false);
				painelprocurapedido.setVisible(true);
				
				painelprocurapedido.getTextFieldNPedido2().setText(achouPedido.getCodPedido());
				painelprocurapedido.getTextFieldCliente2().setText(achouPedido.getCliente().getNome());
				painelprocurapedido.getTextFieldFuncionario2().setText(achouPedido.getFuncionario().getNome());
				painelprocurapedido.getTextFieldPlacaVeiculo2().setText(achouPedido.getVeiculo().getPlaca());
				painelprocurapedido.getTextFieldValor2().setText(String.valueOf(achouPedido.getValor()));
				painelprocurapedido.getTextFieldData2().setText(achouPedido.getData());
				painelprocurapedido.getTextFieldStatus2().setText(achouPedido.getStatus());
			
			}
		});
		bntProcurar.setBounds(220, 13, 89, 23);
		add(bntProcurar);
		
	}

}
