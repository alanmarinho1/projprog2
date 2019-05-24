package Dados;

import Negocios.Produtos;

public interface RepositorioProdutos {
	
	public void inserir(Produtos produto);
	public void alterar(Produtos produto);
	public Produtos procurar(String codigo);
	public void remover(String codigo);
	public void listar();
	
}
