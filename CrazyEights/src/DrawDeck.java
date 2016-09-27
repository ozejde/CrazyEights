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
			Collections.shuffle(this.deck);
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
			Collections.shuffle(this.deck);
		}
	}
}
