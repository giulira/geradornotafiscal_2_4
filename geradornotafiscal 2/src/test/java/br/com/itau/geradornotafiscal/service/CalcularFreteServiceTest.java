package br.com.itau.geradornotafiscal.service;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.itau.geradornotafiscal.model.Endereco;
import br.com.itau.geradornotafiscal.model.Pedido;
import br.com.itau.geradornotafiscal.model.Regiao;
import br.com.itau.geradornotafiscal.model.template.EnderecoTemplate;
import br.com.itau.geradornotafiscal.model.template.PedidoTemplate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalcularFreteServiceTest {	

    @InjectMocks
    private PedidoTemplate pedidoTemplate; 
    

    @InjectMocks
    private EnderecoTemplate enderecoTemplate;
        
    @Mock
    private Regiao regiao;
    
    @Test
    public void calculaFreteRegiaoSulWithSuccess() throws Exception {
    	List<Endereco> enderecos = new ArrayList<Endereco>();
    	enderecos.add(enderecoTemplate.template2());
    	Pedido pedido = pedidoTemplate.template1();
    	pedido.getDestinatario().setEnderecos(enderecos);
    	BigDecimal valorFrete = Regiao.SUL.calcularFreteComPercentual(Regiao.SUL, pedido);
    	assertNotNull(valorFrete);
    }

    @Test
    public void calculaFreteRegiaoSudesteWithSuccess() throws Exception {
    	List<Endereco> enderecos = new ArrayList<Endereco>();
    	enderecos.add(enderecoTemplate.template1());
    	Pedido pedido = pedidoTemplate.template1();
    	pedido.getDestinatario().setEnderecos(enderecos);
    	BigDecimal valorFrete = Regiao.SUDESTE.calcularFreteComPercentual(Regiao.SUDESTE, pedido);
    	assertNotNull(valorFrete);
    }
    
    @Test
    public void calculaFreteRegiaoNorteWithSuccess() throws Exception {
    	List<Endereco> enderecos = new ArrayList<Endereco>();
    	enderecos.add(enderecoTemplate.template4());
    	Pedido pedido = pedidoTemplate.template1();
    	pedido.getDestinatario().setEnderecos(enderecos);
    	BigDecimal valorFrete = Regiao.NORTE.calcularFreteComPercentual(Regiao.NORTE, pedido);
    	assertNotNull(valorFrete);
    }
    
    @Test
    public void calculaFreteRegiaoNordesteWithSuccess() throws Exception {
    	List<Endereco> enderecos = new ArrayList<Endereco>();
    	enderecos.add(enderecoTemplate.template3());
    	Pedido pedido = pedidoTemplate.template1();
    	pedido.getDestinatario().setEnderecos(enderecos);
    	BigDecimal valorFrete = Regiao.NORDESTE.calcularFreteComPercentual(Regiao.NORDESTE, pedido);
    	assertNotNull(valorFrete);
    }

    
    @Test
    public void calculaFreteRegiaoCentroOesteWithSuccess() throws Exception {
    	List<Endereco> enderecos = new ArrayList<Endereco>();
    	enderecos.add(enderecoTemplate.template3());
    	Pedido pedido = pedidoTemplate.template1();
    	pedido.getDestinatario().setEnderecos(enderecos);
    	BigDecimal valorFrete = Regiao.CENTRO_OESTE.calcularFreteComPercentual(Regiao.CENTRO_OESTE, pedido);
    	assertNotNull(valorFrete);
    }

}
