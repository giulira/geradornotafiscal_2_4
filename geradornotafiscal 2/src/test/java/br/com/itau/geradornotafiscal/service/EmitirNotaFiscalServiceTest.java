package br.com.itau.geradornotafiscal.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.itau.geradornotafiscal.model.NotaFiscal;
import br.com.itau.geradornotafiscal.model.template.NotaFiscalTemplate;
import br.com.itau.geradornotafiscal.model.template.PedidoTemplate;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EmitirNotaFiscalServiceTest {
	
	@InjectMocks
	private CarregarDadosNotaFiscalService emitirNotaFiscalService;	

    @InjectMocks
    private PedidoTemplate pedidoTemplate; 
    
    @InjectMocks
    private NotaFiscalTemplate notaFiscalTemplate;
    	
	 @Test
	 public void shouldEmitirNotaFiscalWithSuccess() throws Exception {
		 NotaFiscal notaFiscal = emitirNotaFiscalService.emitirNotaFiscal(
				 pedidoTemplate.template1(), 
				 notaFiscalTemplate.template1().getValorFrete(), 
				 notaFiscalTemplate.template1().getItens());
		 assertNotNull(notaFiscal);
		assertEquals(notaFiscal.getItens().size(), notaFiscalTemplate.template1().getItens().size());
	 }


}
