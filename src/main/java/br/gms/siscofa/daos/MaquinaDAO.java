package br.gms.siscofa.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.gms.siscofa.models.Fazenda;
import br.gms.siscofa.models.Maquina;

@Repository
public class MaquinaDAO extends BaseCRUDRepository<Maquina>{

	public List<Maquina> getMaquinasDaFazenda(Fazenda faz) {

		StringBuffer ql = new StringBuffer();
		ql.append("  from Maquina maq ");
		ql.append(" where maq.fazenda = :fazenda ");

		Query query = manager.createQuery(ql.toString());
		query.setParameter("fazenda", faz);

		@SuppressWarnings("unchecked")
		List<Maquina> results = query.getResultList();

		return results;
	}
}
