package Dados;

import Negocios.Pessoa;

public interface RepositorioPessoa {
	
	public void inserir(Pessoa pessoa);
	public void alterar(Pessoa pessoa);
	public Pessoa procurar(String id);
	public void remover(String id);
	public void listar();
	

}
