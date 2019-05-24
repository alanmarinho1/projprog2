package Negocios;

public class PessoaJaExisteException extends Exception{

	private String identificador;
	
	public PessoaJaExisteException (String identificador) {
		super("Esse cadastro já existe no banco de dados");
		this.identificador = identificador;
	}
	
	public String getIdentificador(){
		return identificador;
	}

}
