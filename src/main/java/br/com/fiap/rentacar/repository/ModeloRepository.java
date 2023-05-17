package br.com.fiap.rentacar.repository;

import br.com.fiap.rentacar.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
