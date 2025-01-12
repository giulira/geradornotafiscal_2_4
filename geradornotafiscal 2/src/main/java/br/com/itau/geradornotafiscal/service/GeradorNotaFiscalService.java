package br.com.itau.geradornotafiscal.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itau.geradornotafiscal.model.Destinatario;
import br.com.itau.geradornotafiscal.model.Endereco;
import br.com.itau.geradornotafiscal.model.Finalidade;
import br.com.itau.geradornotafiscal.model.ItemNotaFiscal;
import br.com.itau.geradornotafiscal.model.NotaFiscal;
import br.com.itau.geradornotafiscal.model.Pedido;
import br.com.itau.geradornotafiscal.model.Regiao;
import br.com.itau.geradornotafiscal.model.RegimeTributacaoPJ;
import br.com.itau.geradornotafiscal.model.TipoPessoa;
import br.com.itau.geradornotafiscal.service.integracoes.EntregaService;
import br.com.itau.geradornotafiscal.service.integracoes.EstoqueService;
import br.com.itau.geradornotafiscal.service.integracoes.FinanceiroService;
import br.com.itau.geradornotafiscal.service.integracoes.RegistroService;

@Service
public class GeradorNotaFiscalService{

	public NotaFiscal gerarNotaFiscal(Pedido pedido) {

		Destinatario destinatario = pedido.getDestinatario();
		TipoPessoa tipoPessoa = destinatario.getTipoPessoa();
		List<ItemNotaFiscal> itemNotaFiscalList = new ArrayList<>();

		if (tipoPessoa == TipoPessoa.FISICA) {
		
			CalcularAliquotaBaseService calculoAliquotaBasePF = new CalcularAliquotaPessoaFisicaService();
			itemNotaFiscalList = calculoAliquotaBasePF.calcularAlicotaProduto(pedido);
			
		} else if (tipoPessoa == TipoPessoa.JURIDICA) {

			RegimeTributacaoPJ regimeTributacao = destinatario.getRegimeTributacao();

			if (regimeTributacao == RegimeTributacaoPJ.SIMPLES_NACIONAL) {
			
				CalcularAliquotaBaseService calculoAliquotaBasePJSimplesNacional = new CalcularAliquotaPJSimplesNacionalService();
				itemNotaFiscalList = calculoAliquotaBasePJSimplesNacional.calcularAlicotaProduto(pedido);
				
			} else if (regimeTributacao == RegimeTributacaoPJ.LUCRO_REAL) {
								
				CalcularAliquotaBaseService calculoAliquotaBasePJLucroReal = new CalcularAliquotaPJLucroRealService();
				itemNotaFiscalList = calculoAliquotaBasePJLucroReal.calcularAlicotaProduto(pedido);
			
			} else if (regimeTributacao == RegimeTributacaoPJ.LUCRO_PRESUMIDO) {
							
				CalcularAliquotaBaseService calculoAliquotaBasePJLucroPresumido = new CalcularAliquotaPJLucroPresumidoService();
				itemNotaFiscalList = calculoAliquotaBasePJLucroPresumido.calcularAlicotaProduto(pedido);
			}
		}
	
		Regiao regiao = buscarRegiao(pedido);
			
		BigDecimal valorFreteComPercentual = regiao.calcularFreteComPercentual(regiao, pedido);
		

		CarregarDadosNotaFiscalService emitirNotaFiscal = new CarregarDadosNotaFiscalService();
		NotaFiscal notaFiscal = emitirNotaFiscal.emitirNotaFiscal(pedido, valorFreteComPercentual, itemNotaFiscalList);
		
		new EstoqueService().enviarNotaFiscalParaBaixaEstoque(notaFiscal);
		new RegistroService().registrarNotaFiscal(notaFiscal);
		new EntregaService().agendarEntrega(notaFiscal);
		new FinanceiroService().enviarNotaFiscalParaContasReceber(notaFiscal);

		return notaFiscal;
	}
	
	private Regiao buscarRegiao(Pedido pedido) {
		Regiao regiao = pedido.getDestinatario().getEnderecos().stream()
				.filter(endereco -> endereco.getFinalidade() == Finalidade.ENTREGA || endereco.getFinalidade() == Finalidade.COBRANCA_ENTREGA)
				.map(Endereco::getRegiao)
				.findFirst()
				.orElse(null);
		
		return regiao;
	}
}