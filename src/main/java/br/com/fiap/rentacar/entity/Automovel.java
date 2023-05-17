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

    @ManyToOne
    @JoinColumn(name = "ID_MODELO") //indica qual a coluna de ligação - Foreing Key
    private Modelo modelo;

    @ManyToMany
    //ManyToMany precisa mapear a tabela de relação, informando qual a tabela e quais as colunas de FK
    @JoinTable(name = "TBL_REL_AUTOMOVEL_ACESSORIO",
    joinColumns = @JoinColumn(name = "ID_AUTOMOVEL"),
    inverseJoinColumns = @JoinColumn(name = "ID_ACESSORIO"))
    private List<Acessorio> acessorios;
}
