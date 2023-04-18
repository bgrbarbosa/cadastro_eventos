package br.com.bgsis.cadastro_eventos.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	@NotBlank  // NotBlank não permite valores vazios e nem valores em branco
	@Column(nullable = false, length = 50)
	private String nomeEvento;
	
	@Column(nullable = false)
	@NotBlank  // NotBlank não permite valores vazios e nem valores em branco
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd' T'HH:mm:ss'Z'") // Formata data para padrão utc
	private LocalDateTime dataEvento;
	
	@Column(nullable= false)
	@NotBlank  // NotBlank não permite valores vazios e nem valores em branco
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Time inicio;
	
	@Column
	private Time fim;

	@ManyToMany
	@JoinTable(name = "tb_convidado_evento",
		       joinColumns = @JoinColumn(name = "idEvento"),
		       inverseJoinColumns = @JoinColumn(name = "idConvidado"))
	private List<Convidado>convidados;
	
	
	


}
