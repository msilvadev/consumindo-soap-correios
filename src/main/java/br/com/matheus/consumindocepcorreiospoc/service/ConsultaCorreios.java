package br.com.matheus.consumindocepcorreiospoc.service;

import org.springframework.stereotype.Service;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteServiceLocator;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

@Service
public class ConsultaCorreios {
		
	public EnderecoERP consultaCEP(String cep) {
		try {
			AtendeClienteService service = new AtendeClienteServiceLocator();
			AtendeCliente port = service.getAtendeClientePort();
			EnderecoERP result = port.consultaCEP(cep);
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}
