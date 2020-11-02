package dk.s180076galgelegmadsstorgaardnielsen.menu.highscore;

public class HighscoreModel {
    String secretWord;
    String playerName;
    String guesses;

    public String getGuesses() {
        return guesses;
    }

    public HighscoreModel(String secretWord, String playerName, String guesses) {
        this.secretWord = secretWord;
        this.playerName = playerName;
        this.guesses = guesses;
    }

    public HighscoreModel() {
    }

    public HighscoreModel addHighscore(HighscoreModel highscoreModel) {
        return new HighscoreModel();
    }

    public String toString() {
        if (Integer.parseInt(guesses) == 0) {
            return playerName + " havde ordet \"" + secretWord + "\" og fandt det med " + guesses + " forkerte gæt.";
        }
        if (Integer.parseInt(guesses) == 1) {
            return playerName + " havde ordet \"" + secretWord + "\" og fandt det med " + guesses + " forkert gæt.";
        } else
            return playerName + " havde ordet \"" + secretWord + "\" og fandt det med " + guesses + " forkerte gæt.";
    }
}
