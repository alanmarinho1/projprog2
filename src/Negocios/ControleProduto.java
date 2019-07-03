package Negocios;

import java.util.ArrayList;

import Dados.RepositorioProdutos;
import Dados.RepositorioProdutosBD;


public class ControleProduto {

	RepositorioProdutos produtos = new RepositorioProdutosBD();
	
	
	public void cadastrar(Produtos produto) throws InserirException, ProdutoJaExisteException {
		if (produto.getDescricao().equals("") || produto.getDescricao() == null) {
			InserirException e1;
			e1 = new InserirException(produto.getDescricao());
			throw e1;
        }
		if (produtos.procurar(produto.getDescricao()).getCodigo() == produto.getDescricao()){
			ProdutoJaExisteException e2;
			e2 = new ProdutoJaExisteException(produto.getDescricao());
			throw e2;
		}
		
					produtos.inserir(produto);
					
		}	
	
	public void alterar(Produtos produto) throws InserirException, ProdutoJaExisteException {
		if (produto.getDescricao().equals("") || produto.getDescricao() == null) {
			InserirException e;
			e = new InserirException((produto).getDescricao());
			throw e;
        }
			
					produtos.alterar(produto);
		}
     
	public Produtos procurar(String codigo) throws NaoLocalizadoProdutoException{
		if (produtos.procurar(codigo).getCodigo() == null) {
			throw new NaoLocalizadoProdutoException(codigo);
		}else {
			
		return produtos.procurar(codigo);
		
		}
	}

	public ArrayList<Produtos> listarProdutos(String descricao) throws NaoLocalizadoProdutoException{
		if (produtos.listarProdutos(descricao) == null) {
			throw new NaoLocalizadoProdutoException(descricao);
		}
		return produtos.listarProdutos(descricao);
	}	
}
	
	
