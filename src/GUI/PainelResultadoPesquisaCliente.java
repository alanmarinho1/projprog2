package GUI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Negocios.Funcionario;
import javax.swing.ListSelectionModel;

public class PainelResultadoPesquisaCliente extends JPanel {
	private JTable tablePesquisaClientes;

	/**
	 * Create the panel.
	 */
	public PainelResultadoPesquisaCliente() {
		setLayout(null);
		
		tablePesquisaClientes = new JTable();
		tablePesquisaClientes.setToolTipText("Clientes");
		tablePesquisaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePesquisaClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nome", "Email", "Endereco", "CPF", "RG", "Data de Nascimento"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePesquisaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePesquisaClientes.getColumnModel().getColumn(1).setPreferredWidth(122);
		tablePesquisaClientes.getColumnModel().getColumn(2).setPreferredWidth(132);
		tablePesquisaClientes.getColumnModel().getColumn(3).setPreferredWidth(143);
		tablePesquisaClientes.getColumnModel().getColumn(5).setPreferredWidth(61);
		tablePesquisaClientes.getColumnModel().getColumn(6).setPreferredWidth(119);
		tablePesquisaClientes.setBounds(10, 30, 430, 246);
		add(tablePesquisaClientes);

		
	}
}
