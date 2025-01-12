package br.com.itau.geradornotafiscal.model.template;

import br.com.itau.geradornotafiscal.model.Endereco;
import br.com.itau.geradornotafiscal.model.Finalidade;
import br.com.itau.geradornotafiscal.model.Regiao;

public class EnderecoTemplate {

	
	public Endereco template1() {
		Endereco endereco =  Endereco.builder()
				.finalidade(Finalidade.ENTREGA)
				.regiao(Regiao.SUDESTE)
				.logradouro("Av do estado")
				.numero("5533")
				.estado("SP")
				.complemento("4 anndar b")
				.cep("03105003")				
				.build();
		
		return endereco;
		
	}
	
	public Endereco template2() {
		Endereco endereco =  Endereco.builder()
				.finalidade(Finalidade.ENTREGA)
				.regiao(Regiao.SUL)
				.logradouro("Av do estado")
				.numero("5533")
				.estado("SP")
				.complemento("4 anndar b")
				.cep("03105003")				
				.build();
		
		return endereco;
		
	}
	
	public Endereco template3() {
		Endereco endereco =  Endereco.builder()
				.finalidade(Finalidade.ENTREGA)
				.regiao(Regiao.NORDESTE)
				.logradouro("Av do estado")
				.numero("5533")
				.estado("SP")
				.complemento("4 anndar b")
				.cep("03105003")				
				.build();
		
		return endereco;
		
	}
	
	public Endereco template4() {
		Endereco endereco =  Endereco.builder()
				.finalidade(Finalidade.ENTREGA)
				.regiao(Regiao.NORTE)
				.logradouro("Av do estado")
				.numero("5533")
				.estado("SP")
				.complemento("4 anndar b")
				.cep("03105003")				
				.build();
		
		return endereco;
		
	}
	
	public Endereco template5() {
		Endereco endereco =  Endereco.builder()
				.finalidade(Finalidade.ENTREGA)
				.regiao(Regiao.CENTRO_OESTE)
				.logradouro("Av do estado")
				.numero("5533")
				.estado("SP")
				.complemento("4 anndar b")
				.cep("03105003")				
				.build();
		
		return endereco;
		
	}

}
