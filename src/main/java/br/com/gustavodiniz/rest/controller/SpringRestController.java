package br.com.gustavodiniz.rest.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavodiniz.rest.to.RestTO;
import br.com.gustavodiniz.rest.to.UserTO;

@RestController
public class SpringRestController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<RestTO>> index(){
		
		List<RestTO> lista = new ArrayList<RestTO>();
		lista.add(new RestTO("listarUsuarios","GET","http://localhost:8080/springrest/usuarios"));
		lista.add(new RestTO("buscarUsuario","GET","http://localhost:8080/springrest/usuarios/{nome}"));
		
		return new ResponseEntity<List<RestTO>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ResponseEntity<List<UserTO>> listarUsuarios(){
		
		List<UserTO> lista = new ArrayList<UserTO>();
		lista.add(new UserTO("Gustavo Diniz",30,"gds@gds.com"));
		
		return new ResponseEntity<List<UserTO>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuarios/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserTO> buscarUsuario(@PathVariable("nome") String nome){
		
		System.out.println("Buscando usuário por: " + nome);
		List<UserTO> lista = new ArrayList<UserTO>();
		lista.add(new UserTO("Gustavo",30,"gds@gds.com"));
		lista.add(new UserTO("Jose",30,"gds@gds.com"));
		lista.add(new UserTO("Luiz",30,"gds@gds.com"));
		lista.add(new UserTO("Rodrigo",30,"gds@gds.com"));
		lista.add(new UserTO("Paulo",30,"gds@gds.com"));
		
		UserTO to = null;
		for(UserTO user:lista){
			if(user.getNome().equalsIgnoreCase(nome)){
				to = user;
				break;
			}
		}
		
		if(to == null){
			System.out.println("Usuario nao encontrado: " + nome);
            return new ResponseEntity<UserTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserTO>(to, HttpStatus.OK);
	}
	
	
}
