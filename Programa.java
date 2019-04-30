import java.util.Calendar;

public class Programa {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Alan", "123123123", "rua tal", "123123" , "alan@alan.com", "32224242", "15/06/1991");
		Funcionario funcionario = new Funcionario("Alan", "123123123", "rua tal", "Vendedor", 1200, 0.03);
		Produtos produto1 = new Produtos(1, "hamburguer", 3, 15);
		Produtos produto2 = new Produtos(2, "cachorro quente", 4, 20);
		Produtos produto3 = new Produtos(3, "guaraná", 5, 30.5);
		Promocoes promocao1 = new Promocoes(0.01, cliente);
		Promocoes promocao2 = new Promocoes(0.10, cliente);
		Financeiro caixa = new Financeiro();
		Pedido pedido = new Pedido(funcionario, cliente, produto1, promocao1, caixa, 13);
		

	}

}
