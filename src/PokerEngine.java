

/**
 * 17PokerEngine - interface defining the methods expected from a class
 * 					 implementing the 17 Poker game logic.
 * 
 */
public interface PokerEngine {
	public static final int ONE_PAIR 		 = 1;
	public static final int THREE_OF_A_KIND	 = 2;
	public static final int FOUR_OF_A_KIND 	 = 3;
	public static final int TWO_PAIR 		 = 4;
	public static final int FIVE_OF_A_KIND	 = 5;
	public static final int FULL_HOUSE       = 6; 
	public static final int DEALER_WON 		 = 7;
	public static final int PLAYER_WON 		 = 8;
	public static final int GAME_IN_PROGRESS = 9;
	
	/**
	 * Returns the number of decks being used. 
	 * @return number of decks
	 */
	public int getNumberOfDecks();
	
	
	/**
	 * Creates and shuffles the card deck(s) using a random number generator.
	 */
	public void createAndShuffleGameDeck();
	
	
	/**
	 * Returns the current deck of cards.
	 * @return Card array representing deck of cards.
	 */
	public Card[] getGameDeck();
	
	/**
	 * Creates a new deck of cards, and assigns cards to the dealer and player.
	 * A total of eight cards are dealt alternating between player and dealer.
	 */
	public void deal();
	
	/**
	 * Returns dealer's cards.
	 * @return Card array representing the dealer's cards.
	 */
	public Card[] getDealerCards();
	

	
	
	/**
	 * Returns an integer value that represents the hand of the Dealer.
	 * @return Integer value that corresponds to one of the following: 
	 * ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FOUR_OF_A_KIND, FIVE_OF_A_KIND, FULL_HOUSE
	 */

	public int getDealerCardsEvaluation();
	
	
	/**
	 * Returns player's cards.
	 * @return Card array representing the player's cards.
	 */
	public Card[] getPlayerCards();
	
	
	/**
	 * Returns an integer value that represents the hand of the Player.
	 * @return Integer value that corresponds to one of the following: 
	 * ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FOUR_OF_A_KIND, FIVE_OF_A_KIND, FULL_HOUSE
	 */
	public int getPlayerCardsEvaluation();
	
	/**
	 * Cuts the game deck based on the integer n. It will send n cards to the
	 * bottom of the deck.
	 */
	public void playerCut(int n);
	
	
	/** 
	 * Updates the bet amount to the provided value 
	 */
	public void setBetAmount(int amount);
	
	
	/**
	 * Returns an integer representing the bet amount.
	 * @return bet amount.
	 */
	public int getBetAmount();
	
	
	/**
	 * Updates the player's account with the parameter value.
	 * @param amount 
	 */
	public void setAccountAmount(int amount);
	
	
	/**
	 * Returns the player's account amount
	 * @return account amount
	 */
	public int getAccountAmount();
	
	
	/**
	 * Returns an integer representing the game status.   
	 * @return DRAW, PLAYER_WON, DEALER_WON OR GAME_IN_PROGRESS
	 */
	public int getGameStatus();
}
