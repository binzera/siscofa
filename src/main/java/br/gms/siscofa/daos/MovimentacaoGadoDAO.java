package br.gms.siscofa.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.gms.siscofa.models.Fazenda;
import br.gms.siscofa.models.MovimentacaoGado;
import br.gms.siscofa.models.Usuario;

@Repository
public class MovimentacaoGadoDAO extends BaseCRUDRepository<MovimentacaoGado>{
	
	public List<Fazenda> getMovimentacoesDoUsuario(Usuario user) {

		StringBuffer ql = new StringBuffer();
		ql.append("  from MovimentacaoGado mov ");
		ql.append("  join mov.fazenda faz ");
		ql.append("  join faz.usuario usu ");
		ql.append(" where usu.usuario = :usuario ");

		Query query = manager.createQuery(ql.toString());
		query.setParameter("usuario", user);

		@SuppressWarnings("unchecked")
		List<Fazenda> results = query.getResultList();

		return results;
	}
	
	
	public List<Fazenda> getMovimentacoesDaFazenda(Fazenda faz) {

		StringBuffer ql = new StringBuffer();
		ql.append("  from MovimentacaoGado mov ");
		ql.append(" where mov.fazenda = :fazenda ");

		Query query = manager.createQuery(ql.toString());
		query.setParameter("fazenda", faz);

		@SuppressWarnings("unchecked")
		List<Fazenda> results = query.getResultList();

		return results;
	}

}
