package Negocios;

public class NaoLocalizadaCompraException extends Exception{
	
	private String identificador;
	
	public NaoLocalizadaCompraException (String identificador) {
		super("Compra não encontrada");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}
}
