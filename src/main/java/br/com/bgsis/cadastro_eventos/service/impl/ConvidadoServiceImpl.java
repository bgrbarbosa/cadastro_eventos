package br.com.bgsis.cadastro_eventos.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bgsis.cadastro_eventos.model.Convidado;
import br.com.bgsis.cadastro_eventos.repository.ConvidadoRepository;
import br.com.bgsis.cadastro_eventos.service.ConvidadoService;

@Service
public class ConvidadoServiceImpl implements ConvidadoService {

	@Autowired
	ConvidadoRepository repository;

	@Override
	public Convidado insertConvidado(Convidado convidado) {
		return repository.save(convidado);		
	}
	
	@Override
	public List<Convidado>buscarConvidados() {
		return repository.findAll(); 
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
