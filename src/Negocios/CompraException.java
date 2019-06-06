package Negocios;

public class CompraException extends Exception{
	
	private Pessoa funcionario;
	private Produtos produto;
	
	public CompraException (Funcionario funcionario) {
		super("Funcionario não encontrado");
		this.funcionario = funcionario;
	}
	
	public CompraException (Produtos produto) {
		super("Produto não encontrado");
		this.produto = produto;
	}
	
	public Pessoa getFuncionario() {
		return funcionario;
	}
	
	public Produtos getProduto() {
		return produto;
	}
	

}
