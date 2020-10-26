package dk.s180076galgelegmadsstorgaardnielsen;

import java.util.ArrayList;
import java.util.Random;

public class HangmanLogic {
    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<String> usedLetters = new ArrayList<>();
    private String correctWord;
    private boolean isWon, isLost = false;
    private boolean correctGuess;
    private int wrongGuesses;
    private String wordProgress;

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
        return null; //TODO find ud af hvordan kun de korrekte bogstaver kan returneres
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
        updateWordProgress();
    }

    public void guessLetter(String letter) {
        if (correctWord.length() != 1) return;
        System.out.println("Der gættes på bogstavet: " + letter);
        if (usedLetters.contains(letter)) return;
        if (isWon || isLost) return;

        usedLetters.add(letter);

        if (correctWord.contains(letter)) {
            correctGuess = true;
            System.out.println("Bogstavet var korrekt: " + letter);
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            correctGuess = false;
            System.out.println("Bogstavet var IKKE korrekt: " + letter);
            wrongGuesses = wrongGuesses + 1;
            if (wrongGuesses > 6) {
                isLost = true;
            }
        }
        updateWordProgress();
    }

    public void updateWordProgress() {
        wordProgress = "";
        isWon = true;
        for (int n = 0; n < correctWord.length(); n++) {
            String bogstav = correctWord.substring(n, n + 1);
            if (usedLetters.contains(bogstav)) {
                wordProgress = wordProgress + bogstav;
            } else {
                wordProgress = wordProgress + "*";
                isLost = false;
            }
        }
    }
}
