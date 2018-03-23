package br.gms.siscofa.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.gms.siscofa.models.Fazenda;
import br.gms.siscofa.models.Funcionario;

@Repository
public class FuncionarioDAO extends BaseCRUDRepository<Funcionario>{

	public List<Funcionario> getFuncionariosDaFazenda(Fazenda faz) {

		StringBuffer ql = new StringBuffer();
		ql.append("  from Funcionario f ");
		ql.append(" where f.fazenda = :fazenda ");

		Query query = manager.createQuery(ql.toString());
		query.setParameter("fazenda", faz);

		@SuppressWarnings("unchecked")
		List<Funcionario> results = query.getResultList();

		return results;
	}

}
