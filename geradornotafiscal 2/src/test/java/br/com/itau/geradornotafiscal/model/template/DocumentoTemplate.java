package br.com.itau.geradornotafiscal.model.template;

import br.com.itau.geradornotafiscal.model.Documento;
import br.com.itau.geradornotafiscal.model.TipoDocumento;

public class DocumentoTemplate {
	
	public Documento template1() {
		return Documento.builder()
				.numero("88740347095")
				.tipo(TipoDocumento.CPF)
				.build();
	}
	
	public Documento template2() {
		return Documento.builder()
				.numero("49695613000180")
				.tipo(TipoDocumento.CNPJ)
				.build();
	}

}
