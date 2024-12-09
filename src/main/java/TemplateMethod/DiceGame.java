package TemplateMethod;

import java.util.Random;

public class DiceGame extends Game {
    private int[] scores;         // Array to track player scores
    private int targetScore;      // Winning score
    private int numberOfPlayers;  // Total players
    private int winner;           // Index of the winner
    private Random random;        // Random number generator for dice rolls

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.scores = new int[numberOfPlayers];
        this.targetScore = 50;  // Set target score for the game
        this.winner = -1;       // No winner initially
        this.random = new Random();

        System.out.println("Welcome to the Dice Game!");
        System.out.println("First player to reach " + targetScore + " points wins!");
    }

    @Override
    public boolean endOfGame() {
        // Game ends when a player reaches or exceeds the target score
        for (int i = 0; i < numberOfPlayers; i++) {
            if (scores[i] >= targetScore) {
                winner = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Player " + (player + 1) + "'s turn:");
        int diceRoll = random.nextInt(6) + 1;  // Simulate dice roll (1-6)
        scores[player] += diceRoll;
        System.out.println("Player " + (player + 1) + " rolled a " + diceRoll);

    }

    @Override
    public void displayWinner() {
        System.out.println("==================================");
        System.out.println("Game Over!");
        System.out.println("Player " + (winner + 1) + " wins with " + scores[winner] + " points!");
    }
}
