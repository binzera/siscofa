package br.gms.siscofa.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.gms.siscofa.infra.model.BaseCRUDRepository;
import br.gms.siscofa.model.Usuario;

@Repository
public class UsuarioRepository extends BaseCRUDRepository<Usuario> {
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findByUserName(String userName) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from Usuario b ");
		ql.append(" where lower(b.usuario) = :usuario ");

		Query query = getSession().createQuery(ql.toString());
		query.setParameter("usuario", userName.toLowerCase().trim());

		return query.list();
	}

}
