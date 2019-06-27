package Dados;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Negocios.Cliente;
import Negocios.Pessoa;


public class RepositorioClienteBD implements RepositorioCliente {
	
	public void inserir(Cliente cliente) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO cliente (nome, email, endereco, cpf, rg, nascimento, telefone) "
					+ "VALUES ('" + cliente.getNome() + "', '" + cliente.getEmail() + "', '" + cliente.getEndereco() + "', '" +
					cliente.getCpf() + "', '" + ((Cliente)cliente).getRg() + "', '" +
					sdf.format(cliente.getNascimento().getTime())+ "', '"+ cliente.getTelefone() +"');"; 
			
			BD.getInstance().getStatement().executeUpdate(query);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public Cliente procurar(String dado) {
		BD.getInstance().conectar();
		Cliente resultado = new Cliente();
		ResultSet resultset;
		DateFormat f = DateFormat.getDateInstance();
		
		try {
			String query = "SELECT * FROM cliente WHERE id_cliente = '" + dado + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_cliente"));
    			resultado.setNome(resultset.getString("nome"));
    			resultado.setEmail(resultset.getString("email"));
    			resultado.setEndereco(resultset.getString("endereco"));
    			resultado.setCpf(resultset.getString("cadastro_fisica_juridica"));
    			resultado.setRg(Integer.parseInt(resultset.getString("rg")));
    			resultado.getNascimento().setTime((f.parse(resultset.getString("nascimento"))));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}
	
	public ArrayList<Cliente> listarClientes(String nome) {
		BD.getInstance().conectar();
		ArrayList<Cliente> resultadolista = new ArrayList<Cliente>();
		DateFormat f = DateFormat.getDateInstance();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM cliente WHERE nome like '" + nome + "%';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
			
			while(resultset != null && resultset.next()){
				Cliente resultado = new Cliente();
				resultado.setCodigo(resultset.getString("id_cliente"));
    			resultado.setNome(resultset.getString("nome"));
    			resultado.setEmail(resultset.getString("email"));
    			resultado.setEndereco(resultset.getString("endereco"));
    			resultado.setCpf(resultset.getString("cpf"));
    			resultado.setRg(Integer.parseInt(resultset.getString("rg")));
    			resultado.getNascimento().setTime((f.parse(resultset.getString("nascimento"))));
    			resultado.setTelefone(resultset.getString("telefone"));
    			
    			resultadolista.add(resultado);
    			
    		
			}
					
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultadolista;
	}

	public void alterar(Cliente cliente) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		BD.getInstance().conectar();
		try {
			String query = "UPDATE cliente SET nome = '" + cliente.getNome() + "', email = '" + cliente.getEmail() + 
					"', endereco = '" + cliente.getEndereco() + "', cpf = '" + cliente.getCpf() + "', rg = '" + cliente.getRg() +
					"', nascimento = '" + sdf.format(cliente.getNascimento().getTime()) + "', telefone = '"+ cliente.getTelefone() +"' WHERE id_cliente = '" + cliente.getCodigo() + "';"; 
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
