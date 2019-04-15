
public class Produtos {
	
	private String descricao;
	private int quantidade;
	private double valor;
	
	public Produtos(String descricao, int quantidade, double valor) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}
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
	
	public void estoque() {
		//aqui trará relatorio de quantidade de produtos e o quanto tem de valor desse total
	}
	
}
