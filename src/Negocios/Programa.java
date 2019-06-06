package Negocios;
import java.util.Calendar;

public class Programa {

	public static void main(String[] args) {
		
		Financeiro caixa = new Financeiro();
		caixa.creditar(300);
		Fachada.getInstance().alterarFinanceiro(caixa);
//		Cliente cliente = new Cliente();
/*		Funcionario funcionario = new Funcionario("Alan", "123123123", "rua tal", "Vendedor", 1200, 0.03);
		Produtos produto1 = new Produtos(1, "hamburguer", 3, 15);
		Produtos produto2 = new Produtos(2, "cachorro quente", 4, 20);
		Produtos produto3 = new Produtos(3, "guaraná", 5, 30.5);

		Pedido pedido = new Pedido(funcionario, cliente, produto1, promocao1, caixa, 13);
	*/	

	}

}
