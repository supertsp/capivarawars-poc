package br.com.CapivaraWars.layout;

import com.sun.org.apache.xerces.internal.xs.PSVIProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void readFile(String fileName) {
		BufferedReader input = null;
		String register;
		String registerType;
		String playerPlace, playerName, email, gender;
		double age;
		int victories, countRegister = 0;
		int draws;
		int losts;
		int coins;
		int rigthShots;
		int wrongShots;

		//opening the file
		try {
			input = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {
			System.out.printf("Error trying to open the file: %s.\n", e.getMessage());
		}

		//Read the register files
		try {
			//Read a register
			register = input.readLine();

			while (register != null) {
				//Get the register type
				registerType = register.substring(0, 2);

				if (registerType.equals("00")) {
					System.out.println("Header");
					System.out.println("File Type: " + register.substring(2, 14));
					System.out.println("Hour n date from file genaration"
							+ register.substring(14, 16));
					System.out.println("Hour n date from file genaration"
							+ register.substring(30, 32));
				} else if (registerType.equals("01")) {
					System.out.println("\nTrailer");
					int qtRegisters = Integer.parseInt(register.substring(2, 12));
					if (qtRegisters == countRegister) {
						System.out.println("Quantity of registers records with "
								+ "read quantity readed");
					} else {
						System.out.println("Quantity of record register doesen´t"
								+ " match with the readed quantity");
					}
				} else if (registerType.contentEquals("02")) {
					if (countRegister == 0) {
						System.out.println();
						System.out.printf("%-5s %-5s %-4s %-2s %3s %9s %9s"
								+ " %9s %9s %9s %9s\n",
								"N° PLAYER", "PLAYER NAME", "EMAIL", "GENDER",
								"AGE", "VICTORYS", "DRAW", "DEFEATED",
								"COINS", "RIGHT SHOTS", "WRONG SHOTS");
					}

					System.out.println("tamanho" + register.length());
					playerPlace = register.substring(2, 7);
					playerName = register.substring(7, 57);
					email = register.substring(57, 97);
					System.out.println("tamanho do email"+email.length());
					gender = register.substring(97, 99);
					age = Integer.parseInt(register.substring(99, 102).replace(',', '.'));
					victories = Integer.parseInt(register.substring(102, 111).trim());
					draws = Integer.parseInt(register.substring(111, 120).trim());
					losts = Integer.parseInt(register.substring(120, 129).trim());
					coins = Integer.parseInt(register.substring(129, 138).trim());
					rigthShots = Integer.parseInt(register.substring(138, 147).trim());
					wrongShots = Integer.parseInt(register.substring(147, 156).trim());

					System.out.printf("%-5s %-50s %-40s %-2s"
							+ " %-3d %-9d %-9d %-9d %-9d %-9d %-9d %-9d\n",
							playerPlace.trim(), playerName.trim(), email.trim(),
							gender.trim(), age, victories, draws, losts,
							coins, rigthShots, wrongShots);

					countRegister++;
				} else {
					System.out.println("Invalid register type");
				}

				//read the next register
				register = input.readLine();
			}

			//close file
			input.close();
		} catch (IOException e) {
			System.err.printf("Error trying to read the file: %s.\n", e.getMessage());
		}

	}
	public static void main(String[] args) {
		String fileName = "PlayerData";
		readFile(fileName);
	}

}//class
