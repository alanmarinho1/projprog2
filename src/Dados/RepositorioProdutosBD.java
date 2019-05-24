package Dados;

import java.sql.ResultSet;
import java.util.Calendar;
import Negocios.Produtos;


public class RepositorioProdutosBD implements RepositorioProdutos {

	
	public void inserir(Produtos produto) {
		
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO produto (codigo, descricao, quantidade, valorvenda, valorcompra diadasemana) "
					+ "VALUES ('" + produto.getCodigo() + "', '" + produto.getDescricao() + "', '" + produto.getQuantidade() + "', '" + produto.getValorvenda() + "', '" + produto.getDiadasemana().DAY_OF_WEEK + "');"; 
			
			BD.getInstance().getStatement().executeUpdate(query);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}

	
	public void alterar(Produtos produto) {
		
		BD.getInstance().conectar();
		try {
			String query = "UPDATE produto SET descricao = '" + produto.getDescricao() + "', quantidade = '" + produto.getQuantidade() + "'"
					+ ", valorvenda= '" + produto.getValorvenda() + "', valorcompra = '" + produto.getValorcompra() + "' WHERE codigo = '" + produto.getCodigo() + "';"; 
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}

	
	public Produtos procurar(String codigo) {
		
		BD.getInstance().conectar();
		Produtos resultado = new Produtos();
		ResultSet resultset;
		try {
			String query = "SELECT * FROM produto WHERE codigo = '" + codigo + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("codigo"));
    			resultado.setDescricao(resultset.getString("descricao"));
    			resultado.setQuantidade(resultset.getInt("quantidade"));
    			resultado.setValorvenda(resultset.getDouble("valorvenda"));
    			resultado.setValorcompra(resultset.getDouble("valorcompra"));
    			//tem que ver se ele ta comparando se é o mesmo dia da semana
    			resultado.setDiadasemana((Calendar) resultset.getObject("diadasemana"));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}

	@Override
	public void remover(String codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

	
	
}
