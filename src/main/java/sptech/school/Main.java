package sptech.school;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String listarCameras(ArrayList<Camera> cameras) {
        String resp = "==============================LISTA DE CÂMERAS=============================\n\n";
        for (Camera camera : cameras) {
            resp += "\n---------------------------------------------------------------------------\n";
            String statusCam = camera.getAtiva() ? "Ativa" : "Desativada";

            resp += ("Id: %d -> Agência: %s | Status: %s").formatted(camera.getIdentificador(), camera.getAgencia(), statusCam);
        }
        return resp;
    }

    static String exibirMenu() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }

        return ("""
                ===========================================================================
                                                MENU
                ===========================================================================
                                         DIGITE O QUE DESEJA
                                         -------------------
                (0) - Cadastrar uma câmera
                (1) - Listar todas as câmeras
                (2) - Observar câmeras
                (3) - Alterar status da câmera
                (4) - Sair
                ===========================================================================
                
                Selecione uma opção: 
                """);
    }

    static Boolean voltarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDeseja voltar para o menu? (s/n): ");
        String resp = sc.next();
        while (!resp.equals("s") && !resp.equals("n")) {
            System.out.println("\n-------\nEntrada inválida digite novamente\n-------");
            System.out.println("\nDeseja voltar para o menu? (s/n): ");
            resp = sc.next();
        }
        return !resp.equals("n");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Camera> cameras = new ArrayList<>();
        cameras.add(new Camera(1, "Itau 01", true));
        cameras.add(new Camera(2, "Safra 02", false));

        MonitoramentoCameras monitor = new MonitoramentoCameras(cameras);
        Thread t = new Thread(monitor);
        t.start();

        Boolean continuarProg = true;
        while (continuarProg) {

            System.out.println(exibirMenu());
            monitor.ativar();
            Integer opcao = 0;
            try {
                Boolean opcaoValida = false;
                while (!opcaoValida) {
                    try {
                        opcao = sc.nextInt();
                        sc.nextLine();
                        if (opcao >= 0) { // ADICIONAR LIMITE
                            opcaoValida = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida digite novamente.");
                        sc.nextLine();
                    }
                }
                switch (opcao) {
                    case 0 -> {
                        monitor.desativar();
                        Boolean ativa = false;
                        Boolean ativaValida = false;

                        System.out.println("Digite o número ou nome da agência referente a câmera: ");
                        String agencia = sc.nextLine();

                        while (!ativaValida) {
                            System.out.println("A câmera está ativa? (s/n): ");
                            String resp = sc.next();
                            if (resp.equals("s") || resp.equals("n")) {
                                ativaValida = true;
                                ativa = resp.equals("s");
                            } else {
                                System.out.println("\n-------\nEntrada inválida digite novamente\n-------");
                            }
                        }
                        cameras.add(new Camera(cameras.size() + 1, agencia, ativa));
                        System.out.println("\nCadastro realizado com sucesso!");
                        continuarProg = voltarMenu();
                    }
                    case 1 -> {
                        monitor.desativar();
                        System.out.println(listarCameras(cameras));
                        continuarProg = voltarMenu();
                    }
                    case 2 -> {
                        monitor.desativar();
                        Boolean contObservando = false;
                        while (!contObservando) {
                            System.out.println("Digite o Id da câmera: ");
                            Integer idCam = sc.nextInt();
                            for (Camera c : cameras) {
                                if (c.getIdentificador().equals(idCam)) {
                                    System.out.println(c.getCenario());
                                }
                            }
                            System.out.println("\nDeseja observar outras câmeras? (s/n): ");
                            String escolha = sc.next();
                            while (!escolha.equals("s") && !escolha.equals("n")) {
                                System.out.println("\nErro! Deseja observar outras câmeras? (s/n): ");
                                escolha = sc.next();
                            }
                            if (escolha.equals("n")) {
                                contObservando = true;
                            }
                        }

                        continuarProg = voltarMenu();
                    }
                    case 3 -> {
                        Boolean contAtualizar = false;
                        while (!contAtualizar) {
                            System.out.println("Digite o Id da câmera: ");
                            Integer idCam = sc.nextInt();
                            for (Camera c : cameras) {
                                if (c.getIdentificador().equals(idCam)) {
                                    c.setAtiva(!c.getAtiva().equals(true));
                                    System.out.println("\nStatus da câmera atualizado!");
                                    break;
                                }
                            }

                            System.out.println("\nDeseja atualizar o status de mais câmeras? (s/n): ");
                            String escolha = sc.next();
                            while (!escolha.equals("s") && !escolha.equals("n")) {
                                System.out.println("\nErro! Deseja atualizar o status de mais câmeras? (s/n): ");
                                escolha = sc.next();
                            }
                            if (escolha.equals("n")) {
                                contAtualizar = true;
                            }
                        }
                        continuarProg = voltarMenu();
                    }
                    case 4 -> {
                        continuarProg = false;
                        monitor.desativar();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida digite novamente.");
                sc.nextLine();
            }
        }
        t.interrupt();
    }

}