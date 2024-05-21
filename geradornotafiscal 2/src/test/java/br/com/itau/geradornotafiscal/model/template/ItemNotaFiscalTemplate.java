package br.com.itau.geradornotafiscal.model.template;

import java.math.BigDecimal;

import br.com.itau.geradornotafiscal.model.ItemNotaFiscal;

public class ItemNotaFiscalTemplate {

	public ItemNotaFiscal template1() {
		ItemNotaFiscal itemNotaFiscal = ItemNotaFiscal.builder()
				.idItem("1")
				.descricao("Teclado USB")				
				.valorUnitario(BigDecimal.valueOf(50))
				.quantidade(2).build();
		
		return itemNotaFiscal;
	}
}
