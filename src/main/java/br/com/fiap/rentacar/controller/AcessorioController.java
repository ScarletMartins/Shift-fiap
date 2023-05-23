package br.com.fiap.rentacar.controller;

import br.com.fiap.rentacar.entity.Acessorio;
import br.com.fiap.rentacar.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioRepository acessorioRepository;

    @GetMapping
    public List<Acessorio> findAll() {
        return acessorioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acessorio> findById(@PathVariable Long id) {
        Optional<Acessorio> result = acessorioRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<Acessorio> insert(@RequestBody Acessorio acessorio) {

        Acessorio saved = acessorioRepository.save(acessorio);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acessorio> update(@PathVariable Long id, @RequestBody Acessorio acessorio) {
        if (!acessorioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Acessorio updated = acessorioRepository.save(acessorio);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Acessorio> delete(@PathVariable Long id) {
        Optional<Acessorio> result = acessorioRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        acessorioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
