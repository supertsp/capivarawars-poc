package br.com.capivarawars.database.model;

// <editor-fold defaultstate="collapsed" desc="imports...">
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author WINDOWS 8.1 JOSHUA, 20/11/2019, 21:13:54
 * Last update: -
 */// </editor-fold>
public class GravaArquivo {
	public static void gravaRegistro (String nomeArq, String registro) {
		BufferedWriter saida = null;
		try {
			// o argumento true � para indicar que o arquivo n�o ser� sobrescrito e sim
			// gravado com append (no final do arquivo)
			saida = new BufferedWriter(new FileWriter(nomeArq, true));
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		try {
				saida.append(registro + "\n");
			    saida.close();

		} catch (IOException e) {
			System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
		}
	}
	
	

	public static void main(String[] args) {
		
		String nomeArq = "DadosJogador";
		String header = "";
		String corpo = "";
		String trailer = "";
		int contRegDados = 0;
		
		// Monta o registro header
		Date dataDeHoje = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
		
		header += "00DADOSJOGADORES";
		header += formatter.format(dataDeHoje);
		header += "01";
		
		// Grava o registro header
		gravaRegistro(nomeArq, header);
		
		// Monta o corpo 
		
		// 1o registro de dados
		corpo += "02";
		// %-5s : para strings, usamos s
		//        alinha para a esquerda, campo de 5 caracteres, completa
		//        espa�os com brancos
		corpo += String.format("%-5s", "1");
		corpo += String.format("%-50s", "Joshua");
		corpo += String.format("%-40s", "joshuaandre@gmail.com");
		corpo += String.format("%-2s", "m");
		corpo += String.format("%-3s", "123");
		corpo += String.format("%-9s", "123");
		corpo += String.format("%-9s", "123");
		corpo += String.format("%-9s", "123");
		corpo += String.format("%-9s", "12333");
		corpo += String.format("%-9s", "123");
		corpo += String.format("%-9s", "123");
		// %05.2f : para n�mero com casas decimais, usamos f
		//          alinha para a direita, porque n�o tem o -
		//          completa com zeros � esquerda
		//          formata com 2 casas decimais, separado por v�rgula
//		corpo += String.format("%05.2f", 7.5);
		// %03d : para n�mero inteiro, usamos d
		//        alinha para a direita e completa com zeros � esquerda
//		corpo += String.format("%03d", 10);
		// incrementa o contador de registros de dados
		contRegDados++;
		// chama o m�todo para gravar um registro
		gravaRegistro(nomeArq,corpo);
		
		// 2o registro de dados
		
		
		// 3o registro de dados
//		corpo = "02";
//		corpo += String.format("%-5s", "REDES");
//		corpo += "01181090";
//		corpo += String.format("%-50s", "Fulano Teixeira");
//		corpo += String.format("%-40s", "Seguran�a");
//		corpo += String.format("%05.2f", 8.0);
//		corpo += String.format("%03d", 15);
//		contRegDados++;
//		gravaRegistro(nomeArq,corpo);

		
		// monta o trailer
		trailer += "01";
		trailer += String.format("%010d", contRegDados);
		gravaRegistro(nomeArq,trailer);
	}

}//class
