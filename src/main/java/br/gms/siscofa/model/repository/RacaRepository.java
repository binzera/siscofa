package br.gms.siscofa.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.gms.siscofa.infra.model.BaseCRUDRepository;
import br.gms.siscofa.model.RacaGado;
import br.gms.siscofa.model.Usuario;

@Repository
public class RacaRepository extends BaseCRUDRepository<RacaGado>{
	
	@SuppressWarnings("unchecked")
	public List<RacaGado> consultarTodos() {
		Query query = getSession().createQuery("from RacaGado");
		return query.list();
	}
	
	public RacaGado porNome(RacaGado raca) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from RacaGado r ");
		ql.append(" where lower(r.nome) = :nome ");

		Query query = getSession().createQuery(ql.toString());
		query.setParameter("nome", raca.getNome().toLowerCase().trim());

		return (RacaGado) query.uniqueResult();
	}
}
