package br.com.fiap.rentacar.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Modelo {

    private Long id;
    private String nome;
    private Double potencia;
    private Marca marca;
}
