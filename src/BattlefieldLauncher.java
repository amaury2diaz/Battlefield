import java.util.Scanner;

/*	File Name: BattlefieldLauncher Class
 *	Course Name:Object Oriented Programming CST 8132
 *	Lab	Section:CST 8132-301
 *	Student	Name: Amaury Diaz Diaz
 *	Date: Sep-29-2014
 */
/*This class has the main method that runs
 * the program.
 */
/*
 * References:(Stanley Pieda (2014) personal communication)
 */
public class BattlefieldLauncher {
	public static void main(String[] args) {
		Battlefield battlefield = new Battlefield();
		Scanner input = new Scanner(System.in);
		int option = -1;
		int sanity = 0; // game could go on forever
		while (option != 0 && sanity < 100) {
			System.out.println("Moving	Actors");
			battlefield.moveActors();
			System.out.println("Processing	Fights");

			battlefield.processFights();

			System.out.println(battlefield.rendorBattleField());
			if (battlefield.getElfCount() == 0) {
				System.out.println("Orcs	win");
				break;
			}
			if (battlefield.getOrcCount() == 0) {
				System.out.println("Elves	win");
				break;
			}
			System.out.printf("Round	%d	of	100	completed\n", sanity++ + 1);
			System.out.println("Enter	anything	to	play	next	turn");
			System.out.println("Enter	0	to	quit");
			option = input.nextInt();
		}
		if (sanity >= 100) {
			System.out.println("Battle	was	ended	after	100	rounds");
			System.out.println("Final	Game	State:	");
			System.out.println(battlefield.rendorBattleField());
		}
		System.out.println("Thanks	for	playing");
		input.close();
	}
}
