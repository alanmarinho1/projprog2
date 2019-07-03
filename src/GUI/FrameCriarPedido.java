package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocios.Cliente;
import Negocios.Fachada;
import Negocios.Funcionario;
import Negocios.InserirException;
import Negocios.ItensPedido;
import Negocios.ItensPedidoQtdException;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.NaoLocalizadoProdutoException;
import Negocios.NaoLocalizadoUsuarioException;
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
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FrameCriarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCliente;
	private JTable tableClientes;
	private JTextField textFieldProduto;
	private ArrayList<Produtos> achouProdutos = null;
	ArrayList<Cliente> achouClientes = null;
	private Pedido achoupedido = new Pedido();
	private ArrayList<ItensPedido> achouItensPedido = new ArrayList<ItensPedido>();
	private JScrollPane scrollPane_3;
	private JTextField textFieldQuantidadeItens;
	private JTable tableProdutos;
	private JTextField textFieldTotalVenda;
	private JScrollPane scrollPane_2;
	private JTable tableItensPedido;
	private double totalitematual = 0;
	private double valor = 0;
	private int numeroitens;

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
	@SuppressWarnings("deprecation")
	public FrameCriarPedido() {
		Funcionario funcionario = null;
		
		try {
			funcionario = Fachada.getInstance().procurarUsuario(Login.getInstance().getTextFieldUsuario().getText(), Login.getInstance().getPasswordField().getText());
		} catch (NaoLocalizadoUsuarioException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Pedido pedido = new Pedido();
		
		Fachada.getInstance().cadastrarPedido(pedido);
		
		achoupedido = Fachada.getInstance().procurarPedido2();
		achoupedido.setFuncionario(funcionario);
		
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
		
		textFieldProduto = new JTextField();
		textFieldProduto.setColumns(10);
		textFieldProduto.setBounds(99, 187, 127, 20);
		contentPane.add(textFieldProduto);
		
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
		
		scrollPane_3 = new JScrollPane();
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
		
		textFieldTotalVenda = new JTextField();
		textFieldTotalVenda.setEditable(false);
		textFieldTotalVenda.setBounds(456, 517, 83, 20);
		contentPane.add(textFieldTotalVenda);
		textFieldTotalVenda.setColumns(10);
		
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
				
				for(int i = 0; i <= achouClientes.size()-1; i++ ) {
					dadoscli.add(new Object[] {achouClientes.get(i).getCodigo(), achouClientes.get(i).getNome(), achouClientes.get(i).getCpf(), 
							sdf.format(achouClientes.get(i).getNascimento().getTime()), achouClientes.get(i).getTelefone()});
			}
				
				
			}
		});
		btnBuscar.setBounds(226, 44, 83, 23);
		contentPane.add(btnBuscar);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						achouProdutos = Fachada.getInstance().listarProdutos(textFieldProduto.getText());
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
				itenspedido.setPedido(achoupedido);
				
				while(true) {
					
					try {
						itenspedido.setQuantidadeitens(Integer.parseInt(textFieldQuantidadeItens.getText()));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Favor inserir somente numeros na quantidade de itens");
						e2.printStackTrace();
						break;
					}
						itenspedido.setValortotalitem(achouProdutos.get(tableProdutos.getSelectedRow()).getValorvenda() * itenspedido.getQuantidadeitens());
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
				
				achouItensPedido.add(itenspedido);
				
				
				carregarTabela();

				
				}		
		});
		
		button.setBounds(236, 186, 83, 23);
		contentPane.add(button);
		
		JButton btnRemoverItem = new JButton("Remover Item");
		btnRemoverItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diminuirTabela();
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
		btnConcluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				achoupedido.setTotal(totalitematual);
				achoupedido.setCliente(achouClientes.get(tableClientes.getSelectedRow()));
				achoupedido.getData().setTime((Calendar.getInstance().getTime()));
				achoupedido.setNumeroitens(numeroitens);
				System.out.println(achoupedido.getNumeroitens());
				Fachada.getInstance().alterarPedido2(achoupedido);
				JOptionPane.showMessageDialog(null, "Pedido Realizado com sucesso");
				dispose();
			}
		});
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
		
	}
	
	public void diminuirTabela() {
		
		ArrayList<Object[]> dadositens1 = new ArrayList<Object[]>();
		String [] Colunasitens1 = new String[] {"Produto", "Qtd", "Valor Unitario", "Valor total"};
		ModeloTabela modeloitens1 = new ModeloTabela(dadositens1, Colunasitens1);
		tableItensPedido = new JTable();
		tableItensPedido.setModel(modeloitens1);
		tableItensPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableItensPedido.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane_3.setViewportView(tableItensPedido);
		
		
				dadositens1.remove(tableItensPedido.getSelectedRow()+1);
		
				totalitematual = totalitematual - achouItensPedido.get(tableItensPedido.getSelectedRow()).getValortotalitem();
				textFieldTotalVenda.setText(String.valueOf(totalitematual));
	}
	
	public void carregarTabela() {
		
		ArrayList<Object[]> dadositens1 = new ArrayList<Object[]>();
		String [] Colunasitens1 = new String[] {"Produto", "Qtd", "Valor Unitario", "Valor total"};
		ModeloTabela modeloitens1 = new ModeloTabela(dadositens1, Colunasitens1);
		tableItensPedido = new JTable();
		tableItensPedido.setModel(modeloitens1);
		tableItensPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableItensPedido.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableItensPedido.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane_3.setViewportView(tableItensPedido);
		
		int x = achouItensPedido.size()-1;
		
			for(int i = 0; i <= achouItensPedido.size()-1; i++)
				dadositens1.add(new Object[] {achouItensPedido.get(i).getProduto().getDescricao(), achouItensPedido.get(i).getQuantidadeitens(), 
				achouItensPedido.get(i).getProduto().getValorvenda(), achouItensPedido.get(i).getValortotalitem()});
				
				
				totalitematual = totalitematual + achouItensPedido.get(x).getValortotalitem();
				textFieldTotalVenda.setText(String.valueOf(totalitematual));
		
		
			
				
	}
}
