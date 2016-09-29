import java.util.ArrayList;
import java.util.Collections;

public class DrawDeck {
	private ArrayList<String> deck;

	public DrawDeck(boolean shuffle) {
		this.deck = new ArrayList<>();

		for (String card : NamedDecks.standardDeck) {
			this.deck.add(card);
		}

		if (shuffle) {
			this.shuffle();
		}
	}

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

	public void shuffle(){
		Collections.shuffle(this.deck);
	}
	
	public int size(){
		return this.deck.size();
	}
	
	public String drawCard() {
			String card = this.deck.get(0);
			this.deck.remove(0);
			return card;
	}
	
	public void addDeck(ArrayList<String> discardPile){
		for (String card : discardPile) {
			this.deck.add(card);
		}
		this.shuffle();
	}
}
