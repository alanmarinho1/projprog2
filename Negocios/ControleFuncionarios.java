package Negocios;


import Dados.RepositorioFuncionarioBD;
import Dados.RepositorioPessoa;

public class ControleFuncionarios {
	
	RepositorioPessoa funcionarios = new RepositorioFuncionarioBD();
    
	public void cadastrar(Pessoa pessoa) throws InserirException{
		
		if (((Funcionario)pessoa).getCpf().length() != 11 || ((Funcionario)pessoa).getCpf().equals("")) {
			InserirException e;
			e = new InserirException(((Funcionario)pessoa).getCpf());
			throw e;
        }
					funcionarios.inserir(pessoa);
		}
    
     
	public void alterar(Pessoa pessoa)throws InserirException {
	
	if (((Funcionario)pessoa).getCpf().length() != 11 || ((Funcionario)pessoa).getCpf().equals("")) {
		InserirException e;
		e = new InserirException(((Funcionario)pessoa).getCpf());
		throw e;
    }
	
	
	 		funcionarios.alterar(pessoa);
    }    
     
	public Pessoa procurar(String cpf) throws NaoLocalizadaPessoaException{
		if (funcionarios.procurar(cpf).getCodigo() == null) {
		throw new NaoLocalizadaPessoaException(cpf);
		}else {
		
			return funcionarios.procurar(cpf);
	
		}
	}
	
	public void remover(String codigo) {
		funcionarios.remover(codigo);
	}
	
	public void listar() {
		funcionarios.listar();
	}
	
	
}

	