package Negocios;

public class InserirException extends Exception{
	
	private String identificador;
	
	public InserirException (String identificador) {
		super("N�o foi possivel inserir");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}
}
