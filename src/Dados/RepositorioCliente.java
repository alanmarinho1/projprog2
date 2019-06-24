package Dados;

import Negocios.Cliente;

public interface RepositorioCliente {
	
	public void inserir(Cliente cliente);
	public void alterar(Cliente cliente);
	public Cliente procurar(String nome);
	public void remover(String nome);
	public void listar();
	

}
