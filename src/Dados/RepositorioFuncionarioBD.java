package Dados;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;

import Negocios.Cliente;
import Negocios.Funcionario;
import Negocios.Funcionario;

public class RepositorioFuncionarioBD implements RepositorioFuncionario{

	public void inserir(Funcionario funcionario) {
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO funcionario (nome, endereco, cpf, profissao, salario, comissao, senha, usuario) "
					+ "VALUES ('" + funcionario.getNome()
					+ "', '" + funcionario.getEndereco()
					+ "','" + funcionario.getCpf()
					+"','" + funcionario.getProfissao()
					+"', '" + funcionario.getSalario()
					+"', '"+ funcionario.getComissao()
					+"', '"+ funcionario.getSenha()
					+"', '"+ funcionario.getUsuario()+"');"; 

			BD.getInstance().getStatement().executeUpdate(query);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: N�o foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public Funcionario procurar(String usuario, String senha) {
		BD.getInstance().conectar();
		Funcionario resultado = new Funcionario();
		ResultSet resultset;
		
		try {
			String query = "SELECT * FROM funcionario WHERE usuario = '" + usuario + "' AND senha = '" + senha + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
				
				resultado.setCodigo(resultset.getString("id_funcionario"));
    			resultado.setNome(resultset.getString("nome"));
    			resultado.setEndereco(resultset.getString("endereco"));
    			resultado.setCpf(resultset.getString("cpf"));
    			resultado.setProfissao(resultset.getString("profissao"));
    			resultado.setSalario(Double.valueOf(resultset.getString("salario")));
    			resultado.setComissao(Double.valueOf(resultset.getString("comissao")));
				resultado.setUsuario(resultset.getString("usuario"));
    			resultado.setSenha(resultset.getString("senha"));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: N�o foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}
	
	public Funcionario procurar(String usuario) {
		BD.getInstance().conectar();
		Funcionario resultado = new Funcionario();
		ResultSet resultset;
		
		try {
			String query = "SELECT * FROM funcionario WHERE usuario LIKE '" + usuario + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_funcionario"));
    			resultado.setNome(resultset.getString("nome"));
    			resultado.setEndereco(resultset.getString("endereco"));
    			resultado.setCpf(resultset.getString("cpf"));
    			resultado.setProfissao(resultset.getString("profissao"));
    			resultado.setSalario(Double.valueOf(resultset.getString("salario")));
    			resultado.setComissao(Double.valueOf(resultset.getString("comissao")));
    			resultado.setUsuario(resultset.getString("usuario"));
    			resultado.setSenha(resultset.getString("senha"));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: N�o foi possivel pesquisar" + e.getMessage());
			}
		
		return resultado;
	}

	public ArrayList<Funcionario> listarFuncionarios(String usuario) {
		BD.getInstance().conectar();
		ArrayList<Funcionario> resultadolista = new ArrayList<Funcionario>();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM funcionario WHERE usuario like '" + usuario + "%';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
			
			while(resultset != null && resultset.next()){
				Funcionario resultado = new Funcionario();
				resultado.setCodigo(resultset.getString("id_funcionario"));
    			resultado.setNome(resultset.getString("nome"));
    			resultado.setEndereco(resultset.getString("endereco"));
    			resultado.setCpf(resultset.getString("cpf"));
    			resultado.setProfissao(resultset.getString("profissao"));
    			resultado.setSalario(Double.valueOf(resultset.getString("salario")));
    			resultado.setComissao(Double.valueOf(resultset.getString("comissao")));
    			resultado.setUsuario(resultset.getString("usuario"));
    			resultado.setSenha(resultset.getString("senha"));
    			
    			resultadolista.add(resultado);    		
			}
					
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: N�o foi possivel pesquisar" + e.getMessage());
			}
		return resultadolista;
	}
	
	public void alterar(Funcionario funcionario) {
		BD.getInstance().conectar();
		try {
			String query = "UPDATE funcionario SET nome = '" + funcionario.getNome()
			+ "', cpf = '" + funcionario.getCpf()
			+ "', profissao = '" + funcionario.getProfissao()
			+ "', salario = '" + funcionario.getSalario()
			+ "', comissao = '" + funcionario.getComissao()
			+ "', usuario = '"+ funcionario.getUsuario()
			+ "', senha = '"+ funcionario.getSenha()
			+ "' WHERE id_funcionario = '" + funcionario.getCodigo() + "';"; 
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: N�o foi possivel alterar " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}

	public void remover(String id) {
		BD.getInstance().conectar();
		try {
			String query = "DELETE FROM funcionario WHERE id_funcionario = " + id + ";";
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: N�o foi possivel deletar " + e.getMessage());
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
					"\nUsuario: " + BD.getInstance().getResultset().getString("usuario") +
					"\nNome: " + BD.getInstance().getResultset().getString("nome") + 
					"\nEmail: " + BD.getInstance().getResultset().getString("Endereco") +
					"\nCPF: " + BD.getInstance().getResultset().getString("cpf") + 
					"\nProfissao: " + BD.getInstance().getResultset().getString("profissao") + 
					"\nSalario: " + BD.getInstance().getResultset().getString("salario") + 
					"\nComissao: " + BD.getInstance().getResultset().getString("comissao") + "\n");
		}
	} catch(Exception e) {
		System.out.println("Erro: N�o foi possivel listar " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
}
