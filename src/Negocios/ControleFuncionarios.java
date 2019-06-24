package Negocios;


import Dados.RepositorioFuncionario;
import Dados.RepositorioFuncionarioBD;

public class ControleFuncionarios {
	
	RepositorioFuncionario funcionarios = new RepositorioFuncionarioBD();
    
	public void cadastrar(Funcionario funcionario) throws InserirException, PessoaJaExisteException{
		
		if (funcionario.getCpf().length() != 11 || funcionario.getCpf().equals("")) {
			InserirException e;
			e = new InserirException(((Funcionario)funcionario).getCpf());
			throw e;
        }
		
		if (funcionarios.procurar(funcionario.getCodigo()).getUsuario()  == funcionario.getUsuario()) {
			PessoaJaExisteException e2;
			e2 = new PessoaJaExisteException(funcionario.getUsuario());
			throw e2;
		}
					funcionarios.inserir(funcionario);
		}
    
     
	public void alterar(Funcionario funcionario)throws InserirException, PessoaJaExisteException {
	
	 if (((Funcionario)funcionario).getCpf().length() != 11 || ((Funcionario)funcionario).getCpf().equals("")) {
		InserirException e;
		e = new InserirException(((Funcionario)funcionario).getCpf());
		throw e;
    }
	 if (funcionarios.procurar(funcionario.getCodigo()).getUsuario()  == funcionario.getUsuario()) {
			PessoaJaExisteException e2;
			e2 = new PessoaJaExisteException(funcionario.getUsuario());
			throw e2;
		}
	
	 		funcionarios.alterar(funcionario);
    }    
	public Funcionario procurar(String usuario, String senha) throws NaoLocalizadoUsuarioException{
			if (funcionarios.procurar(usuario, senha).getCodigo() == null) {
			throw new NaoLocalizadoUsuarioException(usuario, senha);
			}else {
			
				return funcionarios.procurar(usuario, senha);
		}
	}
	public Funcionario procurar(String usuario) throws NaoLocalizadaPessoaException{
		if (funcionarios.procurar(usuario).getCodigo() == null) {
		throw new NaoLocalizadaPessoaException(usuario);
		}else { 
		
			return funcionarios.procurar(usuario);
	
		}
	}
	
	public void remover(String codigo) {
		
		funcionarios.remover(codigo);
	}
	
	public void listar() {
		funcionarios.listar();
	}
	
	
}

	