package br.com.matheus.consumindocepcorreiospoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.matheus.consumindocepcorreiospoc.service.ConsultaCorreios;

@RestController
@RequestMapping("/consuta-cep")
public class ConsultaController {
	
	@Autowired
	ConsultaCorreios consultaCorreiosWS;
	
	@GetMapping
	public ResponseEntity<EnderecoERP> consultaCEP(@RequestParam String cep) {
		EnderecoERP endereco = consultaCorreiosWS.consultaCEP(cep);
		return !StringUtils.isEmpty(endereco) ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
	}
}
