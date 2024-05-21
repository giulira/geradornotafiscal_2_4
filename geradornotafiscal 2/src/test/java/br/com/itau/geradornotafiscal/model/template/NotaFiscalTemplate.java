package br.com.itau.geradornotafiscal.model.template;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

import br.com.itau.geradornotafiscal.model.NotaFiscal;

public class NotaFiscalTemplate {
	
	public NotaFiscal template1() {
		ItemNotaFiscalTemplate itemNotaFiscalTemplate = new ItemNotaFiscalTemplate();
		DestinatarioTemplate destinatarioTemplate = new DestinatarioTemplate();
		NotaFiscal notaFiscal = NotaFiscal.builder()
				.data(LocalDateTime.now())
				.idNotaFiscal(UUID.randomUUID().toString())
				.valorFrete(BigDecimal.valueOf(300))
				.valorTotalItens(BigDecimal.valueOf(300))
				.itens(Arrays.asList(itemNotaFiscalTemplate.template1()))
				.destinatario(destinatarioTemplate.template1())
				.build();
		
		return notaFiscal;
	}

}

