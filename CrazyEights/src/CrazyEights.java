import java.util.ArrayList;
import java.util.Scanner;

public class CrazyEights {

	private DrawDeck drawDeck;
	private DiscardPile discardPile;
	private ArrayList<Player> players;
	private int currentPlayerNumber;
	private int totalPlayers;

	/**
	 * Initialize your fields here (then change this documentation).
	 */
	public CrazyEights() {
		this.currentPlayerNumber = 0;
		this.players = new ArrayList<>();

	}

	/**
	 * Decodes a command and invokes the right method. You may update this
	 * method if you find it's necessary for your design, but be careful you
	 * don't break anything. If you make changes to this method, do it in very
	 * small increments and frequently run the tests.
	 * 
	 * @param command
	 *            The command to decode
	 * @return the results of the command. "ok" if success but no result.
	 */
	public String handleCommand(String command) {
		Scanner input = new Scanner(command);
		String commandType = input.next();
		String toReturn = null;

		if (commandType.equals("start-game")) {
			int numPlayers = input.nextInt();
			String deckName = null;
			boolean shuffle = true;
			if (input.hasNext()) {
				deckName = input.next();
			}
			if (input.hasNextBoolean()) {
				shuffle = input.nextBoolean();
			}
			toReturn = handleStartGame(numPlayers, deckName, shuffle);
		} else if (commandType.equals("play-card")) {
			String cardValue = input.next();
			toReturn = handlePlayCard(cardValue);

		} else if (commandType.equals("draw-card")) {
			toReturn = handleDrawCard();
		} else if (commandType.equals("exit")) {
			input.close();
			System.exit(0);
		} else {
			toReturn = "Unknown command " + commandType;
		}
		input.close();
		return toReturn;
	}

	/**
	 * Handles starting a game for the specified number of players with the
	 * specified deck.
	 */
	private String handleStartGame(int numPlayers, String deckName, boolean shuffle) {
		this.totalPlayers = numPlayers;
		
		if (deckName != null) {
			this.drawDeck = new DrawDeck(deckName, shuffle);
		} else {
			this.drawDeck = new DrawDeck(shuffle);
		}

		for (int i = 0; i < numPlayers; i++) {
			this.players.add(new Player(this.drawDeck));
		}

		for (int i = 0; i < 6; i++) {
			for (int x = 0; x < numPlayers; x++) {
				this.players.get(x).drawCard();
			}
		}

		this.discardPile = new DiscardPile(this.drawDeck);
		this.currentPlayerNumber = 1;
		return "Cards dealt. " + this.statusUpdate();
	}

	/**
	 * Handles the play-card command.
	 * 
	 * @param cardValue
	 *            - The value (rank and suit) of the card to play.
	 * @return The string message to display to the user before the game state
	 *         text.
	 */
		private String handlePlayCard(String cardValue){
			
			
		return null;
	}

	/**
	 * Handles the draw-card command.
	 * 
	 * @return The string message to display to the user before the game state
	 *         text.
	 */
	private String handleDrawCard() {
		
		players.get(currentPlayerNumber-1).drawCard();
		return null;
	}

	private String statusUpdate() {
		String line1 = "Player " + this.currentPlayerNumber + ", your turn.";
		String line2 = "Your cards are" + this.players.get(this.currentPlayerNumber - 1).getHand();
		String line3 = "The top discard is " + this.discardPile.getTopCard();
		return "\n" + line1 + "\n" + line2 + "\n" + line3;
	}

	/**
	 * 
	 * Run the CrazyEights in console mode (that is, input is to come from the
	 * console).
	 * 
	 * THIS METHOD IS WRITTEN FOR YOU - no need to edit
	 * 
	 * @param args
	 *            Command line arguments (ignored)
	 */
	public static void main(String[] args) {
		CrazyEights game = new CrazyEights();
		System.out.println("Welcome to CrazyEights.  Enter commands.  Type 'exit' to end.");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String commandLine = scanner.nextLine();
			String result = game.handleCommand(commandLine);
			System.out.println(result);
		}

	}

}
