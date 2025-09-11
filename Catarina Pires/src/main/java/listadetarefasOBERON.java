import java.util.Scanner;

public class listadetarefasOBERON {

    public static void main(String[] args) {

        Boolean repeticao = true;

        Task[] tasks = new Task[50];
        int contadorTarefal = 0;

        do {
            System.out.println("""
                       Bem-Vindo a Lista de Tarefas OBERON 👁️
                    --------------------------------------------
                                  O que deseja fazer?
                    --------------------------------------------
                           1- Adicionar tarefas na lista
                           2- Visualizar lista
                           3- Visualizar tarefa
                           4- Alterar status da tarefa
                           5- Encerrar programa
                    --------------------------------------------
                    
                    """);

            Scanner scNumeros = new Scanner(System.in);
            Scanner scTexto = new Scanner(System.in);

            Integer X = scNumeros.nextInt();

            if (X == 1) {

                Task novaTask = new Task();

                System.out.println("Informe o nome da sua nova tarefa:");
                novaTask.nome = scTexto.nextLine();

                System.out.println("Informe a descrição da sua tarefa:");
                novaTask.descricao = scTexto.nextLine();

                System.out.println("""
                        Informe a prioridade da sua nova tarefa:
                        ----------------------------------------
                        1- Máxima
                        2- Média
                        3- Mínima
                        ----------------------------------------
                        """);
                Integer prioridade = scNumeros.nextInt();
                switch (prioridade) {
                    case 1 -> novaTask.prioridade = "Máxima";
                    case 2 -> novaTask.prioridade = "Média";
                    case 3 -> novaTask.prioridade = "Mínima";
                    default -> System.out.println("Informação inválida");
                }

                System.out.println("""
                        Informe a classificação da sua nova tarefa:
                        -------------------------------------------
                        1- Essencial
                        2- Importante
                        3- Desejável
                        -------------------------------------------
                        """);
                Integer classificacao = scNumeros.nextInt();
                switch (classificacao) {
                    case 1 -> novaTask.classificacao = "Essencial";
                    case 2 -> novaTask.classificacao = "Importante";
                    case 3 -> novaTask.classificacao = "Desejável";
                    default -> System.out.println("Informação Inválida");
                }

                System.out.println("""
                        Informe o status da sua nova tarefa:
                        -------------------------------------------
                        1- A fazer
                        2- Em andamento
                        3- Finalizada
                        -------------------------------------------
                        """);
                Integer status = scNumeros.nextInt();
                switch (status) {
                    case 1 -> novaTask.status = "A fazer";
                    case 2 -> novaTask.status = "Em andamento";
                    case 3 -> novaTask.status = "Finalizada";
                }

                tasks[contadorTarefal] = novaTask;
                contadorTarefal++;
            }

            if (X == 2) {

                System.out.println("""
                                ----------------------
                                |  Lista de Tarefas  |
                                ______________________
                            """);

                for (int i = 0; i < tasks.length; i++) {
                    if (tasks[i] == null) {
                        break;
                    }
//                    System.out.println(tasks[i].nome);
                    System.out.printf("""
                                   ________________________
                              %d-   %s
                                   ________________________
                            """, i + 1,  tasks[i].nome);
                }
            }

            if (X == 3) {
                System.out.println("Qual tarefa você deseja visualizar? (Inserir número correspondente)");
                Integer taskDesejada = scNumeros.nextInt() - 1;
                System.out.printf("""
                        Nome da Tarefa:
                        %s
                        ----------------------------------
                        Descrição:
                        %s
                        ----------------------------------
                        Prioridade:
                        %s
                        ----------------------------------
                        Classificação:
                        %s
                        ----------------------------------
                        Status:
                        %s
                        ----------------------------------
                        """, tasks[taskDesejada].nome, tasks[taskDesejada].descricao, tasks[taskDesejada].prioridade,
                        tasks[taskDesejada].classificacao, tasks[taskDesejada].status);
            }

            if (X == 5) {
                repeticao = false;
            }

            if (X == 4) {
                System.out.println("Você deseja alterar o status de qual tarefa? (Inserir número correspondente)");
                Integer taskDesejada01 = scNumeros.nextInt() - 1;
                System.out.println("""
                        Informe o novo status da sua tarefa:
                        -------------------------------------------
                        1- A fazer
                        2- Em andamento
                        3- Finalizada
                        -------------------------------------------
                        """);

                Integer novoStatus = scNumeros.nextInt();
                String stringStatus = switch (novoStatus) {
                    case 1 -> "A fazer";
                    case 2 -> "Em andamento";
                    case 3 -> "Finalizada";
                    default -> null;
                };
                tasks[taskDesejada01].status = stringStatus;
            }

        } while (repeticao);

    }

}