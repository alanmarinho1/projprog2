package Negocios;
import java.util.Calendar;
import java.util.Date;

public class Cliente extends Pessoa{

	private int rg;
	private String email;
	private String telefone;
	private Calendar nascimento = Calendar.getInstance();
	
	public Cliente() {}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
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

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	
	public void historicoPedidos(){
	
		
	}
	
}
