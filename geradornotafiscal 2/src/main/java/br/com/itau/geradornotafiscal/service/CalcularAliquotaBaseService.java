package br.com.itau.geradornotafiscal.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.itau.geradornotafiscal.model.Item;
import br.com.itau.geradornotafiscal.model.ItemNotaFiscal;
import br.com.itau.geradornotafiscal.model.Pedido;

public abstract class CalcularAliquotaBaseService {
	
	private List<ItemNotaFiscal> itemNotaFiscalList = new ArrayList<>();
	
	  public List<ItemNotaFiscal> calcularAliquota(List<Item> items, BigDecimal aliquotaPercentual) {
		  
	        for (Item item : items) {
	        	BigDecimal valorTributo = item.getValorUnitario().multiply(aliquotaPercentual);
	            ItemNotaFiscal itemNotaFiscal = ItemNotaFiscal.builder()
	                    .idItem(item.getIdItem())
	                    .descricao(item.getDescricao())
	                    .valorUnitario(item.getValorUnitario())
	                    .quantidade(item.getQuantidade())
	                    .valorTributoItem(valorTributo)
	                    .build();
	            itemNotaFiscalList.add(itemNotaFiscal);
	        }
	        return itemNotaFiscalList;
	    }

	  public abstract List<ItemNotaFiscal> calcularAlicotaProduto(Pedido pedido);
		  
	  

}
