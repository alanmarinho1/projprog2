package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.ProdutoJaExisteException;
import Negocios.Produtos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PainelCriarProduto extends JPanel {
	private JTextField textFieldCodigo;
	private JTextField textFieldDescricao;
	private JTextField textFieldValorVenda;
	private JTextField textFieldValorCompra;
	private JTextField textFieldQuantidade;

	/**
	 * Create the panel.
	 */
	public PainelCriarProduto() {
		setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(17, 17, 71, 25);
		add(label);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(135, 21, 76, 20);
		add(textFieldCodigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(17, 41, 86, 25);
		add(lblDescrio);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(135, 45, 174, 20);
		add(textFieldDescricao);
		
		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorDeVenda.setBounds(17, 66, 96, 21);
		add(lblValorDeVenda);
		
		textFieldValorVenda = new JTextField();
		textFieldValorVenda.setColumns(10);
		textFieldValorVenda.setBounds(135, 71, 130, 20);
		add(textFieldValorVenda);
		
		JLabel lblValorDeCompra = new JLabel("Valor de Compra:");
		lblValorDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorDeCompra.setBounds(17, 87, 108, 25);
		add(lblValorDeCompra);
		
		textFieldValorCompra = new JTextField();
		textFieldValorCompra.setColumns(10);
		textFieldValorCompra.setBounds(135, 91, 71, 20);
		add(textFieldValorCompra);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setEditable(false);
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(135, 112, 86, 18);
		add(textFieldQuantidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(17, 110, 86, 18);
		add(lblQuantidade);
		
		JLabel lblPromooDoDia = new JLabel("Promo\u00E7\u00E3o do dia:");
		lblPromooDoDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPromooDoDia.setBounds(227, 92, 114, 20);
		add(lblPromooDoDia);
		
		JComboBox comboBoxDiadaSemana = new JComboBox();
		comboBoxDiadaSemana.setBounds(344, 92, 114, 20);
		add(comboBoxDiadaSemana);
		comboBoxDiadaSemana.addItem("Segunda-feira");
		comboBoxDiadaSemana.addItem("Terça-feira");
		comboBoxDiadaSemana.addItem("Quarta-feira");
		comboBoxDiadaSemana.addItem("Quinta-feira");
		comboBoxDiadaSemana.addItem("Sexta-feira");
		comboBoxDiadaSemana.addItem("Sabado");
		comboBoxDiadaSemana.addItem("Domingo");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCriarProduto painelcriarproduto = new PainelCriarProduto();
				painelcriarproduto.setVisible(true);
				
				Produtos produto = new Produtos();
	
				produto.setDescricao(textFieldDescricao.getText());
				produto.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
				produto.setDiadasemana((String) comboBoxDiadaSemana.getSelectedItem());
				
				
				try {
					produto.setValorvenda(Double.parseDouble(textFieldValorVenda.getText()));
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Venda)");
					e2.printStackTrace();
				}
				while(true) {
					try {
						produto.setValorvenda(Double.parseDouble(textFieldValorVenda.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Venda)");
						e2.printStackTrace();
						break;
					}
					try {
						produto.setValorcompra(Double.parseDouble(textFieldValorCompra.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Compra)");
						e2.printStackTrace();
					}
					while(true) {
						try {
							produto.setValorcompra(Double.parseDouble(textFieldValorCompra.getText()));
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Compra)");
							e2.printStackTrace();
							break;
						}
					}
					try {
						Fachada.getInstance().cadastrarProduto(produto);
					} catch (InserirException e1) {
						JOptionPane.showMessageDialog(null, "A descrição está vazia");
						e1.printStackTrace();
						break;
					} catch (ProdutoJaExisteException e2) {
						JOptionPane.showMessageDialog(null, "Esse produto já existe");
						e2.printStackTrace();
						break;
					}
					
				JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
				painelcriarproduto.setVisible(false);
				break;
				}
				
			}
		});
		btnSalvar.setBounds(300, 145, 89, 23);
		add(btnSalvar);
		
		
		
		

	}
	
}