package br.com.capivarawars.core.game;

//<editor-fold defaultstate="collapsed" desc="imports...">
import java.util.List;
import java.util.ArrayList;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 23 de set de 2019, 09:14:26
 * Last update: -
 *///</editor-fold>
public class MarcadorDeTempo {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private float tempoLimite;
    private boolean exibirToStringBasico;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    private long tempoInicial;
    private long tempoPausa;
    private long tempoSaldoInicial;
    private boolean iniciouTempo;
    private boolean pausouTempo;    
    private float tempoAuxiliar;
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public MarcadorDeTempo(float tempoLimiteEmSegundos) {
        this(tempoLimiteEmSegundos, false);
    }

    public MarcadorDeTempo(float tempoLimiteEmSegundos, boolean exibirToStringBasico) {
        setTempoLimite(tempoLimiteEmSegundos);
        setExibirToStringBasico(exibirToStringBasico);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
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
    
    public boolean isExibirToStringBasico(){
        return exibirToStringBasico;
    }
    
    public void setExibirToStringBasico(boolean exibirToStringBasico) {
        this.exibirToStringBasico = exibirToStringBasico;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        if (exibirToStringBasico) {
            return getTempoDecorrido().toString();
        }

        return "MarcadorDeTempo {"
                + "\n tempoDecorrido = " + getTempoDecorrido()
                + "\n tempoLimite = " + tempoLimite
                + "\n iniciouTempo = " + iniciouTempo
                + "\n pausouTempo = " + pausouTempo
                + "\n atingiuTempoLimite = " + isAtingiuLimiteTempo()
                + "\n}";
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
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

    public Float getTempoDecorrido() {
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
    
    public Integer getTempoDecorridoComoInteger() {
        return getTempoDecorrido().intValue();
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
    //</editor-fold>
    
    //</editor-fold>
    
}//class
