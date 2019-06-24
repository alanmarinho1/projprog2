package Negocios;


import Negocios.Pedido;

public class Fachada {
	
	private ControleFuncionarios funcionarios;
	private ControleCliente clientes;
	private ControlePedido pedidos;
	private ControleProduto produtos;
	private ControleCompra compra;
	private ControleFinanceiro financeiro;
	private static Fachada instance;
	
	public Fachada() {
	
	funcionarios = new ControleFuncionarios();
	clientes = new ControleCliente();
	pedidos = new ControlePedido();
	produtos = new ControleProduto();
	compra = new ControleCompra();
	financeiro = new ControleFinanceiro();
	
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
	
	public Funcionario procurarFuncionario(String cpf) throws NaoLocalizadaPessoaException {
		return funcionarios.procurar(cpf);
	}
	public Funcionario procurarUsuario(String usuario, String senha) throws NaoLocalizadoUsuarioException {
		return funcionarios.procurar(usuario, senha);
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
	
	public Cliente procurarCliente(String cpf) throws NaoLocalizadaPessoaException{
		 return clientes.procurar(cpf);
	}
	
	public void removerCliente(String id) {
		clientes.remover(id);
	}
	
	public void listarCliente() {
		clientes.listar();
	}
	
	public void cadastrarPedido(Pedido pedido) throws PedidoException{
		pedidos.cadastrar(pedido);
	}
	
	public Pedido procurarPedido(String codPedido) throws NaoLocalizadoPedidoException{
		return pedidos.procurar(codPedido);
	}
	
	public void removerPedido(String codPedido) throws NaoLocalizadoPedidoException {
		pedidos.remover(codPedido);
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
	
	public void listarProduto() {
		produtos.listar();
	}
	
}
