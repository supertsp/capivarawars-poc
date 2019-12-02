package layout;

import java.util.Random;

public class DinamicLines {
//Creating dinamic variables to create more than one line

	int dnmPlayerPlace = 1;
	String dnmPlayerName = null;
	String dnmEmail = null;
	String dnmGender = null;
	int dnmAge; //could be random
	int dnmVictories; //could be random
	int dnmDraws; //could be random
	int dnmLosts; //could be random
	int dnmCoins; //could be random
	int dnmRightShots; //could be random
	int dnmWrongShots; //could be random

	//create a dnmPlayerPlace that ascending +1 each line

	public int getDnmPlayerPlace() {
		return dnmPlayerPlace++;
	}

	public String getDnmPlayerName() {
		return dnmPlayerName = "Player Name";
	}

	public String getDnmEmail() {
		return dnmEmail = "palyeremail@email.com";
	}

	public String getDnmGender() {
		return dnmGender = "M";
	}

	public int getDnmAge() {
		Random random = new Random();
		return dnmAge = random.nextInt(100);
	}

	public int getDnmVictories() {
		Random random = new Random();
		return dnmVictories = random.nextInt(1000000);
	}

	public int getDnmDraws() {
		Random random = new Random();
		return dnmVictories = random.nextInt(1000000);
	}

	public int getDnmLosts() {
		Random random = new Random();
		return dnmLosts = random.nextInt(1000000);
	}

	public int getDnmCoins() {
		Random random = new Random();
		return dnmCoins = random.nextInt(1000000);
	}

	public int getDnmRightShots() {
		Random random = new Random();
		return dnmRightShots = random.nextInt(1000000);
	}

	public int getDnmWrongShots() {
		Random random = new Random();
		return dnmWrongShots = random.nextInt(1000000);
	}
	

}//class
