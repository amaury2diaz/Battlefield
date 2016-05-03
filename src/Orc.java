/*	File Name: Orc Class.
*	Course Name:Object Oriented Programming CST 8132
*	Lab	Section:CST 8132-301
*	Student	Name: Amaury Diaz Diaz
*	Date: Sept-29-2014
*/
/* This class creates an orc with a random strength
 * from 0-9, give it an icon and tells this orc
 * to move into a random position by one cell if the movement
 * can be done(valid cell, not mountain terrain, not an orc in 
 * the cell already.)
 */
/*
 * References:(Stanley Pieda (2014) personal communication)
 */
public class Orc {
	private int strength;
/*
 * It generates the random strength of the orc from 0-9.
 */
	public Orc() {

		strength = RandomUtil.nextInt(10);
	}
/* It returns the Icon of the orc.
 */
	public String getIcon() {
		return "O";
	}
/*It returns the strength of the orc
 */
	public int getStrength() {
		return strength;
	}
/*This method propose where the orc can move, it checks if 
 * the movement can be done and then it moves to a random
 * position by one cell.
 */
	public void move(Square[][] battlefield, int currentRowIndex,
			int currentColumnIndex) {

		switch (RandomUtil.nextInt(4)) {//random number from 0-3 to decide where the orc is going to move
		case 0://go up
			if (checkDestination(battlefield, currentRowIndex - 1,
					currentColumnIndex) != null) {
				battlefield[currentRowIndex - 1][currentColumnIndex]
						.setOrc(battlefield[currentRowIndex][currentColumnIndex]
								.getOrc());
				battlefield[currentRowIndex][currentColumnIndex].setOrc(null);
			}
			break;
		case 1://go down
			if (checkDestination(battlefield, currentRowIndex + 1,
					currentColumnIndex) != null) {
				battlefield[currentRowIndex + 1][currentColumnIndex]
						.setOrc(battlefield[currentRowIndex][currentColumnIndex]
								.getOrc());
				battlefield[currentRowIndex][currentColumnIndex].setOrc(null);
			}
			break;
		case 2://go right
			if (checkDestination(battlefield, currentRowIndex,
					currentColumnIndex + 1) != null) {
				battlefield[currentRowIndex][currentColumnIndex + 1]
						.setOrc(battlefield[currentRowIndex][currentColumnIndex]
								.getOrc());
				battlefield[currentRowIndex][currentColumnIndex].setOrc(null);
			}
			break;
		case 3://go left
			if (checkDestination(battlefield, currentRowIndex,
					currentColumnIndex - 1) != null) {
				battlefield[currentRowIndex][currentColumnIndex - 1]
						.setOrc(battlefield[currentRowIndex][currentColumnIndex]
								.getOrc());
				battlefield[currentRowIndex][currentColumnIndex].setOrc(null);
			}
			break;
		}

	}
/*This method check if the movement proposed above is valid, else
 * it returns null
 */
	private Square checkDestination(Square[][] battlefield,
			int proposedRowIndex, int proposedColumnIndex) {
		if (proposedRowIndex > 4
				|| proposedRowIndex < 0
				|| proposedColumnIndex > 4
				|| proposedColumnIndex < 0
				|| battlefield[proposedRowIndex][proposedColumnIndex].getOrc() != null
				|| battlefield[proposedRowIndex][proposedColumnIndex]
						.getTerrain().getIcon() == "M") {
			return null;
		} else
			return battlefield[proposedRowIndex][proposedColumnIndex];
	}
}
