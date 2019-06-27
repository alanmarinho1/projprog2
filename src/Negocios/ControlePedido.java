package Negocios;


import Dados.RepositorioPedido;
import Dados.RepositorioPedidoBD;

public class ControlePedido {
	
	RepositorioPedido pedidos = new RepositorioPedidoBD();
    
	public void cadastrar(Pedido pedido) {
		
	
		pedidos.inserir(pedido);
	}
     
     
	public Pedido procurar(String codPedido) throws NaoLocalizadoPedidoException{
	
			
		return pedidos.procurar(codPedido);
	}
	
	public Pedido procurar2(){
		
		
		return pedidos.procurar2();
	}
	
	public void alterar(Pedido pedido) {
		
		pedidos.alterar(pedido);
	}
	
	public void alterar2(Pedido pedido) {
		
		pedidos.alterar2(pedido);
	}

	
	public void remover() {
	
		pedidos.remover();
		}
	
	public void listar() {
		pedidos.listar();
	}
}
