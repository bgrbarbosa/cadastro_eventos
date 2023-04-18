package br.com.bgsis.cadastro_eventos.components;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.bgsis.cadastro_eventos.dto.EventoDto;
import br.com.bgsis.cadastro_eventos.model.Evento;

@Component
public class EventoMapper {
	
	private final ModelMapper modelMapper = new ModelMapper();
	
    
	public List<EventoDto> toDto(List<Evento> eventos) {
    	
    	List<Evento>listEventos = new ArrayList<>();
    	List<EventoDto>listEventosDto = new ArrayList<>();
    	for (int i=0; i<eventos.size();i++) {
    		listEventosDto.add(modelMapper.map(eventos.get(i), EventoDto.class));
    	}
    	return listEventosDto;
    }
  
    public List<Evento>toEntity(List<EventoDto> eventosDto) {
    	
    	List<Evento>listEventos = new ArrayList<>();
    	List<EventoDto>listEventosDto = new ArrayList<>();
    	for (int i=0; i<eventosDto.size();i++) {
    		listEventos.add(modelMapper.map(eventosDto.get(i), Evento.class));
    	}
    	return listEventos;
    }

}
