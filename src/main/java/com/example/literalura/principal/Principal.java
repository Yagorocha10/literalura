package com.example.literalura.principal;

import com.example.literalura.model.DadosLivro;
import com.example.literalura.model.DadosResposta;
import com.example.literalura.model.Livro;
import com.example.literalura.repository.LivroRepository;
import com.example.literalura.service.ConsumoApi;
import com.example.literalura.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";


    private LivroRepository repositorio;

    public Principal(LivroRepository repositorio) {
        this.repositorio = repositorio;
    }




    public void exibeMenu() {

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


    private DadosLivro buscarLivroPeloTitulo() {
        System.out.println("Insira o nome do livro que voce deseja procurar: ");
        var nomeLivro = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
        DadosResposta dadosResposta = converteDados.obterDados(json, DadosResposta.class);

        if (dadosResposta != null && !dadosResposta.resultados().isEmpty()) {
            DadosLivro dadosLivro = dadosResposta.resultados().get(0);

            Livro livro = new Livro(dadosLivro);

            repositorio.save(livro);

            System.out.println("Livro salvo com sucesso no banco!");
            System.out.println(livro);
            return dadosLivro;


        } else {
            System.out.println("Livro não encontrado");
            return null;
        }
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
