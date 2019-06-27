package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

import Negocios.Fachada;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.NaoLocalizadoProdutoException;

import Negocios.Produtos;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrimeiraTelaProduto extends JPanel {

	private JTextField textFieldProduto;
	private JTable table;
	ArrayList<Produtos> achouProdutos = null;
	
	/**
	 * Create the panel.
	 */
	public PrimeiraTelaProduto() {
		setLayout(null);

		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProduto.setBounds(10, 11, 63, 22);
		add(lblProduto);
		
		textFieldProduto = new JTextField();
		textFieldProduto.setColumns(10);
		textFieldProduto.setBounds(75, 14, 134, 20);
		add(textFieldProduto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 63, 622, 257);
		add(scrollPane);
		
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String [] Colunas = new String[] {"Codigo", "Descricao", "Quantidade", "Valor de Venda", "Valor de Compra"};
		ModeloTabela modelo = new ModeloTabela(dados, Colunas);
		table = new JTable();
		table.setModel(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCriarPedido criarpedido = new FrameCriarPedido();
				criarpedido.setVisible(true);
				
			}
		});
		btnCriar.setBounds(344, 13, 89, 23);
		add(btnCriar);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					achouProdutos = Fachada.getInstance().listarProdutos(textFieldProduto.getText());
				} catch (NaoLocalizadoProdutoException e1) {
					JOptionPane.showMessageDialog(null, "O Produto não existe.");
					e1.printStackTrace();
					
				 }
				
				ArrayList<Object[]> dados = new ArrayList<Object[]>();
				String [] Colunas = new String[] {"Codigo", "Descricao", "Quantidade", "Valor de Venda", "Valor de Compra"};
				ModeloTabela modelo = new ModeloTabela(dados, Colunas);
				table = new JTable();
				table.setModel(modelo);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(1).setPreferredWidth(180);
				table.getColumnModel().getColumn(2).setPreferredWidth(30);
				table.getColumnModel().getColumn(3).setPreferredWidth(50);
				table.getColumnModel().getColumn(4).setPreferredWidth(50);
				scrollPane.setViewportView(table);
				
				for(int i = 0; i <= achouProdutos.size()-1; i++ ) {
					dados.add(new Object[] {achouProdutos.get(i).getCodigo(), achouProdutos.get(i).getDescricao(), achouProdutos.get(i).getQuantidade(),
							achouProdutos.get(i).getValorvenda(), achouProdutos.get(i).getValorcompra()});
			}
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
							
							FrameAlterarProduto frameproduto = new FrameAlterarProduto();
							frameproduto.getTextFieldCodigo().setText(achouProdutos.get(table.getSelectedRow()).getCodigo());
							frameproduto.getTextFieldDescricao().setText(achouProdutos.get(table.getSelectedRow()).getDescricao());
							frameproduto.getTextFieldQuantidade().setText(String.valueOf((achouProdutos.get(table.getSelectedRow()).getQuantidade())));
							frameproduto.getTextFieldValorVenda().setText(String.valueOf((achouProdutos.get(table.getSelectedRow()).getValorvenda())));
							frameproduto.getTextFieldValorCompra().setText(String.valueOf((achouProdutos.get(table.getSelectedRow()).getValorcompra())));
							frameproduto.getComboBoxDiadaSemana().setSelectedItem(achouProdutos.get(table.getSelectedRow()).getDiadasemana());
							
							frameproduto.setVisible(true);
							
						}
					}

					
					
				});
				
			}
		});
		bntProcurar.setBounds(233, 13, 89, 23);
		add(bntProcurar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBounds(542, 13, 89, 23);
		add(btnVoltar);
		
		
		
	}

}
