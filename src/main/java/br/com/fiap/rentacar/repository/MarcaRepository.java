package br.com.fiap.rentacar.repository;

import br.com.fiap.rentacar.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
