package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Negocios.Cliente;
import Negocios.Fachada;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.Funcionario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrimeiraTelaFunc extends JPanel {
	
	private JTextField textFieldUsuario;
	private JTable table;
	ArrayList<Funcionario> achouFuncionario = null;
	
	/**
	 * Create the panel.
	 */
	public PrimeiraTelaFunc() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 46, 621, 298);
		add(scrollPane);
		
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String [] Colunas = new String[] {"Codigo", "Usuario", "Nome", "Endereco", "CPF", "Profissao", "Salario", "Comissao"};
		ModeloTabela modelo = new ModeloTabela(dados, Colunas);
		table = new JTable();
		table.setModel(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
	
		scrollPane.setViewportView(table);
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 11, 63, 22);
		add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(64, 14, 137, 20);
		add(textFieldUsuario);
		
		
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCriarFuncionario criarfuncionario = new FrameCriarFuncionario();
				criarfuncionario.setVisible(true);
			}
		});
		btnCriar.setBounds(336, 13, 89, 23);
		add(btnCriar);
	
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					achouFuncionario = Fachada.getInstance().listarFuncionarios(textFieldUsuario.getText());
				} catch (NaoLocalizadaPessoaException e1) {
					JOptionPane.showMessageDialog(null, "Registro não encontrado");
					e1.printStackTrace();
				}
				
				ArrayList<Object[]> dados = new ArrayList<Object[]>();
				String [] Colunas = new String[] {"Codigo", "Usuario", "Nome", "Endereco", "CPF", "Profissao", "Salario", "Comissao"};
				ModeloTabela modelo = new ModeloTabela(dados, Colunas);
				table = new JTable();
				table.setModel(modelo);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.getColumnModel().getColumn(0).setPreferredWidth(61);
				table.getColumnModel().getColumn(1).setPreferredWidth(80);
				table.getColumnModel().getColumn(2).setPreferredWidth(130);
				table.getColumnModel().getColumn(3).setPreferredWidth(130);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.getColumnModel().getColumn(5).setPreferredWidth(100);
				table.getColumnModel().getColumn(6).setPreferredWidth(80);
				table.getColumnModel().getColumn(7).setPreferredWidth(80);
			
				scrollPane.setViewportView(table);
				
				for(int i = 0; i <= achouFuncionario.size()-1; i++ ) {
					dados.add(new Object[] {achouFuncionario.get(i).getCodigo(), achouFuncionario.get(i).getUsuario(), achouFuncionario.get(i).getNome(),
							achouFuncionario.get(i).getEndereco(),	achouFuncionario.get(i).getCpf(), achouFuncionario.get(i).getProfissao(), 
							 achouFuncionario.get(i).getSalario(), achouFuncionario.get(i).getComissao()});
			}
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
							
							FrameAlterarFuncionario framefuncionario = new FrameAlterarFuncionario();
							framefuncionario.getTextFieldCodigo().setText(achouFuncionario.get(table.getSelectedRow()).getCodigo());
							framefuncionario.getTextFieldNome().setText(achouFuncionario.get(table.getSelectedRow()).getNome());
							framefuncionario.getTextFieldProfissão().setText(achouFuncionario.get(table.getSelectedRow()).getProfissao());
							framefuncionario.getTextFieldEndereco().setText(achouFuncionario.get(table.getSelectedRow()).getEndereco());
							framefuncionario.getTextFieldCPF().setText(achouFuncionario.get(table.getSelectedRow()).getCpf());
							framefuncionario.getTextFieldSalario().setText(String.valueOf(achouFuncionario.get(table.getSelectedRow()).getSalario()));
							framefuncionario.getTextFieldUsuario().setText(achouFuncionario.get(table.getSelectedRow()).getUsuario());
							framefuncionario.getTextFieldSenha().setText(achouFuncionario.get(table.getSelectedRow()).getSenha());
							framefuncionario.getTextFieldComissao().setText(String.valueOf(achouFuncionario.get(table.getSelectedRow()).getComissao()));
							
							framefuncionario.setVisible(true);
							
						}
					}

					
					
				});
				
			}
		});
		btnProcurar.setBounds(220, 13, 89, 23);
		add(btnProcurar);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setBounds(552, 15, 89, 23);
		add(button);
		
		

	}
}
