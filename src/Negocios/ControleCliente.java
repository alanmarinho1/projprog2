package Negocios;


import Dados.RepositorioClienteBD;

import java.util.ArrayList;

import Dados.RepositorioCliente;


public class ControleCliente {
	
	RepositorioCliente Cliente = new RepositorioClienteBD();
    
	public void cadastrar(Cliente cliente) throws InserirException, PessoaJaExisteException {
		
		if (cliente.getCpf().length() != 11 || cliente.getCpf().equals("")) {
			InserirException e1;
			e1 = new InserirException(cliente.getCpf());
			throw e1;		
			
		}
		
		if (cliente.getNome().equals("")) {
			InserirException e1;
			e1 = new InserirException(cliente.getNome());
			throw e1;		
			
		}
		
		if (Cliente.procurar(cliente.getCpf()).getCodigo() == cliente.getCpf()) {
			PessoaJaExisteException e2;
			e2 = new PessoaJaExisteException(cliente.getCpf());
			throw e2;
		}

			Cliente.inserir(cliente);
        }
	

     
	public void alterar(Cliente cliente) throws InserirException, PessoaJaExisteException {
		if (cliente.getCpf().length() != 11 || cliente.getCpf().equals("")) {
			InserirException e1;
			e1 = new InserirException(cliente.getCpf());
			throw e1;
        }
		
		if (Cliente.procurar(cliente.getCpf()).getCodigo() == cliente.getCpf() || Cliente.procurar(cliente.getNome()).getCodigo() == cliente.getNome()) {
			PessoaJaExisteException e2;
			e2 = new PessoaJaExisteException(cliente.getCpf());
			throw e2;
		}
		
		 		Cliente.alterar(cliente);
        }
    
	public Cliente procurar(String dado) throws NaoLocalizadaPessoaException{
		if (Cliente.procurar(dado).getCodigo() == null) {
			throw new NaoLocalizadaPessoaException(dado);
		}else {
			
		return Cliente.procurar(dado);
		}
	}
	
	public ArrayList<Cliente> listarClientes(String nome) throws NaoLocalizadaPessoaException{
		 
			if (Cliente.listarClientes(nome) == null) {
				throw new NaoLocalizadaPessoaException(nome);
			}
		
		return Cliente.listarClientes(nome);
	}
	
	public void remover(String id) {
		
		Cliente.remover(id);
	}
	
	public void listar() {
		
		Cliente.listar();
	}
}
