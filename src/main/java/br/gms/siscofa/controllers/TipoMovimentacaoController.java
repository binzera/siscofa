package br.gms.siscofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.daos.TipoMovimentacaoDAO;
import br.gms.siscofa.models.Resultado;
import br.gms.siscofa.models.TipoMovimentacao;


@Controller
@RequestMapping("/tipoMovimentacao")
public class TipoMovimentacaoController {

	@Autowired
	private TipoMovimentacaoDAO dao;
	
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
	public Resultado incluir(@RequestBody TipoMovimentacao tipoMov) {
		return new Resultado((Object) dao.incluir(tipoMov));
	}
	
	@RequestMapping(value="/excluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado excluir(@RequestBody TipoMovimentacao tipoMov) {
		try {
			dao.excluir(tipoMov);
			return new Resultado(null, "TipoMovimentação excluída com sucesso");
		} catch (Exception e) {
			Resultado resultado = new Resultado(null, "Erro ao exluir o tipo movimentação. detalhes: " + e.getMessage());
			resultado.setSucesso(false);
			return resultado;
		}
	}
	
	@RequestMapping(value="/alterar" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado alterar(@RequestBody TipoMovimentacao tipoMov) {
		try {
			return new Resultado(dao.alterar(tipoMov), "TipoMovimentação alterada com sucesso");
		} catch (Exception e) {
			Resultado resultado = new Resultado(null, "Erro ao alterar o tipo movimentação. detalhes: " + e.getMessage());
			resultado.setSucesso(false);
			return resultado;
		}
	}
}
