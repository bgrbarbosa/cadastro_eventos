package br.com.bgsis.cadastro_eventos.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EVENTOS")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idEvento;
	
	@Column(nullable = false, length = 50)
	private String nomeEvento;
	
	@Column(nullable = false)
	private LocalDate dataEvento;
	
	@Column(nullable= false)
	private Time inicio;
	
	@Column
	private Time fim;

	@ManyToMany
	@JoinTable(name = "tb_convidado_evento",
		       joinColumns = @JoinColumn(name = "idEvento"),
		       inverseJoinColumns = @JoinColumn(name = "idConvidado"))
	private List<Convidado>convidados;
	
	
	


}
