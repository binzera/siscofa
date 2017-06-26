package br.gms.siscofa.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.Fazenda;
import br.gms.siscofa.model.LoteGado;
import br.gms.siscofa.model.MovimentacaoGado;
import br.gms.siscofa.model.Usuario;
import br.gms.siscofa.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository dao;

	public Resultado logar(Usuario user) {
		String retorno = "";
		Usuario usuario = null;

		List<Usuario> lista = dao.findByUserName(user.getUsuario());
		if (lista.isEmpty()) {
			retorno = new String("USER_NAO_CADASTRADO");
		} else if (lista.get(0).getSenha().equals(user.getSenha())) {
			usuario = lista.get(0);
			usuario.setFazendas(new ArrayList<Fazenda>());
			usuario.setLoteGados(new ArrayList<LoteGado>());
			usuario.setMovimentacaoGados(new ArrayList<MovimentacaoGado>());
			retorno = new String("LOGIN_SUCESSO");
		} else {
			retorno = new String("SENHA_INCORRETA");
		}

		return new Resultado(usuario, retorno);
	}

	public Resultado cadastrarUsuario(Usuario entity) {

		String retorno = new String("ERRO_CADASTRO");
		Usuario user = null;

		List<Usuario> lista = dao.findByUserName(entity.getUsuario());

		if (!lista.isEmpty()) {
			retorno = new String("USUARIO_JA_CADASTRADO");
		} else {
			user = dao.incluir(entity);
			if (user.getId() != null && !user.getId().equals("")) {
				retorno = new String("USUARIO_CADASTRADO_SUCESSO");
			}
		}

		return new Resultado(user, retorno);
	}
	
	
	public String testeHibernate() {

		for(int i=0 ; i<200 ; i++){
			Usuario user = dao.consultarPorId(2);
			user.setNome("" + i);
			Usuario atualizado = dao.alterar(user);
			System.out.println("novo nome: " + atualizado.getNome());
		}

		return "testado";
	}
	
}
