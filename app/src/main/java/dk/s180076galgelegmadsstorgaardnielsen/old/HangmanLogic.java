/*
package dk.s180076galgelegmadsstorgaardnielsen;

import java.util.ArrayList;
import java.util.Random;

import dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces.Subject;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces.Observer;

//TODO patterns (Observer, state og factory)
public class HangmanLogic implements Observer {
    ArrayList<String> wordList = new ArrayList<>();

    private String correctWord;
    boolean isWon = false;
    boolean isLost = false;
    private int wrongGuesses;
    private String guess;
    private String playerName;
    int amountWrongGuess;


    //TODO hente ord fra nettet, feks. async task
    public HangmanLogic(Subject LogicDataGrabber) {
        LogicDataGrabber.register(this);
        wordList.add("b");
        //wordList.add("bil");
        newGame();
    }

    public int getAmountWrongGuess() {
        return amountWrongGuess;
    }

    public String getHiddenStr(int wordLength) {
        String str = "";
        for (int i = 0; i < wordLength; i++) {
            str += "*";
        }
        return str;
    }

    public String updateHiddenWordProgress(ArrayList<String> usedLetters) {
        isWon = true;
        String wordProgress = "";
        int wordLength = correctWord.length();
        for (int n = 0; n < wordLength; n++) {
            String bogstav = correctWord.substring(n, n + 1);
            if (usedLetters.contains(bogstav)) {
                wordProgress = wordProgress + bogstav;
            } else {
                wordProgress = wordProgress + "*";
                isWon = false;
            }
        }
        return wordProgress;
    }

    public boolean isWon() {
        return isWon;
    }

    public boolean guessLetter(String letter) {
        if (correctWord.contains(letter)) {
            return true;
        } else {
            ++amountWrongGuess;
            if (amountWrongGuess == 7) {
                isLost = true;
            }
            return false;
        }
    }

    public boolean isLost() {
        return isLost;
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public void newGame() {
        wrongGuesses = 0;
        isLost = false;
        isWon = false;
        correctWord = wordList.get(new Random().nextInt(wordList.size()));
    }

    @Override
    public void update(boolean isWon, boolean isLost, String guess, int wrongGuesses, String correctWord, String playerName) {
        this.playerName = playerName;
        this.isWon = isWon;
        this.isLost = isLost;
        this.guess = guess;
        this.wrongGuesses = wrongGuesses;
        this.correctWord = correctWord;
        printUpdate();
    }

    public void printUpdate() {
        System.out.println("\n" +
                "Player name: " + playerName + "\n" +
                "isWon: " + isWon + "\n" +
                "isLost: " + isLost + "\n" +
                "Guess: " + guess + "\n" +
                "Wrong Guesses: " + wrongGuesses + "\n" +
                "Correct Word: " + correctWord);
    }
}
*/
