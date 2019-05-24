package Negocios;

public class NaoLocalizadaPessoaException extends Exception{
	
	private String identificador;
	
	public NaoLocalizadaPessoaException (String identificador) {
		super("Pessoa não encontrada");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}
}
