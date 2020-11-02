package dk.s180076galgelegmadsstorgaardnielsen.playgame.game;

import java.util.ArrayList;

import dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces.Observer;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces.Subject;

public class GameModel implements Subject {
    private static GameModel instance = new GameModel();
    private ArrayList<Observer> observers;
    ArrayList<String> usedLetters = new ArrayList<>();
    String guess;
    String playerName;
    String wordProgress = "";
    String correctWord;
    int amountWrongGuess;
    boolean isLost = false;
    boolean isWon = false;

    private GameModel() {
        observers = new ArrayList<>();
    }

    public void resetVariables() {
        usedLetters.clear();
        guess = "";
        playerName = "";
        wordProgress = "";
        correctWord = "";
        amountWrongGuess=0;
        isLost=false;
        isWon=false;
    }

    public static GameModel getInstance() {
        return instance;
    }

    public boolean isLost() {
        return isLost;
    }

    public void clearUsedLetters() {
        usedLetters.clear();
    }

    public void setLost(boolean lost) {
        isLost = lost;
        notifyObservers();
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
        notifyObservers();
    }

    public ArrayList<String> getUsedLetters() {
        return usedLetters;
    }

    public void addUsedLetter(String letter) {
        usedLetters.add(letter);
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
        notifyObservers();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        notifyObservers();
    }

    public String getWordProgress() {
        return wordProgress;
    }

    public void setWordProgress(String wordProgress) {
        this.wordProgress = wordProgress;
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
        notifyObservers();
    }

    public int getAmountWrongGuess() {
        return amountWrongGuess;
    }

    public void setAmountWrongGuess(int amountWrongGuess) {
        this.amountWrongGuess = amountWrongGuess;
        notifyObservers();
    }


    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
        System.out.println("--- OBSERVER ADDED ---");
    }

    @Override
    public void unregister(Observer deleteObserver) {
        observers.remove(deleteObserver);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(isWon, isLost, guess, amountWrongGuess, correctWord, playerName);
        }
    }
}
