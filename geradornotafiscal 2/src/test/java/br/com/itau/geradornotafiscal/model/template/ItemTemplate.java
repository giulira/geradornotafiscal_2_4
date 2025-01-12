package br.com.itau.geradornotafiscal.model.template;

import java.math.BigDecimal;

import br.com.itau.geradornotafiscal.model.Item;


public class ItemTemplate {

	public Item template1() {
		Item item = Item.builder()
				.idItem("1")
				.descricao("Teclado USB")				
				.valorUnitario(BigDecimal.valueOf(50))
				.quantidade(2).build();
		return item;
	}
	
		
	public Item template2() {
		Item item = Item.builder()
				.idItem("2")
				.descricao("Mouse USB")				
				.valorUnitario(BigDecimal.valueOf(150))
				.quantidade(5).build();
		return item;
	}
	
	public Item template3() {
		Item item = Item.builder()
				.idItem("3")
				.descricao("TV Samsung")				
				.valorUnitario(BigDecimal.valueOf(150))
				.quantidade(5).build();
		return item;
	}
	
	public Item template4() {
		Item item = Item.builder()
				.idItem("4")
				.descricao("Microondas brastemp")				
				.valorUnitario(BigDecimal.valueOf(750))
				.quantidade(1).build();
		return item;
	}
		
	public Item template5() {
		Item item = Item.builder()
				.idItem("5")
				.descricao("Liquidificador brastemp")				
				.valorUnitario(BigDecimal.valueOf(150))
				.quantidade(1).build();
		return item;
	}
	
	public Item template6() {
		Item item = Item.builder()
				.idItem("6")
				.descricao("Fogao Consul")				
				.valorUnitario(BigDecimal.valueOf(150))
				.quantidade(1).build();
		return item;
	}
	
}
