package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.ProdutoJaExisteException;
import Negocios.Produtos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAlterarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldDescricao;
	private JTextField textFieldValorVenda;
	private JTextField textFieldValorCompra;
	private JTextField textFieldQuantidade;
	private JComboBox comboBoxDiadaSemana;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAlterarProduto frame = new FrameAlterarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameAlterarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(17, 17, 71, 25);
		getContentPane().add(label);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(135, 21, 76, 20);
		getContentPane().add(textFieldCodigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(17, 41, 86, 25);
		getContentPane().add(lblDescrio);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(135, 45, 174, 20);
		getContentPane().add(textFieldDescricao);
		
		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorDeVenda.setBounds(17, 66, 96, 21);
		getContentPane().add(lblValorDeVenda);
		
		textFieldValorVenda = new JTextField();
		textFieldValorVenda.setColumns(10);
		textFieldValorVenda.setBounds(135, 71, 71, 20);
		getContentPane().add(textFieldValorVenda);
		
		JLabel lblValorDeCompra = new JLabel("Valor de Compra:");
		lblValorDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorDeCompra.setBounds(17, 87, 108, 25);
		getContentPane().add(lblValorDeCompra);
		
		textFieldValorCompra = new JTextField();
		textFieldValorCompra.setColumns(10);
		textFieldValorCompra.setBounds(135, 91, 71, 20);
		getContentPane().add(textFieldValorCompra);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setEditable(false);
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(135, 112, 46, 18);
		getContentPane().add(textFieldQuantidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(17, 110, 86, 18);
		getContentPane().add(lblQuantidade);
		
		JLabel lblPromooDoDia = new JLabel("Promo\u00E7\u00E3o do dia:");
		lblPromooDoDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPromooDoDia.setBounds(17, 134, 114, 20);
		getContentPane().add(lblPromooDoDia);
		
		comboBoxDiadaSemana = new JComboBox();
		comboBoxDiadaSemana.setEditable(true);
		comboBoxDiadaSemana.setBounds(134, 134, 114, 20);
		getContentPane().add(comboBoxDiadaSemana);
		comboBoxDiadaSemana.addItem("Segunda-feira");
		comboBoxDiadaSemana.addItem("Terça-feira");
		comboBoxDiadaSemana.addItem("Quarta-feira");
		comboBoxDiadaSemana.addItem("Quinta-feira");
		comboBoxDiadaSemana.addItem("Sexta-feira");
		comboBoxDiadaSemana.addItem("Sabado");
		comboBoxDiadaSemana.addItem("Domingo");
		
		JButton button = new JButton("Alterar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produtos produto = new Produtos();
				
				produto.setCodigo(textFieldCodigo.getText());
				produto.setDescricao(textFieldDescricao.getText());
				produto.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
				produto.setDiadasemana(String.valueOf((String) comboBoxDiadaSemana.getSelectedItem()));
				
				while(true) {
					try {
						produto.setValorvenda(Double.parseDouble(textFieldValorVenda.getText()));
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Venda)");
						e1.printStackTrace();
						break;
					}
										
					try {
						produto.setValorcompra(Double.parseDouble(textFieldValorCompra.getText()));
						} catch (NumberFormatException e3) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Valor da Compra)");
						e3.printStackTrace();
							break;
					}
					try {
						Fachada.getInstance().alterarProduto(produto);
					} catch (InserirException e4) {
						JOptionPane.showMessageDialog(null, "A descrição está vazia");
						e4.printStackTrace();
						break;
					} catch (ProdutoJaExisteException e5) {
						JOptionPane.showMessageDialog(null, "Esse produto já existe");
						e5.printStackTrace();
						break;
					}
					
				JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");
				dispose();
				break;
				}
				
			}
		});
		button.setBounds(335, 227, 89, 23);
		contentPane.add(button);
		
		JButton button_2 = new JButton("Voltar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setBounds(335, 24, 89, 23);
		contentPane.add(button_2);
		
	}

	public JTextField getTextFieldCodigo() {
		return textFieldCodigo;
	}

	public void setTextFieldCodigo(JTextField textFieldCodigo) {
		this.textFieldCodigo = textFieldCodigo;
	}

	public JTextField getTextFieldDescricao() {
		return textFieldDescricao;
	}

	public void setTextFieldDescricao(JTextField textFieldDescricao) {
		this.textFieldDescricao = textFieldDescricao;
	}

	public JTextField getTextFieldValorVenda() {
		return textFieldValorVenda;
	}

	public void setTextFieldValorVenda(JTextField textFieldValorVenda) {
		this.textFieldValorVenda = textFieldValorVenda;
	}

	public JTextField getTextFieldValorCompra() {
		return textFieldValorCompra;
	}

	public void setTextFieldValorCompra(JTextField textFieldValorCompra) {
		this.textFieldValorCompra = textFieldValorCompra;
	}

	public JTextField getTextFieldQuantidade() {
		return textFieldQuantidade;
	}

	public void setTextFieldQuantidade(JTextField textFieldQuantidade) {
		this.textFieldQuantidade = textFieldQuantidade;
	}

	public JComboBox getComboBoxDiadaSemana() {
		return comboBoxDiadaSemana;
	}

	public void setComboBoxDiadaSemana(JComboBox comboBoxDiadaSemana) {
		this.comboBoxDiadaSemana = comboBoxDiadaSemana;
	}

}
