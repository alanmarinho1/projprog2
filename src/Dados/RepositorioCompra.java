package Dados;

import Negocios.Compra;

public interface RepositorioCompra {
	
	public void inserir(Compra compra);
	public void alterar(Compra compra);
	public Compra procurar(String codigo);
	public void remover(String codigo);
	public void listar();
}
