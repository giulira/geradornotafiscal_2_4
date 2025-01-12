package br.com.itau.geradornotafiscal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.geradornotafiscal.model.NotaFiscal;
import br.com.itau.geradornotafiscal.model.Pedido;
import br.com.itau.geradornotafiscal.service.GeradorNotaFiscalService;

@RestController
@RequestMapping("/api/pedido")
public class GeradorNFController {

	@Autowired
	private GeradorNotaFiscalService notaFiscalService;

	@PostMapping("/gerarNotaFiscal")
	public ResponseEntity<NotaFiscal> gerarNotaFiscal(@RequestBody Pedido pedido) {
		
		String mensagem = "Nota fiscal gerada com sucesso para o pedido: " + pedido.getIdPedido();
		NotaFiscal notaFiscal = notaFiscalService.gerarNotaFiscal(pedido);
		return new ResponseEntity<>(notaFiscal, HttpStatus.OK);
	}
	
}
