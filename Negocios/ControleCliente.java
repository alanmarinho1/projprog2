package Negocios;


import Dados.RepositorioClienteBD;
import Dados.RepositorioPessoa;


public class ControleCliente {
	
	RepositorioPessoa Cliente = new RepositorioClienteBD();
    
	public void cadastrar(Pessoa pessoa) throws InserirException {
		
		if (((Cliente)pessoa).getCpf().length() != 11 || ((Cliente)pessoa).getCpf().equals("")) {
			InserirException e;
			e = new InserirException(((Cliente)pessoa).getCpf());
			throw e;		
			
		}

			Cliente.inserir(pessoa);
        }
	

     
	public void alterar(Pessoa pessoa) throws InserirException {
		if (((Cliente)pessoa).getCpf().length() != 11 || ((Cliente)pessoa).getCpf().equals("")) {
			InserirException e;
			e = new InserirException(((Cliente)pessoa).getCpf());
			throw e;
        }
		
		 		Cliente.alterar(pessoa);
        }
    
	public Pessoa procurar(String cpf) throws NaoLocalizadaPessoaException{
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
