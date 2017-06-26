package br.gms.siscofa.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.Fazenda;
import br.gms.siscofa.model.Usuario;
import br.gms.siscofa.model.repository.FazendaRepository;


@Service
public class FazendaService {

	@Autowired
	FazendaRepository fazendaReporitory;

	public FazendaService(FazendaRepository repository) {
		super();
		this.fazendaReporitory = repository;
	}

	@Transactional
	public Fazenda incluir(Fazenda entidade) {
		return fazendaReporitory.incluir(entidade);
	}

	@Transactional
	public Fazenda alterar(Fazenda entidade) {
		return fazendaReporitory.alterar(entidade);
	}

	@Transactional
	public void excluir(Fazenda entidade) {
		fazendaReporitory.excluir(entidade);
	}

	public Fazenda consultarPorId(Integer id) {
		return fazendaReporitory.consultarPorId(id);
	}

	public List<Fazenda> consultarTodos() {
		return fazendaReporitory.consultarTodos();
	}

	public Resultado cadastrarFazenda(Fazenda fazenda) {

		String mensagem = "";
		Fazenda faz = null;

		if (!fazendaReporitory.isExisteFazenda(fazenda)) {
			try {
				faz = fazendaReporitory.incluir(fazenda);
				if (faz != null) {
					mensagem = "Fazenda cadastrada com sucesso!";
				}
			} catch (Exception e) {
				mensagem = "Erro ao cadastrar a fazenda, contate o administrador.";
			}
		} else {
			mensagem = "Fazenda já existe";
		}

		return new Resultado(faz, mensagem);
	}
	
	public List<Fazenda> getFazendasUsuario(Usuario user) {
		List<Fazenda> lista = fazendaReporitory.findByUserId(user);
		return lista;
	}

}
