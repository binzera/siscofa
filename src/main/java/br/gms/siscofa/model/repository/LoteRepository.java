package br.gms.siscofa.model.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.gms.siscofa.infra.model.BaseCRUDRepository;
import br.gms.siscofa.model.LoteGado;
import br.gms.siscofa.model.Usuario;

@Repository
public class LoteRepository extends BaseCRUDRepository<LoteGado>{

	@SuppressWarnings("unchecked")
	public List<LoteGado> getLotesDoUsuario(Usuario user) {
		Criteria criteria = getSession().createCriteria(LoteGado.class);
		criteria.add(Restrictions.eq("usuario", user));
		return criteria.list();
	}

}
