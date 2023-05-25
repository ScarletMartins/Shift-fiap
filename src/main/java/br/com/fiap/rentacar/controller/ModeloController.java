package br.com.fiap.rentacar.controller;

import br.com.fiap.rentacar.entity.Modelo;
import br.com.fiap.rentacar.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping
    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findById(@PathVariable Long id) {
        Optional<Modelo> result = modeloRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<Modelo> insert(@RequestBody Modelo modelo) {
        var exists = modeloRepository.findByPotenciaAndNomeIgnoreCase(modelo.getPotencia(), modelo.getNome());
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Modelo saved = modeloRepository.save(modelo);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> update(@PathVariable Long id, @RequestBody Modelo modelo) {
        var exists = modeloRepository.findByPotenciaAndNomeIgnoreCaseAndIdNot(modelo.getPotencia(), modelo.getNome(), id);
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Modelo> result = modeloRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Modelo updated = modeloRepository.save(modelo);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Modelo> delete(@PathVariable Long id) {
        Optional<Modelo> result = modeloRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        modeloRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
