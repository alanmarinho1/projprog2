package Dados;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Negocios.Cliente;
import Negocios.Pessoa;


public class RepositorioClienteBD implements RepositorioCliente {
	
	public void inserir(Cliente cliente) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO cliente (nome, email, endereco, cpf, rg, nascimento) "
					+ "VALUES ('" + cliente.getNome() + "', '" + ((Cliente)cliente).getEmail() + "', '" + cliente.getEndereco() + "', '" + cliente.getCpf() + "', '" + ((Cliente)cliente).getRg() + "', '" + sdf.format(((Cliente) cliente).getNascimento().getTime())+ "');"; 
			
			BD.getInstance().getStatement().executeUpdate(query);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public Cliente procurar(String nome) {
		BD.getInstance().conectar();
		Cliente resultado = new Cliente();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM cliente WHERE nome like = '%''" + nome + "''%';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			do {
				resultado.setCodigo(resultset.getString("id_cliente"));
    			resultado.setNome(resultset.getString("nome"));
    			resultado.setEmail(resultset.getString("email"));
    			resultado.setEndereco(resultset.getString("endereco"));
    			resultado.setCpf(resultset.getString("cadastro_fisica_juridica"));
    			resultado.setRg(Integer.parseInt(resultset.getString("rg")));
    			resultado.setNascimento((Calendar)resultset.getObject("nascimento"));
			}while(resultset != null && resultset.next());
			
			/*if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_cliente"));
    			resultado.setNome(resultset.getString("nome"));
    			((Cliente)resultado).setEmail(resultset.getString("email"));
    			resultado.setEndereco(resultset.getString("endereco"));
    			resultado.setCpf(resultset.getString("cadastro_fisica_juridica"));
    			((Cliente)resultado).setRg(Integer.parseInt(resultset.getString("rg")));
    			((Cliente)resultado).setNascimento((Calendar)resultset.getObject("nascimento"));
            }*/
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}

	public void alterar(Cliente cliente) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		BD.getInstance().conectar();
		try {
			String query = "UPDATE cliente SET nome = '" + cliente.getNome() + "', email = '" + cliente.getEmail() + "', endereco = '" + cliente.getEndereco() + "'"
					+ ", cpf = '" + cliente.getCpf() + "', rg = '" + cliente.getRg() + "', nascimento = '" + sdf.format(cliente.getNascimento().getTime()) + "' WHERE cpf = '" + cliente.getCpf() + "';"; 
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
		String query = "SELECT * FROM cliente ORDER BY id_cliente";
		BD.getInstance().setResultset(BD.getInstance().getStatement().executeQuery(query));
		while(BD.getInstance().getResultset().next()) {
			System.out.println("ID: " + BD.getInstance().getResultset().getString("id_cliente") + "\nNome: " + BD.getInstance().getResultset().getString("nome") + 
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
