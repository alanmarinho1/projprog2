package Negocios;

public class NaoLocalizadoPedidoException extends Exception {
	
private String identificador;
	
	public NaoLocalizadoPedidoException (String identificador) {
		super("Pessoa não encontrada");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}

}
