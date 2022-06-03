package br.com.carro.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carro.carros.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{
}
