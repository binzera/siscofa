package br.gms.siscofa.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.gms.siscofa.models.Despesa;
import br.gms.siscofa.models.Fazenda;

@Repository
public class DespesaDAO extends BaseCRUDRepository<Despesa>{

	public List<Despesa> getDespesasDaFazenda(Fazenda faz) {

		StringBuffer ql = new StringBuffer();
		ql.append("  from Despesa des ");
		ql.append(" where des.fazenda = :fazenda ");

		Query query = manager.createQuery(ql.toString());
		query.setParameter("fazenda", faz);

		@SuppressWarnings("unchecked")
		List<Despesa> results = query.getResultList();

		return results;
	}
}
