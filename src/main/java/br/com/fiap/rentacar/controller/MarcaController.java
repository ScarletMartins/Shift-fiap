package br.com.fiap.rentacar.controller;

import br.com.fiap.rentacar.entity.Marca;
import br.com.fiap.rentacar.repository.MarcaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "*", maxAge = 3600)
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
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<Marca> insert(@RequestBody Marca marca) {
        var exists = marcaRepository.findByNomeIgnoreCase(marca.getNome());
        if (exists.isEmpty()) {
            Marca saved = marcaRepository.save(marca);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable Long id, @RequestBody Marca marca) {
        var exists = marcaRepository.findByNomeIgnoreCaseAndIdNot(marca.getNome(), id);
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build(); }
        //var result = repository.findById(id);
        // if (result.isEmpty()) {
        if (!marcaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var updated = marcaRepository.save(marca);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Marca> delete(@PathVariable Long id) {
        Optional<Marca> result = marcaRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var exists = marcaRepository.findModelos(id);
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        marcaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
