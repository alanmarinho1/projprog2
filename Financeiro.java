
public class Financeiro {
	
	private static double saldo = 1200;
	private String registro;
	
	
	public Financeiro(String registro) {
		super();
		this.registro = registro;
	}

	public static double getSaldo() {
		return saldo;
	}

	public static void setSaldo(double saldo) {
		Financeiro.saldo = saldo;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String relatorio) {
		this.registro = registro;
	}

	public void creditar() {
		
	}
	
	public void debitar() {
		
	}
	
}
