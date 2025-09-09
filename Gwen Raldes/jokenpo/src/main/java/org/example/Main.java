package org.example;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Random rnd = new Random();

            String[] opcoes = {"Pedra", "Papel", "Tesoura"};

            int rodadas = 0;
            int vitorias = 0;
            int derrotas = 0;
            int empates = 0;

            System.out.println("=== JOKENPÔ ===");
            System.out.println("Digite 0=Pedra, 1=Papel, 2=Tesoura, 9=Sair");

            while (true) {
                System.out.print("\nSua jogada: ");
                String entrada = in.nextLine();

                if (entrada.equals("9")) {
                    System.out.println("\nJogo encerrado!");
                    break;
                }


                if (entrada.equals("") || (!entrada.equals("0") && !entrada.equals("1") && !entrada.equals("2"))) {
                    System.out.println("Entrada inválida!");
                    continue;
                }

                int jogador = Integer.parseInt(entrada);
                int oponente = rnd.nextInt(3);

                System.out.println("Você jogou: " + opcoes[jogador]);
                System.out.println("Oponente jogou: " + opcoes[oponente]);

                rodadas++;

                if (jogador == oponente) {
                    System.out.println("Resultado: Empate!");
                    empates++;
                } else if ((jogador == 0 && oponente == 2) ||
                        (jogador == 1 && oponente == 0) ||
                        (jogador == 2 && oponente == 1)) {
                    System.out.println("Resultado: Você venceu!");
                    vitorias++;
                } else {
                    System.out.println("Resultado: Oponente venceu!");
                    derrotas++;
                }
            }

            System.out.println("\n=== RELATÓRIO FINAL ===");
            System.out.println("Total de rodadas: " + rodadas);
            System.out.println("Vitórias: " + vitorias);
            System.out.println("Empates: " + empates);
            System.out.println("Derrotas: " + derrotas);

            in.close();
        }
    }
