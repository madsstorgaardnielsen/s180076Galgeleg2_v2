package dk.s180076galgelegmadsstorgaardnielsen.playgame.game;

import java.util.ArrayList;

import dk.s180076galgelegmadsstorgaardnielsen.menu.settings.SettingController;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.gamefactory.Game;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.gamefactory.GameFactory;

public class GameController {

    GameLogic gameLogic;
    GameModel gameModel;
    SettingController settingController;
    GameFactory gameFactory;
    Game game;
    String DIFFICULTY_LEVEL;


    public GameController() {
        settingController = new SettingController();
        DIFFICULTY_LEVEL = settingController.getDifficultyLevel();
        gameFactory = new GameFactory();
        game = gameFactory.makeGame(DIFFICULTY_LEVEL);
        gameLogic = new GameLogic();
        gameModel = GameModel.getInstance();
        //gameModel.setCorrectWord(game.getCorrectWord());
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public String getHiddenWord() {
        int length = game.getCorrectWord().length();
        return gameLogic.getHiddenStr(length);
    }

    public boolean isGameWon() {
        return gameModel.isWon;
    }

    public boolean isGameLost() {
        return gameModel.isLost;
    }

    public int getAmountWrongGuesses() {
        return gameModel.getAmountWrongGuess();
    }

    public void setAmountWrongGuesses(int amountWrongGuesses) {
        gameModel.setAmountWrongGuess(amountWrongGuesses);
    }

    public ArrayList<String> getUsedLetters() {
        return gameModel.getUsedLetters();
    }

    public void setUsedLetters(String letter) {
        gameModel.addUsedLetter(letter);
    }

    public void setGuess(String guess) {
        gameModel.setGuess(guess);
    }

    public String getGuess() {
        return gameModel.getGuess();
    }

    public String getPlayerName() {
        return gameModel.getPlayerName();
    }

    public void setPlayerName(String playerName) {
        gameModel.setPlayerName(playerName);
    }

    public String getWordProgress() {
        return gameLogic.getWordProgress();
    }

    public String getCorrectWord() {
        return gameModel.getCorrectWord();
    }

    public boolean isLost() {
        return gameModel.isLost;
    }

    public void setLost(boolean lost) {
        gameModel.setLost(lost);
    }

    public boolean isWon() {
        return gameModel.isWon;
    }

    public void setWon(boolean won) {
        gameModel.setWon(won);
    }

    public boolean isGuessCorrect(String letter) {
        return gameLogic.guessLetter(letter);
    }
}
