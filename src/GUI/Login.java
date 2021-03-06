package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocios.Fachada;
import Negocios.Funcionario;
import Negocios.NaoLocalizadoUsuarioException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private static Login instance = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUsuario;
	private JButton btnOk;
	private JButton btnCancelar;
	private JPasswordField passwordField;

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public static Login getInstance() {
		if (Login.instance == null) {
			Login.instance = new Login();
		}
		return Login.instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Acesso ao Sistema");
		setBounds(100, 100, 180, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 11, 64, 14);
		contentPanel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 45, 46, 14);
		contentPanel.add(lblSenha);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(68, 8, 86, 20);
		contentPanel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 42, 88, 17);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					Funcionario achouFuncionario = null;
					
						try {
							achouFuncionario = Fachada.getInstance().procurarUsuario(textFieldUsuario.getText(), passwordField.getText());
							Login.getInstance().getTextFieldUsuario().setText(textFieldUsuario.getText());
							Login.getInstance().getPasswordField().setText(passwordField.getText());
							
						} catch (NaoLocalizadoUsuarioException e) {
							JOptionPane.showMessageDialog(null, "Usuario e/ou Senha est�o incorretos");
							e.printStackTrace();
							}
						if(achouFuncionario != null) {
							Tela_Inicial telainicial = new Tela_Inicial();
							telainicial.setVisible(true);
							dispose();
						}
						}
			});
			buttonPane.add(btnOk);
			
			btnCancelar = new JButton("Cancelar");
			buttonPane.add(btnCancelar);
			
		}
		
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public void setTextFieldUsuario(JTextField textFieldUsuario) {
		this.textFieldUsuario = textFieldUsuario;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
}
