package Dados;

import Negocios.Funcionario;

public interface RepositorioFuncionario {
	
	public void inserir(Funcionario funcionario);
	public void alterar(Funcionario pessoa);
	public Funcionario procurar(String usuario, String senha);
	public Funcionario procurar(String id);
	public void remover(String id);
	public void listar();
	

}
