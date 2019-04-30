
public class Financeiro {
	
	private static double saldo = 1200;
		
	
	public Financeiro() {
		
	}

	public static double getSaldo() {
		return saldo;
	}

	public static void setSaldo(double saldo) {
		Financeiro.saldo = saldo;
	}

	public void creditar(double valor) {
		setSaldo(getSaldo() + valor);
	}
	
	public void debitar(double valor) {
		
		setSaldo(getSaldo() - valor);
	}
	
}
