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
import Negocios.NaoLocalizadaPessoaException;
import Negocios.NaoLocalizadoVeiculoException;
import Negocios.PessoaFisica;
import Negocios.Veiculo;

public class PrimeiraTelaProduto extends JPanel {

	private JTextField textFieldChassi;
	/**
	 * Create the panel.
	 */
	public PrimeiraTelaProduto() {
		setLayout(null);

		JLabel lblChassi = new JLabel("Chassi:");
		lblChassi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChassi.setBounds(10, 11, 63, 22);
		add(lblChassi);
		
		textFieldChassi = new JTextField();
		textFieldChassi.setColumns(10);
		textFieldChassi.setBounds(53, 14, 148, 20);
		add(textFieldChassi);
		
		PainelCriarProduto painelcriarveiculo = new PainelCriarProduto();
		painelcriarveiculo.setBounds(10, 44, 475, 202);
		add(painelcriarveiculo);
		painelcriarveiculo.setLayout(null);
		painelcriarveiculo.setVisible(false);
		
		PainelProcurarProduto painelprocuraveiculo = new PainelProcurarProduto();
		painelprocuraveiculo.setBounds(10, 44, 475, 202);
		add(painelprocuraveiculo);
		painelprocuraveiculo.setLayout(null);
		painelprocuraveiculo.setVisible(false);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelcriarveiculo.setVisible(true);
				painelprocuraveiculo.setVisible(false);
			}
		});
		btnCriar.setBounds(363, 13, 89, 23);
		add(btnCriar);
		btnCriar.setVisible(false);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Veiculo achouVeiculo = null;
				try {
					achouVeiculo = (Veiculo) Fachada.getInstance().procurarVeiculo(textFieldChassi.getText());
				} catch (NaoLocalizadoVeiculoException e1) {
					JOptionPane.showMessageDialog(null, "O Veiculo não existe.");
					e1.printStackTrace();
					btnCriar.setVisible(true);
				 }
				
				painelcriarveiculo.setVisible(false);
				painelprocuraveiculo.setVisible(true);
				
				painelprocuraveiculo.getTextFieldCodVeiculo2().setText(achouVeiculo.getCodVeiculo());
				painelprocuraveiculo.getTextFieldFabricante2().setText(achouVeiculo.getFabricante());
				painelprocuraveiculo.getTextFieldValor2().setText(String.valueOf(achouVeiculo.getValor()));
				painelprocuraveiculo.getTextFieldChassi2().setText(achouVeiculo.getChassi());
				painelprocuraveiculo.getTextFieldCombustivel2().setText(achouVeiculo.getCombustivel());
				painelprocuraveiculo.getTextFieldEstoque2().setText(achouVeiculo.getEstocado());
				painelprocuraveiculo.getTextFieldModelo2().setText(achouVeiculo.getModelo());
				painelprocuraveiculo.getTextFieldCor2().setText(achouVeiculo.getCor());
				painelprocuraveiculo.getTextFieldPlaca2().setText(achouVeiculo.getPlaca());
				
			}
		});
		bntProcurar.setBounds(220, 13, 89, 23);
		add(bntProcurar);
		
	}

}
