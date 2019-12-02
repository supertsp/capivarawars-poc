package layout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RecordFile {

	public static void recordFile(String fileName, String record) {
		BufferedWriter outPut = null;
		try {

			outPut = new BufferedWriter(new FileWriter(fileName, true));

		} catch (IOException e) {
			System.err.printf("Error, could not opening the file: %s. \n", e.getMessage());
		}

		try {
			outPut.append(record + "\n");
			outPut.close();
		} catch (IOException e) {
			System.err.printf("Error, could not record the file: %s.\n", e.getMessage());
		}
	}

	public static void main(String[] args) {

		String fileName = "PlayerData";
		String header = "";
		String body = "";
		String trailer = "";
		int countDataReg = 0;

		Date todayDate = new Date();
		SimpleDateFormat dateformatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		header += "PLAYERDATA";
		header += dateformatter.format(todayDate);
		header += "01";

		//recording the register on header
		recordFile(fileName, header);

		DinamicLines dinamic = new DinamicLines();
		for (int count = 0; count < 20; count++) {

			//Creating the body
			body += "02";
			//PLAYERPLACE
			body += String.format("%-5s", dinamic.getDnmPlayerPlace());
			//PLAYERNAME
			body += String.format("%-20s", dinamic.getDnmPlayerName());
			//EMAIL
			body += String.format("%-30s", dinamic.getDnmEmail());
			//GENDER
			body += String.format("%-2s", dinamic.getDnmGender());
			//AGE
			body += String.format("%-3d", dinamic.getDnmAge());
			//VICTORIES
			body += String.format("%-9d", dinamic.getDnmVictories());
			//DRAWS
			body += String.format("%-9d", dinamic.getDnmDraws());
			//LOSTS
			body += String.format("%-9d", dinamic.getDnmLosts());
			//COINS
			body += String.format("%-9d", dinamic.getDnmCoins());
			//RIGHTSHOTS
			body += String.format("%-9d", dinamic.getDnmRightShots());
			//WRONGSHOTS
			body += String.format("%9d", dinamic.getDnmWrongShots());
			body += "\n";

			countDataReg++;
		}

		recordFile(fileName, body);

		trailer += "01";
		trailer += String.format("%010d", countDataReg);
		recordFile(fileName, trailer);
	}

}//class
