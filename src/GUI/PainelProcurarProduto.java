package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.ProdutoJaExisteException;
import Negocios.Produtos;

public class PainelProcurarProduto extends JPanel {

	private JTextField textFieldCodigo2;
	private JTextField textFieldDescricao2;
	private JTextField textFieldValorVenda2;
	private JTextField textFieldValorCompra2;
	private JTextField textFieldQuantidade2;
	private JComboBox comboBoxDiadaSemana2;
	protected PainelProcurarProduto painelproduto;
	
	/**
	 * Create the panel.
	 */
	public PainelProcurarProduto() {
		setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(17, 17, 71, 25);
		add(label);
		
		textFieldCodigo2 = new JTextField();
		textFieldCodigo2.setEditable(false);
		textFieldCodigo2.setColumns(10);
		textFieldCodigo2.setBounds(135, 21, 76, 20);
		add(textFieldCodigo2);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(17, 41, 86, 25);
		add(lblDescrio);
		
		textFieldDescricao2 = new JTextField();
		textFieldDescricao2.setEditable(false);
		textFieldDescricao2.setColumns(10);
		textFieldDescricao2.setBounds(135, 45, 174, 20);
		add(textFieldDescricao2);
		
		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorDeVenda.setBounds(17, 66, 96, 21);
		add(lblValorDeVenda);
		
		textFieldValorVenda2 = new JTextField();
		textFieldValorVenda2.setEditable(false);
		textFieldValorVenda2.setColumns(10);
		textFieldValorVenda2.setBounds(135, 71, 130, 20);
		add(textFieldValorVenda2);
		
		JLabel lblValorDeCompra = new JLabel("Valor de Compra:");
		lblValorDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorDeCompra.setBounds(17, 87, 108, 25);
		add(lblValorDeCompra);
		
		textFieldValorCompra2 = new JTextField();
		textFieldValorCompra2.setEditable(false);
		textFieldValorCompra2.setColumns(10);
		textFieldValorCompra2.setBounds(135, 91, 71, 20);
		add(textFieldValorCompra2);
		
		textFieldQuantidade2 = new JTextField();
		textFieldQuantidade2.setEditable(false);
		textFieldQuantidade2.setColumns(10);
		textFieldQuantidade2.setBounds(135, 112, 86, 18);
		add(textFieldQuantidade2);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(17, 110, 86, 18);
		add(lblQuantidade);
		
		JLabel lblPromooDoDia = new JLabel("Promo\u00E7\u00E3o do dia:");
		lblPromooDoDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPromooDoDia.setBounds(227, 92, 114, 20);
		add(lblPromooDoDia);
		
		JComboBox comboBoxDiadaSemana2 = new JComboBox();
		comboBoxDiadaSemana2.setBounds(344, 92, 114, 20);
		add(comboBoxDiadaSemana2);
		comboBoxDiadaSemana2.addItem("Segunda-feira");
		comboBoxDiadaSemana2.addItem("Terça-feira");
		comboBoxDiadaSemana2.addItem("Quarta-feira");
		comboBoxDiadaSemana2.addItem("Quinta-feira");
		comboBoxDiadaSemana2.addItem("Sexta-feira");
		comboBoxDiadaSemana2.addItem("Sabado");
		comboBoxDiadaSemana2.addItem("Domingo");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCriarProduto painelcriarproduto = new PainelCriarProduto();
				painelcriarproduto.setVisible(true);
				
				Produtos produto = new Produtos();
	
				produto.setDescricao(textFieldDescricao2.getText());
				produto.setQuantidade(Integer.parseInt(textFieldQuantidade2.getText()));
				produto.setDiadasemana((String) comboBoxDiadaSemana2.getSelectedItem());
				
				
				try {
					produto.setValorvenda(Double.parseDouble(textFieldValorVenda2.getText()));
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Venda)");
					e2.printStackTrace();
				}
				while(true) {
					try {
						produto.setValorvenda(Double.parseDouble(textFieldValorVenda2.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Venda)");
						e2.printStackTrace();
						break;
					}
					try {
						produto.setValorcompra(Double.parseDouble(textFieldValorCompra2.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Compra)");
						e2.printStackTrace();
					}
					while(true) {
						try {
							produto.setValorcompra(Double.parseDouble(textFieldValorCompra2.getText()));
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
		btnSalvar.setBounds(240, 152, 89, 23);
		add(btnSalvar);
		
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldDescricao2.setEditable(true);
				textFieldValorVenda2.setEditable(true);
				textFieldValorCompra2.setEditable(true);
				comboBoxDiadaSemana2.setEditable(true);
				
				
				
				btnAlterar.setVisible(false);
				btnSalvar.setVisible(true);
			}
		});
		btnAlterar.setBounds(240, 152, 89, 23);
		add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTelaProduto telaproduto = new PrimeiraTelaProduto();
				telaproduto.setVisible(true);
				painelproduto.setVisible(false);
			}
		});
		btnCancelar.setBounds(344, 152, 89, 23);
		add(btnCancelar);
		
		
	}

	public JTextField getTextFieldCodigo2() {
		return textFieldCodigo2;
	}

	public void setTextFieldCodigo2(JTextField textFieldCodigo2) {
		this.textFieldCodigo2 = textFieldCodigo2;
	}

	public JTextField getTextFieldDescricao2() {
		return textFieldDescricao2;
	}

	public void setTextFieldDescricao2(JTextField textFieldDescricao2) {
		this.textFieldDescricao2 = textFieldDescricao2;
	}

	public JTextField getTextFieldValorVenda2() {
		return textFieldValorVenda2;
	}

	public void setTextFieldValorVenda2(JTextField textFieldValorVenda2) {
		this.textFieldValorVenda2 = textFieldValorVenda2;
	}

	public JTextField getTextFieldValorCompra2() {
		return textFieldValorCompra2;
	}

	public void setTextFieldValorCompra2(JTextField textFieldValorCompra2) {
		this.textFieldValorCompra2 = textFieldValorCompra2;
	}

	public JTextField getTextFieldQuantidade2() {
		return textFieldQuantidade2;
	}

	public void setTextFieldQuantidade2(JTextField textFieldQuantidade2) {
		this.textFieldQuantidade2 = textFieldQuantidade2;
	}

	public JComboBox getComboBoxDiadaSemana2() {
		return comboBoxDiadaSemana2;
	}

	public void setComboBoxDiadaSemana2(JComboBox comboBoxDiadaSemana2) {
		this.comboBoxDiadaSemana2 = comboBoxDiadaSemana2;
	}

}
