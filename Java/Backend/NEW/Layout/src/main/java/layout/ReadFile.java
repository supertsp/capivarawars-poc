package layout;

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
		int age;
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
			System.out.printf("Error trying to open the file: %s.\n",
					e.getMessage());
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
						System.out.printf(
								"%-5s" //
								+ "%-20s"
								+ "%-24s"
								+ "%-3s"
								+ "%-5s"
								+ "%-12s"
								+ "%-11s"
								+ "%-7s"
								+ "%-11s"
								+ "%-16s"
								+ "%-12s\n",
								"N°", "NAME", "EMAIL", "G",
								"AGE", "VICTORIES", "DRAW", "LOSTS",
								"COINS", "RIGHT STS", "WRONG STS");
					}

					playerPlace = register.substring(2, 7);
					playerName = register.substring(7, 27);
					email = register.substring(27, 57);
					gender = register.substring(57, 59);
					age = Integer.parseInt(register.substring(59, 62).trim());
					victories = Integer.parseInt(register.substring(62, 71).trim());
					draws = Integer.parseInt(register.substring(71, 80).trim());
					losts = Integer.parseInt(register.substring(80, 89).trim());
					coins = Integer.parseInt(register.substring(89, 98).trim());
					rigthShots = Integer.parseInt(register.substring(98, 107).trim());
					wrongShots = Integer.parseInt(register.substring(107, 116).trim());

					System.out.printf(
							"%-4s"
							+ " %-19s"
							+ " %-23s"
							+ " %-2s"
							+ " %-4d"
							+ " %-11d"
							+ " %-1d"
							+ "	%-6d"
							+ " %-10d"
							+ " %-15d"
							+ " %-20d\n",
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
