package br.com.fiap.rentacar.entity;

import br.com.fiap.rentacar.enums.TipoCombustivelEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_AUTOMOVEL")
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AUTOMOVEL")
    private Long id;

    @Column(name = "NR_ANO_FABRICACAO")
    private Integer anoFabricacao;

    @Column(name = "NR_ANO_MODELO")
    private Integer anoModelo;

    @Column(name = "TP_COMBUSTIVEL")
    @Enumerated(EnumType.STRING) //indica que é uma Enum e que deve ser armazenado o texto
    private TipoCombustivelEnum tipoCombustivel;

    @Transient
    private Modelo modelo;

    @Transient
    private List<Acessorio> acessorios;
}
