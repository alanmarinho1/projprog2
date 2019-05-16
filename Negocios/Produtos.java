package Negocios;

import java.util.Calendar;

public class Produtos {
	
	private int codigo;
	private String descricao;
	private int quantidade;
	private double valor;
	private Calendar diadasemana;
	
	
	public Produtos(int codigo, String descricao, int quantidade, double valor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public Produtos() {}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDiadasemana() {
		return diadasemana;
	}

	public void setDiadasemana(Calendar diadasemana) {
		this.diadasemana = diadasemana;
	}

	public void estoque() {
		
	//aqui trará relatorio de quantidade de produtos e o quanto tem de valor desse total
	double total = getValor() * getQuantidade();
	System.out.println("--------");
	System.out.println("Quantidade em estoque: " + getQuantidade() + "\n");
	System.out.println("Valor total do produto em estoque: " + total);
	System.out.println("--------");
	}
	
}
