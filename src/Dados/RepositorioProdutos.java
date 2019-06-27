package Dados;

import java.util.ArrayList;

import Negocios.Produtos;

public interface RepositorioProdutos {
	
	public void inserir(Produtos produto);
	public void alterar(Produtos produto);
	public Produtos procurar(String codigo);
	public ArrayList<Produtos> listarProdutos(String descricao);
	
}
