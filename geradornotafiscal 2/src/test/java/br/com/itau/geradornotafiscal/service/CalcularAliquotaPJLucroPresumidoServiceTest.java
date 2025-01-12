package br.com.itau.geradornotafiscal.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.itau.geradornotafiscal.model.ItemNotaFiscal;
import br.com.itau.geradornotafiscal.model.Pedido;
import br.com.itau.geradornotafiscal.model.template.PedidoTemplate;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalcularAliquotaPJLucroPresumidoServiceTest {	
	@InjectMocks
	private CalcularAliquotaPJLucroPresumidoService calcularAliquotaPJLucroPresumidoService;
	
	@InjectMocks
	private PedidoTemplate pedidoTemplate;
	
	
	@Test
	public void shouldCalcularAliquotaBasePessoaJuridicaLucroPresumido() throws Exception {
		Pedido pedido = pedidoTemplate.template5();
		List<ItemNotaFiscal> itemNotaFiscalList = calcularAliquotaPJLucroPresumidoService
				.calcularAliquota(pedido.getItens(), BigDecimal.valueOf(300));
		assertFalse(itemNotaFiscalList.isEmpty());
		assertNotNull(itemNotaFiscalList.get(0).getValorTributoItem());

		
	}


}
