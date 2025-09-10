package school.sptech;

import java.util.Scanner;

public class Mup {

    public void iniciar() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Bem-vindo a Igreja União Pentecostal");

        // Solicitando o nome do usuário
        System.out.print("Digite seu nome: ");
        String nome = leitor.nextLine(); // Lê o nome digitado ex: Fernanda C

        // Variável para armazenar a opção escolhida pelo usuário
        int opcao = -1; // começa com -1 para garantir que o menu apareça pelo menos uma vez

        // Roda enquanto a opção for diferente de 0
        while (opcao != 0) {
            System.out.println("\nOlá, " + nome + "! Escolha uma opção:");
            System.out.println("1 - Versículo do dia");
            System.out.println("2 - Agenda de cultos");
            System.out.println("3 - Informações da igreja");
            System.out.println("0 - Sair");

            // Verificando se o usuário digitou número
            if (leitor.hasNextInt()) {
                opcao = leitor.nextInt(); // Lê o número digitado
                leitor.nextLine(); //

                // Condições switch para cada opção do menu
                switch (opcao) {
                    case 1 -> {
                        System.out.println("\n📖 Versículo do dia:");
                        System.out.println("\"O Senhor é o meu pastor; nada me faltará.\" - Salmo 23:1");
                    }
                    case 2 -> {
                        System.out.println("\n📅 Agenda de cultos:");
                        System.out.println("• Quarta-feira - Culto da campanha (20h00)");
                        System.out.println("• Sexta-feira - Oração (09h00)");
                        System.out.println("• Domingo - Culto da família (18h)");
                    }
                    case 3 -> {
                        System.out.println("\nℹ️ Informações da igreja:");
                        System.out.println("Endereço: Rua da Esperança, 123 - Parque São Francisco");
                        System.out.println("Pastor Responsável: Pr. Renato Menezes");
                        System.out.println("Telefone: (11) 95900-9090");
                    }
                    case 0 -> {
                        System.out.println("\nAté logo, " + nome + "! Que Deus te abençoe 🙏");
                    }
                    default -> {
                        System.out.println("Opção inválida, tente novamente.");
                    }
                }
            } else {
                // Usuário só pode digitar número
                System.out.println("Digite apenas números.");
                leitor.next();
            }
        }

        // Fechando o Scanner
        leitor.close();
    }

    public static void main(String[] args) {
        new Mup().iniciar();
    }
}