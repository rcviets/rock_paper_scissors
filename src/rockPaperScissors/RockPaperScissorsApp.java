/**
 * 
 */
package rockPaperScissors;

/**
 * @author Randa Viets & Samuel Franks
 *
 */
public class RockPaperScissorsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RockPaperScissors throw1 = new RockPaperScissors(ThrowType.ROCK);
		RockPaperScissors throw2 = new RockPaperScissors(ThrowType.PAPER);
		
		System.out.println("Throw 1: " + throw1);
		System.out.println("Throw 2: " + throw2);
		
		System.out.println("Throw 1 Equals Throw 2 ? : " + throw1.equals(throw2));
	}

}
