package br.com.bgsis.cadastro_eventos.components;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.bgsis.cadastro_eventos.dto.ConvidadoDto;
import br.com.bgsis.cadastro_eventos.model.Convidado;

@Component
public class ConvidadoMapper {

	private final ModelMapper modelMapper = new ModelMapper();	
    
	public List<ConvidadoDto> toDto(List<Convidado> convidados) {
    	
    	List<Convidado>listConvidados = new ArrayList<>();
    	List<ConvidadoDto>listConvidadosDto = new ArrayList<>();
    	for (int i=0; i<convidados.size();i++) {
    		listConvidadosDto.add(modelMapper.map(convidados.get(i), ConvidadoDto.class));
    	}
    	return listConvidadosDto;
    }
  
    public List<Convidado>toEntity(List<ConvidadoDto> convidadosDto) {
    	
    	List<Convidado>listConvidados = new ArrayList<>();
    	List<ConvidadoDto>listConvidadosDto = new ArrayList<>();
    	for (int i=0; i<convidadosDto.size();i++) {
    		listConvidados.add(modelMapper.map(convidadosDto.get(i), Convidado.class));
    	}
    	return listConvidados;
    }
}
