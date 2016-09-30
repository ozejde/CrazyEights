import java.util.ArrayList;

/**
 * Class: Player
 * 
 * @author ejdeoz, murrayjd
 * 
 * 
 *         Purpose: This class creates and modifies a Player object.
 *
 *         Use: Player player = new Player(drawDeck);
 * 
 */
public class Player {
	public DrawDeck drawDeck;
	public ArrayList<String> cardsInHand;

	/**
	 * 
	 * Creates a new Player object
	 *
	 * @param drawDeck
	 *            current game's DrawDeck
	 */
	public Player(DrawDeck drawDeck) {
		this.cardsInHand = new ArrayList<>();
		this.drawDeck = drawDeck;
		this.cardsInHand.add(drawDeck.drawCard());
	}

	/**
	 * 
	 * Shows all of the cards in Player's hand
	 *
	 * @return String result of all cards in Player's cardsInHand
	 */
	public String getHand() {
		String result = "";
		for (String card : this.cardsInHand) {
			result += " " + card;
		}
		return result;
	}

	/**
	 * 
	 * Adds a card to Player's hand
	 *
	 * @return String of card added to cardsInHand
	 */
	public String drawCard() {
		String card = this.drawDeck.drawCard();
		this.cardsInHand.add(card);
		return card;
	}

	/**
	 * 
	 * Gives a list of all cards in Player's hand
	 *
	 * @return ArrayList of all cards in cardsInHand
	 */
	public ArrayList<String> getCards() {
		return this.cardsInHand;
	}

}