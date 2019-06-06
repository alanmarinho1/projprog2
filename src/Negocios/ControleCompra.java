package Negocios;

import Dados.RepositorioCompra;
import Dados.RepositorioCompraBD;


public class ControleCompra {
	
	RepositorioCompra compras = new RepositorioCompraBD();
	
	
	public void cadastrar(Compra compra) throws PedidoException {
		
		/*	if(pedido.getFuncionario() == null) {
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
	        }*/
			compras.inserir(compra);
		}
	     
	     
		public Compra procurar(String codCompra) throws NaoLocalizadoPedidoException{
		/*	if (pedidos.procurar(codPedido).getCodigo() == null) {
				throw new NaoLocalizadoPedidoException(codPedido);
			}else {*/
				
			return compras.procurar(codCompra);
			}
//		}
		
		public void listar() {
			compras.listar();
		}

}
