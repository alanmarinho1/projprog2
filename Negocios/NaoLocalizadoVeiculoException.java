package Negocios;

public class NaoLocalizadoVeiculoException extends Exception {
	private String identificador;
	
	public NaoLocalizadoVeiculoException (String identificador) {
		super("Veiculo não localizado");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}
}
