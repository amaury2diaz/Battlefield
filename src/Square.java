/*	File Name: Square Class
*	Course Name:Object Oriented Programming CST 8132
*	Lab	Section:CST 8132-301
*	Student	Name: Amaury Diaz Diaz
*	Date: Sept-29-2014
*/
/*This class checks the elements that
 * are inside a square (orc, elf, and terrain), it
 * checks if a fight can be performed inside the
 * square, and it returns the square as a String.
 */
/*
 * References:(Stanley Pieda (2014) personal communication)
 */
public class Square {
	private Elf elf;
	private Orc orc;
	private Terrain terrain;
/*This constructor accepts references to
 * terrain, elf and orc objects.
 */
	public Square(Terrain terrain, Elf elf, Orc orc) {
		terrain = new Terrain();
		elf = new Elf();
		orc = new Orc();
	}
/*This method returns a reference to
 * a terrain object inside the square.
 */
	public Terrain getTerrain() {
		return terrain;
	}
/* This method sets an elf into the square
 * if the reference is null the terrain is made to normal
 * terrain.
 * 
 */
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
		if (terrain==null){
			this.terrain=new Terrain();
		}
	}
	/*This method returns a reference to
	 * an elf object inside the square.
	 */
	public Elf getElf() {
		return elf;
	}
	/* This method sets an elf into the square
	 * if the reference is null the elf is removed
	 * from the square.
	 */
	public void setElf(Elf elf) {
		this.elf = elf;
	}
	/*This method returns a reference to
	 * an orc object inside the square.
	 */
	public Orc getOrc() {
		return orc;
	}
	/* This method sets an orc into the square
	 * if the reference is null the orc is removed
	 * from the square.
	 */
	public void setOrc(Orc orc) {
		this.orc = orc;
	}
/*This method checks if there are both an elf and
 * an orc inside the square. If there are both the one
 * with the lowest strength is set to null and is removed from the square.
 */
	public void fight() {
		if (elf != null && orc != null) {

			if (elf.getStrength() > orc.getStrength()) {
				orc = null;
			} else if (elf.getStrength() < orc.getStrength()) {
				elf = null;
			}
		}
	}
/*This method uses a StringBuilder class to
 * return the square and the elements inside it
 * (terrain,orc and elf) as a String.
 */
	public String rendorSquare() {
		StringBuilder builder = new StringBuilder();
		if (elf != null && orc != null) {
			builder.append("[").append(terrain.getIcon()).append(elf.getIcon())
					.append(orc.getIcon()).append("]");

		}
		if (orc == null && elf == null) {
			builder.append("[").append(terrain.getIcon()).append(" ")
					.append(" ").append("]");
		}
		if (elf == null && orc != null) {
			builder.append("[").append(terrain.getIcon()).append(" ")
					.append(orc.getIcon()).append("]");
		}
		if (orc == null && elf != null) {
			builder.append("[").append(terrain.getIcon()).append(elf.getIcon())
					.append(" ").append("]");
		}

		return builder.toString();
	}
}
