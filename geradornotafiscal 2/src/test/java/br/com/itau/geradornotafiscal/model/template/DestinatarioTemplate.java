package br.com.itau.geradornotafiscal.model.template;

import java.util.Arrays;

import br.com.itau.geradornotafiscal.model.Destinatario;
import br.com.itau.geradornotafiscal.model.RegimeTributacaoPJ;
import br.com.itau.geradornotafiscal.model.TipoPessoa;

public class DestinatarioTemplate {
	

	public Destinatario template1(){
		EnderecoTemplate enderecoTemplate = new EnderecoTemplate();
		DocumentoTemplate documentoTemplate = new DocumentoTemplate();
		Destinatario destinatario = Destinatario.builder()
				.nome("John Doe")
				.tipoPessoa(TipoPessoa.FISICA)
				.documentos(Arrays.asList(documentoTemplate.template1()))
				.enderecos(Arrays.asList(enderecoTemplate.template1())).build();
		return destinatario;
	}
	
	
	public Destinatario template2(){
		EnderecoTemplate enderecoTemplate = new EnderecoTemplate();
		DocumentoTemplate documentoTemplate = new DocumentoTemplate();
		Destinatario destinatario = Destinatario.builder()
				.nome("John Doe")
				.tipoPessoa(TipoPessoa.JURIDICA)
				.regimeTributacao(RegimeTributacaoPJ.SIMPLES_NACIONAL)
				.documentos(Arrays.asList(documentoTemplate.template2()))
				.enderecos(Arrays.asList(enderecoTemplate.template1())).build();
		return destinatario;
	}
	
	public Destinatario template3(){
		EnderecoTemplate enderecoTemplate = new EnderecoTemplate();
		DocumentoTemplate documentoTemplate = new DocumentoTemplate();
		Destinatario destinatario = Destinatario.builder()
				.nome("John Doe")
				.tipoPessoa(TipoPessoa.JURIDICA)
				.regimeTributacao(RegimeTributacaoPJ.LUCRO_REAL)
				.documentos(Arrays.asList(documentoTemplate.template2()))
				.enderecos(Arrays.asList(enderecoTemplate.template1())).build();
		return destinatario;
	}
	
	public Destinatario template4(){
		EnderecoTemplate enderecoTemplate = new EnderecoTemplate();
		DocumentoTemplate documentoTemplate = new DocumentoTemplate();
		Destinatario destinatario = Destinatario.builder()
				.nome("John Doe")
				.tipoPessoa(TipoPessoa.JURIDICA)
				.regimeTributacao(RegimeTributacaoPJ.LUCRO_PRESUMIDO)
				.documentos(Arrays.asList(documentoTemplate.template2()))
				.enderecos(Arrays.asList(enderecoTemplate.template1())).build();
		return destinatario;
	}
	

	public Destinatario template5(){
		EnderecoTemplate enderecoTemplate = new EnderecoTemplate();
		DocumentoTemplate documentoTemplate = new DocumentoTemplate();
		Destinatario destinatario = Destinatario.builder()
				.nome("John Doe")
				.tipoPessoa(TipoPessoa.FISICA)
				.documentos(Arrays.asList(documentoTemplate.template1()))
				.enderecos(Arrays.asList(enderecoTemplate.template2())).build();
		return destinatario;
	}
	
}
