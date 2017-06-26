package br.gms.siscofa.model.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.gms.siscofa.infra.model.BaseCRUDRepository;
import br.gms.siscofa.model.TipoMovimentacao;

@Repository
public class TipoMovimentacaoRepository extends BaseCRUDRepository<TipoMovimentacao> {

	@SuppressWarnings("unchecked")
	public List<TipoMovimentacao> consultarTodos() {
		Query query = getSession().createQuery("from TipoMovimentacao");
		return query.list();
	}

}
