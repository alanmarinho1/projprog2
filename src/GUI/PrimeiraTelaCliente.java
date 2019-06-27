package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Negocios.Fachada;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.Pessoa;
import Negocios.Cliente;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrimeiraTelaCliente extends JPanel {

	
	private JTextField textFieldCCliente;
	private JTable table;
	ArrayList<Cliente> achouClientes = null;
	
	
	/**
	 * Create the panel.
	 */
	
	public PrimeiraTelaCliente() {
		setLayout(null);
		
		JLabel lblCCliente = new JLabel("Cliente:");
		lblCCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCCliente.setBounds(10, 11, 63, 22);
		add(lblCCliente);
		
		textFieldCCliente = new JTextField();
		textFieldCCliente.setColumns(10);
		textFieldCCliente.setBounds(62, 14, 148, 20);
		add(textFieldCCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 44, 621, 298);
		add(scrollPane);
	
		
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String [] Colunas = new String[] {"Codigo", "Nome", "Email", "Endereco", "CPF", "RG", "Data de Nascimento", "Telefone"};
		ModeloTabela modelo = new ModeloTabela(dados, Colunas);
		table = new JTable();
		table.setModel(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(109);
		table.getColumnModel().getColumn(2).setPreferredWidth(123);
		table.getColumnModel().getColumn(3).setPreferredWidth(151);
		table.getColumnModel().getColumn(4).setPreferredWidth(108);
		table.getColumnModel().getColumn(5).setPreferredWidth(78);
		table.getColumnModel().getColumn(6).setPreferredWidth(180);
		table.getColumnModel().getColumn(7).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameCriarCliente criarcliente = new FrameCriarCliente();
				criarcliente.setVisible(true);
				
			}
		});
		btnCriar.setBounds(332, 13, 89, 23);
		add(btnCriar);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					achouClientes = Fachada.getInstance().listarClientes(textFieldCCliente.getText());
				} catch (NaoLocalizadaPessoaException e1) {
					JOptionPane.showMessageDialog(null, "Registro não encontrado");
					e1.printStackTrace();
				}	
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				ArrayList<Object[]> dados = new ArrayList<Object[]>();
				String [] Colunas = new String[] {"Codigo", "Nome", "Email", "Endereco", "CPF", "RG", "Data de Nascimento", "Telefone"};
				ModeloTabela modelo = new ModeloTabela(dados, Colunas);
				table = new JTable();
				table.setModel(modelo);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.getColumnModel().getColumn(0).setPreferredWidth(61);
				table.getColumnModel().getColumn(1).setPreferredWidth(109);
				table.getColumnModel().getColumn(2).setPreferredWidth(123);
				table.getColumnModel().getColumn(3).setPreferredWidth(151);
				table.getColumnModel().getColumn(4).setPreferredWidth(108);
				table.getColumnModel().getColumn(5).setPreferredWidth(78);
				table.getColumnModel().getColumn(6).setPreferredWidth(180);
				table.getColumnModel().getColumn(7).setPreferredWidth(107);
				
				scrollPane.setViewportView(table);
				
				
				for(int i = 0; i <= achouClientes.size()-1; i++ ) {
					dados.add(new Object[] {achouClientes.get(i).getCodigo(), achouClientes.get(i).getNome(), achouClientes.get(i).getEmail() ,
							achouClientes.get(i).getEndereco(),	achouClientes.get(i).getCpf(), achouClientes.get(i).getRg(), 
							sdf.format(achouClientes.get(i).getNascimento().getTime()), achouClientes.get(i).getTelefone()});
			}
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
							
							
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							FrameAlterarCliente framecliente = new FrameAlterarCliente();
							framecliente.getTextFieldCodigo().setText(achouClientes.get(table.getSelectedRow()).getCodigo());
							framecliente.getTextFieldNome().setText(achouClientes.get(table.getSelectedRow()).getNome());
							framecliente.getTextFieldEmail().setText(achouClientes.get(table.getSelectedRow()).getEmail());
							framecliente.getTextFieldEndereco().setText(achouClientes.get(table.getSelectedRow()).getEndereco());
							framecliente.getTextFieldCPF().setText(achouClientes.get(table.getSelectedRow()).getCpf());
							framecliente.getTextFieldRG().setText(String.valueOf(achouClientes.get(table.getSelectedRow()).getRg()));
							framecliente.getTextFieldDataNascimento().setText(sdf.format(achouClientes.get(table.getSelectedRow()).getNascimento().getTime()));
							framecliente.getTextFieldTelefone().setText(achouClientes.get(table.getSelectedRow()).getTelefone());
							
							framecliente.setVisible(true);
							
						}
					}

					
					
				});
				
			}
		});
		bntProcurar.setBounds(220, 13, 89, 23);
		add(bntProcurar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnVoltar.setBounds(552, 13, 89, 23);
		add(btnVoltar);
		
	}



	

}
