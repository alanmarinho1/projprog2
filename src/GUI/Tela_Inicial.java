package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class Tela_Inicial extends JFrame {

	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Inicial frame = new Tela_Inicial();
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
	public Tela_Inicial() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 327);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		PainelBoasVindas boasvindas = new PainelBoasVindas();
		contentPane.add(boasvindas, "name_36913695526262");
		boasvindas.setLayout(null);
		boasvindas.setVisible(false);
		
		PrimeiraTelaCliente primeiratelapj = new PrimeiraTelaCliente();
		contentPane.add(primeiratelapj, "name_36913695526266");
		primeiratelapj.setLayout(null);
		primeiratelapj.setVisible(false);
		
		PrimeiraTelaFunc primeiratelafunc = new PrimeiraTelaFunc();
		contentPane.add(primeiratelafunc, "name_36913712635038");
		primeiratelafunc.setLayout(null);
		primeiratelafunc.setVisible(false);
		
		PrimeiraTelaVeiculo primeiratelaveiculo = new PrimeiraTelaVeiculo();
		contentPane.add(primeiratelaveiculo, "name_36913728240865");
		primeiratelaveiculo.setLayout(null);
		primeiratelaveiculo.setVisible(false);
		
		PrimeiraTelaCliente primeiratelacliente = new PrimeiraTelaCliente();
		contentPane.add(primeiratelacliente, "name_36913743812207");
		primeiratelacliente.setLayout(null);
		primeiratelacliente.setVisible(false);
		
		PrimeiraTelaProposta primeiratelaproposta = new PrimeiraTelaProposta();
		contentPane.add(primeiratelaproposta, "name_36913743812227");
		primeiratelaproposta.setLayout(null);
		primeiratelaproposta.setVisible(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenu mnPessoa = new JMenu("Pessoa");
		mnCadastro.add(mnPessoa);
		
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				primeiratelacliente.setVisible(true);
				primeiratelapj.setVisible(false);
				primeiratelafunc.setVisible(false);
				primeiratelaveiculo.setVisible(false);
				boasvindas.setVisible(false);
				
			}
		});
		mnPessoa.add(mntmCliente);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primeiratelapj.setVisible(true);
				primeiratelacliente.setVisible(false);
				primeiratelafunc.setVisible(false);
				primeiratelaveiculo.setVisible(false);
				boasvindas.setVisible(false);
			}
		});
		mnPessoa.add(mntmFuncionario);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primeiratelaveiculo.setVisible(true);
				primeiratelafunc.setVisible(false);
				primeiratelapj.setVisible(false);
				primeiratelacliente.setVisible(false);
				boasvindas.setVisible(false);
			}
		});
		mnCadastro.add(mntmProduto);
		
		JMenu mnNegocios = new JMenu("Negocios");
		mnNegocios.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnNegocios);
		
		JMenuItem mntmPedido = new JMenuItem("Pedido");
		mntmPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primeiratelacliente.setVisible(false);
				primeiratelapj.setVisible(false);
				primeiratelafunc.setVisible(false);
				primeiratelaveiculo.setVisible(false);
				boasvindas.setVisible(false);
				primeiratelaproposta.setVisible(true);
			}
		});
		mnNegocios.add(mntmPedido);
		
		JMenuItem mntmCompra = new JMenuItem("Compra");
		mnNegocios.add(mntmCompra);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmSair);
		
		
		
	}
}
