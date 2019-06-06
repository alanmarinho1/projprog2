package Negocios;

public class CompraException extends Exception{
	
	private Pessoa funcionario;
	private Produtos produto;
	
	public CompraException (Funcionario funcionario) {
		super("Funcionario n�o encontrado");
		this.funcionario = funcionario;
	}
	
	public CompraException (Produtos produto) {
		super("Produto n�o encontrado");
		this.produto = produto;
	}
	
	public Pessoa getFuncionario() {
		return funcionario;
	}
	
	public Produtos getProduto() {
		return produto;
	}
	

}
