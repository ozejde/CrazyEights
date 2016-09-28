import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;


public class CrazyEightsCommandTests {
	
	@Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	private CrazyEights game;
	
	@Before
	public void setUp() throws Exception {
		game = new CrazyEights();
	}

	@Test
	public void testExitGame() {
		String[] expected = new String[] {
				"Cards dealt.","Player 1, your turn.", "Your cards are QH JC 8S JD 10D 5H 3D", "The top discard is KC"
		};
		String[] result = game.handleCommand("start-game 2 testDeck false").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	
	@Test
	public void testStartGameTwoPlayers() {
		String[] expected = new String[] {
				"Cards dealt.","Player 1, your turn.", "Your cards are QH JC 8S JD 10D 5H 3D", "The top discard is KC"
		};
		String[] result = game.handleCommand("start-game 2 testDeck false").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	@Test
	public void testPlayCard() {
		String[] expected = new String[] {
				"Card JC played.",
				"Player 2, your turn.",
				"Your cards are 7H 9D 4C AH 4S QC AD", 
				"The top discard is JC"
		};
		game.handleCommand("start-game 2 testDeck false");
		String[] result = game.handleCommand("play-card JC").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	@Test
	public void testPlayInvalidBasedOnDiscardCard() {
		String[] expected = new String[] {
				"Card was not valid for play. Please try again.",
				"Player 1, your turn.",
				"Your cards are QH JC 8S JD 10D 5H 3D", 
				"The top discard is KC"
		};
		game.handleCommand("start-game 2 testDeck false");
		String[] result = game.handleCommand("play-card QH").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	@Test
	public void testPlayInvalidCardText() {
		String[] expected = new String[] {
				"Card was not valid for play. Please try again.",
				"Player 1, your turn.",
				"Your cards are QH JC 8S JD 10D 5H 3D", 
				"The top discard is KC"
		};
		game.handleCommand("start-game 2 testDeck false");
		String[] result = game.handleCommand("play-card H").split("\n");
		compareStringArrayResults(expected, result);
	}

	@Test
	public void testPlayReversedCardText() {
		String[] expected = new String[] {
				"Card was not valid for play. Please try again.",
				"Player 1, your turn.",
				"Your cards are QH JC 8S JD 10D 5H 3D", 
				"The top discard is KC"
		};
		game.handleCommand("start-game 2 testDeck false");
		String[] result = game.handleCommand("play-card CJ").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	@Test
	public void testMultipleTurns2Players() {
		String[] expected1 = new String[] {
				"Card JC played.",
				"Player 2, your turn.",
				"Your cards are 7H 9D 4C AH 4S QC AD", 
				"The top discard is JC"
		};
		String[] expected2 = new String[] {
				"Card QC played.",
				"Player 1, your turn.",
				"Your cards are QH 8S JD 10D 5H 3D", 
				"The top discard is QC"
		};
		String[] expected3 = new String[] {
				"Card QH played.",
				"Player 2, your turn.",
				"Your cards are 7H 9D 4C AH 4S AD", 
				"The top discard is QH"
		};
		String[] expected4 = new String[] {
				"Card 7H played.",
				"Player 1, your turn.",
				"Your cards are 8S JD 10D 5H 3D ", 
				"The top discard is 7H"
		};
		game.handleCommand("start-game 2 testDeck false");
		String[] result1 = game.handleCommand("play-card JC").split("\n");
		String[] result2 = game.handleCommand("play-card QC").split("\n");
		String[] result3 = game.handleCommand("play-card QH").split("\n");
		String[] result4 = game.handleCommand("play-card 7H").split("\n");
		compareStringArrayResults(expected1, result1);
		compareStringArrayResults(expected2, result2);
		compareStringArrayResults(expected3, result3);
		compareStringArrayResults(expected4, result4);
	}
	
	@Test
	public void testMultipleTurns3Players() {
		String[] expected1 = new String[] {
				"Card 6S played.",
				"Player 2, your turn.",
				"Your cards are 7H 8S AH 5H AD 2S QD", 
				"The top discard is 6S"
		};
		String[] expected2 = new String[] {
				"Card 2S played.",
				"Player 3, your turn.",
				"Your cards are JC 4C 10D QC KC 3C 5C", 
				"The top discard is 2S"
		};
		String[] expected3 = new String[] {
				"Card 6D was drawn.",
				"Player 3, your turn.",
				"Your cards are JC 4C 10D QC KC 3C 5C 6D", 
				"The top discard is 2S"
		};
		String[] expected4 = new String[] {
				"Card 3S was drawn.",
				"Player 3, your turn.",
				"Your cards are JC 4C 10D QC KC 3C 5C 6D 3S", 
				"The top discard is 2S"
		};
		String[] expected5 = new String[] {
				"Card 3S played.",
				"Player 1, your turn.",
				"Your cards are QH 9D JD 4S 3D KD", 
				"The top discard is 3S"
		};
		game.handleCommand("start-game 3 testDeck false");
		String[] result1 = game.handleCommand("play-card 6S").split("\n");
		String[] result2 = game.handleCommand("play-card 2S").split("\n");
		String[] result3 = game.handleCommand("draw-card").split("\n");
		String[] result4 = game.handleCommand("draw-card").split("\n");
		String[] result5 = game.handleCommand("play-card 3S").split("\n");
		compareStringArrayResults(expected1, result1);
		compareStringArrayResults(expected2, result2);
		compareStringArrayResults(expected3, result3);
		compareStringArrayResults(expected4, result4);
		compareStringArrayResults(expected5, result5);
	}
	
	@Test
	public void testStartGameThreePlayers() {
		String[] expected = new String[] {
				"Cards dealt.","Player 1, your turn.", "Your cards are QH 9D JD 4S 3D KD 6S", "The top discard is 7S"
		};
		String[] result = game.handleCommand("start-game 3 testDeck false").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	@Test 
	public void testExit() {
		exit.expectSystemExitWithStatus(0);
		game.handleCommand("exit");
	}
	
	@Test 
	public void testFullGames() {
		testGame("game1.txt");
		testGame("game2.txt");
		testGame("game3.txt");
	}
	private void testGame(String name) {
		exit.expectSystemExitWithStatus(0);
		ArrayList<String> commands = new ArrayList<String>();
		ArrayList<ArrayList<String>> responses = new ArrayList<ArrayList<String>>();
		Scanner exampleGame;
		try {
			exampleGame = new Scanner(new File(name));
		
			ArrayList<String> currentList = null;
			exampleGame.nextLine(); //remove the welcome line
			while (exampleGame.hasNextLine()) {
				String line = exampleGame.nextLine().trim();;
				if (line.startsWith("start-game") || line.startsWith("play-card") || line.startsWith("pay-card") || line.startsWith("draw-card") || line.startsWith("exit")) {
					if (currentList!=null) {
						responses.add(currentList);
					}
					commands.add(line);
					currentList = new ArrayList<String>();
				}
				else {
					currentList.add(line);
				}
			}
			responses.add(currentList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (commands.size()>0) {
			String[] expected = new String[responses.get(0).size()];
			responses.remove(0).toArray(expected);
			String command = commands.remove(0);
			String[] result = game.handleCommand(command).split("\n");
			compareStringArrayResults(expected, result);
		}
		exit.expectSystemExitWithStatus(0);
	}
	
	@Test
	public void testStartGameFourPlayers() {
		String[] expected = new String[] {
				"Cards dealt.","Player 1, your turn.", "Your cards are QH 8S 10D 3D 2S 5C AS", "The top discard is 2D"
		};
		String[] result = game.handleCommand("start-game 4 testDeck false").split("\n");
		compareStringArrayResults(expected, result);
	}
	@Test
	public void testStartGameOnePlayer() {
		String[] expected = new String[] {
				"Incorrect number of players, must be between 2 and 4."
		};
		String[] result = game.handleCommand("start-game 1").split("\n");
		compareStringArrayResults(expected, result);
		
		result = game.handleCommand("start-game 5").split("\n");
		compareStringArrayResults(expected, result);
	}
	
	private static void compareStringArrayResults(String[] expected, String[] actual) {
		assertEquals(expected.length, actual.length);
		for (int i=0;i<expected.length;i++) {
			assertEquals(expected[i].trim(), actual[i].trim());
		}
	}
}