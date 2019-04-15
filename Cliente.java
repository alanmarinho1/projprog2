import java.util.Calendar;
import java.util.Date;

public class Cliente extends Pessoa{

	private String rg;
	private String email;
	private String telefone;
	private String nascimento;

	public Cliente(String nome, String cpf, String endereco, String rg, String email, String telefone,
			String nascimento) {
		super(nome, cpf, endereco);
		this.rg = rg;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	
	
}
