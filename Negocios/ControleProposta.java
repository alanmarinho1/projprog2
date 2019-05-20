package Negocios;


import Dados.RepositorioProposta;
import Dados.RepositorioPropostaBD;

public class ControleProposta {
	
	RepositorioProposta propostas = new RepositorioPropostaBD();
    
	public void cadastrar(Proposta proposta) throws PropostaException {
		
		if(proposta.getFuncionario() == null) {
			PropostaException e1;
			e1 = new PropostaException(proposta.getFuncionario());
			throw e1;
		}
		
        if (proposta.getCliente() == null){
        	PropostaException e2;
        	e2 = new PropostaException(proposta.getCliente());
			throw e2;
        }
        if (proposta.getVeiculo() == null){
        	PropostaException e3;
        	e3 = new PropostaException(proposta.getVeiculo());
			throw e3;
        }
		propostas.inserir(proposta);
	}
     
	public void alterar(Proposta proposta) throws PropostaException {
		if(proposta.getFuncionario() == null) {
			PropostaException e1;
			e1 = new PropostaException(proposta.getFuncionario());
			throw e1;
		}
		
        if (proposta.getCliente() == null){
        	PropostaException e2;
        	e2 = new PropostaException(proposta.getCliente());
			throw e2;
        }
        if (proposta.getVeiculo() == null){
        	PropostaException e3;
        	e3 = new PropostaException(proposta.getVeiculo());
			throw e3;
        }
		propostas.alterar(proposta);
    }
     
	public Proposta procurar(String codProposta) throws NaoLocalizadoPropostaException{
		if (propostas.procurar(codProposta).getCodProposta() == null) {
			throw new NaoLocalizadoPropostaException(codProposta);
		}else {
			
		return propostas.procurar(codProposta);
		}
	}
	
	public void remover(String codProposta) {
		propostas.remover(codProposta);
	}
	public void listar() {
		propostas.listar();
	}
}
