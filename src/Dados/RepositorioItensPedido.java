package Dados;

import Negocios.ItensPedido;

public interface RepositorioItensPedido {
	
	public void inserir(ItensPedido itens);
	public ItensPedido procurar(String codigo);
	public void listar();

}
