package br.com.fiap.rentacar.entity;

import br.com.fiap.rentacar.enums.TipoCombustivelEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Automovel {

    private Long id;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private TipoCombustivelEnum tipoCombustivel;
    private Modelo modelo;
    private List<Acessorio> acessorios;
}
