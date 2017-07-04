package br.gms.siscofa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.Fazenda;
import br.gms.siscofa.model.Usuario;
import br.gms.siscofa.model.service.FazendaService;

@Controller
@RequestMapping("/fazendas")
public class FazendaController {

	@Autowired
	private FazendaService fazendaService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado fazendas() {
		return new Resultado(fazendaService.consultarTodos());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado porId(@PathVariable Integer id) {
		return new Resultado(fazendaService.consultarPorId(id));
	}
	
	@RequestMapping(value="/cadastrarFazenda" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@Transactional
	public Resultado cadastrarFazenda(@RequestBody Fazenda entity) {
		return fazendaService.cadastrarFazenda(entity);
	}
	
	@RequestMapping(value="/fazendasOfUser" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado getFazendasUser(Usuario user) {
		return new Resultado(fazendaService.getFazendasUsuario(user));
	}
}
