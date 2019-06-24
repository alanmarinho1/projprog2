package Negocios;

public class Funcionario extends Pessoa{

	private String usuario;
	private String senha;
	private String profissao;
	private double salario;
	private double comissao = 0;
	
	public Funcionario() {}

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
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double receberSalario() {
		
		double total = getSalario() + getComissao();
		setComissao(0);
		
		return total;
	}
}
