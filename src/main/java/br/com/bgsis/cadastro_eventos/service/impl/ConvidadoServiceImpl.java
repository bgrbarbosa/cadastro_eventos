package br.com.bgsis.cadastro_eventos.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bgsis.cadastro_eventos.components.ConvidadoMapper;
import br.com.bgsis.cadastro_eventos.dto.ConvidadoDto;
import br.com.bgsis.cadastro_eventos.dto.EventoDto;
import br.com.bgsis.cadastro_eventos.model.Convidado;
import br.com.bgsis.cadastro_eventos.model.Evento;
import br.com.bgsis.cadastro_eventos.repository.ConvidadoRepository;
import br.com.bgsis.cadastro_eventos.service.ConvidadoService;

@Service
public class ConvidadoServiceImpl implements ConvidadoService {

	@Autowired
	ConvidadoRepository repository;
	
	@Autowired
	ConvidadoMapper mapper;
	
	private List<Convidado>convidados = new ArrayList<>();
	
	@Override
	public Convidado insertConvidado(Convidado convidado) {
		return repository.save(convidado);		
	}
	
	@Override
	public List<ConvidadoDto>buscarConvidados() { 
		convidados = repository.findAll();
		return mapper.toDto(convidados);
	}
	
	@Override
	public Page<Convidado> findAll(Pageable pageable) {
		return  repository.findAll(pageable);

	}
	
	

	@Override
	public void updateConvidado(Convidado convidado) {
		repository.save(convidado);
	}
	
	@Override
	public Optional<Convidado> buscarPorId(UUID id) {
		return repository.findById(id);
	}

	@Override
	public void deleteConvidado(UUID id) {
		repository.deleteById(id);		
	}



}
