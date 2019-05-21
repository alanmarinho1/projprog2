package Negocios;

public class NaoLocalizadoProdutoException extends Exception {
	private String identificador;
	
	public NaoLocalizadoProdutoException (String identificador) {
		super("Veiculo n�o localizado");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}
}
