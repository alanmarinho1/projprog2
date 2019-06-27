package Negocios;

public class ItensPedidoQtdException extends Exception{
	private int identificador;
	
	public ItensPedidoQtdException (int identificador) {
		super("N�o foi possivel inserir");
		this.identificador = identificador;
	}
	
	public int getIdentificador(){
		return identificador;
	}
}
