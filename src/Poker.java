import java.util.*;

/// second commit testing!

public class Poker implements PokerEngine {
	private ArrayList<Card> gameDeck = new ArrayList<Card>();
	private ArrayList<Card> playerDeck = new ArrayList<Card>();
	private ArrayList<Card> opponentDeck = new ArrayList<Card>();
	private Random randomGenerator = new Random();
	private static int initialAccountAmount = 200;
	private static int initialBetAmount = 5;
	private int numberOfDecks;
	private int accountAmount;
	private int betAmount;
	private int gameSession;

	public Poker(Random randomGenerator, int numberOfDecks) {
		this.numberOfDecks = numberOfDecks;
		this.randomGenerator = randomGenerator;
		this.accountAmount = initialAccountAmount;
		this.betAmount = initialBetAmount;
	}

	public int getNumberOfDecks() {
		return numberOfDecks;
	}

	public void createAndShuffleGameDeck() {
		gameDeck = new ArrayList<Card>();
		gameDeck.add(new Card("Joker", "wildcard", 99));
		gameDeck.add(new Card("J", "spade", 1));
		gameDeck.add(new Card("J", "diamond", 1));
		gameDeck.add(new Card("J", "heart", 1));
		gameDeck.add(new Card("J", "clubs", 1));
		gameDeck.add(new Card("Q", "spade", 2));
		gameDeck.add(new Card("Q", "diamond", 2));
		gameDeck.add(new Card("Q", "heart", 2));
		gameDeck.add(new Card("Q", "clubs", 2));
		gameDeck.add(new Card("K", "spade", 3));
		gameDeck.add(new Card("K", "diamond", 3));
		gameDeck.add(new Card("K", "heart", 3));
		gameDeck.add(new Card("K", "clubs", 3));
		gameDeck.add(new Card("A", "spade", 4));
		gameDeck.add(new Card("A", "diamond", 4));
		gameDeck.add(new Card("A", "heart", 4));
		gameDeck.add(new Card("A", "clubs", 4));
		Collections.shuffle(gameDeck, randomGenerator);
	}

	public void deal() {
		playerDeck = new ArrayList<Card>();
		opponentDeck = new ArrayList<Card>();
		this.createAndShuffleGameDeck();
		for (int i = 0; i < 4; i++) {
			playerDeck.add(gameDeck.remove(0));
			opponentDeck.add(gameDeck.remove(0));
		}
	}

	public Card[] getGameDeck() {
		Card[] deck = new Card[gameDeck.size()];
		deck = gameDeck.toArray(deck);
		return deck;
	}

	public Card[] getDealerCards() {
		Card[] dealerCards = new Card[opponentDeck.size()];
		dealerCards = opponentDeck.toArray(dealerCards);
		return dealerCards;
	}

	public Card[] getPlayerCards() {
		Card[] playerCards = new Card[playerDeck.size()];
		playerCards = playerDeck.toArray(playerCards);
		return playerCards;
	}

	public int getDealerCardsEvaluation() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPlayerCardsEvaluation() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void playerCut(int n) {
		for (int i = 0; i < n; i++) {
			gameDeck.add(gameDeck.remove(0));
		}

	}

	public void setBetAmount(int amount) {
		betAmount = amount;

	}

	public int getBetAmount() {
		return betAmount;
	}

	public void setAccountAmount(int amount) {
		accountAmount = amount;

	}

	public int getAccountAmount() {
		return accountAmount;
	}

	public int getGameStatus() {
		return gameSession;
	}

}
