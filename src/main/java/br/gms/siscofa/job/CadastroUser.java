package br.gms.siscofa.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.Usuario;
import br.gms.siscofa.model.service.UsuarioService;

@Component
public class CadastroUser {
	
	@Autowired
	private UsuarioService service;
	
	//@Scheduled(fixedDelay=50000)
	public void iniciar(){
		List<Usuario> lista = new ArrayList<Usuario>();
		for(int i=0; i<10; i++){
			Usuario user = new Usuario();
			user.setNome("user" + i);
			user.setEmail("teste@gmail.com");
			user.setUsuario("user " + i);
			user.setSenha("noix");
			user.setCreated(new Date());
			user.setUpdated(new Date());
			lista.add(user);
		}
		
		this.inserir(lista);
		
		//System.out.println(user.getNome() + " inserido com sucesso");
		
		this.continuar();
	}
	
	@Transactional
	private void inserir(List<Usuario> lista) {
		// TODO Auto-generated method stub
		for(Usuario user : lista){
			Resultado result = service.cadastrarUsuario(user);
			System.out.println(result.getDados().toString());
		}
		
	}

	private void continuar() {
		// TODO Auto-generated method stub
		System.out.println("continuou");
	}

	@Transactional
	public void inserir(Usuario user) {
		// TODO Auto-generated method stub
		this.service.cadastrarUsuario(user);
	}
	

}
