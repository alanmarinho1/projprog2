package Negocios;

import Dados.RepositorioFinanceiro;
import Dados.RepositorioFinanceiroBD;

public class ControleFinanceiro {

	RepositorioFinanceiro financeiro = new RepositorioFinanceiroBD();
	
	public void alterar (Financeiro caixa) {
		financeiro.alterar(caixa);
	}
}
