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
 * @param <T> Tipos permitidos de BarraDeEnergia: Integer, Float e Double 
 *///</editor-fold>
public class BarraDeEnergia<T> extends Component{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private T valorAtual;
    private T valorMinimoPermitido;
    private T valorMaximoPermitido;
    private boolean regeneracaoAutomatica;
    private MarcadorDeTempo marcadorDeTempo;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public BarraDeEnergia(T valorMinimoPermitido, T valorMaximoPermitido, float tempoDeEsperaParaRegenerar) {
        setValoresPermitidos(valorMinimoPermitido, valorMaximoPermitido);
        setValorAtual(valorMaximoPermitido);
        marcadorDeTempo = new MarcadorDeTempo(tempoDeEsperaParaRegenerar);
    }
    
    public BarraDeEnergia(T valorMinimoPermitido, T valorMaximoPermitido, 
            float tempoDeEsperaParaRegenerar, boolean regeneracaoAutomatica) {
        this(valorMinimoPermitido, valorMaximoPermitido, tempoDeEsperaParaRegenerar);
        this.regeneracaoAutomatica = regeneracaoAutomatica;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public T getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(T valorAtual) {
        if (isValorDentroDosLimites(valorAtual)) {
            this.valorAtual = valorAtual;
        } else {
            if (isValorMenorQueLimite(valorAtual)) {
                valorAtual = valorMinimoPermitido;
            } else {
                valorAtual = valorMaximoPermitido;
            }
        }
    }

    public T getValorMinimoPermitido() {
        return valorMinimoPermitido;
    }

    public void setValorMinimoPermitido(T valorMinimoPermitido) {
        if (isTipoTValido(valorMinimoPermitido)) {
            this.valorMinimoPermitido = valorMinimoPermitido;
        }
    }

    public T getValorMaximoPermitido() {
        return valorMaximoPermitido;
    }

    public void setValorMaximoPermitido(T valorMaximoPermitido) {
        if (isTipoTValido(valorMaximoPermitido)) {
            this.valorMaximoPermitido = valorMaximoPermitido;
        }
    }

    public void setValoresPermitidos(T valorMinimoPermitido, T valorMaximoPermitido) {
        setValorMinimoPermitido(valorMinimoPermitido);
        setValorMaximoPermitido(valorMaximoPermitido);
    }
    
    public void setRegeneracaoAutomatica(boolean regeneracaoAutomatica){
        this.regeneracaoAutomatica = regeneracaoAutomatica;
    }
    
    public boolean isRegeneracaoAutomatica(){
        return regeneracaoAutomatica;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        return "BarraDeEnergia<" + valorMinimoPermitido.getClass().getSimpleName() +  "> {"
                + "\n valorAtual = " + valorAtual
                + "\n valorMinimoPermitido = " + valorMinimoPermitido
                + "\n valorMaximoPermitido = " + valorMaximoPermitido
                + "\n iniciouRegeneracao = " + marcadorDeTempo.isIniciouTempo()
                + "\n terminouTempoRegeneracao = " + terminouTempoRegeneracao()
                + "\n}";
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private boolean isTipoTValido(T tipo) {
        return tipo instanceof Integer
                || tipo instanceof Float
                || tipo instanceof Double;
    }

    private boolean isValorDentroDosLimites(T valor) {
        return isTipoTValido(valor)
                && converterParaDouble(valor) >= converterParaDouble(valorMinimoPermitido)
                && converterParaDouble(valor) <= converterParaDouble(valorMaximoPermitido);
    }

    private boolean isValorDentroDosLimites(double valorAtual) {
        return valorAtual >= converterParaDouble(valorMinimoPermitido)
                && valorAtual <= converterParaDouble(valorMaximoPermitido);
    }

    private boolean isValorMenorQueLimite(T valor) {
        return isTipoTValido(valor)
                && converterParaDouble(valor) < converterParaDouble(valorMinimoPermitido);
    }

    private double converterParaDouble(T valor) {
        double temp = 0;

        if (valor instanceof Integer) {
            temp = (Integer) valor;
        } else if (valor instanceof Float) {
            temp = (Float) valor;
        } else if (valor instanceof Double) {
            temp = (Double) valor;
        }

        return temp;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    @SuppressWarnings("unchecked")
    public void incrementarValorAtual(T valorIncremento) {
        if (isTipoTValido(valorIncremento)) {

            if (isValorDentroDosLimites(converterParaDouble(valorAtual) + converterParaDouble(valorIncremento))) {
                if (valorAtual instanceof Integer) {
                    Integer incremento = (int) (converterParaDouble(valorAtual) + converterParaDouble(valorIncremento));
                    valorAtual = (T) incremento;
                } else if (valorAtual instanceof Float) {
                    Float incremento = (float) (converterParaDouble(valorAtual) + converterParaDouble(valorIncremento));
                    valorAtual = (T) incremento;
                } else if (valorAtual instanceof Double) {
                    Double incremento = converterParaDouble(valorAtual) + converterParaDouble(valorIncremento);
                    valorAtual = (T) incremento;
                }
            } else if ((converterParaDouble(valorAtual) + converterParaDouble(valorIncremento)) < converterParaDouble(valorMinimoPermitido)) {
                valorAtual = valorMinimoPermitido;
                iniciarTempoRegeneracao();
            } else {
                valorAtual = valorMaximoPermitido;
            }

        }
    }

    @SuppressWarnings("unchecked")
    public void incrementarValorAtual() {
        incrementarValorAtual((T) new Double(1));
    }

    public void iniciarTempoRegeneracao() {
        marcadorDeTempo.iniciarTempo();
    }

    public Float getTempoDecorridoParaRegeneracao() {
        if (isRegeneracaoAutomatica() && marcadorDeTempo.isAtingiuLimiteTempo()) {
            regenerar();
        }
        
        return marcadorDeTempo.getTempoDecorrido();
    }
    
    public Integer getTempoDecorridoParaRegeneracaoComoInteger() {
        return getTempoDecorridoParaRegeneracao().intValue();
    }

    public boolean terminouTempoRegeneracao() {
        if (isRegeneracaoAutomatica() && marcadorDeTempo.isAtingiuLimiteTempo()) {
            regenerar();
        }
        
        return marcadorDeTempo.isAtingiuLimiteTempo();
    }
    
    public boolean iniciouTempoRegeneracao(){
        return marcadorDeTempo.isIniciouTempo();
    }

    public void regenerar() {
        regenerar(valorMaximoPermitido);
    }

    public void regenerar(T valorDeRegeneracao) {
        if (iniciouTempoRegeneracao() && marcadorDeTempo.isAtingiuLimiteTempo()) {
            incrementarValorAtual(valorDeRegeneracao);
            marcadorDeTempo.pararTempo();
        }
    }
    //</editor-fold>
    
    //</editor-fold>
    
}//class
