package br.com.fiap.rentacar.controller;

import br.com.fiap.rentacar.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioRepository acessorioRepository;
}
