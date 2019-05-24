package Negocios;

public class NaoLocalizadoPedidoException extends Exception {
	
private String identificador;
	
	public NaoLocalizadoPedidoException (String identificador) {
		super("Pessoa n�o encontrada");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}

}
