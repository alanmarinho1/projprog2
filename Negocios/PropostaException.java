package Negocios;

public class PropostaException extends Exception{
	
	private Pessoa funcionario;
	private Pessoa cliente;
	private Veiculo veiculo;
	
	public PropostaException (Funcionario funcionario) {
		super("Funcionario não encontrado");
		this.funcionario = funcionario;
	}
	
	public PropostaException (Pessoa cliente) {
		super("Cliente não encontrado");
		this.cliente = cliente;
	}
	
	public PropostaException (Veiculo veiculo) {
		super("Veiculo não encontrado");
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
