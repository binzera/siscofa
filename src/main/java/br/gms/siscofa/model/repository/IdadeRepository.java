package br.gms.siscofa.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.gms.siscofa.infra.model.BaseCRUDRepository;
import br.gms.siscofa.model.Idade;

@Repository
public class IdadeRepository extends BaseCRUDRepository<Idade> {

	@SuppressWarnings("unchecked")
	public List<Idade> consultarTodos() {
		Query query = getSession().createQuery("from Idade");
		return query.list();
	}

}
