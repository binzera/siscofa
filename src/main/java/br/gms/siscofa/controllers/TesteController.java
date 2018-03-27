package br.gms.siscofa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gms.siscofa.models.Maquina;
import br.gms.siscofa.models.Resultado;

@Controller
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private RestTemplate restTemplate;
	
	protected ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected List<Maquina> listar() {
			
		String url = "http://localhost:8080/siscofa/maquina/listar";
		 
		//ResponseEntity<? extends ArrayList<Maquina>> resultado = 
		//		restTemplate.getForEntity(url, (Class<? extends ArrayList<Maquina>>)ArrayList.class);
		
		Resultado resultado = this.restTemplate.getForObject(url, Resultado.class);
		
		TypeReference<List<Maquina>> type = new TypeReference<List<Maquina>>() {};
		
		List<Maquina> teste = mapper.convertValue(resultado.getDados(), type);
		
		return teste;
	}
}
