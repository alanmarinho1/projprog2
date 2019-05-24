package Negocios;

public class PedidoException extends Exception{
	
	private Pessoa funcionario;
	private Pessoa cliente;
	private Produtos produto;
	
	public PedidoException (Funcionario funcionario) {
		super("Funcionario n�o encontrado");
		this.funcionario = funcionario;
	}
	
	public PedidoException (Pessoa cliente) {
		super("Cliente n�o encontrado");
		this.cliente = cliente;
	}
	
	public PedidoException (Produtos produto) {
		super("Veiculo n�o encontrado");
		this.produto = produto;
	}
	
	public Pessoa getFuncionario() {
		return funcionario;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}
	
	public Produtos getProduto() {
		return produto;
	}
	

}
