package Dados;

import java.sql.ResultSet;
import java.util.Calendar;

import Negocios.Cliente;
import Negocios.Pessoa;


public class RepositorioClienteBD implements RepositorioPessoa {
	
	public void inserir(Pessoa pessoa) {
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO cliente (id_cliente, nome, email, endereco, cpf, rg, nascimento) "
					+ "VALUES ( '" + pessoa.getCodigo() + "', '" + pessoa.getNome() + "', '" + ((Cliente)pessoa).getEmail() + "', '" + pessoa.getEndereco() + "', '" + pessoa.getCpf() + "', '" + ((Cliente)pessoa).getRg() + "', '" + ((Cliente)pessoa).getNascimento().getTime()+ "');"; 
			
			BD.getInstance().getStatement().executeUpdate(query);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public Pessoa procurar(String cpf) {
		BD.getInstance().conectar();
		Pessoa resultado = new Cliente();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM cliente WHERE cpf = '" + cpf + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("codigo"));
    			resultado.setNome(resultset.getString("nome"));
    			((Cliente)resultado).setEmail(resultset.getString("email"));
    			resultado.setEndereco(resultset.getString("endereco"));
    			resultado.setCpf(resultset.getString("cadastro_fisica_juridica"));
    			((Cliente)resultado).setRg(Integer.parseInt(resultset.getString("rg")));
    			((Cliente)resultado).setNascimento((Calendar)resultset.getObject("nascimento"));
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
			String query = "UPDATE cliente SET nome = '" + pessoa.getNome() + "', email = '" + ((Cliente)pessoa).getEmail() + "', endereco = '" + pessoa.getEndereco() + "'"
					+ ", cpf = '" + pessoa.getCpf() + "', rg = '" + ((Cliente)pessoa).getRg() + "', nascimento = '" + ((Cliente)pessoa).getNascimento().getTime() + "' WHERE cpf = '" + pessoa.getCpf() + "';"; 
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}

	public void remover(String id) {
		BD.getInstance().conectar();
		System.out.println(id);
		try {
			String query = "DELETE FROM cliente WHERE id_cliente = " + id + ";";
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public void listar() {
		BD.getInstance().conectar();
		try {
		String query = "SELECT * FROM cliente WHERE tipo ORDER BY id_cliente";
		BD.getInstance().setResultset(BD.getInstance().getStatement().executeQuery(query));
		while(BD.getInstance().getResultset().next()) {
			System.out.println("ID: " + BD.getInstance().getResultset().getString("codigo") + "\nNome: " + BD.getInstance().getResultset().getString("nome") + 
					"\nEmail: " + BD.getInstance().getResultset().getString("email") + "\nEndereço: " + BD.getInstance().getResultset().getString("endereco") +
					"\nCPF: " + BD.getInstance().getResultset().getString("cpf") + "\nRG: " + BD.getInstance().getResultset().getString("rg") +
					"\nData de Nascimento: " + BD.getInstance().getResultset().getString("nascimento") + "\n");
		}
	} catch(Exception e) {
		System.out.println("Erro: " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}

}
