package br.com.capivarawars.core.game;

public class MarcadorDeTempo {

    private float tempoLimite;

    private long tempoInicial;
    private long tempoPausa;
    private long tempoSaldoInicial;
    private boolean iniciouTempo;
    private boolean pausouTempo;
    private boolean exibirToStringBasico;
    private float tempoAuxiliar;

    public MarcadorDeTempo(float tempoLimiteEmSegundos) {
        setTempoLimite(tempoLimiteEmSegundos);
    }

    public MarcadorDeTempo(float tempoLimiteEmSegundos, boolean exibirToStringBasico) {
        setTempoLimite(tempoLimiteEmSegundos);
        setExibirToStringBasico(exibirToStringBasico);
    }

    public float getTempoLimite() {
        return tempoLimite;
    }

    public void setTempoLimite(float novoTempoLimiteEmSegundos) {
        if (novoTempoLimiteEmSegundos >= 0) {
            tempoLimite = novoTempoLimiteEmSegundos;
        } else {
            tempoLimite = 0;
        }
    }

    public void setExibirToStringBasico(boolean exibirToStringBasico) {
        this.exibirToStringBasico = exibirToStringBasico;
    }

    public void iniciarTempo() {
        if (!iniciouTempo) {
            iniciouTempo = true;
            tempoInicial = System.currentTimeMillis();
        }
    }

    public void pararTempo() {
        if (iniciouTempo) {
            iniciouTempo = false;
            pausouTempo = false;

            tempoSaldoInicial = 0;
            tempoPausa = 0;
        }
    }

    public void pausarTempo() {
        if (iniciouTempo && !pausouTempo) {
            pausouTempo = true;
            tempoPausa = System.currentTimeMillis();
        }

        if (iniciouTempo && pausouTempo) {
            tempoPausa = System.currentTimeMillis();
        }
    }

    public void retomarTempo() {
        if (iniciouTempo && pausouTempo) {
            tempoSaldoInicial += (tempoPausa - tempoInicial) / 1000f;
            pausouTempo = false;
            tempoInicial = System.currentTimeMillis();
        }
    }

    public void reiniciarTempo() {
        pararTempo();
        iniciarTempo();
    }

    public float getTempoDecorrido() {
        if (iniciouTempo && !pausouTempo) {
            tempoAuxiliar = ((System.currentTimeMillis() - tempoInicial) / 1000f) + tempoSaldoInicial;

            if (tempoAuxiliar >= tempoLimite) {
                return tempoLimite;
            } else {
                return tempoAuxiliar;
            }
        }

        if (iniciouTempo && pausouTempo) {
            tempoAuxiliar = ((tempoPausa - tempoInicial) / 1000f) + tempoSaldoInicial;

            if (tempoAuxiliar >= tempoLimite) {
                return tempoLimite;
            } else {
                return tempoAuxiliar;
            }
        }

        return 0f;
    }

    public boolean isAtingiuLimiteTempo() {
        if (iniciouTempo) {
            return getTempoDecorrido() >= tempoLimite;
        }

        return false;
    }

    public boolean isIniciouTempo() {
        return iniciouTempo;
    }

    public boolean isPausouTempo() {
        return pausouTempo;
    }

    @Override
    public String toString() {
        if (exibirToStringBasico) {
            return "Tempo: " + getTempoDecorrido();
        }

        return "MarcadorDeTempo {"
                + "\n tempoDecorrido = " + getTempoDecorrido()
                + "\n tempoLimite = " + tempoLimite
                + "\n iniciouTempo = " + iniciouTempo
                + "\n pausouTempo = " + pausouTempo
                + "\n atingiuTempoLimite = " + isAtingiuLimiteTempo()
                + "\n}";
    }

}
