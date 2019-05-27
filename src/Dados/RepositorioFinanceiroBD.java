package Dados;


import Negocios.Financeiro;


public class RepositorioFinanceiroBD implements RepositorioFinanceiro{

	
	public void alterar(Financeiro caixa) {
		BD.getInstance().conectar();
		try {
			String query = "UPDATE caixa SET saldo = '" + Financeiro.getSaldo() + "';"; 
			BD.getInstance().getStatement().executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		BD.getInstance().desconectar();
	}
		
}
