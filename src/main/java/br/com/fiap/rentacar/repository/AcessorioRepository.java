package br.com.fiap.rentacar.repository;

import br.com.fiap.rentacar.entity.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
    
}
