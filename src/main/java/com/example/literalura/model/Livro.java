package com.example.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String idioma;
    private Double numeroDeDownloads;

    public Livro() {
    }

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.numeroDeDownloads = Double.valueOf(dadosLivro.numeroDeDownloads());

        if (dadosLivro.autor() != null && !dadosLivro.autor().isEmpty()) {
            this.autor = dadosLivro.autor().get(0).nome();
        } else {
            this.autor = "Desconhecido";
        }

        if (dadosLivro.idiomas() != null && !dadosLivro.idiomas().isEmpty()) {
            this.idioma = dadosLivro.idiomas().get(0);
        } else {
            this.idioma = "N/A";
        }
    }


    @Override
    public String toString() {
        return String.format("""
                ----- LIVRO -----
                Título: %s
                Autor: %s
                Idioma: %s
                Número de downloads: %.1f
                -----------------
                """, titulo, autor, idioma, numeroDeDownloads);
    }

}
