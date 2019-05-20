package Dados;

import java.sql.ResultSet;

import Negocios.Pessoa;
import Negocios.Funcionario;

public class RepositorioFuncionarioBD implements RepositorioPessoa{

	public void inserir(Pessoa pessoa) {
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO funcionario (nome, email, cpf, profissao, salario) "
					+ "VALUES ('" + pessoa.getNome() + "', '" + pessoa.getEmail() + "','" + ((Funcionario) pessoa).getCpf()
					+ "','" + ((Funcionario) pessoa).getProfissao()
					+ "', '" + ((Funcionario)pessoa).getSalario() +"');"; 

			BD.getInstance().getStatement().executeUpdate(query);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public Pessoa procurar(String cpf) {
		BD.getInstance().conectar();
		Pessoa resultado = new Funcionario();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM funcionario WHERE cpf = '" + cpf + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_funcionario"));
    			resultado.setNome(resultset.getString("nome"));
    			resultado.setEmail(resultset.getString("email"));
    			((Funcionario)resultado).setCpf(resultset.getString("cpf"));
    			((Funcionario)resultado).setProfissao(resultset.getString("profissao"));
    			((Funcionario)resultado).setSalario(Double.valueOf(resultset.getString("salario")));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}

	public void alterar(Pessoa pessoa) {
		BD.getInstance().conectar();
		try {
			String query = "UPDATE funcionario SET nome = '" + pessoa.getNome() + "', email = '" + pessoa.getEmail()
			+ "', cpf = '" + ((Funcionario)pessoa).getCpf()
			+ "', profissao = '" + ((Funcionario)pessoa).getProfissao()
			+ "', salario = '" + ((Funcionario)pessoa).getSalario()
			+ "' WHERE cpf = '" + ((Funcionario) pessoa).getCpf() + "';"; 
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: Não foi possivel alterar " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}

	public void remover(String id) {
		BD.getInstance().conectar();
		try {
			String query = "DELETE FROM funcionario WHERE id_funcionario = " + id + ";";
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: Não foi possivel deletar " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public void listar() {
		BD.getInstance().conectar();
		try {
		String query = "SELECT * FROM funcionario ORDER BY id_funcionario";
		BD.getInstance().setResultset(BD.getInstance().getStatement().executeQuery(query));
		while(BD.getInstance().getResultset().next()) {
			System.out.println("ID: " + BD.getInstance().getResultset().getString("id_funcionario") + 
					"\nNome: " + BD.getInstance().getResultset().getString("nome") + 
					"\nEmail: " + BD.getInstance().getResultset().getString("email") +
					"\nCPF: " + BD.getInstance().getResultset().getString("cpf") + 
					"\nProfissao: " + BD.getInstance().getResultset().getString("profissao") + 
					"\nSalario: " + BD.getInstance().getResultset().getString("salario") + "\n");
		}
	} catch(Exception e) {
		System.out.println("Erro: Não foi possivel listar " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
}
