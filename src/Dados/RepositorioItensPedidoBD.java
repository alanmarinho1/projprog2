package Dados;

import Negocios.ItensPedido;

public class RepositorioItensPedidoBD implements RepositorioItensPedido{

	
	public void inserir(ItensPedido itens) {
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO itens_pedido (id_pedido, id_produto, quantidade_itens, valor_total_item) "
			+ "VALUES ('" + itens.getPedido().getCodigo() + "', '"+ itens.getProduto().getCodigo() +"', '"+ itens.getQuantidadeitens() +"', '"+ itens.getValortotalitem() +"');";
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
		
	}

	
	public ItensPedido procurar(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	public void listar() {
		// TODO Auto-generated method stub
		
	}

}
