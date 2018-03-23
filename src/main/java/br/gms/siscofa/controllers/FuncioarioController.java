package br.gms.siscofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.daos.FuncionarioDAO;
import br.gms.siscofa.models.Despesa;
import br.gms.siscofa.models.Fazenda;
import br.gms.siscofa.models.Funcionario;
import br.gms.siscofa.models.Resultado;

@Controller
@RequestMapping("/funcionario")
public class FuncioarioController {

	
	@Autowired
	private FuncionarioDAO dao;
	
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
	public Resultado incluir(@RequestBody Funcionario funcionario) {
		return new Resultado((Object) dao.incluir(funcionario));
	}
	
	@RequestMapping(value="/excluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado excluir(@RequestBody Funcionario funcionario) {
		try {
			dao.excluir(funcionario);
			return new Resultado(null, "Despesa excluída com sucesso");
		} catch (Exception e) {
			Resultado resultado = new Resultado(null, "Erro ao exluir funcionario. detalhes: " + e.getMessage());
			resultado.setSucesso(false);
			return resultado;
		}
	}
	
	@RequestMapping(value="/alterar" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado alterar(@RequestBody Funcionario funcionario) {
		try {
			return new Resultado(dao.alterar(funcionario), "Funcionario alterada com sucesso");
		} catch (Exception e) {
			Resultado resultado = new Resultado(null, "Erro ao alterar a funcionario. detalhes: " + e.getMessage());
			resultado.setSucesso(false);
			return resultado;
		}
	}
	
	@RequestMapping(value="/porFazenda" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado getFuncioanriosDaFazenda(Fazenda faz) {
		return new Resultado(dao.getFuncionariosDaFazenda(faz));
	}
}
