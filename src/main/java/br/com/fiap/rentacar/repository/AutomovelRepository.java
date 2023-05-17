package br.com.fiap.rentacar.repository;

import br.com.fiap.rentacar.entity.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

}
