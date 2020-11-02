package dk.s180076galgelegmadsstorgaardnielsen.playgame.gamefactory;

import java.util.ArrayList;

public abstract class Game {
    ArrayList<String> wordList = new ArrayList<>();
    boolean isWon = false;
    boolean isLost = false;
    String correctWord;
    String guess;
    String playerName;
    int amountWrongGuess;

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public void setWordList(ArrayList<String> wordList) {
        this.wordList = wordList;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAmountWrongGuess() {
        return amountWrongGuess;
    }

    public void setAmountWrongGuess(int amountWrongGuess) {
        this.amountWrongGuess = amountWrongGuess;
    }

}
