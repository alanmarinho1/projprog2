package Negocios;


import Dados.RepositorioPessoa;
import Dados.RepositorioPessoaFisicaBD;

public class ControlePessoaFisica {
	
	RepositorioPessoa pessoafisica = new RepositorioPessoaFisicaBD();
    
	public void cadastrar(Pessoa pessoa) throws InserirException {
		
		if (((PessoaFisica)pessoa).getCpf().length() != 11 || ((PessoaFisica)pessoa).getCpf().equals("")) {
			InserirException e;
			e = new InserirException(((PessoaFisica)pessoa).getCpf());
			throw e;		
			
		}

			pessoafisica.inserir(pessoa);
        }
	

     
	public void alterar(Pessoa pessoa) throws InserirException {
		if (((PessoaFisica)pessoa).getCpf().length() != 11 || ((PessoaFisica)pessoa).getCpf().equals("")) {
			InserirException e;
			e = new InserirException(((PessoaFisica)pessoa).getCpf());
			throw e;
        }
		
		 		pessoafisica.alterar(pessoa);
        }
    
	public Pessoa procurar(String cpf) throws NaoLocalizadaPessoaException{
		if (pessoafisica.procurar(cpf).getCodigo() == null) {
			throw new NaoLocalizadaPessoaException(cpf);
		}else {
			
		return pessoafisica.procurar(cpf);
		}
	}
	
	public void remover(String id) {
		
		pessoafisica.remover(id);
	}
	
	public void listar() {
		
		pessoafisica.listar();
	}
}
