package Dados;

import java.sql.ResultSet;
import java.util.Calendar;

import Negocios.Pedido;
import Negocios.Produtos;

public class RepositorioPedidoBD implements RepositorioPedido {

	
	public void inserir(Pedido pedido) {
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO pedido (id_funcionario, id_cliente, id_produto, data_pedido, numeroitens, valor) "
					+ "VALUES ('" + pedido.getFuncionario().getCodigo() + "', '" + pedido.getCliente().getCodigo() + "', '" + pedido.getProduto().getCodigo() +"', "
							+ "'" + pedido.getData().getTime() + "', '"+ pedido.getNumeroitens() +"', '" + pedido.getTotal() + "');"; 
			
			BD.getInstance().getStatement().executeUpdate(query);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
		
	}

	
	public Pedido procurar(String codigo) {
		
		BD.getInstance().conectar();
		Pedido resultado = new Pedido();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM pedido WHERE id_pedido = '" + codigo + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_pedido"));
    			resultado.getFuncionario().setCodigo(resultset.getString("id_funcionario"));
    			resultado.getCliente().setCodigo(resultset.getString("id_cliente"));
    			resultado.getProduto().setCodigo(resultset.getString("id_produto"));
    			resultado.setNumeroitens(resultset.getInt("numeroitens"));
    			resultado.setTotal(resultset.getDouble("valor"));
    			//tem que ver se ele ta comparando se é o mesmo dia da semana
    			resultado.setData((Calendar) resultset.getObject("data_pedido"));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}

	@Override
	public void listar() {
		
		
	}

}
