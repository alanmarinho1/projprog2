package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFastFood = new JLabel("Fast Food");
		lblFastFood.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblFastFood.setBounds(194, 25, 136, 63);
		contentPane.add(lblFastFood);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(10, 185, 89, 23);
		contentPane.add(btnClientes);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setBounds(151, 185, 101, 23);
		contentPane.add(btnFuncionarios);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setBounds(294, 185, 89, 23);
		contentPane.add(btnProdutos);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(420, 185, 89, 23);
		contentPane.add(btnPedidos);
	}
}
