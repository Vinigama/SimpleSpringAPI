package br.com.carro.carros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carro.carros.entity.Carro;
import br.com.carro.carros.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> list() {
		return carroRepository.findAll();
	}
	
	public Carro getById(Long id) {
		Optional<Carro> carroBusca = carroRepository.findById(id);
		if(carroBusca.isEmpty())
			return null;
		return carroBusca.get();
	}
	
	public void create(Carro carro) {
		carroRepository.save(carro);
	}
}
