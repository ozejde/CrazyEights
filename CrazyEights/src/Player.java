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
		String card = this.drawDeck.drawCard();
		this.cardsInHand.add(card);
		return card;
	}
	
	public ArrayList<String> getCards(){
		return this.cardsInHand;
	}
	public void discard(){
		//this.cardsInHand.g
	}
}