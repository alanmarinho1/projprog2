package Dados;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;

import Negocios.Produtos;


public class RepositorioProdutosBD implements RepositorioProdutos {

	
	public void inserir(Produtos produto) {
		
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO produto (descricao, quantidade, valorvenda, valorcompra, diadasemana) "
					+ "VALUES ('" + produto.getDescricao() + "', '" + produto.getQuantidade() + "', '" + produto.getValorvenda() + "', '" + produto.getDiadasemana() + "');"; 
			
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
			String query = "UPDATE produto SET descricao = '" + produto.getDescricao() + "', quantidade = '" + produto.getQuantidade() + 
					"', valorvenda= '" + produto.getValorvenda() + "', valorcompra = '" + produto.getValorcompra() + 
					"', diadasemana ='"+ produto.getDiadasemana() +"' WHERE id_produto = '" + produto.getCodigo() + "';"; 
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
			String query = "SELECT * FROM produto WHERE id_produto = '" + codigo + "';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			if(resultset != null && resultset.next()){
    			resultado.setCodigo(resultset.getString("id_produto"));
    			resultado.setDescricao(resultset.getString("descricao"));
    			resultado.setQuantidade(resultset.getInt("quantidade"));
    			resultado.setValorvenda(resultset.getDouble("valorvenda"));
    			resultado.setValorcompra(resultset.getDouble("valorcompra"));
    			//tem que ver se ele ta comparando se é o mesmo dia da semana
    			resultado.setDiadasemana((String) resultset.getObject("diadasemana"));
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		return resultado;
	}
	
	
	
	public ArrayList<Produtos> listarProdutos(String descricao) {
		
		BD.getInstance().conectar();
		ArrayList<Produtos> resultadolista = new ArrayList<Produtos>();
		
		ResultSet resultset;
		
		try {
			String query = "SELECT * FROM produto WHERE descricao like '" + descricao + "%';";
			resultset = BD.getInstance().getStatement().executeQuery(query);
		
			while(resultset != null && resultset.next()){
				Produtos resultado = new Produtos();
    			resultado.setCodigo(resultset.getString("id_produto"));
    			resultado.setDescricao(resultset.getString("descricao"));
    			resultado.setQuantidade(resultset.getInt("quantidade"));
    			resultado.setValorvenda(resultset.getDouble("valorvenda"));
    			resultado.setValorcompra(resultset.getDouble("valorcompra"));
    			resultado.setDiadasemana((String) resultset.getObject("diadasemana"));
    			
    			resultadolista.add(resultado);
            }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel pesquisar" + e.getMessage());
			}
		
		return resultadolista;
	}

	
	
}
