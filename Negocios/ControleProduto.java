package Negocios;

import Dados.RepositorioVeiculo;
import Dados.RepositorioVeiculoBD;



public class ControleProduto {

	RepositorioProduto produtos = new RepositorioProdutoBD();
	
	//fazer a regra de negocio pra produtos depois
	
	public void cadastrar(Produto produto) throws InserirException {
		if ((veiculo).getChassi().length() != 17 || (veiculo).getChassi().equals("")) {
			InserirException e;
			e = new InserirException((veiculo).getChassi());
			throw e;
        }
		
					veiculos.inserir(veiculo);
					
		}	
	
	public void alterar(Veiculo veiculo) throws InserirException {
		if ((veiculo).getChassi().length() != 17 || (veiculo).getChassi().equals("")) {
			InserirException e;
			e = new InserirException((veiculo).getChassi());
			throw e;
        }
			
					veiculos.alterar(veiculo);
		}
     
	public Veiculo procurar(String chassi) throws NaoLocalizadoVeiculoException{
		if (veiculos.procurar(chassi).getCodVeiculo() == null) {
			throw new NaoLocalizadoVeiculoException(chassi);
		}else {
			
		return veiculos.procurar(chassi);
		
		}
	}
	
	public void remover(String codVeiculo) {
		veiculos.remover(codVeiculo);
	}

	public void listar() {
		veiculos.listar();
		
	}
	
}
	
	
