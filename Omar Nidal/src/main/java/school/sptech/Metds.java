package school.sptech;


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Metds {

    public Double Cassino(){
        Scanner leitor = new Scanner(System.in);

        System.out.println("""
                 .----------------.  .----------------.  .-----------------. .----------------.\s
                | .--------------. || .--------------. || .--------------. || .--------------. |
                | | ____    ____ | || |  _________   | || | ____  _____  | || | _____  _____ | |
                | ||_   \\  /   _|| || | |_   ___  |  | || ||_   \\|_   _| | || ||_   _||_   _|| |
                | |  |   \\/   |  | || |   | |_  \\_|  | || |  |   \\ | |   | || |  | |    | |  | |
                | |  | |\\  /| |  | || |   |  _|  _   | || |  | |\\ \\| |   | || |  | '    ' |  | |
                | | _| |_\\/_| |_ | || |  _| |___/ |  | || | _| |_\\   |_  | || |   \\ `--' /   | |
                | ||_____||_____|| || | |_________|  | || ||_____|\\____| | || |    `.__.'    | |
                | |              | || |              | || |              | || |              | |
                | '--------------' || '--------------' || '--------------' || '--------------' |
                 '----------------'  '----------------'  '----------------'  '----------------'\s""");
        System.out.println("Olá! Seja Bem Vindo ao Cassino");


        System.out.println("Digite seu nome: ");
        String nome = leitor.nextLine();

        Double saldo = 0d;

        while (saldo < 20) {
            System.out.println("O Depósito minímo válido é de R$20");
            System.out.println("Digite o quanto você deseja depositar: ");

            if (leitor.hasNextDouble()) {
                saldo = leitor.nextDouble();

                if (saldo < 20) {
                    System.out.println("Depósito inválido.");
                }
            } else {
                System.out.println("Digite apenas números.");
                leitor.next();
            }
        }
        System.out.println("Depósito concluído com sucesso!");


        while (saldo > 0) {
            System.out.println("Olá " + nome + "\n" + "Saldo Atual: R$" + saldo);
            System.out.println("Digite o valor da sua aposta (mínimo R$1)");
            System.out.println("Caso queira sair, digite 0");

            if (leitor.hasNextDouble()) {
                Double aposta = leitor.nextDouble();

                if (aposta == 0) {
                    System.out.println("Até a proxima " + nome + "! :)");
                    return saldo;
                } else if (aposta < 1 || aposta > saldo) {
                    System.out.println("Valor inválido! Digite entre R$1 e R$" + saldo);
                } else {
                    Double posaposta = saldo - aposta;
                    System.out.println("Aposta concluida com sucesso!");
                    System.out.println("Saldo Atual: R$" + posaposta);
                }

                if (aposta >= 1 && aposta <= saldo) {
                    Integer escolha = 0;
                    while (escolha < 1 || escolha > 3) {
                        System.out.println("""
                                Escolha uma cor:
                                (1) Vermelho
                                (2) Preto
                                (3) Branco
                                Em qual cor você deseja apostar? """);

                        escolha = leitor.nextInt();

                    }

                    String[] roleta = {
                            "Tente novamente", "Tente novamente", "Tente novamente", "Tente novamente", "Tente novamente", "Tente novamente", "Tente novamente", "Tente novamente", "Tente novamente", "Tente novamente",
                            "Vermelho", "Vermelho", "Vermelho", "Vermelho", "Vermelho",
                            "Preto", "Preto", "Preto",
                            "Branco"
                    };
                    Integer sorteio = ThreadLocalRandom.current().nextInt(roleta.length);

                    String resultado = roleta[sorteio];

                    System.out.println("Roleta parou em: " + resultado);

                    String cor = "";

                    if (escolha == 1) {
                        cor = "Vermelho";
                    } else if (escolha == 2) {
                        cor = "Preto";
                    } else {
                        cor = "Branco";
                    }

                    if (resultado.equals(cor)) {
                        Double ganhou = 0d;

                        if (cor.equals("Vermelho")) {
                            ganhou = aposta * 2;
                        } else if (cor.equals("Preto")) {
                            ganhou = aposta * 5;
                        } else {
                            ganhou = aposta * 15;
                        }
                        saldo = saldo - aposta + ganhou;
                        System.out.println("Você ganhou R$" + ganhou);
                        System.out.println("Saldo Atual: R$" + saldo);
                    } else {
                        saldo -= aposta;
                        System.out.println("Você perdeu R$" + aposta);
                        System.out.println("Saldo Atual: R$" + saldo);
                    }

                }
            } else {
                System.out.println("Digite apenas números.");
                leitor.next();
            }
        }
        System.out.println("Saldo Esgotado!");
        System.out.println("Obrigado " + nome + ", pela sua participação.");
        return saldo;
    }
}
