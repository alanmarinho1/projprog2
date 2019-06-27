package Negocios;

import java.util.ArrayList;

import Dados.RepositorioItensPedido;
import Dados.RepositorioItensPedidoBD;
import Dados.RepositorioProdutos;
import Dados.RepositorioProdutosBD;

public class ControleItensPedido {
	
	RepositorioItensPedido itenspedidos = new RepositorioItensPedidoBD();
	RepositorioProdutos produtos = new RepositorioProdutosBD();
	
	public void cadastrar (ItensPedido itenspedido) throws InserirException, ItensPedidoQtdException {
		
		if(itenspedidos.procurar(itenspedido.getProduto().getDescricao()).getCodigo() == itenspedido.getProduto().getDescricao()) {
			InserirException e1;
			e1 = new InserirException(itenspedido.getProduto().getDescricao());
			throw e1;
		}
		
		if(produtos.procurar(itenspedido.getProduto().getCodigo()).getQuantidade() < itenspedido.getQuantidadeitens() ) {
			ItensPedidoQtdException e1;
			e1 = new ItensPedidoQtdException(itenspedido.getQuantidadeitens());
			throw e1;
		}
		
		itenspedidos.inserir(itenspedido);
	}
	
	public ItensPedido procurar (String produto) {
		
		return itenspedidos.procurar(produto);
	}
	
	public void alterar (ItensPedido itenspedido) throws ItensPedidoQtdException {
				
		if(produtos.procurar(itenspedido.getProduto().getCodigo()).getQuantidade() > itenspedido.getQuantidadeitens() ) {
			ItensPedidoQtdException e1;
			e1 = new ItensPedidoQtdException(itenspedido.getQuantidadeitens());
			throw e1;
		}
		itenspedidos.alterar(itenspedido);
	}
	
	public void remover (String pedido) {
		
		itenspedidos.remover(pedido);
	}
	
	public ArrayList<ItensPedido> listarItensPedido(String pedido){
		
		return itenspedidos.listarItensPedido(pedido);
	}

}
