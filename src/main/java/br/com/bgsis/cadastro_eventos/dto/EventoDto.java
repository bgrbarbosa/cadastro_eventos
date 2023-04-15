package br.com.bgsis.cadastro_eventos.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import br.com.bgsis.cadastro_eventos.model.Convidado;
import br.com.bgsis.cadastro_eventos.model.Evento;
import lombok.Data;

@Data
public class EventoDto {
	
	private UUID idEvento;
	private String nomeEvento;
	private LocalDate dataEvento;
	private Time inicio;
	private Time fim;
	private Set<Convidado>convidados;
	


}
