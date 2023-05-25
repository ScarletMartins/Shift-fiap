package br.com.fiap.rentacar.repository;

import br.com.fiap.rentacar.entity.Marca;
import br.com.fiap.rentacar.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    List<Marca> findByNomeIgnoreCase(String nome);

    //busca o nome com o Id diferente passados por parametro
    List<Marca> findByNomeIgnoreCaseAndIdNot(String nome, Long id);

    @Query("select m from Modelo m where m.marca.id = :idMarca") //monta uma estrutura de JPQL - query de SQL com OO
    List<Modelo> findModelos(Long idMarca);
}
