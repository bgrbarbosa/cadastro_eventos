package br.com.bgsis.cadastro_eventos.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

import br.com.bgsis.cadastro_eventos.dto.ConvidadoDto;
import br.com.bgsis.cadastro_eventos.model.Convidado;
import br.com.bgsis.cadastro_eventos.model.Evento;
import br.com.bgsis.cadastro_eventos.service.ConvidadoService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/convidados")
@Log4j2
public class ConvidadoController {

	@Autowired
	ConvidadoService service;
	
    @PostMapping
    public ResponseEntity<Object> cadastrarConvidado(@RequestBody ConvidadoDto convidadoDto){
    	 var convidado = new Convidado();
         BeanUtils.copyProperties(convidadoDto, convidado);
    	service.insertConvidado(convidado);
    	log.info("Registro: " + convidado.getIdConvidado() + " com sucesso!!");
    	return  ResponseEntity.status(HttpStatus.CREATED).body(convidado);
    }
    
   /* @GetMapping
    public List<ConvidadoDto>buscarConvidados(){
    	return service.buscarConvidados();
    }*/
    
    @GetMapping
    public ResponseEntity<Page<Convidado>> listarConvidados(@PageableDefault(page = 0, size = 10, sort = "nomeConvidado", 
                                                       direction = Sort.Direction.ASC)Pageable pageable){
    	log.info("Consultando lista de convidados!!");
        Page<Convidado> userModelPage = service.findAll(pageable); 
        return ResponseEntity.status(HttpStatus.OK).body(userModelPage);
    }
    
    @PutMapping
    public ResponseEntity<Object>atualizarConvidado(@RequestBody ConvidadoDto convidadoDto){
        var convidado = new Convidado();
        BeanUtils.copyProperties(convidadoDto, convidado);
    	if (!service.buscarPorId(convidado.getIdConvidado()).isPresent()) {
    		log.info("Registro: " + convidadoDto.getEventos() + " não foi encontrado!!");
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convidado não encontrado!!!");
    	}else {
        	service.updateConvidado(convidado);
        	log.info("Registro: " + convidadoDto.getEventos() + " com sucesso!!");
        	return  ResponseEntity.status(HttpStatus.CREATED).body(convidado);    		
    	}
    }
          
    @GetMapping("/{id}")
    public ResponseEntity<Object>buscarPorCodigo(@PathVariable(value = "id")UUID id){
    	Optional<Convidado>convidado = service.buscarPorId(id);
    	if (!convidado.isPresent()) {
    		log.info("Registro: " + id + " não foi encontrado!!");
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convidado nao encontrado!!");
    	}else {
    		log.info("Registro: " + id);
    		return ResponseEntity.status(HttpStatus.OK).body(convidado.get());
    	}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteEndereco(@PathVariable(value = "id")UUID id){
    	Optional<Convidado>convidado = service.buscarPorId(id);
    	if (!convidado.isPresent()) {
    		log.info("Registro: " + id + " não foi encontrado!!");
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convidado não encontrado!!!");
    	}else {
    		service.deleteConvidado(id);
    		log.info("Registro: " + id + " deletado com sucesso!!");
    		return ResponseEntity.status(HttpStatus.OK).body("Convidado deletado com sucesso!!!");
    	}
    }
      	
}    
   

 


