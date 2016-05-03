
/*	File Name: Terrain Class
*	Course Name:Object Oriented Programming CST 8132
*	Lab	Section:CST 8132-301
*	Student	Name: Amaury Diaz Diaz
*	Date: Sep-29-2014
*/
/* This class initializes a terrain with a default icon of
 * "N" or an specified String as an icon and returns a reference to
 * the icon String.
 */
/*
 * References:(Stanley Pieda (2014) personal communication)
 */
public class Terrain {
	private String icon;
/*This constructor initializes the icon to
 * a default String "N".
 */
	public Terrain() {
		icon = "N";
	}
/*This constructor initializes the icon
 * to a specific String.
 */
	public Terrain(String icon) {
		this.icon = icon;
	}
/*This method returns a String reference 
 * of the icon.
 */
	public String getIcon() {
		return icon;
	}
}
