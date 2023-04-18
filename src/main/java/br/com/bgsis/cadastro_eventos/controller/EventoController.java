package br.com.bgsis.cadastro_eventos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bgsis.cadastro_eventos.components.EventoMapper;
import br.com.bgsis.cadastro_eventos.dto.EventoDto;
import br.com.bgsis.cadastro_eventos.model.Evento;
import br.com.bgsis.cadastro_eventos.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoService service;
	
	@Autowired
	private EventoMapper mapper;

	
    @PostMapping
    public ResponseEntity<Object> cadastrarEvento(@RequestBody EventoDto dto){
        var evento = new Evento();
        BeanUtils.copyProperties(dto, evento);
    	service.insertEvento(evento);    	
    	return  ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }
    
   @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteEvento(@PathVariable(value = "id")UUID id){
    	Optional<Evento>evento = service.buscarPorId(id);
    	if (!evento.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado!!!");
    	}else {
    		service.deleteEvento(id);
    		return ResponseEntity.status(HttpStatus.OK).body("Evento deletado com sucesso!!!");
    	}
    }
    
    @PutMapping
    public ResponseEntity<Object>atualizarEvento(@RequestBody EventoDto eventoDto){
        var evento = new Evento();
        BeanUtils.copyProperties(eventoDto, evento);
    	if (!service.buscarPorId(evento.getIdEvento()).isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convidado não encontrado!!!");
    	}else {
    	   	service.updateEvento(evento);
        	return  ResponseEntity.status(HttpStatus.CREATED).body(evento);    		
    	}   	
    }
    
    @GetMapping
    public List<EventoDto>listarEvento(){
    	return service.listarEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>buscarPorCodigo(@PathVariable(value = "id")UUID id){
    	Optional<Evento>evento = service.buscarPorId(id);
    	if (!evento.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convidado nao encontrado");
    	}else {
    		return ResponseEntity.status(HttpStatus.OK).body(evento.get());
    	}
    }


}
