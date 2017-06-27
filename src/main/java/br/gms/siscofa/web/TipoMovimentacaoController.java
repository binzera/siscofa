package br.gms.siscofa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.repository.TipoMovimentacaoRepository;

@Controller
@RequestMapping("/tipomov")
public class TipoMovimentacaoController {
	
	@Autowired
	private TipoMovimentacaoRepository repository;
	
	@RequestMapping(value="/listar" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado listar() {
		return new Resultado(repository.consultarTodos());
	}

}
