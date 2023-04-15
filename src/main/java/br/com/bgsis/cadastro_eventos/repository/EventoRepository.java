package br.com.bgsis.cadastro_eventos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bgsis.cadastro_eventos.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {

}
