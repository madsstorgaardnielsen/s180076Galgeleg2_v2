package dk.s180076galgelegmadsstorgaardnielsen;

import java.util.ArrayList;
import java.util.Random;

public class HangmanLogic {
    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<String> usedLetters = new ArrayList<>();
    private String correctWord;
    private boolean isWon = false, isLost = false;
    private boolean correctGuess;
    private int wrongGuesses;
    private String wordProgress;

    //TODO hente ord fra nettet, feks. async task
    public HangmanLogic() {
        wordList.add("bil");
        newGame();
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public boolean isWon() {
        return isWon;
    }

    public boolean isLost() {
        return isLost;
    }

    public boolean isCorrectGuess() {
        return correctGuess;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public ArrayList<String> getUsedLetters() {
        return usedLetters;
    }

    public String getWordProgress() {
        return wordProgress;
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public boolean isGameOver() {
        return isWon || isLost;
    }

    public void newGame() {
        usedLetters.clear();
        wrongGuesses = 0;
        isLost = false;
        isWon = false;
        correctWord = wordList.get(new Random().nextInt(wordList.size()));
        updateHiddenWordProgress();
    }

    public void guessLetter(String letter) {
        if (letter.length() != 1) return;
        if (usedLetters.contains(letter)) return;
        if (isWon || isLost) return;

        usedLetters.add(letter);

        if (correctWord.contains(letter)) {
            correctGuess = true;
        } else {
            correctGuess = false;
            wrongGuesses = wrongGuesses + 1;
            if (wrongGuesses > 6) {
                isLost = true;
            }
        }
        updateHiddenWordProgress();
    }

    public void updateHiddenWordProgress() {
        wordProgress = "";
        isWon = true;
        for (int n = 0; n < correctWord.length(); n++) {
            String bogstav = correctWord.substring(n, n + 1);
            if (usedLetters.contains(bogstav)) {
                wordProgress = wordProgress + bogstav;
            } else {
                wordProgress = wordProgress + "*";
                isWon = false;
            }
        }
    }
}
