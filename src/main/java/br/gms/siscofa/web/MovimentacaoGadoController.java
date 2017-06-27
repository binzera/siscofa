package br.gms.siscofa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.MovimentacaoGado;
import br.gms.siscofa.model.repository.MovimentacaoGadoRepository;

@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoGadoController {
	
	@Autowired
	MovimentacaoGadoRepository repository;
	
	@RequestMapping(value="/inserir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado inserir(@RequestBody MovimentacaoGado mov) {
		String mensagem = "Movimentação cadastrada com sucesso!";
		MovimentacaoGado movOk = null;
		try {
			movOk = repository.incluir(mov);
		} catch (Exception e){
			mensagem = e.getMessage();
		}
		return new Resultado(movOk, mensagem);
	}

}
