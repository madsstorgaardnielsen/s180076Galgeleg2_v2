package dk.s180076galgelegmadsstorgaardnielsen.playgame.game;

import org.junit.Test;

import dk.s180076galgelegmadsstorgaardnielsen.menu.settings.SettingController;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.gamefactory.Game;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.gamefactory.GameFactory;

import static org.junit.Assert.*;

public class GameControllerTest {
    SettingController settingController = new SettingController();
    String DIFFICULTY_LEVEL = settingController.getDifficultyLevel();
    GameFactory gameFactory = new GameFactory();
    Game game = gameFactory.makeGame(DIFFICULTY_LEVEL);

    //GameLogic gameLogic = new GameLogic();
    GameModel gameModel = GameModel.getInstance();
    GameController gc = new GameController();
    GameLogic gl = new GameLogic();
    public void startNewGame(Game newGame) {
        gameModel.setWon(newGame.isWon());
        gameModel.setLost(newGame.isLost());
        gameModel.setAmountWrongGuess(newGame.getAmountWrongGuess());
        gameModel.clearUsedLetters();
    }

    @Test
    public void getHiddenWord() {
        startNewGame(game);
        assertEquals("easy", settingController.getDifficultyLevel());
    }

    @Test
    public void isGameWon() {
        gameModel.setWon(false);
        assertEquals(false, gameModel.isWon);
    }

    @Test
    public void isGameLost() {
        gameModel.setLost(false);
        assertEquals(false, gameModel.isLost);
    }

    @Test
    public void getAmountWrongGuesses() {
        assertEquals(0, gc.getAmountWrongGuesses());
        gc.setAmountWrongGuesses(1);
        assertEquals(1, gc.getAmountWrongGuesses());
    }

    @Test
    public void getUsedLetters() {
        gc.setUsedLetters("l");
        int size = gc.getUsedLetters().size();
        assertEquals(1, size);
    }


    @Test
    public void setGuess() {
        gc.setGuess("l");
        assertEquals("l", gc.getGuess());
    }

    @Test
    public void getPlayerName() {
        gc.setPlayerName("m");
        assertEquals("m", gc.getPlayerName());
    }

    @Test
    public void getWordProgress() {
        gameModel.setCorrectWord("*");
        assertEquals("*", gc.getWordProgress());
    }

    @Test
    public void getCorrectWord() {
        gameModel.setCorrectWord("easy");
        assertEquals(gc.getCorrectWord(),"easy");
    }

    @Test
    public void isLost() {
        assertEquals(gc.isLost(),false);
        gc.setLost(true);
        assertEquals(gc.isLost(),true);
    }

    @Test
    public void isWon() {
        assertEquals(gc.isWon(),false);
        gc.setWon(true);
        assertEquals(gc.isWon(),true);
    }


    @Test
    public void isGuessCorrect() {
        gameModel.setCorrectWord("l");
        assertEquals(gl.guessLetter("l"),true);
    }
}