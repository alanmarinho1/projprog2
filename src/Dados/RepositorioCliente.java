package Dados;

import java.util.ArrayList;

import Negocios.Cliente;

public interface RepositorioCliente {
	
	public void inserir(Cliente cliente);
	public void alterar(Cliente cliente);
	public ArrayList<Cliente> listarClientes(String nome);
	public Cliente procurar(String dado);
	public void remover(String nome);
	public void listar();
	

}
