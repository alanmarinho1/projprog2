package Negocios;


import Dados.RepositorioClienteBD;
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
		
		if (Cliente.procurar(cliente.getCpf()).getCodigo() == cliente.getCpf()) {
			PessoaJaExisteException e2;
			e2 = new PessoaJaExisteException(cliente.getCpf());
			throw e2;
		}
		
		 		Cliente.alterar(cliente);
        }
    
	public Cliente procurar(String cpf) throws NaoLocalizadaPessoaException{
		if (Cliente.procurar(cpf).getCodigo() == null) {
			throw new NaoLocalizadaPessoaException(cpf);
		}else {
			
		return Cliente.procurar(cpf);
		}
	}
	
	public void remover(String id) {
		
		Cliente.remover(id);
	}
	
	public void listar() {
		
		Cliente.listar();
	}
}
