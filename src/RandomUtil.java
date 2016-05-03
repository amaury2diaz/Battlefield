import java.util.Random;
/*	File Name: RandomUtil Class
*	Course Name:Object Oriented Programming CST 8132
*	Lab	Section:CST 8132-301
*	Student	Name: Amaury Diaz Diaz
*	Date: Sep-29-2014
*/
/*This class generates a random interger
 * number.
 */
/*
 * References:(Stanley Pieda (2014) personal communication)
 */
public class RandomUtil {

	private static final Random random = new Random();

	private RandomUtil() {
	}
/*This method returns a random number 
 * from 0 to the maximum-1.
 */
	public static int nextInt(int max) {
		return random.nextInt(max);
	}
}
