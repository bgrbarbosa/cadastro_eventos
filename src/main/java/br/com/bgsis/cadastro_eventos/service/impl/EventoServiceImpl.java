package br.com.bgsis.cadastro_eventos.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bgsis.cadastro_eventos.model.Evento;
import br.com.bgsis.cadastro_eventos.repository.ConvidadoRepository;
import br.com.bgsis.cadastro_eventos.repository.EventoRepository;
import br.com.bgsis.cadastro_eventos.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	ConvidadoRepository convidadoRepository;

	@Override
	public void insertEvento(Evento evento) {
		eventoRepository.save(evento);
		
	}

	@Override
	public void updateEvento(Evento evento) {
		eventoRepository.save(evento);
	}

	@Override
	public void deleteEvento(UUID id) {
		eventoRepository.deleteById(id);		
	}

	@Override
	public Optional<Evento> buscarPorId(UUID id) {
		return eventoRepository.findById(id);
	}

	@Override
	public List<Evento>buscarPorNome(String nome) {
		return null;
	}

	@Override
	public List<Evento> listarEventos() {
		return eventoRepository.findAll();
	}


}
