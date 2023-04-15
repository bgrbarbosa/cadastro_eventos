package br.com.bgsis.cadastro_eventos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.bgsis.cadastro_eventos.dto.EventoDto;
import br.com.bgsis.cadastro_eventos.model.Evento;


public interface EventoService {
	
	void insertEvento(Evento evento);
	
	void updateEvento(Evento evento);
	
	void deleteEvento(UUID id);
	
	Optional<Evento>buscarPorId(UUID id);
	
	List<Evento>buscarPorNome(String nome);
	
	List<Evento>listarEventos();
	


}
