package Dados;

import java.util.ArrayList;

import Negocios.ItensPedido;

public interface RepositorioItensPedido {
	
	public void inserir(ItensPedido itens);
	public ItensPedido procurar(String produto);
	public ArrayList<ItensPedido> listarItensPedido(String pedido);
	public void alterar (ItensPedido itenspedido);
	public void remover(String pedido);
	
	

}
