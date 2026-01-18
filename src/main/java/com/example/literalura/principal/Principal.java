package com.example.literalura.principal;

import com.example.literalura.model.*;
import com.example.literalura.repository.AutorRepository;
import com.example.literalura.repository.LivroRepository;
import com.example.literalura.service.ConsumoApi;
import com.example.literalura.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";


    private LivroRepository livroRepositorio;
    private AutorRepository autorRepositorio;

    public Principal(LivroRepository livroRepositorio, AutorRepository autorRepositorio) {
        this.livroRepositorio = livroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }




    public void exibeMenu() {

        var opcao = 9;
        while (opcao != 6) {
            System.out.println("""
                    Escolha o número de sua opção:
                    1- buscar livro pelo titulo
                    2- buscar autor pelo nome
                    3- listar livros registrados
                    4- listar autores registrados
                    5- listar autores vivos em um determinado ano
                    6- listar livros em um determinado idioma
                    6- sair
                                    
                    """);
        opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                buscarLivroPeloTitulo();
                break;
            case 2:
                buscarAutorPeloNome();
                break;
            case 3:
                listarLivrosRegistrados();
                break;
            case 4:
                listarAutoresRegistrados();
                break;
            case 5:
                listarAutoresVivosEmDeterminadoAno();
                break;
            case 6:
                listarLivrosEmDeterminadoAno();
            default:
                System.out.println("Opção inválida");
        }
        
        
        
        

        }

    }


    private DadosLivro buscarLivroPeloTitulo() {
        System.out.println("Insira o nome do livro que voce deseja procurar: ");
        var nomeLivro = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
        DadosResposta dadosResposta = converteDados.obterDados(json, DadosResposta.class);

        if (dadosResposta != null && !dadosResposta.resultados().isEmpty()) {
            DadosLivro dadosLivro = dadosResposta.resultados().get(0);

            Livro livro = new Livro(dadosLivro);

            livroRepositorio.save(livro);

            System.out.println("Livro salvo com sucesso no banco!");
            System.out.println(livro);
            return dadosLivro;


        } else {
            System.out.println("Livro não encontrado");
            return null;
        }
    }

    private Autor buscarAutorPeloNome() {
        System.out.println("Insira o nome do autor que voce deseja procurar: ");
        var nome = sc.nextLine();

        var json = consumo.obterDados("https://gutendex.com/books/?search=" + nome.replace(" ", "+"));
        DadosResposta dadosResposta = converteDados.obterDados(json, DadosResposta.class);

        if (dadosResposta != null && !dadosResposta.resultados().isEmpty()) {
            var dadosLivro = dadosResposta.resultados().get(0);

            if (!dadosLivro.autor().isEmpty()) {
                DadosAutor dadosAutor = dadosLivro.autor().get(0);

                Autor autor = new Autor(dadosAutor);
                autorRepositorio.save(autor);

                System.out.println("Autor encontrado e salvo: ");
                System.out.println(autor);

                return autor;
            } else {
                System.out.println("Dados do autor não disponíveis para este título.");
                return null;

            }

        }
        System.out.println("Nenhum resultado encontrado para a busca.");
        return null;
    }


    private void listarLivrosRegistrados() {
       var livros = livroRepositorio.findAll();
        System.out.println(livros);
    }

    private void listarAutoresRegistrados() {
        var autores = autorRepositorio.findAll();
        System.out.println(autores);
    }

    private void listarAutoresVivosEmDeterminadoAno() {
    }

    private void listarLivrosEmDeterminadoAno() {
    }
}
