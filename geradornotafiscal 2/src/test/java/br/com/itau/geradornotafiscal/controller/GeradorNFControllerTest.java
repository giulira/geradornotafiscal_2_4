package br.com.itau.geradornotafiscal.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itau.geradornotafiscal.model.template.NotaFiscalTemplate;
import br.com.itau.geradornotafiscal.model.template.PedidoTemplate;
import br.com.itau.geradornotafiscal.web.controller.GeradorNFController;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class GeradorNFControllerTest {	
    
	@InjectMocks
	private GeradorNFController controller;
	
	@InjectMocks
	private NotaFiscalTemplate notaFiscalTemplate;
	
	@InjectMocks
    private PedidoTemplate pedidoTemplate; 
    
	@Autowired
	private MockMvc mock;

	@Test
	public void gerarNotaFiscalWithSuccess() throws Exception {
		mock.perform(post("/api/pedido/gerarNotaFiscal")
				.content(asJsonString(pedidoTemplate.template1()))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(status().is2xxSuccessful());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}

