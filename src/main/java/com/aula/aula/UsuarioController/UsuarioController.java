package com.aula.aula.UsuarioController;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aula.aula.entities.Usuario;
import com.aula.aula.repositories.UsuarioRepository;

@RestController
	@RequestMapping(value= "/usuarios")
	public class UsuarioController {
	
		@Autowired
		private UsuarioRepository usuarioRepository;
		
		@GetMapping
		public List<Usuario> findAll(){
			List<Usuario> result= usuarioRepository.findAll();
			return result;
			
		}
		
		@GetMapping(value="/{id}")
		public Usuario findById(@PathVariable Long id){
			Usuario result = usuarioRepository.findById(id).get();
		    return result;
		
		}
		
		@PostMapping
		public Usuario insert(@RequestBody Usuario usuario) {
			Usuario result = usuarioRepository.save(usuario);
			return result;
		}


	@PutMapping("/{id}")
	public Usuario update(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
		Optional<Usuario> usuarioOptional =usuarioRepository.findById(id);
		
		
		if(usuarioOptional.isPresent()) {
			Usuario usuario =usuarioOptional.get();
			usuario.setNome(novoUsuario.getNome());
			usuario.setEmail(novoUsuario.getEmail());
			
			Usuario resultado = usuarioRepository.save(usuario);
			return resultado;
			
				} else {
					return null;
				}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object>delete(@PathVariable Long id){
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		
		if( usuarioOptional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
	}else {
		return ResponseEntity.notFound().build();
	}
		
	}


	}

