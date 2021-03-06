package br.gms.siscofa.daos;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.gms.siscofa.models.Usuario;


@Repository
public class UsuarioDAO extends BaseCRUDRepository<Usuario>{
	
	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager
				.createQuery("select u from Usuario u where u.email = :email",
				Usuario.class)
			.setParameter("email", email)
			.getResultList();
		
		if (usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuário "  + email + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}
	
	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}
}
