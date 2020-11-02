package dk.s180076galgelegmadsstorgaardnielsen.playgame.gamefactory;

import java.util.ArrayList;

public class MediumGame extends Game {

    ArrayList<String> wordList;
    int amountWrongGuess;
    boolean isLost;
    boolean isWon;
    String correctWord;

    public MediumGame(ArrayList<String> wordList, int amountWrongGuess, boolean isLost, boolean isWon, String correctWord) {
        this.wordList = wordList;
        this.amountWrongGuess = amountWrongGuess;
        this.isLost = isLost;
        this.isWon = isWon;
        this.correctWord=correctWord;
    }

    @Override
    public ArrayList<String> getWordList() {
        return super.getWordList();
    }

    @Override
    public void setWordList(ArrayList<String> wordList) {
        super.setWordList(wordList);
    }

    @Override
    public boolean isWon() {
        return super.isWon();
    }

    @Override
    public void setWon(boolean won) {
        super.setWon(won);
    }

    @Override
    public boolean isLost() {
        return super.isLost();
    }

    @Override
    public void setLost(boolean lost) {
        super.setLost(lost);
    }

    @Override
    public String getCorrectWord() {
        return super.getCorrectWord();
    }

    @Override
    public void setCorrectWord(String correctWord) {
        super.setCorrectWord(correctWord);
    }

    @Override
    public String getGuess() {
        return super.getGuess();
    }

    @Override
    public void setGuess(String guess) {
        super.setGuess(guess);
    }

    @Override
    public String getPlayerName() {
        return super.getPlayerName();
    }

    @Override
    public void setPlayerName(String playerName) {
        super.setPlayerName(playerName);
    }

    @Override
    public int getAmountWrongGuess() {
        return super.getAmountWrongGuess();
    }

    @Override
    public void setAmountWrongGuess(int amountWrongGuess) {
        super.setAmountWrongGuess(amountWrongGuess);
    }
}
