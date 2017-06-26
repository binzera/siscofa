package br.gms.siscofa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.RacaGado;
import br.gms.siscofa.model.Usuario;
import br.gms.siscofa.model.repository.RacaRepository;
import br.gms.siscofa.model.service.RacaService;

@Controller
@RequestMapping("/racas")
public class RacaController {
	
	@Autowired
	private RacaRepository racaRepository;
	
	@Autowired
	private RacaService racaService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado racas() {
		return new Resultado(racaRepository.consultarTodos());
	}
	
	@RequestMapping(value="/inserir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado inserir(@RequestBody RacaGado entity) {
		return racaService.inserir(entity);
	}
}
