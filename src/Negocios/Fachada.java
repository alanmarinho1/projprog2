package Negocios;


import java.util.ArrayList;

import Negocios.Pedido;

public class Fachada {
	
	private ControleFuncionarios funcionarios;
	private ControleCliente clientes;
	private ControlePedido pedidos;
	private ControleProduto produtos;
	private ControleCompra compra;
	private ControleFinanceiro financeiro;
	private ControleItensPedido itenspedidos;
	private static Fachada instance;
	
	public Fachada() {
	
	funcionarios = new ControleFuncionarios();
	clientes = new ControleCliente();
	pedidos = new ControlePedido();
	produtos = new ControleProduto();
	compra = new ControleCompra();
	financeiro = new ControleFinanceiro();
	itenspedidos = new ControleItensPedido();
	
	}
	
	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	public void cadastrarFuncionario(Funcionario funcionario) throws InserirException, PessoaJaExisteException {
		funcionarios.cadastrar(funcionario);
	}
	
	public void alterarFuncionario(Funcionario funcionario) throws InserirException, PessoaJaExisteException{
		funcionarios.alterar(funcionario);
    }
	
	public Funcionario procurarFuncionario(String usuario) throws NaoLocalizadaPessoaException {
		return funcionarios.procurar(usuario);
	}
	public Funcionario procurarUsuario(String usuario, String senha) throws NaoLocalizadoUsuarioException {
		return funcionarios.procurar(usuario, senha);
	}
	public ArrayList<Funcionario> listarFuncionarios(String usuario) throws NaoLocalizadaPessoaException {
		 return funcionarios.listarFuncionarios(usuario);
	}
	
	public void removerFuncionario(String codigo) {
		funcionarios.remover(codigo);
	}
	
	
	public void cadastrarCliente(Cliente cliente) throws InserirException, PessoaJaExisteException{
		clientes.cadastrar(cliente);
	}
	
	public void alterarCliente(Cliente cliente) throws InserirException, PessoaJaExisteException{
		clientes.alterar(cliente);
    }
	
	public Cliente procurar(String dado) throws NaoLocalizadaPessoaException{
		return clientes.procurar(dado);
	}
	
	public ArrayList<Cliente> listarClientes(String nome) throws NaoLocalizadaPessoaException {
		 return clientes.listarClientes(nome);
	}
	
	public void removerCliente(String id) {
		clientes.remover(id);
	}
	
	public void listarCliente() {
		clientes.listar();
	}
	
	public void cadastrarPedido(Pedido pedido){
		pedidos.cadastrar(pedido);
	}
	
	public Pedido procurarPedido2() {
		return pedidos.procurar2();
	}
	
	public void alterarPedido2(Pedido pedido) {
		pedidos.alterar2(pedido);
	}
	
	public Pedido procurarPedido(String codPedido) throws NaoLocalizadoPedidoException{
		return pedidos.procurar(codPedido);
	}
	
	public void removerPedido() {
		pedidos.remover();
	}
	
	public void alterarFinanceiro() throws FinanceiroException {
		financeiro.alterar();
	}

	public void cadastrarProduto(Produtos produto) throws InserirException, ProdutoJaExisteException {
		produtos.cadastrar(produto);
	}
	
	public void alterarProduto(Produtos produto) throws InserirException, ProdutoJaExisteException {
		produtos.alterar(produto);
	}
	
	public Produtos procurarProduto(String codigo) throws NaoLocalizadoProdutoException {
		return produtos.procurar(codigo);
	}

	public ArrayList<Produtos> listarProdutos(String descricao) throws NaoLocalizadoProdutoException {
	
		return produtos.listarProdutos(descricao);
	}
	
	public void cadastrarItensPedido (ItensPedido itenspedido) throws InserirException, ItensPedidoQtdException {
		itenspedidos.cadastrar(itenspedido);
	}
	
	public ItensPedido procurarItensPedido(String produto) {
		return itenspedidos.procurar(produto);
	}
	
	public void alterarItensPedido (ItensPedido itenspedido) throws ItensPedidoQtdException {
		itenspedidos.alterar(itenspedido);
	}
	
	public void removerItensPedido (String pedido) {
		itenspedidos.remover(pedido);
	}
	
	public ArrayList<ItensPedido> listarItensPedido(String pedido){
		return itenspedidos.listarItensPedido(pedido);
	}
}
