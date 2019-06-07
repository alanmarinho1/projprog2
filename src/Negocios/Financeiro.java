package Negocios;

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

	public static void creditar(double valor) {
		setSaldo(getSaldo() + valor);
	}
	
	public static void debitar(double valor) {
		
		setSaldo(getSaldo() - valor);
	}
	
	public void historico() {}
	
}
