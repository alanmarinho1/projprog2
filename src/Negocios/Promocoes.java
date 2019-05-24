package Negocios;

import java.util.Calendar;

public class Promocoes {

	private double desconto;
	private String descricao;
	private Cliente cliente;
	private Produtos produto;
	
	public Promocoes() {}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Produtos getProduto() {
		return produto;
	}



	public void setProduto(Produtos produto) {
		this.produto = produto;
	}



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
