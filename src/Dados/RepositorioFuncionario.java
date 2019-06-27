package Dados;

import java.util.ArrayList;


import Negocios.Funcionario;

public interface RepositorioFuncionario {
	
	public void inserir(Funcionario funcionario);
	public void alterar(Funcionario pessoa);
	public ArrayList<Funcionario> listarFuncionarios(String nome);
	public Funcionario procurar(String usuario, String senha);
	public Funcionario procurar(String usuario);
	public void remover(String id);
	public void listar();
	

}
