package Negocios;

public class PropostaException extends Exception{
	
	private Pessoa funcionario;
	private Pessoa cliente;
	private Veiculo veiculo;
	
	public PropostaException (Funcionario funcionario) {
		super("Funcionario n�o encontrado");
		this.funcionario = funcionario;
	}
	
	public PropostaException (Pessoa cliente) {
		super("Cliente n�o encontrado");
		this.cliente = cliente;
	}
	
	public PropostaException (Veiculo veiculo) {
		super("Veiculo n�o encontrado");
		this.veiculo = veiculo;
	}
	
	public Pessoa getFuncionario() {
		return funcionario;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	

}
