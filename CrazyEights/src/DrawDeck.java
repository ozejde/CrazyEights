import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: DrawDeck
 * 
 * @author ejdeoz, murrayjd
 * 
 *         Purpose: This class creates and modifies a DrawDeck object.
 *
 *         Use: DrawDeck drawDeck = new drawDeck(testDeck, false);
 * 
 */
public class DrawDeck {
	private ArrayList<String> deck;
	
	/**
	 * 
	 * Creates placeholder DrawDeck for game initialization
	 *
	 */
	public DrawDeck(){
		this.deck = new ArrayList<>();
	}

	/**
	 * 
	 * Creates a new DrawDeck object
	 *
	 * @param shuffle
	 *            Boolean of whether or not to shuffle
	 */
	public DrawDeck(boolean shuffle) {
		this.deck = new ArrayList<>();

		for (String card : NamedDecks.standardDeck) {
			this.deck.add(card);
		}

		if (shuffle) {
			this.shuffle();
		}
	}

	/**
	 * 
	 * Creates a new DrawDeck object
	 *
	 * @param deckName
	 *            String name of desired deck
	 * @param shuffle
	 *            Boolean of whether or not to shuffle
	 */
	public DrawDeck(String deckName, boolean shuffle) {
		this.deck = new ArrayList<>();
		String[] startDeck;

		if (deckName.equals("standardDeck")) {
			startDeck = NamedDecks.standardDeck;
		} else {
			startDeck = NamedDecks.testDeck;
		}

		for (String card : startDeck) {
			this.deck.add(card);
		}

		if (shuffle) {
			this.shuffle();
		}
	}

	/**
	 * 
	 * Shuffles the DrawDeck
	 *
	 */
	public void shuffle() {
		Collections.shuffle(this.deck);
	}

	/**
	 * 
	 * Gives the size of the DrawDeck
	 *
	 * @return Integer of the size of DrawDeck
	 */
	public int size() {
		return this.deck.size();
	}

	/**
	 * 
	 * Removes top card
	 *
	 * @return String of the removed card
	 */
	public String drawCard() {
		String card = this.deck.get(0);
		this.deck.remove(0);
		return card;
	}

	/**
	 * 
	 * Adds discard pile without top card in case of empty DrawDeck
	 *
	 * @param discardPile
	 *            ArrayList of cards to be added to DrawDeck
	 */
	public void addDeck(ArrayList<String> discardPile) {
		for (String card : discardPile) {
			this.deck.add(card);
		}
		this.shuffle();
	}
}
