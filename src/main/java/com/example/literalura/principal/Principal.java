package com.example.literalura.principal;

import java.util.Scanner;

public class Principal {

    public void exibeMenu() {

        Scanner sc = new Scanner(System.in);

        var opcao = 9;
        while (opcao != 6) {
            System.out.println("""
                    Escolha o número de sua opção:
                    1- buscar livro pelo titulo
                    2- listar livros registrados
                    3- listar autores registrados
                    4- listar autores vivos em um determinado ano
                    5- listar livros em um determinado idioma
                    6- sair
                                    
                    """);
        opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                buscarLivroPeloTitulo();
                break;
            case 2:
                listarLivrosRegistrados();
                break;
            case 3:
                listarAutoresRegistrados();
                break;
            case 4:
                listarAutoresVivosEmDeterminadoAno();
                break;
            case 5:
                listarLivrosEmDeterminadoAno();
                break;
            default:
                System.out.println("Opção inválida");
        }
        
        
        
        

        }

    }


    private void buscarLivroPeloTitulo() {
    }

    private void listarLivrosRegistrados() {
    }

    private void listarAutoresRegistrados() {
    }

    private void listarAutoresVivosEmDeterminadoAno() {
    }

    private void listarLivrosEmDeterminadoAno() {
    }
}
