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
import br.edu.fateczl.ExemploSpringRest.model.entity.Depto;
import br.edu.fateczl.ExemploSpringRest.repository.DeptoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class DeptoController implements ICRUDController<DeptoDTO> {

	
	private List<DeptoDTO> converteListaDeptoListaDeptoDTO(List<Depto> listaDepto) {
		List<DeptoDTO> listaDeptoDTO = new ArrayList<>();
		for (Depto depto : listaDepto) {
			DeptoDTO deptoDTO = new DeptoDTO();
			deptoDTO.setCodigo(depto.getCodigo());
			deptoDTO.setNome(depto.getNome());
			listaDeptoDTO.add(deptoDTO);
		}
		return listaDeptoDTO;
	}

	private DeptoDTO converteDeptoDpetoDTO(Depto depto) {
		DeptoDTO deptoDTO = new DeptoDTO();
		deptoDTO.setCodigo(depto.getCodigo());
		deptoDTO.setNome(depto.getNome());
		return deptoDTO;
	}

	private Depto converteDeptoDTODepto(DeptoDTO deptoDTO) {
		Depto depto = new Depto();
		depto.setCodigo(deptoDTO.getCodigo());
		depto.setNome(deptoDTO.getNome());
		return depto;
	}

}
