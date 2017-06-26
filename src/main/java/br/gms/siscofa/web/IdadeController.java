package br.gms.siscofa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.repository.IdadeRepository;

@Controller
@RequestMapping("/idades")
public class IdadeController {
	
	@Autowired
	private IdadeRepository idadeRepository;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado fazendas() {
		return new Resultado(idadeRepository.consultarTodos());
	}

}
