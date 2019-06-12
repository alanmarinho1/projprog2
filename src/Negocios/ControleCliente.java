package Negocios;


import Dados.RepositorioClienteBD;
import Dados.RepositorioPessoa;


public class ControleCliente {
	
	RepositorioPessoa Cliente = new RepositorioClienteBD();
    
	public void cadastrar(Pessoa pessoa) throws InserirException, PessoaJaExisteException {
		
/*		if (pessoa.getCpf().length() != 11 || pessoa.getCpf().equals("")) {
			InserirException e1;
			e1 = new InserirException(pessoa.getCpf());
			throw e1;		
			
		}
		
		if (Cliente.procurar(pessoa.getCpf()).getCodigo() == pessoa.getCpf()) {
			PessoaJaExisteException e2;
			e2 = new PessoaJaExisteException(pessoa.getCpf());
			throw e2;
		}*/

			Cliente.inserir(pessoa);
        }
	

     
	public void alterar(Pessoa pessoa) throws InserirException, PessoaJaExisteException {
		if (((Cliente)pessoa).getCpf().length() != 11 || ((Cliente)pessoa).getCpf().equals("")) {
			InserirException e1;
			e1 = new InserirException(((Cliente)pessoa).getCpf());
			throw e1;
        }
		
		if (Cliente.procurar(pessoa.getCpf()).getCodigo() == pessoa.getCpf()) {
			PessoaJaExisteException e2;
			e2 = new PessoaJaExisteException(pessoa.getCpf());
			throw e2;
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
