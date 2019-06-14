package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Negocios.Fachada;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.Funcionario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimeiraTelaFunc extends JPanel {
	private JTextField textFieldCPF;

	/**
	 * Create the panel.
	 */
	public PrimeiraTelaFunc() {
		setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPF.setBounds(10, 11, 63, 22);
		add(lblCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(53, 14, 148, 20);
		add(textFieldCPF);
		
		PainelCriarFunc painelcriarfunc = new PainelCriarFunc();
		painelcriarfunc.setBounds(10, 44, 475, 202);
		add(painelcriarfunc);
		painelcriarfunc.setLayout(null);
		painelcriarfunc.setVisible(false);
		
		PainelProcurarFunc painelprocurarfunc = new PainelProcurarFunc();
		painelprocurarfunc.setBounds(10, 44, 475, 202);
		add(painelprocurarfunc);
		painelprocurarfunc.setLayout(null);
		painelprocurarfunc.setVisible(false);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelcriarfunc.setVisible(true);
				painelprocurarfunc.setVisible(false);
			}
		});
		btnCriar.setBounds(363, 13, 89, 23);
		add(btnCriar);
		btnCriar.setVisible(false);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario achouFuncionario = null;
				try {
					achouFuncionario = (Funcionario) Fachada.getInstance().procurarFuncionario(textFieldCPF.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Favor inserir somente numeros");
					e1.printStackTrace();
				} catch (NaoLocalizadaPessoaException e1) {
					JOptionPane.showMessageDialog(null, "O Funcionario não existe.");
					e1.printStackTrace();
					btnCriar.setVisible(true);
				 }
				
				painelcriarfunc.setVisible(false);
				painelprocurarfunc.setVisible(true);
				
				 painelprocurarfunc.getTextFieldCodigo2().setText(achouFuncionario.getCodigo());
				 painelprocurarfunc.getTextFieldNome2().setText(achouFuncionario.getNome());
				 painelprocurarfunc.getTextFieldSalario2().setText(String.valueOf(achouFuncionario.getSalario()));
				 painelprocurarfunc.getTextFieldProfissao2().setText(achouFuncionario.getProfissao());
				 painelprocurarfunc.getTextFieldEndereco2().setText(achouFuncionario.getEndereco());
				 painelprocurarfunc.getTextFieldCPF2().setText(achouFuncionario.getCpf());
				 painelprocurarfunc.getTextFieldComissao().setText(String.valueOf(achouFuncionario.getComissao()));
				
			}
		});
		btnProcurar.setBounds(220, 13, 89, 23);
		add(btnProcurar);
		
		

	}
}
