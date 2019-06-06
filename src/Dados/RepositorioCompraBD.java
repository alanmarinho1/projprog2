package Dados;

import java.sql.ResultSet;
import java.util.Calendar;

import Negocios.Compra;

public class RepositorioCompraBD implements RepositorioCompra {

	public void inserir(Compra compra) {
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO compra (id_funcionario, id_produto, data_compra, numeroitens, valor) "
					+ "VALUES ('" + compra.getFuncionario().getCodigo() + "', '" + compra.getProduto().getCodigo() + "', '" + compra.getDatacompra() +"', "
							+ "'"+ compra.getNumeroitens() +"', '" + compra.getTotal() + "');"; 
			
			BD.getInstance().getStatement().executeUpdate(query);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
		
	}

	
	public Compra procurar(String codigo) {
		
		BD.getInstance().conectar();
		Compra resultado = new Compra();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM compra WHERE id_compra = '" + codigo + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_pedido"));
    			resultado.getFuncionario().setCodigo(resultset.getString("id_funcionario"));
    			resultado.getProduto().setCodigo(resultset.getString("id_produto"));
    			resultado.setNumeroitens(resultset.getInt("numeroitens"));
    			resultado.setTotal(resultset.getDouble("valor"));
    			//tem que ver se ele ta comparando se é o mesmo dia da semana
    			resultado.setDatacompra((Calendar) resultset.getObject("data_pedido"));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}


	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}
}
