package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Negocios.Fachada;
import Negocios.Funcionario;
import Negocios.InserirException;
import Negocios.Pessoa;
import Negocios.Proposta;
import Negocios.PropostaException;
import Negocios.Veiculo;

public class PainelProcurarPedido extends JPanel {
	private JTextField textFieldNProposta2;
	private JTextField textFieldCliente2;
	private JTextField textFieldFuncionario2;
	private JTextField textFieldPlacaVeiculo2;
	private JTextField textFieldData2;
	private JTextField textFieldValor2;
	private JTextField textFieldStatus2;
	private JTextField textFieldCodCliente;
	private JTextField textFieldCodFuncionario;
	private JTextField textFieldCodVeiculo;
	private JTextField textFieldData;
	private JTextField textFieldAdicional;
	private JTextField textFieldValor;

	/**
	 * Create the panel.
	 */
	public PainelProcurarPedido() {
		setLayout(null);
		
		JLabel labelNProposta = new JLabel("N\u00B0 Proposta:");
		labelNProposta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNProposta.setBounds(10, 14, 86, 25);
		add(labelNProposta);
		
		textFieldNProposta2 = new JTextField();
		textFieldNProposta2.setEditable(false);
		textFieldNProposta2.setColumns(10);
		textFieldNProposta2.setBounds(116, 18, 49, 20);
		add(textFieldNProposta2);
		
		JLabel labelCliente = new JLabel("Cliente:");
		labelCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCliente.setBounds(10, 38, 86, 25);
		add(labelCliente);
		
		textFieldCliente2 = new JTextField();
		textFieldCliente2.setEditable(false);
		textFieldCliente2.setColumns(10);
		textFieldCliente2.setBounds(116, 45, 96, 20);
		add(textFieldCliente2);
		
		JLabel labelFuncionario = new JLabel("Funcionario:");
		labelFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFuncionario.setBounds(10, 63, 86, 21);
		add(labelFuncionario);
		
		textFieldFuncionario2 = new JTextField();
		textFieldFuncionario2.setEditable(false);
		textFieldFuncionario2.setColumns(10);
		textFieldFuncionario2.setBounds(116, 68, 96, 20);
		add(textFieldFuncionario2);
		
		JLabel labelPlacaVeiculo = new JLabel("Placa do Veiculo:");
		labelPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPlacaVeiculo.setBounds(10, 84, 102, 25);
		add(labelPlacaVeiculo);
		
		textFieldPlacaVeiculo2 = new JTextField();
		textFieldPlacaVeiculo2.setEditable(false);
		textFieldPlacaVeiculo2.setColumns(10);
		textFieldPlacaVeiculo2.setBounds(116, 91, 96, 20);
		add(textFieldPlacaVeiculo2);
		
		JLabel labelData = new JLabel("Data da Venda:");
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(10, 106, 102, 30);
		add(labelData);
		
		textFieldData2 = new JTextField();
		textFieldData2.setEditable(false);
		textFieldData2.setColumns(10);
		textFieldData2.setBounds(118, 116, 76, 20);
		add(textFieldData2);
		
		JLabel labelValor = new JLabel("Valor:");
		labelValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelValor.setBounds(10, 133, 52, 30);
		add(labelValor);
		
		textFieldValor2 = new JTextField();
		textFieldValor2.setEditable(false);
		textFieldValor2.setColumns(10);
		textFieldValor2.setBounds(118, 140, 76, 20);
		add(textFieldValor2);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(240, 11, 89, 30);
		add(lblStatus);
		
		textFieldStatus2 = new JTextField();
		textFieldStatus2.setEditable(false);
		textFieldStatus2.setColumns(10);
		textFieldStatus2.setBounds(323, 18, 86, 20);
		add(textFieldStatus2);
		
		JLabel label = new JLabel("Codigo Cliente:");
		label.setVisible(false);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 38, 106, 25);
		add(label);
		
		textFieldCodCliente = new JTextField();
		textFieldCodCliente.setVisible(false);
		textFieldCodCliente.setColumns(10);
		textFieldCodCliente.setBounds(138, 41, 46, 20);
		add(textFieldCodCliente);
		
		JLabel label_1 = new JLabel("Codigo Funcionario:");
		label_1.setVisible(false);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 63, 122, 21);
		add(label_1);
		
		textFieldCodFuncionario = new JTextField();
		textFieldCodFuncionario.setVisible(false);
		textFieldCodFuncionario.setColumns(10);
		textFieldCodFuncionario.setBounds(138, 67, 46, 20);
		add(textFieldCodFuncionario);
		
		JLabel label_2 = new JLabel("Codigo Veiculo:");
		label_2.setVisible(false);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 84, 106, 25);
		add(label_2);
		
		textFieldCodVeiculo = new JTextField();
		textFieldCodVeiculo.setVisible(false);
		textFieldCodVeiculo.setColumns(10);
		textFieldCodVeiculo.setBounds(138, 88, 46, 20);
		add(textFieldCodVeiculo);
		
		JLabel label_3 = new JLabel("Data da Venda:");
		label_3.setVisible(false);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 106, 106, 30);
		add(label_3);
		
		textFieldData = new JTextField();
		textFieldData.setVisible(false);
		textFieldData.setText("");
		textFieldData.setColumns(10);
		textFieldData.setBounds(137, 113, 65, 20);
		add(textFieldData);
		
		JLabel label_4 = new JLabel("Adicional:");
		label_4.setVisible(false);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 143, 80, 14);
		add(label_4);
		
		textFieldAdicional = new JTextField();
		textFieldAdicional.setVisible(false);
		textFieldAdicional.setColumns(10);
		textFieldAdicional.setBounds(138, 142, 65, 21);
		add(textFieldAdicional);
		
		JLabel label_5 = new JLabel("Valor Total da Proposta:");
		label_5.setVisible(false);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(235, 45, 167, 19);
		add(label_5);
		
		textFieldValor = new JTextField();
		textFieldValor.setVisible(false);
		textFieldValor.setEditable(false);
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(391, 47, 71, 18);
		add(textFieldValor);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proposta proposta = new Proposta();
				Pessoa cliente = new Pessoa();
				Funcionario funcionario = new Funcionario();
				Veiculo veiculo = new Veiculo();
				
				cliente.setCodigo((textFieldCodCliente.getText()));
				funcionario.setCodigo(textFieldCodFuncionario.getText());
				veiculo.setCodVeiculo(textFieldCodVeiculo.getText());
				proposta.setData(textFieldData.getText());
				proposta.setCliente(cliente);
				proposta.setFuncionario(funcionario);
				proposta.setVeiculo(veiculo);
				while(true) {
					try {
						proposta.setAdicional(Integer.parseInt(textFieldAdicional.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros (Campo Adicional)");
						e2.printStackTrace();
						break;
					}
					try {
						Fachada.getInstance().alterarProposta(proposta);
					} catch (PropostaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				JOptionPane.showMessageDialog(null, "Funcionario Alterado com Sucesso!");
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
				Proposta proposta = new Proposta();
				proposta.setCodProposta((textFieldNProposta2.getText()));
				Fachada.getInstance().removerFuncionario((proposta.getCodProposta()));
				JOptionPane.showMessageDialog(null, "Funcionario Excluido com Sucesso!");
			}
		});
		btnExcluir.setBounds(349, 152, 89, 23);
		add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCliente2.setVisible(false);
				textFieldFuncionario2.setVisible(false);
				textFieldPlacaVeiculo2.setVisible(false);
				textFieldData2.setVisible(false);
				textFieldValor2.setVisible(false);
				textFieldStatus2.setVisible(false);
				
				textFieldCodCliente.setVisible(true);
				textFieldCodFuncionario.setVisible(true);
				textFieldCodVeiculo.setVisible(true);
				textFieldData.setVisible(true);
				textFieldAdicional.setVisible(true);
				textFieldValor.setVisible(true);
				
				btnAlterar.setVisible(false);
				btnExcluir.setVisible(false);
				btnSalvar.setVisible(true);
			}
		});
		btnAlterar.setBounds(240, 152, 89, 23);
		add(btnAlterar);
		
		
		
		
		
		

	}

	public JTextField getTextFieldNProposta2() {
		return textFieldNProposta2;
	}

	public void setTextFieldNProposta2(JTextField textFieldNProposta2) {
		this.textFieldNProposta2 = textFieldNProposta2;
	}

	public JTextField getTextFieldCliente2() {
		return textFieldCliente2;
	}

	public void setTextFieldCliente2(JTextField textFieldCliente2) {
		this.textFieldCliente2 = textFieldCliente2;
	}

	public JTextField getTextFieldFuncionario2() {
		return textFieldFuncionario2;
	}

	public void setTextFieldFuncionario2(JTextField textFieldFuncionario2) {
		this.textFieldFuncionario2 = textFieldFuncionario2;
	}

	public JTextField getTextFieldPlacaVeiculo2() {
		return textFieldPlacaVeiculo2;
	}

	public void setTextFieldPlacaVeiculo2(JTextField textFieldPlacaVeiculo2) {
		this.textFieldPlacaVeiculo2 = textFieldPlacaVeiculo2;
	}

	public JTextField getTextFieldData2() {
		return textFieldData2;
	}

	public void setTextFieldData2(JTextField textFieldData2) {
		this.textFieldData2 = textFieldData2;
	}

	public JTextField getTextFieldValor2() {
		return textFieldValor2;
	}

	public void setTextFieldValor2(JTextField textFieldValor2) {
		this.textFieldValor2 = textFieldValor2;
	}

	public JTextField getTextFieldStatus2() {
		return textFieldStatus2;
	}

	public void setTextFieldStatus2(JTextField textFieldStatus2) {
		this.textFieldStatus2 = textFieldStatus2;
	}

}
