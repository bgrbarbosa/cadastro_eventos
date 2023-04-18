package br.com.bgsis.cadastro_eventos.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/convidados")
public class ConvidadoController {

	@Autowired
	ConvidadoService service;
	
    @PostMapping
    public ResponseEntity<Object> cadastrarConvidado(@RequestBody ConvidadoDto convidadoDto){
    	 var convidado = new Convidado();
         BeanUtils.copyProperties(convidadoDto, convidado);
    	service.insertConvidado(convidado);    	
    	return  ResponseEntity.status(HttpStatus.CREATED).body(convidado);
    }
    
    @GetMapping
    public List<Convidado>buscarConvidados(){
    	return service.buscarConvidados();
    }
    
    @PutMapping
    public ResponseEntity<Object>atualizarConvidado(@RequestBody Convidado convidado){
    	if (!service.buscarPorId(convidado.getIdConvidado()).isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convidado não encontrado!!!");
    	}else {
        	service.updateConvidado(convidado);
        	return  ResponseEntity.status(HttpStatus.CREATED).body(convidado);    		
    	}
    }
          
    @GetMapping("/{id}")
    public ResponseEntity<Object>buscarPorCodigo(@PathVariable(value = "id")UUID id){
    	Optional<Convidado>convidado = service.buscarPorId(id);
    	if (!convidado.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convidado nao encontrado");
    	}else {
    		return ResponseEntity.status(HttpStatus.OK).body(convidado.get());
    	}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteEndereco(@PathVariable(value = "id")UUID id){
    	Optional<Convidado>convidado = service.buscarPorId(id);
    	if (!convidado.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convidado não encontrado!!!");
    	}else {
    		service.deleteConvidado(id);
    		return ResponseEntity.status(HttpStatus.OK).body("Convidado deletado com sucesso!!!");
    	}
    }
      	
}    
   

 


