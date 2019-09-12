package br.com.CapivaraWars.core;

public class BarraEnergia<T> {

	private T valorAtual;
	private T valorMinimoPermitido; 
	private T valorMaximoPermitido;
	private MarcadorDeTempo marcadorDeTempo;
	
	public BarraEnergia(T valorMinimoPermitido, T valorMaximoPermitido, float tempoDeEsperaParaRegenerar) {
		setValoresPermitidos(valorMinimoPermitido, valorMaximoPermitido);
		setValorAtual(valorMaximoPermitido);
		marcadorDeTempo = new MarcadorDeTempo(tempoDeEsperaParaRegenerar);
	}
	
	private boolean isTipoTValido(T tipo) {
		return	tipo instanceof Integer ||
				tipo instanceof Float ||
				tipo instanceof Double;
	}
			
	private boolean isValorDentroDosLimites(T valor) {
		return	isTipoTValido(valor) &&
				converterParaDouble(valor) >= converterParaDouble(valorMinimoPermitido) &&
				converterParaDouble(valor) <= converterParaDouble(valorMaximoPermitido);
	}
	
	private boolean isValorDentroDosLimites(double valorAtual) {		
		return	valorAtual >= converterParaDouble(valorMinimoPermitido) &&
				valorAtual <= converterParaDouble(valorMaximoPermitido);
	}
			
	private boolean isValorMenorQueLimite(T valor) {
		return	isTipoTValido(valor) &&
				converterParaDouble(valor) < converterParaDouble(valorMinimoPermitido); 
	}
	
	private double converterParaDouble(T valor) {
		double temp = 0;
		
		if (valor instanceof Integer) {
			temp = (Integer) valor;
		}
		else if (valor instanceof Float) {
			temp = (Float) valor;
		}
		else if (valor instanceof Double) {
			temp = (Double) valor;
		}
		
		return temp;
	}
	
	
	public T getValorAtual() {
		return valorAtual;
	}
	
	public void setValorAtual(T valorAtual) {
		if (isValorDentroDosLimites(valorAtual)) {
			this.valorAtual = valorAtual;
		}
		else {
			if (isValorMenorQueLimite(valorAtual)) {
				valorAtual = valorMinimoPermitido;
			}
			else {
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
	
	@SuppressWarnings("unchecked")
	public void incrementarValorAtual(T valorIncremento) {
		if (isTipoTValido(valorIncremento)) { 
				
			if (isValorDentroDosLimites( converterParaDouble(valorAtual) + converterParaDouble(valorIncremento) )) {
				if (valorAtual instanceof Integer) {
					Integer incremento = (int)(converterParaDouble(valorAtual) + converterParaDouble(valorIncremento));
					valorAtual = (T)incremento;
				}
				else if (valorAtual instanceof Float) {
					Float incremento = (float)(converterParaDouble(valorAtual) + converterParaDouble(valorIncremento));
					valorAtual = (T)incremento;
				}
				else if (valorAtual instanceof Double) {
					Double incremento = converterParaDouble(valorAtual) + converterParaDouble(valorIncremento);
					valorAtual = (T)incremento;
				}
			}
			else if ((converterParaDouble(valorAtual) + converterParaDouble(valorIncremento)) < converterParaDouble(valorMinimoPermitido)) {
				valorAtual = valorMinimoPermitido;
				iniciarTempoRegeneracao();
			}
			else {
				valorAtual = valorMaximoPermitido;
			}
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public void incrementarValorAtual() {
		incrementarValorAtual((T)new Double(1));
	}
	
	public void iniciarTempoRegeneracao() {
		marcadorDeTempo.iniciarTempo();
	}
	
	public float getTempoDecorridoParaRegeneracao() {
		return marcadorDeTempo.getTempoDecorrido();
	}
	
	public boolean terminouTempoRegeneracao() {
		return marcadorDeTempo.isAtingiuLimiteTempo();
	}
	
	public void regenerar() {
		regenerar(valorMaximoPermitido);
	}
	
	public void regenerar(T valorDeRegeneracao) {
		if (terminouTempoRegeneracao()) {
			incrementarValorAtual(valorDeRegeneracao);
			marcadorDeTempo.pararTempo();			
		}
	}

	@Override
	public String toString() {
		return 	"BarraEnergia {"
				+ "\n valorAtual = " + valorAtual 
				+ "\n valorMinimoPermitido = " + valorMinimoPermitido
				+ "\n valorMaximoPermitido = " + valorMaximoPermitido 
				+ "\n iniciouRegeneracao = " + marcadorDeTempo.isIniciouTempo()
				+ "\n terminouTempoRegeneracao = " + terminouTempoRegeneracao()
				+ "\n}";
	}
	
	
	
}
