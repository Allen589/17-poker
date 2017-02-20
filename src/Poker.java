import java.util.*;

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
		for (int i = 0; i < 5; i++) {
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
		int answer = 0;
		boolean jokerFound = false;

		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (Card c : opponentDeck) {
			if (hash.get(c) == null) {
				hash.put(c.getName(), 0);
			}
			hash.put(c.getName(), hash.get(c) + 1);
		}

		for (String s : hash.keySet()) {
			if (hash.get(s) > answer) {
				answer = hash.get(s);
			}
			if (s.equals("Joker")) {
				jokerFound = true;
			}
		}
		if (jokerFound) {
			return answer + 1;
		} else {
			return answer;
		}
	}

	public int getPlayerCardsEvaluation() {
		int answer = 0;
		boolean jokerFound = false;

		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (Card c : playerDeck) {
			if (hash.get(c) == null) {
				hash.put(c.getName(), 0);
			}
			hash.put(c.getName(), hash.get(c) + 1);
		}

		for (String s : hash.keySet()) {
			if (hash.get(s) > answer) {
				answer = hash.get(s);
			}
			if (s.equals("Joker")) {
				jokerFound = true;
			}
		}
		if (jokerFound) {
			return answer + 1;
		} else {
			return answer;
		}
	}

	public void playerCut(int n) {
		for (int i = 0; i < n; i++) {
			gameDeck.add(gameDeck.remove(0));
		}

	}

	public void swap(int n, Card[] cardsToBeSwapped) {
		for (int i = 0; i < cardsToBeSwapped.length; i++) {
			gameDeck.add(cardsToBeSwapped[i]);
			playerDeck.remove(cardsToBeSwapped[i]);
		}

		for (int i = 0; i < n; i++) {
			playerDeck.add(gameDeck.remove(0));
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
