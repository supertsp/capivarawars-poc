package br.com.CapivaraWars.layout;

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
		int draw;
		int defeated;
		int coin;
		int rigthShots;
		int wrongShots;

		//opening the file
		try {
			input = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {
			System.out.printf("Error trying to open the file: %s.\n", e.getMessage());
		}

		try {
			register = input.readLine();

			while (register != null) {
				registerType = register.substring(0, 2);

				if (registerType.equals("00")) {
					System.out.println("Header");
					System.out.println("File Type: " + register.substring(2, 14));
					System.out.println("Date n time from file generating");
					System.out.println("Layout version: " + register.substring(30, 32));
				} else if (registerType.equals("01")) {
					if (countRegister == 0) {
						System.out.println();
						System.out.printf(
								"%-5s %-5s %-4s %-2s %3s %9s %9s"
								+ " %9s %9s %9s %9s\n",
								"N° PLAYER", "PLAYER NAME", "EMAIL", "GENDER",
								"AGE", "VICTORY'S", "DRAW", "DEFEATED",
								 "COIN", "AGE", "WRONG SHOTS"
						);
					}
					playerPlace = register.substring(2, 4);
					System.out.println("tamanho: " + register.length());
					playerName = register.substring(4, 17);
					email = register.substring(6,10);
					gender = register.substring(97,99);
					age = Integer.parseInt(register.substring(99).replace(',','.'));
					victories = Integer.parseInt(register.substring(102, 111).trim());
					draw = Integer.parseInt(register.substring(111, 120).trim());
					defeated = Integer.parseInt(register.substring(120,129).trim());
					coin = Integer.parseInt(register.substring(129,138).trim());
					rigthShots = Integer.parseInt(register.substring(138,147).trim());
					wrongShots = Integer.parseInt(register.substring(147,156).trim());
					
					System.out.printf("%-2s %-50s %-40s %-2s %-3d %-9d %-9d "
							+ "%-9d %-9d %-9d %-9d %-9d\n", playerPlace.trim(), 
							playerName.trim(), email.trim(),gender.trim(),							                                            
							age, victories, draw, defeated, coin,
							rigthShots, wrongShots);
					countRegister++;
				}
				else{
					System.out.println("Invalid register type");
				}
				
				register = input.readLine();
			}
			
			input.close();
		}catch (IOException e){
			System.err.printf("Error trying to read the file: %s.\n", e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		String fileName = "PlayerData";
		readFile(fileName);
	}

}//class
