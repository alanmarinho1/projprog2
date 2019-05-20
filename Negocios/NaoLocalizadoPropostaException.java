package Negocios;

public class NaoLocalizadoPropostaException extends Exception {
	
private String identificador;
	
	public NaoLocalizadoPropostaException (String identificador) {
		super("Pessoa não encontrada");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}

}
