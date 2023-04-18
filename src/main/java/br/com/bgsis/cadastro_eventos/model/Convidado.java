package br.com.bgsis.cadastro_eventos.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "TB_CONVIDADOS")
public class Convidado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idConvidado;
	
	@Column(nullable = false, length = 60)
	private String nomeConvidado;
	
	@Column(nullable = false, length = 12)
	private String rgConvidado;
	
	@Column(nullable = false, length = 12)
	private String telConvidado;
	
	@Column(nullable = false, length = 70)
	private String emailConvidado;

	@ManyToMany(mappedBy = "convidados")
	@JsonIgnore
	private List<Evento>eventos;

}
