package br.gms.siscofa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.LoteGado;
import br.gms.siscofa.model.Usuario;
import br.gms.siscofa.model.repository.LoteRepository;

@Controller
@RequestMapping("/lote")
public class LoteController {
	
	@Autowired
	LoteRepository loteRepository;
	
	@RequestMapping(value="/inserir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado inserir(@RequestBody LoteGado lote) {
		String mensagem = "Lote cadastrado com sucesso!";
		LoteGado loteOk = null;
		try {
			loteOk = loteRepository.incluir(lote);
		} catch (Exception e){
			mensagem = e.getMessage();
		}
		return new Resultado(loteOk, mensagem);
	}
	
	@RequestMapping(value="/porUsuario" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado getlotesOfUser(Usuario user) {
		return new Resultado(loteRepository.getLotesDoUsuario(user));
	}
}
