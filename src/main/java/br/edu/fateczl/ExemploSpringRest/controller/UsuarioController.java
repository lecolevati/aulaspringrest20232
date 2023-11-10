package br.edu.fateczl.ExemploSpringRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.ExemploSpringRest.model.dto.DeptoDTO;
import br.edu.fateczl.ExemploSpringRest.model.dto.UsuarioDTO;
import br.edu.fateczl.ExemploSpringRest.model.entity.Depto;
import br.edu.fateczl.ExemploSpringRest.model.entity.Usuario;
import br.edu.fateczl.ExemploSpringRest.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UsuarioController implements ICRUDController<UsuarioDTO> {


	
	private List<UsuarioDTO> converteListaUsuarioListaUsuarioDTO(List<Usuario> listaUsuario) {
		List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
		for (Usuario usuario : listaUsuario) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			DeptoDTO deptoDTO = new DeptoDTO();
			
			deptoDTO.setCodigo(usuario.getDepto().getCodigo());
			deptoDTO.setNome(usuario.getDepto().getNome());
			
			usuarioDTO.setDepto(deptoDTO);
			usuarioDTO.setId(usuario.getId());
			usuarioDTO.setNome(usuario.getNome());
			
			listaUsuarioDTO.add(usuarioDTO);
		}
		return listaUsuarioDTO;
	}
	
	private UsuarioDTO converteUsuarioUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		DeptoDTO deptoDTO = new DeptoDTO();
		
		deptoDTO.setCodigo(usuario.getDepto().getCodigo());
		deptoDTO.setNome(usuario.getDepto().getNome());
		
		usuarioDTO.setDepto(deptoDTO);
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNome(usuario.getNome());
		
		return usuarioDTO;
	}
	
	private Usuario converteUsuarioDTOUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		Depto depto = new Depto();
		
		depto.setCodigo(usuarioDTO.getDepto().getCodigo());
		depto.setNome(usuarioDTO.getDepto().getNome());
		
		usuario.setDepto(depto);
		usuario.setId(usuarioDTO.getId());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setSenha(usuarioDTO.getSenha());
		
		return usuario;
	}


}
