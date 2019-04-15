
public class Pedido {

	private Funcionario funcionario;
	private Cliente cliente;
	private Produtos produto;
	private Promocoes promocao;
	private double total;
	
	public Pedido(Funcionario funcionario, Cliente cliente, Produtos produto, Promocoes promocao, double total) {
		super();
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.produto = produto;
		this.promocao = promocao;
		this.total = total;
	}
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
	public Promocoes getPromocao() {
		return promocao;
	}
	public void setPromocao(Promocoes promocao) {
		this.promocao = promocao;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
