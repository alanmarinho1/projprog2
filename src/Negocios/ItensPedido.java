package Negocios;

public class ItensPedido {
	
	private Produtos produto;
	private Pedido pedido;
	private int quantidadeitens;
	private double valortotalitem;
	
	public ItensPedido() {
		
	}
	public Produtos getProduto() {
		return produto;
	}
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public int getQuantidadeitens() {
		return quantidadeitens;
	}
	public void setQuantidadeitens(int quantidadeitens) {
		this.quantidadeitens = quantidadeitens;
	}
	public double getValortotalitem() {
		return valortotalitem;
	}
	public void setValortotalitem(double valortotalitem) {
		this.valortotalitem = valortotalitem;
	}
	
	
	
}
