/*	File Name: Battlefield Class
 *	Course Name:Object Oriented Programming CST 8132
 *	Lab	Section:CST 8132-301
 *	Student	Name: Amaury Diaz Diaz
 *	Date: Sep-29-2014
 */
/*This clas creates a 2 dimensional array of 5x5 of the class 
 * Square(the battlefield), creates 10 elves and 10 orcs in random 
 * positions in the battlefield as well as 5 mountain terrains. It checks
 * how many elves and orcs remain after each round, it controls the movements
 * and fights of the characters, and it formats the entire battlefield into 
 * a String. 
 * 
 */
/*
 * References:(Stanley Pieda (2014) personal communication)
 */
public class Battlefield {
	private Square[][] battlefield;// field battlefield a 2 dimensional array of
									// the Square class.
	private static final int HEIGHT = 5;// constant to create the height of the
										// battlefield.
	private static final int LENGTH = 5;// constant to create the height of the
										// battlefield.
	private int counter;// counter used in getElfCount() and getOrcCount()
						// methods.

	/*
	 * It creates a two dimensional array of the Square class to create the
	 * battlefield using both constants HEIGHT and LENGTH Then it creates 10
	 * elves and orcs ,and 5 mountain terrains in random cells in the
	 * battlefield.
	 */
	public Battlefield() {
		battlefield = new Square[HEIGHT][LENGTH];// creates a battlefield of 5x5
		
		counter = 0;

		for (int row = 0; row < battlefield.length; row++) {

			for (int column = 0; column < battlefield[row].length; column++) {
				battlefield[row][column] = new Square(null, null, null);
				battlefield[row][column].setTerrain(null);

			}

		}
		for (int elf = 0; elf < 10; elf++) {// creates 10 elves in random
											// positions in the battlefield.
			battlefield[RandomUtil.nextInt(5)][RandomUtil.nextInt(5)]
					.setElf(new Elf());

		}
		while (getElfCount() < 10) {// makes sure that 10 elves are created in
									// the inizialization.
			battlefield[RandomUtil.nextInt(5)][RandomUtil.nextInt(5)]
					.setElf(new Elf());
		}

		for (int orc = 0; orc < 10; orc++) {// creates ten orcs in random
											// positions in the battlefield.
			battlefield[RandomUtil.nextInt(5)][RandomUtil.nextInt(5)]
					.setOrc(new Orc());
		}
		while (getOrcCount() < 10) {// makes sure that 10 orcs are created in
									// the inizialization.
			battlefield[RandomUtil.nextInt(5)][RandomUtil.nextInt(5)]
					.setOrc(new Orc());
		}
		for (int mountain = 0; mountain < 5; mountain++) {// crates 5 mountain
															// terrains in
															// random positions
															// in the
															// battlefield.
			battlefield[RandomUtil.nextInt(5)][RandomUtil.nextInt(5)]
					.setTerrain(new Terrain("M"));
		}

		while (getMountainCount() < 5) {// makes sure that 5 mountains are
										// created in the inizialization.
			battlefield[RandomUtil.nextInt(5)][RandomUtil.nextInt(5)]
					.setTerrain(new Terrain("M"));
		}
	}

	/*
	 * This method goes through each square and checks if there are are elf
	 * references inside the squares. If there is a reference the counter of Elf
	 * references is incremented by one.
	 */
	public int getElfCount() {
		counter = 0;
		for (int row = 0; row < battlefield.length; row++) {
			for (int column = 0; column < battlefield[row].length; column++) {
				if (battlefield[row][column].getElf() != null) {
					counter++;
				}
			}
		}
		return counter;
	}

	/*
	 * This method goes through each square and checks if there are orc
	 * references inside the squares. If there is a reference the counter of Orc
	 * references is incremented by one.
	 */
	public int getOrcCount() {
		counter = 0;
		for (int row = 0; row < battlefield.length; row++) {
			for (int column = 0; column < battlefield[row].length; column++) {
				if (battlefield[row][column].getOrc() != null) {
					counter++;
				}
			}
		}
		return counter;
	}

	/*
	 * This method goes through each square and checks if there are terrain(type
	 * mountain) references inside the squares. If there is a reference the
	 * counter of terrain(type mountain) references is incremented by one. Used
	 * just to make sure that there are 5 mountains during the initialization of
	 * the program.
	 */
	public int getMountainCount() {
		counter = 0;
		for (int row = 0; row < battlefield.length; row++) {
			for (int column = 0; column < battlefield[row].length; column++) {
				if (battlefield[row][column].getTerrain().getIcon() == "M") {
					counter++;
				}
			}
		}
		return counter;
	}

	/*
	 * This method goes through each square in the battlefield and demands each
	 * square if there is an orc or an elf inside it. If there is they should
	 * move to one "valid"(no mountain, not the same kind of oject referenced)
	 * random square by one cell position.
	 */
	public void moveActors() {
		for (int row = 0; row < battlefield.length; row++) {
			for (int column = 0; column < battlefield.length; column++) {
				if (battlefield[row][column].getElf() != null) {
					battlefield[row][column].getElf().move(battlefield, row,
							column);
				}
				if (battlefield[row][column].getOrc() != null) {
					battlefield[row][column].getOrc().move(battlefield, row,
							column);
				}
			}
		}

	}

	/*
	 * This method goes through each square in the battlefield and demands each
	 * square to check if there can be a fight between an orc and an elf if both
	 * are present inside the square.
	 */
	public void processFights() {

		for (int row = 0; row < battlefield.length; row++) {
			for (int column = 0; column < battlefield[row].length; column++) {
				battlefield[row][column].fight();
			}
		}
	}

	/*
	 * This method goes through each square in the battlefield and uses a
	 * StringBuilder class to format the battlefield into a String
	 */
	public String rendorBattleField() {
		StringBuilder builder = new StringBuilder();
		for (int row = 0; row < battlefield.length; row++) {
			for (int column = 0; column < battlefield[row].length; column++) {
				builder.append(battlefield[row][column].rendorSquare()).append(
						" ");
			}
			builder.append("\n");
		}
		builder.append("elves: ").append(getElfCount()).append(" orcs: ")
				.append(getOrcCount());
		return builder.toString();// returns the battlefield as a String
	}
}
