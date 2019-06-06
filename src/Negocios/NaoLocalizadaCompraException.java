package Negocios;

public class NaoLocalizadaCompraException extends Exception{
	
	private String identificador;
	
	public NaoLocalizadaCompraException (String identificador) {
		super("Compra n�o encontrada");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}
}
