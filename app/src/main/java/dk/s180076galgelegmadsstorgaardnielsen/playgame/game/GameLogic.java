package dk.s180076galgelegmadsstorgaardnielsen.playgame.game;

import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Random;

import dk.s180076galgelegmadsstorgaardnielsen.R;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.fragments.LostGameFragment;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.fragments.WonGameFragment;

public class GameLogic {

    GameModel gameModel = GameModel.getInstance();

    public boolean guessLetter(String letter) {
        String correctWord = gameModel.getCorrectWord();
        int amountWrongGuess = gameModel.getAmountWrongGuess();
        if (correctWord.contains(letter)) {
            return true;
        } else {
            amountWrongGuess++;
            gameModel.setAmountWrongGuess(amountWrongGuess);
            if (amountWrongGuess == 7) {
                gameModel.isLost = true;
            }
            return false;
        }
    }

    public String getHiddenStr(int length) {
        String str = "";
        for (int i = 0; i < length; i++) {
            str += "*";
        }
        return str;
    }

    public String getWordProgress() {
        ArrayList<String > usedLetters = gameModel.getUsedLetters();
        String correctWord = gameModel.getCorrectWord();
        String wordProgress = "";
        int wordLength = correctWord.length();
        gameModel.isWon = true;

        for (int n = 0; n < wordLength; n++) {
            String bogstav = correctWord.substring(n, n + 1);
            if (usedLetters.contains(bogstav)) {
                wordProgress = wordProgress + bogstav;
            } else {
                wordProgress = wordProgress + "*";
                gameModel.isWon = false;
            }
        }
        return wordProgress;
    }

    public boolean isGameWon() {
        return gameModel.isWon;
    }

    public boolean isGameLost() {
        return gameModel.isLost;
    }




}
