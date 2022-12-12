package rockPaperScissors;

public class RockPaperScissorsApp {

	public static void main(String[] args) {
		RockPaperScissors t1 = new RockPaperScissors(ThrowType.ROCK);
		RockPaperScissors t2 = new RockPaperScissors(ThrowType.PAPER);

		System.out.println("t1: " + t1);
		System.out.println("t2: " + t2);

		System.out.println("t1.equals(t2) = " + t1.equals(t2));
	}

}
