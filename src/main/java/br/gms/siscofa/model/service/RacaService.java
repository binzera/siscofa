package br.gms.siscofa.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gms.siscofa.infra.web.Resultado;
import br.gms.siscofa.model.RacaGado;
import br.gms.siscofa.model.repository.RacaRepository;

@Service
public class RacaService {

	@Autowired
	private RacaRepository racaRepository;

	public Resultado inserir(RacaGado raca) {
		Resultado retorno = new Resultado();
		RacaGado existe = racaRepository.porNome(raca);
		if (existe == null) {
			retorno = new Resultado(racaRepository.incluir(raca), "CADASTRO_RACA_SUCESSO");
		} else {
			retorno = new Resultado(existe, "RACA_JA_EXISTE");
		}

		return retorno;
	}

}
