package br.com.fiap.rentacar.repository;

import br.com.fiap.rentacar.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    List<Modelo> findByPotenciaAndNomeIgnoreCase(BigDecimal potencia, String nome);

    List<Modelo> findByPotenciaAndNomeIgnoreCaseAndIdNot(BigDecimal potencia, String nome, Long id);
}
