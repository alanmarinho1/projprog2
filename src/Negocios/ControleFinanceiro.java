package Negocios;

import Dados.RepositorioFinanceiro;
import Dados.RepositorioFinanceiroBD;

public class ControleFinanceiro {

	RepositorioFinanceiro financeiro = new RepositorioFinanceiroBD();
	
	public void alterar() throws FinanceiroException {
		if (Financeiro.getSaldo() <= 0) {
			FinanceiroException e1;
			e1 = new FinanceiroException(Financeiro.getSaldo());
			throw e1;
		}
		financeiro.alterar();
	}
}
