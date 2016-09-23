import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class CrazyEights {

	/**
	 * Initialize your fields here (then change this documentation).
	 */
	public CrazyEights() {
		
	}
	
	/**
	 * Decodes a command and invokes the right method. You may update this method if you find
	 * it's necessary for your design, but be careful you don't break anything. If you make 
	 * changes to this method, do it in very small increments and frequently run the tests.
	 * 
	 * @param command The command to decode
	 * @return the results of the command.  "ok" if success but no result.
	 */
	public String handleCommand(String command) {
		Scanner input = new Scanner(command);
		String commandType = input.next();
		String toReturn = null;

		if(commandType.equals("start-game")) {
			int numPlayers = input.nextInt();
			String deckName = null;
			boolean shuffle = true;
			if (input.hasNext()) {
				deckName = input.next();
			}
			if (input.hasNextBoolean()) {
				shuffle = input.nextBoolean();
			}
			toReturn =  handleStartGame(numPlayers, deckName, shuffle);
		}
		else if (commandType.equals("play-card")) {
			String cardValue = input.next();
			toReturn = handlePlayCard(cardValue);
			
		}
		else if (commandType.equals("draw-card")) {
			toReturn = handleDrawCard();
		}
		else if(commandType.equals("exit")) {
			input.close();
			System.exit(0);
		}
		else {
			toReturn = "Unknown command " + commandType;
		}
		input.close();
		return toReturn;
	}
	
	/**
	 * Handles starting a game for the specified number of players with the specified deck.
	 */
	private String handleStartGame(int numPlayers, String deckName, boolean shuffle) {
		//TODO: Implement this
		return null;
	}
	
	
	/**
	 * Handles the play-card command.
	 * 
	 * @param cardValue - The value (rank and suit) of the card to play.
	 * @return The string message to display to the user before the game state text.
	 */
	private String handlePlayCard(String cardValue) {
		//TODO: Implement this
		return null;
	}
	
	/**
	 * Handles the draw-card command.
	 * 
	 * @return The string message to display to the user before the game state text.
	 */
	private String handleDrawCard() {
		//TODO: Implement this
		return null;
	}
	

	/**
	 * 
	 * Run the CrazyEights in console mode (that is, input is to come from
	 * the console).
	 * 
	 * THIS METHOD IS WRITTEN FOR YOU - no need to edit
	 * 
	 * @param args Command line arguments (ignored)
	 */
	public static void main(String[] args) {
		CrazyEights game = new CrazyEights();
		System.out.println("Welcome to CrazyEights.  Enter commands.  Type 'exit' to end.");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String commandLine = scanner.nextLine();
			String result = game.handleCommand(commandLine);
			System.out.println(result);
		}
		
	}

}
