package Negocios;

public class FinanceiroException extends Exception{

	private  double identificador;
	
	public FinanceiroException (double identificador) {
		super("Saldo insuficiente");
		this.identificador = identificador;
	}
	
	public double getIdentificador(){
		return identificador;
	}

}
