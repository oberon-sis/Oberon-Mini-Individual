package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
    Scanner sc = new Scanner(System.in);
    Scanner scTxt = new Scanner(System.in);
    List<String> titulosLivros = new ArrayList<>();
    List<String> autoresLivros = new ArrayList<>();
    List<String> codigosLivros = new ArrayList<>();

    public void menu() {
        System.out.println("Olá! Seja bem vindo ao SEB (Sistema Eletrônico Bibliotecário)");
        System.out.println("----- MENU -----");
        System.out.println("1 - Listar todos os livros cadastrados");
        System.out.println("2 - Cadastrar livro");
        System.out.println("3 - Remover livro");
        System.out.println("4 - Consulta por nome");
        System.out.println("5 - Consulta por autor");
        System.out.println("6 - Sair");

        System.out.print("Digite a opção desejada: ");
        Integer option = sc.nextInt();

        if (option.equals(1)) {
            listarLivros();
        } else if (option.equals(2)) {
            cadastrarLivro();
        } else if (option.equals(3)) {
            removerLivro();
        } else if (option.equals(4)) {
            consultaPorNome();
        } else if(option.equals(5)) {
            consultaPorAutor();
        } else if (option.equals(6)) {
            System.out.println("Até mais!");
            System.exit(0);
        } else {
            System.out.println("Digite uma opção válida!");
            menu();
        }

    }

    public void fimMetodo() {
        System.out.print("Deseja voltar para o menu? (s/n): ");
        String escolha = scTxt.nextLine();
        if (escolha.equals("s")) {
            menu();
        } else if (escolha.equals("n")) {
            System.exit(0);
        } else {
            System.out.println("Digite uma opção válida!");
            fimMetodo();
        }
    }

    public void listarLivros() {
        for (int i = 0; i < titulosLivros.size(); i++) {
            System.out.printf("Título: %s | Autor: %s | Código: %s\n", titulosLivros.get(i),
                    autoresLivros.get(i), codigosLivros.get(i));
        }
        fimMetodo();
    }

    public void cadastrarLivro() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }

        while (true) {
            System.out.println("----- CADASTRO -----");
            System.out.print("Título do livro: ");
            String titulo = scTxt.nextLine();
            System.out.print("Nome do autor: ");
            String autor = scTxt.nextLine();
            System.out.print("Código do livro: ");
            String codigo = scTxt.nextLine();

            titulosLivros.add(titulo);
            autoresLivros.add(autor);
            codigosLivros.add(codigo);

            System.out.println("Livro cadastrado com sucesso!");

            System.out.print("Deseja cadastrar outro livro? (s/n): ");
            String desejaCadastrar = scTxt.nextLine();

            if (desejaCadastrar.equals("n")){
                break;
            }
        }

        fimMetodo();
    }

    public void removerLivro() {
        for (int i = 0; i < titulosLivros.size(); i++) {
            System.out.printf("Título: %s | Autor: %s | Código: %s\n", titulosLivros.get(i),
                    autoresLivros.get(i), codigosLivros.get(i));
        }

        System.out.print("Digite o código do livro que deseja remover: ");
        String escolha = scTxt.nextLine();

        for (int i = 0; i < codigosLivros.size(); i++) {
            if (codigosLivros.get(i).equals(escolha)) {
                codigosLivros.remove(i);
                titulosLivros.remove(i);
                autoresLivros.remove(i);
            }
        }

        fimMetodo();
    }

    public void consultaPorNome(){
        System.out.print("Digite o titulo que deseja pesquisar: ");
        String titulo = scTxt.nextLine();
        pesquisa(titulo, 1);
    }

    public void consultaPorAutor(){
        System.out.print("Digite o nome do autor que deseja pesquisar: ");
        String autor = scTxt.nextLine();
        pesquisa(autor, 2);
    }

    public void pesquisa(String txtPesquisa, Integer tipoPesquisa) {

        if (tipoPesquisa.equals(1)) { // consulta por titulo
            for (int i = 0; i < titulosLivros.size(); i++) {
                if (titulosLivros.get(i).equals(txtPesquisa)) {
                    System.out.printf("Título: %s | Autor: %s | Código: %s\n", titulosLivros.get(i),
                            autoresLivros.get(i), codigosLivros.get(i));
                }
            }

        } else { // consulta por autor
            for (int i = 0; i < autoresLivros.size(); i++) {
                if (autoresLivros.get(i).equals(txtPesquisa)) {
                    System.out.printf("Título: %s | Autor: %s | Código: %s\n", titulosLivros.get(i),
                            autoresLivros.get(i), codigosLivros.get(i));
                }
            }
        }


        System.out.println();
        System.out.println("Deseja pesquisar de novo? (s/n): ");
        String escolha = scTxt.nextLine();

        if (escolha.equals("s") && tipoPesquisa.equals(1)) {
            consultaPorNome();
        } else if (escolha.equals("s") && tipoPesquisa.equals(2)) {
            consultaPorAutor();
        } else {
            fimMetodo();
        }
    }

}
