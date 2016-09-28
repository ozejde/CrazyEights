import java.util.ArrayList;

public class DiscardPile {
	private ArrayList<String> discardPile;
	private DrawDeck drawDeck;
	
	public DiscardPile(DrawDeck drawDeck){
		this.drawDeck = drawDeck;
		this.discardPile = new ArrayList<>();
		this.discardPile.add(this.drawDeck.drawCard());
	}
	
	public String getTopCard(){
		return this.discardPile.get(0);
	}
	
	public void addCard(String card){
		this.discardPile.add(0,card);
			}
}
