package br.com.fiap.rentacar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TBL_MODELO")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODELO")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "NR_POTENCIA")
    private BigDecimal potencia;

    @Transient //marca um atributo como nao persistente / não mapea o atributo como coluna no db
    private Marca marca;
}
