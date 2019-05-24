package Dados;

import Negocios.Pedido;

public class RepositorioPedidoBD implements RepositorioPedido {

	
	public void inserir(Pedido pedido) {
		BD.getInstance().conectar();
		try {
			String query = "INSERT INTO pedido (id_funcionario, id_cliente, id_produto, data_pedido, status_pedido, valor, adicional) "
					+ "VALUES ('" + pedido.getFuncionario().getCodigo() + "', '" + pedido.getCliente().getCodigo() + "', '" + pedido.getVeiculo().getCodVeiculo() +"', "
							+ "'" + pedido.getData().getTime() + "', '" + pedido.getStatus() + "', '" + pedido.getValor() + "', '" + pedido.getAdicional()+ "');"; 
			
			BD.getInstance().getStatement().executeUpdate(query);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: Não foi possivel inserir" + e.getMessage());
		}
		BD.getInstance().desconectar();
		
	}

	@Override
	public void alterar(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido procurar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

}
