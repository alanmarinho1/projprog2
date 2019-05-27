package Dados;

import Negocios.Pedido;

public interface RepositorioPedido {
	
	public void inserir(Pedido pedido);
	public Pedido procurar(String id);
	public void listar();
	public void remover(String codPedido);

}
