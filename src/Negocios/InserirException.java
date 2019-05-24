package Negocios;

public class InserirException extends Exception{
	
	private String identificador;
	
	public InserirException (String identificador) {
		super("Dados Invalidos");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}
}
