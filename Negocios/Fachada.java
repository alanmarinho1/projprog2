package Negocios;


import Negocios.Pessoa;
import Negocios.Proposta;
import Negocios.Veiculo;

public class Fachada {
	
	private ControleFuncionarios funcionarios;
	private ControlePessoaFisica pessoafisica;
	private ControlePessoaJuridica pessoajuridica;
	private ControleProposta propostas;
	private ControleVeiculo veiculos;
	private static Fachada instance;
	
	public Fachada() {
	
	funcionarios = new ControleFuncionarios();
	pessoafisica = new ControlePessoaFisica();
	pessoajuridica = new ControlePessoaJuridica();
	propostas = new ControleProposta();
	veiculos = new ControleVeiculo();
	
	}
	
	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	public void cadastrarFuncionario(Pessoa pessoa) throws InserirException {
		funcionarios.cadastrar(pessoa);
	}
	
	public void alterarFuncionario(Pessoa pessoa) throws InserirException{
		funcionarios.alterar(pessoa);
    }
	
	public Pessoa procurarFuncionario(String cpf) throws NaoLocalizadaPessoaException {
		return funcionarios.procurar(cpf);
	}
	
	public void removerFuncionario(String codigo) {
		funcionarios.remover(codigo);
	}
	
	
	public void cadastrarPessoaFisica(Pessoa pessoa) throws InserirException{
		pessoafisica.cadastrar((PessoaFisica) pessoa);
	}
	
	public void alterarPessoaFisica(Pessoa pessoa) throws InserirException{
		pessoafisica.alterar((PessoaFisica) pessoa);
    }
	
	public Pessoa procurarPessoaFisica(String cpf) throws NaoLocalizadaPessoaException{
		 return pessoafisica.procurar(cpf);
	}
	
	public void removerPessoaFisica(String id) {
		pessoafisica.remover(id);
	}
	
	public void cadastrarPessoaJuridica(Pessoa pessoa) throws InserirException {
		pessoajuridica.cadastrar(pessoa);
	}
	
	public void alterarPessoaJuridica(Pessoa pessoa) throws InserirException{
		pessoajuridica.alterar(pessoa);
    }
	
	public Pessoa procurarPessoaJuridica(String cnpj) throws NaoLocalizadaPessoaException{
		return pessoajuridica.procurar(cnpj);
	}
	
	public void removerPessoaJuridica(String cnpj) {
		pessoajuridica.remover(cnpj);
	}
	
	public void cadastrarProposta(Proposta proposta) throws PropostaException{
		propostas.cadastrar(proposta);
	}
	
	public void alterarProposta(Proposta proposta) throws PropostaException {
		propostas.alterar(proposta);
    }
	
	public Proposta procurarProposta(String codProposta) throws NaoLocalizadoPropostaException{
		return propostas.procurar(codProposta);
	}
	
	public void removerProposta(String codProposta) {
		propostas.remover(codProposta);
	}
	
	
	
	public void cadastrarVeiculo(Veiculo veiculo) throws InserirException{
		veiculos.cadastrar(veiculo);
	}
	
	public void alterarVeiculo(Veiculo veiculo) throws InserirException{
		veiculos.alterar(veiculo);
    }
     
	public Veiculo procurarVeiculo(String chassi) throws NaoLocalizadoVeiculoException{
		return veiculos.procurar(chassi);
	}
	
	public void removerVeiculo(String chassi) {
		veiculos.remover(chassi);
	}
	
	
	
}
