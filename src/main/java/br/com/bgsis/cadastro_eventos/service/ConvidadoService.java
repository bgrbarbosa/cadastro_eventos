package br.com.bgsis.cadastro_eventos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.bgsis.cadastro_eventos.dto.ConvidadoDto;
import br.com.bgsis.cadastro_eventos.model.Convidado;


public interface ConvidadoService {
	
	List<ConvidadoDto>buscarConvidados();
	
	Page<Convidado> findAll(Pageable pageable);
	
	Convidado insertConvidado(Convidado convidado);
	
	void updateConvidado(Convidado convidado);
	
	Optional<Convidado> buscarPorId(UUID id);
	
	void deleteConvidado(UUID id);


}
