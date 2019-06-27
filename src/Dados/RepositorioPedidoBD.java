package Dados;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Negocios.Funcionario;
import Negocios.Pedido;
import Negocios.Produtos;

public class RepositorioPedidoBD implements RepositorioPedido {

	
	public void inserir(Pedido pedido) {
		BD.getInstance().conectar();
		
		try {
			String query = "INSERT INTO pedido (id_funcionario) "
					+ "VALUES ('" + pedido.getFuncionario().getCodigo() + "');"; 
			
			BD.getInstance().getStatement().executeUpdate(query);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
		
	}

	public void alterar (Pedido pedido) {
		BD.getInstance().conectar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String query = "UPDATE pedido SET id_funcionario = '" + pedido.getFuncionario().getCodigo() 
			+ "', id_cliente = '" + pedido.getCliente().getCodigo()
			+ "', data_pedido = '" + sdf.format(pedido.getData().getTime())
			+ "', quantidade_itens = '" + pedido.getNumeroitens()
			+ "', valor = '" + pedido.getTotal()
			+ "' WHERE id_pedido = '" + pedido.getCodigo() + "';"; 
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: Não foi possivel alterar " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public Pedido procurar(String codigo) {
		
		BD.getInstance().conectar();
		Pedido resultado = new Pedido();
		DateFormat f = DateFormat.getDateInstance();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM pedido WHERE id_pedido = '" + codigo + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_pedido"));
    			resultado.getFuncionario().setCodigo(resultset.getString("id_funcionario"));
    			resultado.getCliente().setCodigo(resultset.getString("id_cliente"));
    			resultado.setNumeroitens(resultset.getInt("numeroitens"));
    			resultado.setTotal(resultset.getDouble("valor"));
    			resultado.getData().setTime((f.parse(resultset.getString("data_pedido"))));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}

	public void alterar2(Pedido pedido) {
		BD.getInstance().conectar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String query = "UPDATE pedido SET id_cliente = '" + pedido.getCliente().getCodigo()
			+ "', data_pedido = '" + sdf.format(pedido.getData().getTime())
			+ "', quantidade_itens = '" + pedido.getNumeroitens()
			+ "', valor = '" + pedido.getTotal() + "' ORDER BY id_pedido DESC LIMIT 1;"; 
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: Não foi possivel alterar " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	public Pedido procurar2() {
		
		BD.getInstance().conectar();
		Pedido resultado = new Pedido();
		DateFormat f = DateFormat.getDateInstance();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM pedido ORDER BY id_pedido DESC LIMIT 1";;
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_pedido"));
    			resultado.getFuncionario().setCodigo(resultset.getString("id_funcionario"));
    			resultado.getCliente().setCodigo(resultset.getString("id_cliente"));
    			resultado.setNumeroitens(resultset.getInt("numeroitens"));
    			resultado.setTotal(resultset.getDouble("valor"));
    			resultado.getData().setTime((f.parse(resultset.getString("data_pedido"))));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}
	
	public void remover() {
		BD.getInstance().conectar();
		try {
			String query = "DELETE FROM pedido ORDER BY id_pedido DESC LIMIT 1;";
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		BD.getInstance().desconectar();
		
	}
	
	public void listar() {
		
		
	}

}
