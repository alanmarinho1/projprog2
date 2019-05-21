package Negocios;


import Dados.RepositorioPedido;
import Dados.RepositorioPedidoBD;

public class ControlePedido {
	
	RepositorioPedido pedidos = new RepositorioPedidoBD();
    
	public void cadastrar(Pedido pedido) throws PedidoException {
		
		if(pedido.getFuncionario() == null) {
			PedidoException e1;
			e1 = new PedidoException(pedido.getFuncionario());
			throw e1;
		}
		
        if (pedido.getCliente() == null){
        	PedidoException e2;
        	e2 = new PedidoException(pedido.getCliente());
			throw e2;
        }
        if (pedido.getProduto() == null){
        	PedidoException e3;
        	e3 = new PedidoException(pedido.getProduto());
			throw e3;
        }
		pedidos.inserir(pedido);
	}
     
	public void alterar(Pedido pedido) throws PedidoException {
		if(pedido.getFuncionario() == null) {
			PedidoException e1;
			e1 = new PedidoException(pedido.getFuncionario());
			throw e1;
		}
		
        if (pedido.getCliente() == null){
        	PedidoException e2;
        	e2 = new PedidoException(pedido.getCliente());
			throw e2;
        }
        if (pedido.getProduto() == null){
        	PedidoException e3;
        	e3 = new PedidoException(pedido.getProduto());
			throw e3;
        }
		pedidos.alterar(pedido);
    }
     
	public Pedido procurar(String codPedido) throws NaoLocalizadoPedidoException{
		if (pedidos.procurar(codPedido).getCodPedido() == null) {
			throw new NaoLocalizadoPedidoException(codPedido);
		}else {
			
		return pedidos.procurar(codPedido);
		}
	}
	
	public void remover(String codPedido) {
		pedidos.remover(codPedido);
	}
	public void listar() {
		pedidos.listar();
	}
}
