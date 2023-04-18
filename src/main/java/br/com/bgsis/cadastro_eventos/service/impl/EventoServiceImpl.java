package br.com.bgsis.cadastro_eventos.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bgsis.cadastro_eventos.components.EventoMapper;
import br.com.bgsis.cadastro_eventos.dto.EventoDto;
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
	
	@Autowired
	EventoMapper mapper;
	
	private List<Evento>eventos = new ArrayList<>();

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
	public List<EventoDto> listarEventos() {
    	eventos = eventoRepository.findAll();
    	return mapper.toDto(eventos);
	}




}
