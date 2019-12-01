package br.com.CapivaraWars.layout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String trailer  = "";
		int countDataReg = 0;

		Date todayDate = new Date();
		SimpleDateFormat dateformatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		header += "PLAYERDATA";
		header += dateformatter.format(todayDate);
		header += "01";

		//recording the register on header
		recordFile(fileName, header);

		//Creating the body
		body += "02";
		body += String.format("%-5s", "1");
		body += String.format("%-20s", "Joshua");
		body += String.format("%-30s", "joshuaandre@gmail.com");
		body += String.format("%-2s", "M");
		body += String.format("%-3s", "22");
		body += String.format("%-9s", "10000");
		body += String.format("%-9s", "500");
		body += String.format("%-9s", "200");
		body += String.format("%-9s", "56756677");
		body += String.format("%-9s", "556745");
		body += String.format("%-9s", "556868");

		countDataReg++;

		recordFile(fileName, body);
		
		
		
		trailer += "01";
		trailer += String.format("%010d", countDataReg);
		recordFile(fileName, trailer);
	}

}//class
