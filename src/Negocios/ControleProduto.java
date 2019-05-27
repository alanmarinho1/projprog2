package Negocios;

import Dados.RepositorioProdutos;
import Dados.RepositorioProdutosBD;


public class ControleProduto {

	RepositorioProdutos produtos = new RepositorioProdutosBD();
	
	//fazer a regra de negocio pra produtos depois
	
	public void cadastrar(Produtos produto) throws InserirException {
		if ((produto).getChassi().length() != 17 || (produto).getChassi().equals("")) {
			InserirException e;
			e = new InserirException((produto).getChassi());
			throw e;
        }
		
					produtos.inserir(produto);
					
		}	
	
	public void alterar(Produtos produto) throws InserirException {
		if ((produto).getChassi().length() != 17 || (produto).getChassi().equals("")) {
			InserirException e;
			e = new InserirException((produto).getChassi());
			throw e;
        }
			
					produtos.alterar(produto);
		}
     
	public Produtos procurar(String chassi) throws NaoLocalizadoProdutoException{
		if (produtos.procurar(chassi).getCodigo() == null) {
			throw new NaoLocalizadoProdutoException(chassi);
		}else {
			
		return produtos.procurar(chassi);
		
		}
	}

	public void listar() {
		produtos.listar();
		
	}
	
}
	
	
