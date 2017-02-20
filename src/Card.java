/**
 * Card - A Card object representing a playing card from the standard deck
 * It has a name, suit, and value.
 */
public class Card {
	private String name;
	private String suit;
	private int value;
	
	public Card(String name, String suit, int value) {
		this.name = name;
		this.suit = suit;
		this.value = value;
	}
	
	public String getNameAndSuit() {
		return name + suit;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	
}
