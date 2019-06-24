package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelIncluirItens extends JPanel {
	private JTextField textFieldCodigo2;
	private JTextField textFieldDescricao2;
	private JTextField textFieldValor2;
	private JComboBox comboBoxDiadaSemana2;

	/**
	 * Create the panel.
	 */
	public PainelIncluirItens() {
		setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 11, 71, 25);
		add(label);
		
		textFieldCodigo2 = new JTextField();
		textFieldCodigo2.setEditable(false);
		textFieldCodigo2.setColumns(10);
		textFieldCodigo2.setBounds(128, 15, 76, 20);
		add(textFieldCodigo2);
		
		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 35, 86, 25);
		add(label_1);
		
		textFieldDescricao2 = new JTextField();
		textFieldDescricao2.setColumns(10);
		textFieldDescricao2.setBounds(128, 39, 174, 20);
		add(textFieldDescricao2);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(10, 60, 96, 21);
		add(lblValor);
		
		textFieldValor2 = new JTextField();
		textFieldValor2.setColumns(10);
		textFieldValor2.setBounds(128, 65, 130, 20);
		add(textFieldValor2);
		
		JLabel label_3 = new JLabel("Promo\u00E7\u00E3o do dia:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 92, 114, 20);
		add(label_3);
		
		JComboBox comboBoxDiadaSemana2 = new JComboBox();
		comboBoxDiadaSemana2.setBounds(127, 92, 96, 20);
		add(comboBoxDiadaSemana2);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnIncluir.setBounds(251, 127, 89, 23);
		add(btnIncluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(351, 127, 89, 23);
		add(btnSalvar);

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

	public JTextField getTextFieldValor2() {
		return textFieldValor2;
	}

	public void setTextFieldValor2(JTextField textFieldValor2) {
		this.textFieldValor2 = textFieldValor2;
	}

	public JComboBox getComboBoxDiadaSemana2() {
		return comboBoxDiadaSemana2;
	}

	public void setComboBoxDiadaSemana2(JComboBox comboBoxDiadaSemana2) {
		this.comboBoxDiadaSemana2 = comboBoxDiadaSemana2;
	}
	
	
}
