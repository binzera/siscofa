package br.gms.siscofa2018.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.siscofa2018.daos.UsuarioDAO;
import br.gms.siscofa2018.models.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@RequestMapping(value="/logar" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Usuario logar(Usuario usuario) {
		Usuario logado = dao.loadUserByUsername(usuario.getEmail());
		return logado;
	}
	
	@RequestMapping(value="/incluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Usuario cadastrarusuario(@RequestBody Usuario usuario) {
		return dao.incluir(usuario);
	}
	
	@RequestMapping(value="/listar" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> listar() {
		return dao.list();
	}

}
