
/**
	*	Class: DiscardPile
	*	@author	ejdeoz, murrayjd
	*	
	*			Purpose: This class creates and modifies a DiscardPile object.
	*
	*			Use: DiscardPile discardPile  = new DiscardPile(drawDeck);
	*		
	*/
import java.util.ArrayList;

public class DiscardPile {
	private ArrayList<String> discardPile;
	private DrawDeck drawDeck;

	/**
	 * 
	 * Creates placeholder DiscardPile for game initialization
	 *
	 */
	public DiscardPile() {
		this.discardPile = new ArrayList<>();
		this.drawDeck = new DrawDeck();
	}

	/**
	 * 
	 * Initializes the DiscardPile object
	 *
	 * @param drawDeck
	 *            the current game's DrawDeck
	 * 
	 */
	public DiscardPile(DrawDeck drawDeck) {
		this.drawDeck = drawDeck;
		this.discardPile = new ArrayList<>();
		this.discardPile.add(this.drawDeck.drawCard());
	}

	/**
	 * 
	 * Displays the top card
	 *
	 * @return String version of top card
	 */
	public String getTopCard() {
		return this.discardPile.get(0);
	}

	/**
	 * 
	 * Removes a card from the DiscardPile
	 *
	 * @param i
	 *            Index of card that will be removed
	 */
	public void removeCard(int i) {
		this.discardPile.remove(i);
	}

	/**
	 * 
	 * Gives the current DiscardPile ArrayList
	 *
	 * @return ArrayList of current DiscardPile
	 */
	public ArrayList<String> getPile() {
		return this.discardPile;
	}

	/**
	 * 
	 * Adds a card to the DiscardPile
	 *
	 * @param card
	 *            String of card that will be added
	 */
	public void addCard(String card) {
		this.discardPile.add(0, card);
	}

	/**
	 * 
	 * Erases the deck, leaving only the top card
	 *
	 * @param topCard
	 *            String version of top card of the deck that will be erased
	 */
	public void restartDeck(String topCard) {
		this.discardPile = new ArrayList<>();
		this.discardPile.add(topCard);
	}
}
