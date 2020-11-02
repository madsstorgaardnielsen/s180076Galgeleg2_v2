package dk.s180076galgelegmadsstorgaardnielsen.menu.highscore;

public class HighscoreController {
    String secretWord;
    String playerName;
    String guesses;
    HighscoreModel highscoreModel;

    public HighscoreController() {
        highscoreModel = new HighscoreModel();
    }

    public void addHighscore(String correctWord, String playerName, int amountWrongGuesses) {
        highscoreModel = new HighscoreModel(correctWord,playerName,amountWrongGuesses+"");
        highscoreModel.addHighscore(highscoreModel);
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getGuesses() {
        return guesses;
    }

    public void setGuesses(String guesses) {
        this.guesses = guesses;
    }
}
