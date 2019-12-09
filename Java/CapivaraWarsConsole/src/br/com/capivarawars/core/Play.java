package br.com.capivarawars.core;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.game.gameobject.*;
import java.awt.Color;
import java.awt.Font;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;
import smartdb.SmartDbConnection;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author TPEDROSO, 17/09/2019, 10:47:45
 *///</editor-fold>
public class Play {

	//<editor-fold defaultstate="collapsed" desc="static attributes...">
	public static Scanner scanner = new Scanner(System.in);
	public static Capivara capivara;
	//</editor-fold>

	//<editor-fold desc="executable method...">
	public static void main(String[] args) {
		//exemplo de conexão com BD
		SmartDbConnection.setVariablesToSqlServer(
            "jdbc:sqlserver://capivarawars.database.windows.net:1433;database=CapivaraWars;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
            "capivara_admin",
            "!Capii123"
        );
		SmartDbConnection.setCurrentDbType(SmartDbConnection.DbType.SQLServer);
		
		int number = SmartDbConnection.executeQueryToReturnObject(Integer.class, 
                "SELECT COUNT(?) FROM PLAYER",
                "ID_PLAYER"
        );
		
		write("Number of Players: " + number);
		
		
		//exemplo de partida
		Partida partida = new Partida();
		int qtdJogadores = 2;
		int tamanhoRio = 10;
		int tamanhoCanoa = 4;
		String nickJogador = "";
		String nomeCapivara = "";
		Jogador jogTemp = null;
		int posicaoEscolhida = 0;

		CorPadrao corPadrao = CorPadrao.AMARELO;

		for (int indice = 0; indice < qtdJogadores; indice++) {
			nickJogador = readString("JOGADOR " + (indice + 1) + "\n\nQual é o seu Nick?");
			nomeCapivara = readString("JOGADOR " + (indice + 1) + "\n\nQual é nome da sua Capivara?");
			jogTemp = new Jogador(nickJogador, new Capivara(nomeCapivara, CorPadrao.TRANSPARENTE), tamanhoRio, tamanhoCanoa);
			partida.addJogador(jogTemp);
		}

		partida.iniciar();

		do {

			//MOVENDO CANOAS
			for (int indice = 0; indice < qtdJogadores; indice++) {
				try {
					posicaoEscolhida = readInteger(
							partida.getJogador(indice).getNick() + " (J" + (indice + 1)
							+ ")\n\nQual nova posição da sua canoa?"
					);
				} catch (Exception e) {
					posicaoEscolhida = 0;
				}

				partida.moverCanoaAtual(posicaoEscolhida);
			}

			//ATIRANDO NO INIMIGO
			for (int indice = 0; indice < qtdJogadores; indice++) {
				try {
					posicaoEscolhida = readInteger(
							partida.getJogador(indice).getNick() + " (J" + (indice + 1)
							+ ")\n\nQual posição você quer ATIRAR?"
					);
				} catch (Exception e) {
					posicaoEscolhida = 0;
				}

				partida.atirarNoInimigo(posicaoEscolhida + 1, posicaoEscolhida);
			}

			//Exibindo Resultados
			write(partida);

		} while (!partida.terminou());

		if (partida.houveEmpate()) {
			write("EMPATOU!!!!!");
		} else {
			write("PARABÉNS!!! " + partida.alguemGanhou().getNick());
		}

		write(partida);

		//</editor-fold>
	}//main
	//</editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Read and Write methods...">
	public static Integer calculateSizeOfLongestLine(Object messageToUser) {
		String[] slicesOfMessage = messageToUser.toString().split("\n");
		Integer bigger = 0;

		for (Integer index = 0; index < slicesOfMessage.length; index++) {
			if (slicesOfMessage[index].length() > bigger) {
				bigger = slicesOfMessage[index].length();
			}
		}

		return bigger;
	}

	public static String drawBorderLines(Object messageToUser, Integer sidePaddingSize) {
		String border = "+";
		Integer spaces = calculateSizeOfLongestLine(messageToUser) + (2 * sidePaddingSize);
		for (Integer count = 0; count < spaces; count++) {
			border += "-";
		}
		border += "+";
		return border;
	}

	public static void write(Object messageToUser) {
		String border = drawBorderLines(messageToUser, 2);
		String[] slicesOfMessage = messageToUser.toString().split("\n");

		String finalMessage = "\n" + border + "\n";
		for (int count = 0; count < slicesOfMessage.length; count++) {
			finalMessage += "|  " + (String.format("%-" + (border.length() - 6) + "s", slicesOfMessage[count])) + "  |\n";
		}
		finalMessage += border + "\n";

		System.out.println(finalMessage);
	}

	public static String readString(Object messageToUser) {
		String readValue = null;

		String border = drawBorderLines(messageToUser, 2);
		String[] slicesOfMessage = messageToUser.toString().split("\n");

		String headerMessage = "\n" + border + "\n";
		for (int count = 0; count < slicesOfMessage.length; count++) {
			headerMessage += "|  " + (String.format("%-" + (border.length() - 6) + "s", slicesOfMessage[count])) + "  |\n";
		}
		System.out.print(headerMessage + "|  ");

		try {
			readValue = scanner.nextLine();
		} catch (Exception e) {
		}

		System.out.println(border + "\n");

		return readValue;
	}

	public static Integer readInteger(Object messageToUser) {
		try {
			return parseInt(readString(messageToUser));
		} catch (Exception e) {
			return null;
		}
	}

	public static Float readFloat(Object messageToUser) {
		try {
			return parseFloat(readString(messageToUser));
		} catch (Exception e) {
			return null;
		}
	}

	public static Double readDouble(Object messageToUser) {
		try {
			return parseDouble(readString(messageToUser));
		} catch (Exception e) {
			return null;
		}
	}

	public static void writeWindow(Object messageToUser) {
		// <editor-fold defaultstate="collapsed" desc="customizing JOptionPane...">
		//Changing Font new Font(nomeFonte, espessura.valorEspessura, tamanhoCaractere);
		Font fontMonospaced = new Font("Consolas", Font.BOLD, 18);

		//Preparing the text message
		JTextArea textMessage = new JTextArea();
		textMessage.setEditable(false);
		textMessage.setBackground(Color.decode("0x3c3f41"));
		textMessage.setForeground(Color.decode("0xdee4e5"));
		textMessage.setFont(fontMonospaced);
		textMessage.setText(messageToUser.toString());

		//Changing JOptionPane colors
		UIManager.put("OptionPane.background", textMessage.getBackground());
		UIManager.put("Panel.background", textMessage.getBackground());
		UIManager.put("Button.background", Color.decode("0x727A7C"));
		UIManager.put("Button.foreground", textMessage.getForeground());
		UIManager.put("Button.font", fontMonospaced);

		//Changin JOptionPane OK button
		UIManager.put("OptionPane.okButtonText", "Close");
		// </editor-fold>

		JOptionPane.showMessageDialog(null, textMessage, "Write Operation", JOptionPane.PLAIN_MESSAGE);
	}

	public static String readWindowString(Object messageToUser) {
		// <editor-fold defaultstate="collapsed" desc="customizing JOptionPane...">
		//Changing Font new Font(nomeFonte, espessura.valorEspessura, tamanhoCaractere);
		Font fontMonospaced = new Font("Consolas", Font.BOLD, 18);

		//Preparing the text message
		JTextArea textMessage = new JTextArea();
		textMessage.setEditable(false);
		textMessage.setBackground(Color.decode("0x3c3f41"));
		textMessage.setForeground(Color.decode("0xdee4e5"));
		textMessage.setFont(fontMonospaced);
		textMessage.setText(messageToUser.toString());

		//Changing JOptionPane colors
		UIManager.put("OptionPane.background", textMessage.getBackground());
		UIManager.put("Panel.background", textMessage.getBackground());
		UIManager.put("Button.background", Color.decode("0x727A7C"));
		UIManager.put("Button.foreground", textMessage.getForeground());
		UIManager.put("Button.font", fontMonospaced);

		Border inputBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray);
		UIManager.put("TextField.background", textMessage.getBackground());
		UIManager.put("TextField.foreground", Color.white);
		UIManager.put("TextField.border", inputBorder);
		UIManager.put("TextField.font", fontMonospaced);

		//Changin JOptionPane OK button
		UIManager.put("OptionPane.okButtonText", "Insert");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		// </editor-fold>

		String readValue = null;
		try {
			readValue = JOptionPane.showInputDialog(null, textMessage, "Read Operation", JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
		}
		return readValue;
	}

	public static Integer readWindowInteger(Object messageToUser) {
		try {
			return parseInt(readWindowString(messageToUser));
		} catch (Exception e) {
			return null;
		}
	}

	public static Float readWindowFloat(Object messageToUser) {
		try {
			return parseFloat(readWindowString(messageToUser));
		} catch (Exception e) {
			return null;
		}
	}

	public static Double readWindowDouble(Object messageToUser) {
		try {
			return parseDouble(readWindowString(messageToUser));
		} catch (Exception e) {
			return null;
		}
	}
	// </editor-fold>

}//class
