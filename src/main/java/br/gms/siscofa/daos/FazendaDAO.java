package br.gms.siscofa.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.gms.siscofa.models.Fazenda;
import br.gms.siscofa.models.Usuario;

@Repository
public class FazendaDAO extends BaseCRUDRepository<Fazenda>{

	public List<Fazenda> getFazendasDoUsuario(Usuario user) {

		StringBuffer ql = new StringBuffer();
		ql.append("  from Fazenda f ");
		ql.append(" where f.usuario = :usuario ");

		Query query = manager.createQuery(ql.toString());
		query.setParameter("usuario", user);

		List<Fazenda> results = query.getResultList();

		return results;
	}
}
