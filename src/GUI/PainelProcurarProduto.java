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
import Negocios.InserirException;
import Negocios.Veiculo;

public class PainelProcurarProduto extends JPanel {

	private JTextField textFieldCodVeiculo2;
	private JTextField textFieldFabricante2;
	private JTextField textFieldModelo2;
	private JTextField textFieldChassi2;
	private JTextField textFieldValor2;
	private JTextField textFieldCombustivel2;
	private JTextField textFieldPlaca2;	
	private JTextField textFieldEstoque2;
	private JTextField textFieldCor2;
	
	/**
	 * Create the panel.
	 */
	public PainelProcurarProduto() {
		setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 11, 71, 25);
		add(label);
		
		textFieldCodVeiculo2 = new JTextField();
		textFieldCodVeiculo2.setEditable(false);
		textFieldCodVeiculo2.setColumns(10);
		textFieldCodVeiculo2.setBounds(82, 18, 76, 20);
		add(textFieldCodVeiculo2);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabricante.setBounds(10, 35, 86, 25);
		add(lblFabricante);
		
		textFieldFabricante2 = new JTextField();
		textFieldFabricante2.setEditable(false);
		textFieldFabricante2.setColumns(10);
		textFieldFabricante2.setBounds(82, 42, 148, 20);
		add(textFieldFabricante2);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(10, 60, 59, 21);
		add(lblModelo);
		
		textFieldModelo2 = new JTextField();
		textFieldModelo2.setEditable(false);
		textFieldModelo2.setColumns(10);
		textFieldModelo2.setBounds(82, 65, 148, 20);
		add(textFieldModelo2);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaca.setBounds(10, 81, 71, 25);
		add(lblPlaca);
		
		JLabel lblChassi = new JLabel("Chassi:");
		lblChassi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChassi.setBounds(10, 103, 59, 30);
		add(lblChassi);
		
		textFieldChassi2 = new JTextField();
		textFieldChassi2.setText("");
		textFieldChassi2.setEditable(false);
		textFieldChassi2.setColumns(10);
		textFieldChassi2.setBounds(82, 113, 148, 20);
		add(textFieldChassi2);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(10, 127, 52, 30);
		add(lblValor);
		
		textFieldValor2 = new JTextField();
		textFieldValor2.setEditable(false);
		textFieldValor2.setColumns(10);
		textFieldValor2.setBounds(82, 137, 76, 20);
		add(textFieldValor2);
		
		JLabel lblCombustivel = new JLabel("Combustivel:");
		lblCombustivel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCombustivel.setBounds(240, 8, 89, 30);
		add(lblCombustivel);
		
		textFieldCombustivel2 = new JTextField();
		textFieldCombustivel2.setEditable(false);
		textFieldCombustivel2.setColumns(10);
		textFieldCombustivel2.setBounds(323, 15, 86, 20);
		add(textFieldCombustivel2);
		
		textFieldPlaca2 = new JTextField();
		textFieldPlaca2.setEditable(false);
		textFieldPlaca2.setColumns(10);
		textFieldPlaca2.setBounds(82, 88, 71, 20);
		add(textFieldPlaca2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new Veiculo();
				veiculo.setFabricante(textFieldFabricante2.getText());
				veiculo.setModelo(textFieldModelo2.getText());
				veiculo.setPlaca(textFieldPlaca2.getText());
				veiculo.setChassi(textFieldChassi2.getText());
				veiculo.setCor(textFieldCor2.getText());
				veiculo.setCombustivel(textFieldCombustivel2.getText());
				while(true) {
					try {
						veiculo.setValor(Integer.parseInt(textFieldValor2.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo RG)");
						e2.printStackTrace();
						break;
					}
					try {
						Fachada.getInstance().alterarVeiculo(veiculo);
					} catch (InserirException e1) {
						JOptionPane.showMessageDialog(null, "Digite um Chassi válido");
						e1.printStackTrace();
						break;
					}
				JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso!");
				btnSalvar.setVisible(false);
				break;
				}
				
			}
		});
		btnSalvar.setBounds(240, 152, 89, 23);
		add(btnSalvar);
		btnSalvar.setVisible(false);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new Veiculo();
				veiculo.setCodVeiculo((textFieldCodVeiculo2.getText()));
				Fachada.getInstance().removerVeiculo((veiculo.getCodVeiculo()));
				JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso!");
			}
		});
		btnExcluir.setBounds(349, 152, 89, 23);
		add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldFabricante2.setEditable(true);
				textFieldCombustivel2.setEditable(true);
				textFieldModelo2.setEditable(true);
				textFieldPlaca2.setEditable(true);
				textFieldValor2.setEditable(true);
				textFieldChassi2.setEditable(true);
				
				btnAlterar.setVisible(false);
				btnExcluir.setVisible(false);
				btnSalvar.setVisible(true);
			}
		});
		btnAlterar.setBounds(240, 152, 89, 23);
		add(btnAlterar);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstoque.setBounds(240, 38, 65, 18);
		add(lblEstoque);
		
		textFieldEstoque2 = new JTextField();
		textFieldEstoque2.setEditable(false);
		textFieldEstoque2.setBounds(323, 39, 86, 18);
		add(textFieldEstoque2);
		textFieldEstoque2.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCor.setBounds(240, 65, 46, 14);
		add(lblCor);
		
		textFieldCor2 = new JTextField();
		textFieldCor2.setEditable(false);
		textFieldCor2.setBounds(323, 65, 86, 16);
		add(textFieldCor2);
		textFieldCor2.setColumns(10);
	}

	public JTextField getTextFieldCodVeiculo2() {
		return textFieldCodVeiculo2;
	}

	public void setTextFieldCodVeiculo2(JTextField textFieldCodVeiculo2) {
		this.textFieldCodVeiculo2 = textFieldCodVeiculo2;
	}

	public JTextField getTextFieldFabricante2() {
		return textFieldFabricante2;
	}

	public void setTextFieldFabricante2(JTextField textFieldFabricante2) {
		this.textFieldFabricante2 = textFieldFabricante2;
	}

	public JTextField getTextFieldModelo2() {
		return textFieldModelo2;
	}

	public void setTextFieldModelo2(JTextField textFieldModelo2) {
		this.textFieldModelo2 = textFieldModelo2;
	}

	public JTextField getTextFieldChassi2() {
		return textFieldChassi2;
	}

	public void setTextFieldChassi2(JTextField textFieldChassi2) {
		this.textFieldChassi2 = textFieldChassi2;
	}

	public JTextField getTextFieldValor2() {
		return textFieldValor2;
	}

	public void setTextFieldValor2(JTextField textFieldValor2) {
		this.textFieldValor2 = textFieldValor2;
	}

	public JTextField getTextFieldCombustivel2() {
		return textFieldCombustivel2;
	}

	public void setTextFieldCombustivel2(JTextField textFieldCombustivel2) {
		this.textFieldCombustivel2 = textFieldCombustivel2;
	}

	public JTextField getTextFieldPlaca2() {
		return textFieldPlaca2;
	}

	public void setTextFieldPlaca2(JTextField textFieldPlaca2) {
		this.textFieldPlaca2 = textFieldPlaca2;
	}

	public JTextField getTextFieldEstoque2() {
		return textFieldEstoque2;
	}

	public void setTextFieldEstoque2(JTextField textFieldEstoque2) {
		this.textFieldEstoque2 = textFieldEstoque2;
	}

	public JTextField getTextFieldCor2() {
		return textFieldCor2;
	}

	public void setTextFieldCor2(JTextField textFieldCor2) {
		this.textFieldCor2 = textFieldCor2;
	}
}
