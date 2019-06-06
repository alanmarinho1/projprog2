package Negocios;

public class ProdutoJaExisteException extends Exception{

	private String identificador;
	
	public ProdutoJaExisteException (String identificador) {
		super("Esse produto j� existe no banco de dados");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}

}
