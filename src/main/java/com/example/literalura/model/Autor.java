package com.example.literalura.model;


import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalescimento;

    public Autor() {
    }

    public Autor(DadosAutor dadosAutor) {
        this.nome = dadosAutor.nome();
        this.anoNascimento = dadosAutor.anoNascimento();
        this.anoFalescimento = dadosAutor.anoFalecimento();
    }

    @Override
    public String toString() {
        return String.format("""
            ----- AUTOR -----
            Nome: %s
            Ano de nascimento: %s
            Ano de falecimento: %s
            -----------------
            """,
                nome, anoNascimento, anoFalescimento);
    }



}
