package br.gms.siscofa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.daos.MovimentacaoGadoDAO;
import br.gms.siscofa.models.Fazenda;
import br.gms.siscofa.models.MovimentacaoGado;
import br.gms.siscofa.models.Resultado;
import br.gms.siscofa.models.Usuario;

@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoGadoController {
	
	@Autowired
	private MovimentacaoGadoDAO dao;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado fazendas() {
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
	public Resultado cadastrarMovimentacao(@RequestBody MovimentacaoGado mov) {
		return new Resultado((Object) dao.incluir(mov));
	}
	
	@RequestMapping(value="/excluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado excluirMovimentacao(@RequestBody MovimentacaoGado mov) {
		try {
			dao.excluir(mov);
			return new Resultado(null, "Movimentação excluída com sucesso");
		} catch (Exception e) {
			Resultado resultado = new Resultado(null, "Erro ao exluir movimentação. detalhes: " + e.getMessage());
			resultado.setSucesso(false);
			return resultado;
		}
	}
	
	@RequestMapping(value="/porFazenda" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado getMovimentacoesPorFazenda(Fazenda faz) {
		return new Resultado(dao.getMovimentacoesDaFazenda(faz));
	}
	
	
	@RequestMapping(value="/porUsuario" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resultado getMovimentacoesPorFazenda(Usuario user) {
		return new Resultado(dao.getMovimentacoesDoUsuario(user));
	}

}
