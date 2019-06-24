package Negocios;

public class NaoLocalizadoUsuarioException extends Exception{
	
	private String usuario;
	private String senha;
	
	public NaoLocalizadoUsuarioException (String usuario, String senha) {
		super("Usuario n�o encontrado");
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public String getSenha() {
		return senha;
	}
}
