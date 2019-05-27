package Negocios;

import java.util.Calendar;

public class Compra {

	private Produtos produto;
	private Funcionario funcionario;
	private Financeiro caixa;
	private int numeroitens;
	private String Codigo;
	private Calendar datacompra = Calendar.getInstance();
	private double total;
		
	
	public Compra(Produtos produto, Funcionario funcionario,Financeiro caixa, double total) {
		super();
		this.produto = produto;
		this.funcionario = funcionario;
		this.caixa = caixa;
		this.total = total;
	}
	public Compra() {
		
	}
	public Produtos getProduto() {
		return produto;
	}
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
		
	public Financeiro getCaixa() {
		return caixa;
	}
	public void setCaixa(Financeiro caixa) {
		this.caixa = caixa;
	}

	public Calendar getDatacompra() {
		return datacompra;
	}
	public void setDatacompra(Calendar datacompra) {
		this.datacompra = datacompra;
	}
	
	public int getNumeroitens() {
		return numeroitens;
	}
	public void setNumeroitens(int numeroitens) {
		this.numeroitens = numeroitens;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public void realizarCompra() {
		
		//aqui posso realizar compras de um ou mais produtos debitando do saldo total do meu caixa
		caixa.debitar(getTotal());
	}
}
