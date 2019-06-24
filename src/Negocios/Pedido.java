package Negocios;

import java.util.ArrayList;
import java.util.Calendar;

public class Pedido {

	private String codigo;
	private Funcionario funcionario;
	private Cliente cliente;
	private Produtos produto;
	private int numeroitens;
	private Calendar data = Calendar.getInstance();
	private double total;
	
	
	public Pedido() {}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	public int getNumeroitens() {
		return numeroitens;
	}

	public void setNumeroitens(int numeroitens) {
		this.numeroitens = numeroitens;
	}

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public double promoDia (Produtos produto) {
		Calendar data = Calendar.getInstance();
		if (produto.getDiadasemana().DAY_OF_WEEK == data.get(Calendar.DAY_OF_WEEK)) {
			//definir cada produto com um dia da semana e fazer o calculo do valor que vai retornar como desconto
		}
		
		return produto.getValorvenda() * 0.2;
	}
	
	public double promoAniv (Cliente cliente, Produtos produto) {
		Calendar data = Calendar.getInstance();
		
		return produto.getValorcompra() * 0.5;
	}

	public void PedidoRealizado() {
		funcionario.setComissao(getTotal() * 0.2);
		Financeiro.creditar(getTotal());
	}
	
}
