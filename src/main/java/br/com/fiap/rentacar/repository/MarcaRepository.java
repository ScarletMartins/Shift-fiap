package br.com.fiap.rentacar.repository;

import br.com.fiap.rentacar.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    List<Marca> findByNomeIgnoreCase(String nome);
}
