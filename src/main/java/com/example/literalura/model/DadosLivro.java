package com.example.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") List<DadosAutor> autor,
                         @JsonAlias("languages") List<String> idiomas,
                         @JsonAlias("download_count") Integer numeroDeDownloads) {


    @Override
    public String toString() {
        String nomeAutor;
        if (autor == null || autor.isEmpty()) {
            nomeAutor = "Desconhecido";
        } else {
            nomeAutor = autor.get(0).nome();
        }

        String idioma;
        if (idiomas == null || idiomas.isEmpty()) {
            idioma = "N/A";
        } else {
            idioma = idiomas.get(0);
        }



        return String.format("""
                ----- LIVRO -----
                Título: %s
                Autor: %s
                Idioma: %s
                Número de downloads: %d
                -----------------
                """, titulo, nomeAutor, idioma, numeroDeDownloads);
    }
}
