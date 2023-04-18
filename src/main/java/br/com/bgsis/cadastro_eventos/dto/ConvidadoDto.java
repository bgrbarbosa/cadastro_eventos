package br.com.bgsis.cadastro_eventos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bgsis.cadastro_eventos.model.Convidado;
import br.com.bgsis.cadastro_eventos.model.Evento;
import lombok.Data;

@Data
public class ConvidadoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UUID idConvidado;
	private String nomeConvidado;
	private String rgConvidado;
	private String telConvidado;
	private String emailConvidado;
	@JsonIgnore
	private List<Evento>eventos;
	

	
	

}
	

