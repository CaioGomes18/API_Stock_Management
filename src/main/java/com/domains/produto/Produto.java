package com.domains.produto;

import jakarta.persistence.*;

import java.time.LocalDateTime;
//@Entity e @Id- utilizados para que o hibernate consiga identificar essa classe seja mapeada como entidade
//As mesmas definem que essa classe será uma tabela e que o @Id seja chave primaria


@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Como se fosse o auto increment

    private Long id;
    @Column(nullable = false, unique = true)      //propriedades unique tem valor false por default e nullable que tem valor default true

    private String nome;
    @Column(nullable = false)

    private String descricao;
    @Column(nullable = false)

    private Integer quantidadeMinima;
    @Column(nullable = false)

    private Integer quantidadeMaxima;
    @Column(nullable = false)

    private LocalDateTime criadoEm;

    public Produto(String nome, String descricao, Integer quantidadeMinima, Integer quantidadeMaxima) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
        this.criadoEm = LocalDateTime.now();
    }

    public Produto() {}

    public Long getId()
    {
        return id;
    }

    public String getNome(){
        return nome;
    }


}

