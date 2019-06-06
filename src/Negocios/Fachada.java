package Negocios;


import Negocios.Pessoa;
import Negocios.Pedido;

public class Fachada {
	
	private ControleFuncionarios funcionarios;
	private ControleCliente cliente;
	private ControlePedido pedidos;
	private ControleProduto produtos;
	private ControleCompra compra;
	private ControleFinanceiro financeiro;
	private static Fachada instance;
	
	public Fachada() {
	
	funcionarios = new ControleFuncionarios();
	cliente = new ControleCliente();
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
	public void cadastrarFuncionario(Pessoa pessoa) throws InserirException {
		funcionarios.cadastrar(pessoa);
	}
	
	public void alterarFuncionario(Pessoa pessoa) throws InserirException{
		funcionarios.alterar(pessoa);
    }
	
	public Pessoa procurarFuncionario(String cpf) throws NaoLocalizadaPessoaException {
		return funcionarios.procurar(cpf);
	}
	
	public void removerFuncionario(String codigo) {
		funcionarios.remover(codigo);
	}
	
	
	public void cadastrarCliente(Pessoa pessoa) throws InserirException, PessoaJaExisteException{
		cliente.cadastrar(pessoa);
	}
	
	public void alterarCliente(Pessoa pessoa) throws InserirException, PessoaJaExisteException{
		cliente.alterar(pessoa);
    }
	
	public Pessoa procurarCliente(String cpf) throws NaoLocalizadaPessoaException{
		 return cliente.procurar(cpf);
	}
	
	public void removerCliente(String id) {
		cliente.remover(id);
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
	
	public void alterarFinanceiro (Financeiro caixa) {
		financeiro.alterar(caixa);
	}
		
	
}
