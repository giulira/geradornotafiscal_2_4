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
import br.com.itau.geradornotafiscal.model.Pedido;
import br.com.itau.geradornotafiscal.model.template.NotaFiscalTemplate;
import br.com.itau.geradornotafiscal.model.template.PedidoTemplate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GeradorNotaFiscalServiceTest {

    @InjectMocks
    private GeradorNotaFiscalService geradorNotaFiscalService;
    
    @InjectMocks
    private PedidoTemplate pedidoTemplate; 
 
   @Test
    public void shouldGenerateNotaFiscalForTipoPessoaFisica() throws Exception {
       pedidoTemplate = new PedidoTemplate();
       Pedido pedido  = pedidoTemplate.template1();

        NotaFiscal notaFiscal = geradorNotaFiscalService.gerarNotaFiscal(pedido);

        assertEquals(pedido.getValorTotalItens(), notaFiscal.getValorTotalItens());
        assertNotNull(notaFiscal);
        assertEquals(pedido.getItens().size(), notaFiscal.getItens().size());     
    }
   
   @Test
   public void shouldGenerateNotaFiscalForTipoPessoaFisicaWithMoreThan5Item() throws Exception {
      pedidoTemplate = new PedidoTemplate();
      Pedido pedido  = pedidoTemplate.template2();

       NotaFiscal notaFiscal = geradorNotaFiscalService.gerarNotaFiscal(pedido);

       assertEquals(pedido.getValorTotalItens(), notaFiscal.getValorTotalItens());
       assertNotNull(notaFiscal);
       assertEquals(pedido.getItens().size(), notaFiscal.getItens().size());     
   }

   @Test
   public void shouldGenerateNotaFiscalForTipoPessoaJuridicaSimplesNacional() throws Exception {
      pedidoTemplate = new PedidoTemplate();
      Pedido pedido  = pedidoTemplate.template3();

       NotaFiscal notaFiscal = geradorNotaFiscalService.gerarNotaFiscal(pedido);

       assertEquals(pedido.getValorTotalItens(), notaFiscal.getValorTotalItens());
       assertNotNull(notaFiscal);
       assertEquals(pedido.getItens().size(), notaFiscal.getItens().size());     
   }
   
   @Test
   public void shouldGenerateNotaFiscalForTipoPessoaJuridicaLucroReal() throws Exception {
      pedidoTemplate = new PedidoTemplate();
      Pedido pedido  = pedidoTemplate.template4();

       NotaFiscal notaFiscal = geradorNotaFiscalService.gerarNotaFiscal(pedido);

       assertEquals(pedido.getValorTotalItens(), notaFiscal.getValorTotalItens());
       assertNotNull(notaFiscal);
       assertEquals(pedido.getItens().size(), notaFiscal.getItens().size());     
   }
   
   @Test
   public void shouldGenerateNotaFiscalForTipoPessoaJuridicaLucroResumido() throws Exception {
      pedidoTemplate = new PedidoTemplate();
      Pedido pedido  = pedidoTemplate.template5();

       NotaFiscal notaFiscal = geradorNotaFiscalService.gerarNotaFiscal(pedido);

       assertEquals(pedido.getValorTotalItens(), notaFiscal.getValorTotalItens());
       assertNotNull(notaFiscal);
       assertEquals(pedido.getItens().size(), notaFiscal.getItens().size());     
   }
   
}