package Dados;

import java.sql.ResultSet;
import java.util.ArrayList;

import Negocios.Cliente;
import Negocios.ItensPedido;

public class RepositorioItensPedidoBD implements RepositorioItensPedido{

	
	public void inserir(ItensPedido itens) {
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO itens_pedido (id_pedido, id_produto, quantidade_itens, valor_total_item) "
			+ "VALUES ('" + itens.getPedido().getCodigo() + "', '"+ itens.getProduto().getCodigo() +"', '"+ itens.getQuantidadeitens() +
			"', '"+ itens.getValortotalitem() +"');";
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();	
	}

	
	public ItensPedido procurar(String produto) {
		BD.getInstance().conectar();
		ItensPedido resultado = new ItensPedido();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM itens_pedido WHERE id_produto = '"+ produto +"';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
			
			if(resultset != null && resultset.next()){
				
				resultado.setCodigo(resultset.getString("id_itens_pedido"));
				resultado.getProduto().setCodigo(resultset.getString("id_produto"));
				resultado.getPedido().setCodigo(resultset.getString("id_pedido"));
				resultado.setQuantidadeitens(Integer.parseInt(resultset.getString("quantidade_itens")));
				resultado.setValortotalitem(Double.parseDouble(resultset.getString("valor_total_item")));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
		}	
		return resultado;
	}
	
	public ArrayList<ItensPedido> listarItensPedido(String pedido){
		
		BD.getInstance().conectar();
		ArrayList<ItensPedido> resultadolista = new ArrayList<ItensPedido>();
		ResultSet resultset;
		
		try {
			String query = "select * from itens_pedido ip, produto p where p.id_produto = ip.id_produto and ip.id_pedido = '"+ pedido +"';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
			
			while(resultset != null && resultset.next()){
				ItensPedido resultado = new ItensPedido();
				resultado.setCodigo(resultset.getString("id_itens_pedido"));
				resultado.getProduto().setCodigo(resultset.getString("id_produto"));
				resultado.getPedido().setCodigo(resultset.getString("id_pedido"));
				resultado.setQuantidadeitens(Integer.parseInt(resultset.getString("quantidade_itens")));
				resultado.setValortotalitem(Double.parseDouble(resultset.getString("valor_total_item")));
    			
    			resultadolista.add(resultado);
			}
					
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultadolista;
	}
	
	public void alterar(ItensPedido itenspedido) {
		
		BD.getInstance().conectar();
		try {
			String query = "UPDATE itens_pedido SET quatidade_itens = '"+ itenspedido.getQuantidadeitens() +"' WHERE id_itens_pedido = '" + itenspedido.getCodigo() + "';"; 
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
	
	
	public void remover (String pedido) {
		BD.getInstance().conectar();
		try {
			String query = "DELETE FROM itens_pedido WHERE id_pedido = " + pedido + ";";
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: Não foi possivel deletar " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}

}
