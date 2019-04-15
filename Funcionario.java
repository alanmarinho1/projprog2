
public class Funcionario extends Pessoa{

	private String profissao;
	private double salario;
	private double comissao;
	
	public Funcionario(String nome, String cpf, String endereco, String profissao, double salario, double comissao) {
		super(nome, cpf, endereco);
		this.profissao = profissao;
		this.salario = salario;
		this.comissao = comissao;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	public void receberComissao(double valor) {
		
		setSalario(getSalario() + getComissao());
	}
}
