package sptech.school;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MonitoramentoCameras implements Runnable {
    private ArrayList<Camera> cameras;
    private Random random = new Random();
    private Boolean monitorando = false;
    private String cen1 = """
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            | REC º                           |
            |              \\o/                |
            |               |                 |
            |              / \\                |
            |                                 |
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            """;
    private String cen2 = """
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            | REC º                           |
            |                                 |
            |                                 |
            |                                 |
            |                                 |
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            """;

    public MonitoramentoCameras(ArrayList<Camera> cameras) {
        this.cameras = cameras;
    }
    public Boolean getMonitorando(){
        return  monitorando;
    }

    public void ativar() {
        monitorando = true;
    }

    public void desativar() {
        monitorando = false;
    }

    public void run() {
        while (true) {
            try {
                if (monitorando) {
                    Thread.sleep(1000);
                    int sorteio = ThreadLocalRandom.current().nextInt(0, 13);
                    if (sorteio == 7) {
                        ArrayList<Camera> ativas = new ArrayList<>();
                        for (Camera c : cameras) {
                            if (c.getAtiva()) ativas.add(c);
                        }
                        if (!ativas.isEmpty()) {
                            Camera escolhida = ativas.get(random.nextInt(ativas.size()));

                            if (escolhida.getCenario().equals(cen1)) {
                                escolhida.setCenario(cen2);
                            } else {
                                escolhida.setCenario(cen1);
                            }
                            System.out.printf("\n🚨 ALERTA: Houve uma movimentação na câmera %d da agência %s\nDigite o que deseja fazer: ", escolhida.getIdentificador(), escolhida.getAgencia());
                            desativar();
                        }
                    }
                } else {
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
