package Dados;

import Negocios.Pedido;

public interface RepositorioPedido {
	
	public void inserir(Pedido pedido);
	public void alterar(Pedido pedido);
	public Pedido procurar(String id);
	public void remover(String id);
	public void listar();

}
