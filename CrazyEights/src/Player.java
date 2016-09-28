import java.util.ArrayList;

public class Player {
	public DrawDeck drawDeck;
	public ArrayList<String> cardsInHand;

	public Player(DrawDeck drawDeck) {
		this.cardsInHand = new ArrayList<>();
		this.drawDeck = drawDeck;
		this.cardsInHand.add(drawDeck.drawCard());
	}

	public String getHand() {
		String result = "";
		for (String card : this.cardsInHand) {
			result += " " + card;
		}
		return result;
	}
	
	
	
	public String drawCard(){

		this.cardsInHand.add(drawDeck.drawCard());
	}

}