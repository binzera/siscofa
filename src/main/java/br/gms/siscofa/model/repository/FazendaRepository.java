package br.gms.siscofa.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.gms.siscofa.infra.model.BaseCRUDRepository;
import br.gms.siscofa.model.Fazenda;
import br.gms.siscofa.model.Usuario;

@Repository
public class FazendaRepository extends BaseCRUDRepository<Fazenda> {

	@SuppressWarnings("unchecked")
	public List<Fazenda> consultarTodos() {
		Query query = getSession().createQuery("from Fazenda");
		return query.list();
	}

	public List<Fazenda> findByUserId(Usuario user) {

		StringBuffer ql = new StringBuffer();
		ql.append("  from Fazenda f ");
		ql.append(" where f.usuario = :usuario ");

		Query query = getSession().createQuery(ql.toString());
		query.setParameter("usuario", user);

		List<Fazenda> results = query.list();

		return results;
	}

	public boolean isExisteFazenda(Fazenda faz) {

		boolean retorno = false;

		StringBuffer ql = new StringBuffer();
		ql.append(" from Fazenda f ");
		ql.append(" where lower(f.nome) = :nomeFaz ");
		ql.append(" and f.usuario = :usuario");

		Query query = getSession().createQuery(ql.toString());
		query.setParameter("nomeFaz", faz.getNome().toLowerCase().trim());
		query.setParameter("usuario", faz.getUsuario());

		List<Fazenda> lista = query.list();

		if (!lista.isEmpty()) {
			retorno = true;
		}

		return retorno;

	}

}
