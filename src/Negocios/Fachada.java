package Negocios;


import Negocios.Pessoa;
import Negocios.Pedido;

public class Fachada {
	
	private ControleFuncionarios funcionarios;
	private ControleCliente cliente;
	private ControlePedido pedido;
	private ControleProduto produtos;
	private ControleCompra compra;
	private static Fachada instance;
	
	public Fachada() {
	
	funcionarios = new ControleFuncionarios();
	cliente = new ControleCliente();
	pedido = new ControlePedido();
	produtos = new ControleProduto();
	compra = new ControleCompra();
	
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
		pedido.cadastrar(pedido);
	}
	
	public void alterarPedido(Pedido pedido) throws PedidoException {
		pedido.alterar(pedido);
    }
	
	public Pedido procurarPedido(String codPedido) throws NaoLocalizadoPedidoException{
		return pedido.procurar(codPedido);
	}
	
	public void removerPedido(String codPedido) {
		pedido.remover(codPedido);
	}
	
	
	public void cadastrarVeiculo(Veiculo veiculo) throws InserirException{
		veiculos.cadastrar(veiculo);
	}
	
	public void alterarVeiculo(Veiculo veiculo) throws InserirException{
		veiculos.alterar(veiculo);
    }
     
	public Veiculo procurarVeiculo(String chassi) throws NaoLocalizadoVeiculoException{
		return veiculos.procurar(chassi);
	}
	
	public void removerVeiculo(String chassi) {
		veiculos.remover(chassi);
	}
	
	
	
}
