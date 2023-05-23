package br.com.fiap.rentacar.controller;

import br.com.fiap.rentacar.entity.Automovel;
import br.com.fiap.rentacar.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automoveis")
public class AutomovelController {

    @Autowired
    private AutomovelRepository automovelRepository;

    @GetMapping
    public List<Automovel> findAll() {
        return automovelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Automovel> findById(@PathVariable Long id) {
        Optional<Automovel> result = automovelRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<Automovel> insert(@RequestBody Automovel automovel) {

        Automovel saved = automovelRepository.save(automovel);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Automovel> update(@PathVariable Long id, @RequestBody Automovel automovel) {
        if (!automovelRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Automovel updated = automovelRepository.save(automovel);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Automovel> delete(@PathVariable Long id) {
        Optional<Automovel> result = automovelRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        automovelRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
