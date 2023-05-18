package br.com.fiap.rentacar.controller;

import br.com.fiap.rentacar.entity.Marca;
import br.com.fiap.rentacar.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired //atribui ao Spring a responsabilidade de instanciar o objeto Repository
    private MarcaRepository marcaRepository; //objeto de acesso ao banco de dados

    @GetMapping
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(@PathVariable Long id) {
        Optional<Marca> result = marcaRepository.findById(id);

        return ResponseEntity.ok(result.get());
    }
}
