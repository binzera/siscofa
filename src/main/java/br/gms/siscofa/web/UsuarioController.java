package br.gms.siscofa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.Usuario;
import br.gms.siscofa.model.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/logar" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado logar(Usuario entity) {
		return usuarioService.logar(entity);
	}
	
	@RequestMapping(value="/cadastrarUsuario" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Resultado cadastrarusuario(Usuario entity) {
		return usuarioService.cadastrarUsuario(entity);
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping("/url-magica-maluca-oaj")
	public String urlMagicaMaluca() {
		Usuario usuario = new Usuario(); 
		usuario.setNome("Glaubert");
		usuario.setEmail("binzera@gmail.com");
		usuario.setSenha("soh");
		usuario.setUsuario("binzera");
		
		usuarioService.cadastrarUsuario(usuario);
		
		return "Url Mágica executada";
	}

}
