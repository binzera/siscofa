package br.gms.siscofa.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.gms.siscofa.infra.model.BaseCRUDRepository;
import br.gms.siscofa.model.MovimentacaoGado;

@Repository
public class MovimentacaoGadoRepository extends BaseCRUDRepository<MovimentacaoGado> {

	@SuppressWarnings("unchecked")
	public List<MovimentacaoGado> consultarTodos() {
		Query query = getSession().createQuery("from MovimentacaoGado");
		return query.list();
	}

}
