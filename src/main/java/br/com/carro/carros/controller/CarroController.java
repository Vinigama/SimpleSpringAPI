package br.com.carro.carros.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carro.carros.dto.CarroDTO;
import br.com.carro.carros.entity.Carro;
import br.com.carro.carros.service.CarroService;

@RestController
@RequestMapping("carro")
public class CarroController {
    
	@Autowired
	CarroService carroService;
	@Autowired
	ModelMapper modelMapper;
	
    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getBook(@PathVariable Long id) {
    	Carro carro = carroService.getById(id);
    	if(carro == null)
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	
    	return new ResponseEntity<CarroDTO>(modelMapper.map(carro, CarroDTO.class), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CarroDTO> postCarro(CarroDTO carroDto) {
    	Carro carro = modelMapper.map(carroDto, Carro.class);
    	carroService.create(carro);
    	return new ResponseEntity<CarroDTO>(modelMapper.map(carro, CarroDTO.class), HttpStatus.CREATED);
    }
}
