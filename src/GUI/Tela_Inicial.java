package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import Negocios.Fachada;
import Negocios.Funcionario;
import Negocios.NaoLocalizadaPessoaException;
import Negocios.NaoLocalizadoUsuarioException;
import Negocios.Pedido;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class Tela_Inicial extends JFrame {
	
	private static Tela_Inicial instance = null;
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
		setBounds(100, 100, 676, 482);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		PainelBoasVindas boasvindas = new PainelBoasVindas();
		contentPane.add(boasvindas, "name_36913695526262");
		boasvindas.setLayout(null);
		boasvindas.setVisible(false);
		
		PrimeiraTelaFunc primeiratelafunc = new PrimeiraTelaFunc();
		contentPane.add(primeiratelafunc, "name_36913712635038");
		primeiratelafunc.setLayout(null);
		primeiratelafunc.setVisible(false);
		
		PrimeiraTelaProduto primeiratelaveiculo = new PrimeiraTelaProduto();
		contentPane.add(primeiratelaveiculo, "name_36913728240865");
		primeiratelaveiculo.setLayout(null);
		primeiratelaveiculo.setVisible(false);
		
		PrimeiraTelaCliente primeiratelacliente = new PrimeiraTelaCliente();
		contentPane.add(primeiratelacliente, "name_36913743812207");
		primeiratelacliente.setLayout(null);
		primeiratelacliente.setVisible(false);
			
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
				primeiratelafunc.setVisible(false);
				primeiratelaveiculo.setVisible(false);
				boasvindas.setVisible(false);
				
			}
		});
		mnPessoa.add(mntmCliente);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				primeiratelacliente.setVisible(false);
				primeiratelafunc.setVisible(true);
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
				primeiratelacliente.setVisible(false);
				boasvindas.setVisible(false);
			}
		});
		mnCadastro.add(mntmProduto);
		
		JMenu mnNegocios = new JMenu("Negocios");
		mnNegocios.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnNegocios);
		
		JMenuItem mntmPedido = new JMenuItem("Realizar Pedido");
		mntmPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameCriarPedido criarpedido = new FrameCriarPedido();
				Funcionario funcionario = null;
				try {
					funcionario = Fachada.getInstance().procurarUsuario(Login.getInstance().getTextFieldUsuario().getText(), Login.getInstance().getPasswordField().getText());
				} catch (NaoLocalizadoUsuarioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Pedido pedido = new Pedido();
				pedido.setFuncionario(funcionario);
				System.out.println(pedido.getFuncionario().getCodigo());
				Fachada.getInstance().cadastrarPedido(pedido);
				criarpedido.setVisible(true);
				primeiratelacliente.setVisible(false);
				primeiratelafunc.setVisible(false);
				boasvindas.setVisible(false);
				
			}
		});
		mnNegocios.add(mntmPedido);
		
		JMenuItem mntmCompra = new JMenuItem("Realizar Compra");
		mnNegocios.add(mntmCompra);
		
		JMenu mnFinanceiro = new JMenu("Financeiro");
		menuBar.add(mnFinanceiro);
		
		JMenuItem mntmCaixa = new JMenuItem("Caixa");
		mnFinanceiro.add(mntmCaixa);
		
		JMenuItem mntmRealizarPagamento = new JMenuItem("Realizar Pagamento");
		mnFinanceiro.add(mntmRealizarPagamento);
		
		JMenu mnRelatorio = new JMenu("Relatorios");
		menuBar.add(mnRelatorio);
		
		JMenuItem mntmFinanceiro = new JMenuItem("Financeiro");
		mnRelatorio.add(mntmFinanceiro);
		
		JMenuItem mntmHistoricoPedidos = new JMenuItem("Historico Pedidos");
		mnRelatorio.add(mntmHistoricoPedidos);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		menuBar.add(mntmSair);
		
		
		
	}
}
