package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Negocios.Fachada;
import Negocios.Funcionario;
import Negocios.InserirException;
import Negocios.Pessoa;
import Negocios.Pedido;
import Negocios.PedidoException;
import Negocios.Produtos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCriarPedido extends JPanel {
	private JTextField textFieldNPedido;
	private JTextField textFieldCodCliente;
	private JTextField textFieldCodFuncionario;
	private JTextField textFieldData;
	private JTextField textFieldValorProdutos;
	private JLabel lblValorTotal;
	private JTextField textFieldValorTotal;
	private JButton btnSalvar;
	private JTextField textFieldNomeFunc;
	private JTextField textFieldNomeCliente;

	/**
	 * Create the panel.
	 */
	public PainelCriarPedido() {
		setLayout(null);
		
		JLabel labelNPedido = new JLabel("N\u00B0 Pedido:");
		labelNPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNPedido.setBounds(10, 14, 88, 25);
		add(labelNPedido);
		
		textFieldNPedido = new JTextField();
		textFieldNPedido.setEditable(false);
		textFieldNPedido.setColumns(10);
		textFieldNPedido.setBounds(138, 18, 46, 20);
		add(textFieldNPedido);
		
		textFieldCodCliente = new JTextField();
		textFieldCodCliente.setColumns(10);
		textFieldCodCliente.setBounds(138, 41, 46, 20);
		add(textFieldCodCliente);
		
		JLabel labelCodCliente = new JLabel("Codigo Cliente:");
		labelCodCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCodCliente.setBounds(10, 38, 106, 25);
		add(labelCodCliente);
		
		JLabel labelCodFuncionario = new JLabel("Codigo Funcionario:");
		labelCodFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCodFuncionario.setBounds(10, 63, 122, 21);
		add(labelCodFuncionario);
		
		textFieldCodFuncionario = new JTextField();
		textFieldCodFuncionario.setColumns(10);
		textFieldCodFuncionario.setBounds(138, 67, 46, 20);
		add(textFieldCodFuncionario);
		
		JLabel labelData = new JLabel("Data da Venda:");
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(10, 84, 106, 30);
		add(labelData);
		
		textFieldData = new JTextField();
		textFieldData.setEditable(false);
		textFieldData.setText("");
		textFieldData.setColumns(10);
		textFieldData.setBounds(137, 91, 65, 20);
		add(textFieldData);
		
		JLabel labelValorPedido = new JLabel("Valor do Pedido:");
		labelValorPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelValorPedido.setBounds(10, 108, 122, 30);
		add(labelValorPedido);
		
		textFieldValorProdutos = new JTextField();
		textFieldValorProdutos.setEditable(false);
		textFieldValorProdutos.setColumns(10);
		textFieldValorProdutos.setBounds(138, 115, 64, 20);
		add(textFieldValorProdutos);
		
		lblValorTotal = new JLabel("Valor Final:");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorTotal.setBounds(252, 17, 88, 19);
		add(lblValorTotal);
		
		textFieldValorTotal = new JTextField();
		textFieldValorTotal.setEditable(false);
		textFieldValorTotal.setColumns(10);
		textFieldValorTotal.setBounds(350, 19, 71, 18);
		add(textFieldValorTotal);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCriarPedido painelcriarpedido = new PainelCriarPedido();
				painelcriarpedido.setVisible(true);
				
				Pessoa cliente = new Pessoa();
				Pessoa funcionario = new Funcionario();
	
				
				cliente.setCodigo(textFieldCodCliente.getText());
				funcionario.setCodigo(textFieldCodFuncionario.getText());
				
				
				
				while(true) {
					try {
						Pedido.getInstance().setAdicional(Double.parseDouble(textFieldAdicional.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Adicional)");
						e2.printStackTrace();
					}
					textFieldValorProdutos.setText(String.valueOf(Pedido.getInstance().getProdutos().getValor()));
					textFieldValorTotal.setText(String.valueOf(Pedido.getInstance().getProdutos().getValor() + Pedido.getInstance().getAdicional()));
				
				try {
					Fachada.getInstance().cadastrarPedido(Pedido.getInstance());
					Pedido.getInstance().setStatus("Sim");
				} catch (PedidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					break;
				}
					JOptionPane.showMessageDialog(null, "Pedido Cadastrada com Sucesso!");
					painelcriarpedido.setVisible(false);
					break;
				}
			}
		});
		btnSalvar.setBounds(252, 161, 89, 23);
		add(btnSalvar);
		
		JButton btnInserirItens = new JButton("Itens");
		btnInserirItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnInserirItens.setBounds(10, 161, 89, 23);
		add(btnInserirItens);
		
		textFieldNomeFunc = new JTextField();
		textFieldNomeFunc.setEditable(false);
		textFieldNomeFunc.setBounds(194, 41, 173, 20);
		add(textFieldNomeFunc);
		textFieldNomeFunc.setColumns(10);
		
		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setEditable(false);
		textFieldNomeCliente.setBounds(194, 65, 173, 20);
		add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(351, 161, 89, 23);
		add(btnCancelar);

	}
}
