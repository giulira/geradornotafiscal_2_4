package br.com.itau.geradornotafiscal.model.template;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import br.com.itau.geradornotafiscal.model.Pedido;


public class PedidoTemplate {
	
	public Pedido template1() {

		DestinatarioTemplate destinatario = new DestinatarioTemplate();
		ItemTemplate item = new ItemTemplate();
		
		Pedido pedido = Pedido.builder()
				.idPedido(1)
				//.data(LocalDate.now())
				.valorFrete(BigDecimal.valueOf(400))
				.valorTotalItens(BigDecimal.valueOf(100)).build();
		
		pedido.setDestinatario(destinatario.template1());
		pedido.setItens(Arrays.asList(item.template1()));
		
		return pedido;
	}

	public Pedido template2() {

		DestinatarioTemplate destinatario = new DestinatarioTemplate();
		ItemTemplate item = new ItemTemplate();
		
		Pedido pedido = Pedido.builder()
				.idPedido(1)
				.data(LocalDate.now())
				.valorFrete(BigDecimal.valueOf(400))
				.valorTotalItens(BigDecimal.valueOf(100)).build();
		
		pedido.setDestinatario(destinatario.template1());
		
		pedido.setItens(Arrays.asList(item.template1(), 
				item.template2(), 
				item.template3(), 
				item.template4(), 
				item.template5(), 
				item.template6()));
		
		return pedido;
	}

	public Pedido template3() {

		DestinatarioTemplate destinatario = new DestinatarioTemplate();
		ItemTemplate item = new ItemTemplate();
		
		Pedido pedido = Pedido.builder()
				.idPedido(1)
				.data(LocalDate.now())
				.valorFrete(BigDecimal.valueOf(400))
				.valorTotalItens(BigDecimal.valueOf(100)).build();
		
		pedido.setDestinatario(destinatario.template2());
		
		pedido.setItens(Arrays.asList(item.template1()));
		
		return pedido;
	}
	
	public Pedido template4() {

		DestinatarioTemplate destinatario = new DestinatarioTemplate();
		ItemTemplate item = new ItemTemplate();
		
		Pedido pedido = Pedido.builder()
				.idPedido(1)
				.data(LocalDate.now())
				.valorFrete(BigDecimal.valueOf(400))
				.valorTotalItens(BigDecimal.valueOf(100)).build();
		
		pedido.setDestinatario(destinatario.template3());
		
		pedido.setItens(Arrays.asList(item.template1()));
		
		return pedido;
	}
	
	public Pedido template5() {

		DestinatarioTemplate destinatario = new DestinatarioTemplate();
		ItemTemplate item = new ItemTemplate();
		
		Pedido pedido = Pedido.builder()
				.idPedido(1)
				.data(LocalDate.now())
				.valorFrete(BigDecimal.valueOf(400))
				.valorTotalItens(BigDecimal.valueOf(100)).build();
		
		pedido.setDestinatario(destinatario.template4());
		
		pedido.setItens(Arrays.asList(item.template1()));
		
		return pedido;
	}
	
	
	public Pedido template6() {

		DestinatarioTemplate destinatario = new DestinatarioTemplate();
		ItemTemplate item = new ItemTemplate();
		
		Pedido pedido = Pedido.builder().valorFrete(BigDecimal.valueOf(400))
				.valorTotalItens(BigDecimal.valueOf(100)).build();
		
		pedido.setDestinatario(destinatario.template3());
		pedido.setItens(Arrays.asList(item.template1()));
		
		return pedido;
	}

	public Pedido template7() {
//sudeste
		DestinatarioTemplate destinatario = new DestinatarioTemplate();
		ItemTemplate item = new ItemTemplate();
		
		Pedido pedido = Pedido.builder()
				.idPedido(1)
				.data(LocalDate.now())
				.valorFrete(BigDecimal.valueOf(400))
				.valorTotalItens(BigDecimal.valueOf(100)).build();
		
		pedido.setDestinatario(destinatario.template1());
		pedido.setItens(Arrays.asList(item.template1()));
		
		return pedido;
	}


}
