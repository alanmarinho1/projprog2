package Negocios;

import java.util.Calendar;

public class Produtos {
	
	private String codigo;
	private String descricao;
	private int quantidade;
	private double valorvenda;
	private double valorcompra;
	private boolean disponibilidade; //se quantidade for maior que 0, o valor é true
	private Calendar diadasemana = Calendar.getInstance(); //cadastrar um dia da semana pra cada produto, pois na hora de cadastrar perguntar
	//qual o dia da semana o preço vai ser menor
	
	public Produtos(String codigo, String descricao, int quantidade, double valorvenda, double valorcompra,
			Calendar diadasemana) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorvenda = valorvenda;
		this.valorcompra = valorcompra;
		this.diadasemana = diadasemana;
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
	
	public double getValorvenda() {
		return valorvenda;
	}

	public void setValorvenda(double valorvenda) {
		this.valorvenda = valorvenda;
	}

	public double getValorcompra() {
		return valorcompra;
	}

	public void setValorcompra(double valorcompra) {
		this.valorcompra = valorcompra;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public void estoque() {
		
	//aqui trará relatorio de quantidade de produtos e o quanto tem de valor desse total
	double total = getValorvenda() * getQuantidade();
	System.out.println("--------");
	System.out.println("Quantidade em estoque: " + getQuantidade() + "\n");
	System.out.println("Valor total do produto em estoque: " + total);
	System.out.println("--------");
	}

	public Calendar getDiadasemana() {
		return diadasemana;
	}

	public void setDiadasemana(Calendar diadasemana) {
		this.diadasemana = diadasemana;
	}
	
}
