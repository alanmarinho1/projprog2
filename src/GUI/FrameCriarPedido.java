package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocios.Cliente;
import Negocios.Fachada;
import Negocios.InserirException;
import Negocios.ItensPedido;
import Negocios.ItensPedidoQtdException;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.NaoLocalizadoProdutoException;
import Negocios.Pedido;
import Negocios.Produtos;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FrameCriarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCliente;
	private JTable tableClientes;
	private JTextField textField_1;
	ArrayList<Cliente> achouClientes = null;
	ArrayList<Produtos> achouProdutos = null;
	ArrayList<ItensPedido> achouItensPedido = null;
	private JTextField textFieldQuantidadeItens;
	private JTable tableProdutos;
	private JTextField textField_2;
	private JTable table;
	JScrollPane scrollPane_2;
	private JTable tableItensPedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCriarPedido frame = new FrameCriarPedido();
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
	public FrameCriarPedido() {
	
		setBounds(100, 100, 611, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCliente.setBounds(38, 47, 41, 14);
		contentPane.add(lblCliente);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setBounds(89, 45, 127, 20);
		contentPane.add(textFieldCliente);
		textFieldCliente.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 71, 515, 93);
		contentPane.add(scrollPane);
		
		ArrayList<Object[]> dadoscli = new ArrayList<Object[]>();
		String [] Colunascli = new String[] {"Codigo", "Nome", "CPF", "Data de Nascimento", "Telefone"};
		ModeloTabela modelocli = new ModeloTabela(dadoscli, Colunascli);
		tableClientes = new JTable();
		tableClientes.setModel(modelocli);
		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClientes.getColumnModel().getColumn(0).setPreferredWidth(61);
		tableClientes.getColumnModel().getColumn(1).setPreferredWidth(109);
		tableClientes.getColumnModel().getColumn(2).setPreferredWidth(123);
		tableClientes.getColumnModel().getColumn(3).setPreferredWidth(151);
		tableClientes.getColumnModel().getColumn(4).setPreferredWidth(108);
		scrollPane.setViewportView(tableClientes);
		
		JButton btnAdicionarItem = new JButton("Adicionar Item");
		btnAdicionarItem.setBounds(435, 186, 117, 23);
		contentPane.add(btnAdicionarItem);
		
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProduto.setBounds(33, 189, 56, 14);
		contentPane.add(lblProduto);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 187, 127, 20);
		contentPane.add(textField_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 213, 515, 93);
		contentPane.add(scrollPane_1);
		
		ArrayList<Object[]> dadosprod = new ArrayList<Object[]>();
		String [] Colunasprod = new String[] {"Codigo", "Descricao", "Qtd", "Preço"};
		ModeloTabela modeloprod = new ModeloTabela(dadosprod, Colunasprod);
		tableProdutos = new JTable();
		tableProdutos.setModel(modeloprod);
		tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(80);
		scrollPane_1.setViewportView(tableProdutos);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(33, 364, 520, 145);
		contentPane.add(scrollPane_3);
		
		ArrayList<Object[]> dadositens = new ArrayList<Object[]>();
		String [] Colunasitens = new String[] {"Produto", "Qtd", "Valor Unitario", "Valor total"};
		ModeloTabela modeloitens = new ModeloTabela(dadositens, Colunasitens);
		tableItensPedido = new JTable();
		tableItensPedido.setModel(modeloitens);
		tableItensPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableItensPedido.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane_3.setViewportView(tableItensPedido);
		
		Pedido pedido = Fachada.getInstance().procurarPedido2();
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					achouClientes = Fachada.getInstance().listarClientes(textFieldCliente.getText());
				} catch (NaoLocalizadaPessoaException e1) {
					JOptionPane.showMessageDialog(null, "Registro não encontrado");
					e1.printStackTrace();
				}	
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				ArrayList<Object[]> dadoscli = new ArrayList<Object[]>();
				String [] Colunascli = new String[] {"Codigo", "Nome", "CPF", "Data de Nascimento", "Telefone"};
				ModeloTabela modelocli = new ModeloTabela(dadoscli, Colunascli);
				tableClientes = new JTable();
				tableClientes.setModel(modelocli);
				tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableClientes.getColumnModel().getColumn(0).setPreferredWidth(61);
				tableClientes.getColumnModel().getColumn(1).setPreferredWidth(109);
				tableClientes.getColumnModel().getColumn(2).setPreferredWidth(123);
				tableClientes.getColumnModel().getColumn(3).setPreferredWidth(151);
				tableClientes.getColumnModel().getColumn(4).setPreferredWidth(108);
				scrollPane.setViewportView(tableClientes);
				
				for(int i = 0; i <= achouClientes.size(); i++ ) {
					dadoscli.add(new Object[] {achouClientes.get(i).getCodigo(), achouClientes.get(i).getNome(), achouClientes.get(i).getCpf(), 
							sdf.format(achouClientes.get(i).getNascimento().getTime()), achouClientes.get(i).getTelefone()});
			}
				
			pedido.setCliente(achouClientes.get(tableClientes.getSelectedRow()));	
			}
		});
		btnBuscar.setBounds(226, 44, 83, 23);
		contentPane.add(btnBuscar);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						achouProdutos = Fachada.getInstance().listarProdutos(textFieldCliente.getText());
					} catch (NaoLocalizadoProdutoException e1) {
						JOptionPane.showMessageDialog(null, "O Produto não existe.");
						e1.printStackTrace();
					}
				
				
				ArrayList<Object[]> dadosprod = new ArrayList<Object[]>();
				String [] Colunasprod = new String[] {"Codigo", "Descricao", "Qtd", "Preço"};
				ModeloTabela modeloprod = new ModeloTabela(dadosprod, Colunasprod);
				tableProdutos = new JTable();
				tableProdutos.setModel(modeloprod);
				tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(60);
				tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(100);
				tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(50);
				tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(80);
				scrollPane_1.setViewportView(tableProdutos);
				
				for(int i = 0; i <= achouProdutos.size()-1; i++ ) {
					dadosprod.add(new Object[] {achouProdutos.get(i).getCodigo(), achouProdutos.get(i).getDescricao(), 
							achouProdutos.get(i).getQuantidade(), achouProdutos.get(i).getValorvenda()});
			}
				
				
				
				
				
			}
		});
		
		btnAdicionarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ItensPedido itenspedido = new ItensPedido();
				
				itenspedido.setProduto(achouProdutos.get(tableProdutos.getSelectedRow()));
				itenspedido.setPedido(pedido);
				
				while(true) {
					
					try {
						itenspedido.setQuantidadeitens(Integer.parseInt(textFieldQuantidadeItens.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros na quantidade de itens");
						e2.printStackTrace();
						break;
					}
						itenspedido.setValortotalitem(achouProdutos.get(tableProdutos.getSelectedColumn()).getValorvenda() * itenspedido.getQuantidadeitens());
					try {
						Fachada.getInstance().cadastrarItensPedido(itenspedido);
					} catch (InserirException e1) {
					
						e1.printStackTrace();
					} catch (ItensPedidoQtdException e1) {
						JOptionPane.showMessageDialog(null, "A Quantidade do item selecionado é maior do que está em estoque");
						e1.printStackTrace();
							
					}
					break;
				}
				
				
				achouItensPedido = Fachada.getInstance().listarItensPedido(pedido.getCodigo());
				
				ArrayList<Object[]> dadositens = new ArrayList<Object[]>();
				String [] Colunasitens = new String[] {"Produto", "Qtd", "Valor Unitario", "Valor total"};
				ModeloTabela modeloitens = new ModeloTabela(dadositens, Colunasitens);
				tableItensPedido = new JTable();
				tableItensPedido.setModel(modeloitens);
				tableItensPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableItensPedido.getColumnModel().getColumn(0).setPreferredWidth(100);
				tableItensPedido.getColumnModel().getColumn(1).setPreferredWidth(100);
				tableItensPedido.getColumnModel().getColumn(2).setPreferredWidth(100);
				tableItensPedido.getColumnModel().getColumn(3).setPreferredWidth(100);
				scrollPane_3.setViewportView(tableItensPedido);
				
				for(int i = 0; i <= achouItensPedido.size()-1; i++ ) {
					dadositens.add(new Object[] {achouItensPedido.get(i).getProduto(), achouItensPedido.get(i).getQuantidadeitens(), 
							achouItensPedido.get(i).getProduto().getValorvenda()
							, achouItensPedido.get(i).getValortotalitem()});
			}
				
			}
		});
		button.setBounds(236, 186, 83, 23);
		contentPane.add(button);
		
		JButton btnRemoverItem = new JButton("Remover Item");
		btnRemoverItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRemoverItem.setBounds(435, 336, 104, 23);
		contentPane.add(btnRemoverItem);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidade.setBounds(329, 189, 67, 14);
		contentPane.add(lblQuantidade);
		
		textFieldQuantidadeItens = new JTextField();
		textFieldQuantidadeItens.setText("0");
		textFieldQuantidadeItens.setColumns(10);
		textFieldQuantidadeItens.setBounds(400, 187, 25, 20);
		contentPane.add(textFieldQuantidadeItens);
		
		JButton btnConcluirPedido = new JButton("Concluir Pedido");
		btnConcluirPedido.setBounds(106, 635, 141, 23);
		contentPane.add(btnConcluirPedido);
		
		JButton btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().removerPedido();
				dispose();
			}
		});
		btnCancelarPedido.setBounds(343, 635, 141, 23);
		contentPane.add(btnCancelarPedido);
		
		JLabel lblItensDoPedido = new JLabel("Itens do Pedido:");
		lblItensDoPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblItensDoPedido.setBounds(33, 339, 101, 14);
		contentPane.add(lblItensDoPedido);
		
		
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotal.setBounds(400, 519, 46, 14);
		contentPane.add(lblTotal);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(456, 517, 83, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		
		
	}
}
