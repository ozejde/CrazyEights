import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 * 
 * Includes 3 JUnit tests for previous bugs in code
 *
 * @author ejdeoz, murrayjd
 *         
 */

public class SelfTests {
	
	@Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	private CrazyEights game;
	
	@Before
	public void setUp() throws Exception {
		game = new CrazyEights();
	}
	
	//tests if the program can handle card names over length 2
	@Test
	public void testTooLongCard() {
		String[] expected = new String[] {
				"Card was not valid for play. Please try again.",
				"Player 1, your turn.",
				"Your cards are QH JC 8S JD 10D 5H 3D", 
				"The top discard is KC"
		};
		game.handleCommand("start-game 2 testDeck false");
		String[] result = game.handleCommand("play-card AAAAA").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	//tests if the program can handle incorrect deck names
	@Test
	public void testIncorrectDeck() {
		String[] expected = new String[] {
				"Incorrect deck.",
				"Please start game again."
		};
		String[] result = game.handleCommand("start-game 2 deck false").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	//tests if the game properly restarts
	@Test
	public void testRestartGame() {
		String[] expected1 = new String[] {
				"Card JC played.",
				"Player 2, your turn.",
				"Your cards are 7H 9D 4C AH 4S QC AD", 
				"The top discard is JC"
		};
		String[] expected2 = new String[] {
				"Cards dealt.",
				"Player 1, your turn.",
				"Your cards are QH JC 8S JD 10D 5H 3D", 
				"The top discard is KC"
		};
		game.handleCommand("start-game 2 testDeck false");
		String[] result1 = game.handleCommand("play-card JC").split("\n");
		String[] result2 = game.handleCommand("start-game 2 testDeck false").split("\n");
		compareStringArrayResults(expected1, result1);
		compareStringArrayResults(expected2, result2);
	}
	
	
		private static void compareStringArrayResults(String[] expected, String[] actual) {
			assertEquals(expected.length, actual.length);
			for (int i=0;i<expected.length;i++) {
				assertEquals(expected[i].trim(), actual[i].trim());
			}
		}

}
