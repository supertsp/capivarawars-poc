package br.com.kingsofriver;

public class PlayGame {

    public static void main(String[] args) {

        BarraEnergia<Integer> barra = new BarraEnergia<>(0, 50);
        barra.setValorAtual(1);
        System.out.println(barra);

        barra.incrementarValorAtual();
        System.out.println(barra);
        
        startRelogio();
    }

    public static void startRelogio() {

        
        new Thread(() -> {
            int contMili = 0;
            float contSegundos = 0f;
            
            MarcadorDeTempo mt = new MarcadorDeTempo(5f);
//            mt.iniciar();
            
            while (true) {
//                System.out.println("Timer: " + contSegundos);
//                try {
//                    Thread.sleep(1);
//                } catch (Exception e) {
//                }
//                contMili++;
//                contSegundos = contMili / 1000f;
//                System.out.println("Timer: " + System.currentTimeMillis());
                System.out.println("Timer: " + mt.getTempoAtual());
            }
        }).start();

    }

}
