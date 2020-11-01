package dk.s180076galgelegmadsstorgaardnielsen;

import java.util.ArrayList;

import dk.s180076galgelegmadsstorgaardnielsen.interfaces.Observer;
import dk.s180076galgelegmadsstorgaardnielsen.interfaces.Subject;

public class LogicDataGrabber implements Subject {
    private boolean isWon;
    private boolean isLost;
    private String guess;
    private int wrongGuesses;
    private String correctWord;
    private String playerName;
    private ArrayList<Observer> observers;

    public LogicDataGrabber() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        observers.remove(deleteObserver);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(isWon, isLost, guess, wrongGuesses, correctWord, playerName);
        }
    }

    public void setWon(boolean won) {
        isWon = won;
        notifyObservers();
    }

    public void setLost(boolean lost) {
        isLost = lost;
        notifyObservers();
    }

    public void setGuess(String guess) {
        this.guess = guess;
        notifyObservers();
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
        notifyObservers();
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        notifyObservers();
    }
}
