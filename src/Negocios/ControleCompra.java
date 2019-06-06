package Negocios;

import Dados.RepositorioCompra;
import Dados.RepositorioCompraBD;


public class ControleCompra {
	
	RepositorioCompra compras = new RepositorioCompraBD();
	
	
	public void cadastrar(Compra compra) throws CompraException {
		
		/*	if(pedido.getFuncionario() == null) {
				PedidoException e1;
				e1 = new PedidoException(pedido.getFuncionario());
				throw e1;
			}
			
	        if (pedido.getProduto() == null){
	        	PedidoException e2;
	        	e3 = new PedidoException(pedido.getProduto());
				throw e2;
	        }*/
			compras.inserir(compra);
		}
	     
	     
		public Compra procurar(String codCompra) throws NaoLocalizadaCompraException{
		/*	if (compras.procurar(codPedido).getCodigo() == null) {
				throw new NaoLocalizadaCompraException(codCompra);
			}else {*/
				
			return compras.procurar(codCompra);
			}
//		}
		
		public void listar() {
			compras.listar();
		}

}
