package Negocios;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Scanner n = new Scanner(System.in);
		Cliente cliente = new Cliente();
		DateFormat f = DateFormat.getDateInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		sdf.format(cliente.getNascimento().getTime());
		System.out.println("Nome: ");
		cliente.setNome(n.nextLine());
		
		System.out.println("Nascimento: ");
				
		try {
			cliente.getNascimento().setTime(f.parse(n.nextLine()));
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			Fachada.getInstance().cadastrarCliente(cliente);
		} catch (InserirException | PessoaJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Fachada.getInstance().listarCliente();
/*		Pessoa funcionario = new Funcionario("Alan", "123123123", "rua tal", "Vendedor", 1200, 0.03);
		Produtos produto1 = new Produtos(1, "hamburguer", 3, 15);
		Produtos produto2 = new Produtos(2, "cachorro quente", 4, 20);
		Produtos produto3 = new Produtos(3, "guaraná", 5, 30.5);

		Pedido pedido = new Pedido(funcionario, cliente, produto1, promocao1, caixa, 13);
	*/	

	}

}
