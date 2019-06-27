package Dados;

import Negocios.Pedido;

public interface RepositorioPedido {
	
	public void inserir(Pedido pedido);
	public Pedido procurar(String id);
	public Pedido procurar2();
	public void alterar(Pedido pedido);
	public void alterar2(Pedido pedido);
	public void listar();
	public void remover();

}
