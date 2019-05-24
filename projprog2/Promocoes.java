package Negocios;

import java.util.Calendar;

public class Promocoes {

	private double desconto;
	private Cliente cliente;
	private Produtos produto;
	
	public Promocoes(double desconto, Cliente cliente) {
		super();
		this.desconto = desconto;
		this.cliente = cliente;
	}

	public Promocoes() {}
	
	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	public double promoDia (Produtos produto) {
		Calendar data = Calendar.getInstance();
		if (produto.getDiadasemana().DAY_OF_WEEK == data.get(Calendar.DAY_OF_WEEK)) {
			//definir cada produto com um dia da semana e fazer o calculo do valor que vai retornar como desconto
		}
		
		return valor;
	}
	
	public double promoAniv (Cliente cliente, Produtos produto) {
		Calendar data = Calendar.getInstance();
		
		return valor;
	}
	
}
