import java.util.Calendar;

public class Programa {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Alan", "123123123", "rua tal", "123123" , "alan@alan.com", "32224242", "15/06/1991");
		Funcionario funcionario = new Funcionario("Alan", "123123123", "rua tal", "Vendedor", 1200, 0.03);
		Produtos produto = new Produtos("hamburguer", 1, 15);
		Promocoes promocao = new Promocoes(0.01, cliente);
		Pedido pedido = new Pedido(funcionario, cliente, produto, promocao, 13);
		

	}

}
