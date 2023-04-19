package br.com.bgsis.cadastro_eventos.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.bgsis.cadastro_eventos.model.Convidado;
import lombok.Data;

@Data
public class EventoDto {
	
	private UUID idEvento;
	private String nomeEvento;
	private LocalDate dataEvento;
	private Time inicio;
	private Time fim;
	
	private List<Convidado>convidados;
	

	
}
