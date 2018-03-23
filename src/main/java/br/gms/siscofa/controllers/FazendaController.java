package br.gms.siscofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.daos.FazendaDAO;
import br.gms.siscofa.models.Fazenda;
import br.gms.siscofa.models.Resultado;
import br.gms.siscofa.models.Usuario;


@Controller
@RequestMapping("/fazenda")
public class FazendaController {
	
	@Autowired
	private FazendaDAO dao;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado listar() {
		return new Resultado(dao.list());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado porId(@PathVariable Integer id) {
		try {
			return new Resultado(dao.consultarPorId(id));
		} catch (Exception e) {
			return new Resultado(null, e.getMessage());
		}
	}
	
	@RequestMapping(value="/incluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado cadastrar(@RequestBody Fazenda fazenda) {
		return new Resultado((Object) dao.incluir(fazenda));
	}
	
	@RequestMapping(value="/excluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado excluir(@RequestBody Fazenda fazenda) {
		try {
			dao.excluir(fazenda);
			return new Resultado(null, "Fazenda excluída com sucesso");
		} catch (Exception e) {
			Resultado resultado = new Resultado(null, "Erro ao exluir fazenda. detalhes: " + e.getMessage());
			resultado.setSucesso(false);
			return resultado;
		}
	}
	
	@RequestMapping(value="/porUsuario" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado getFazendasUser(Usuario user) {
		return new Resultado(dao.getFazendasDoUsuario(user));
	}

}
