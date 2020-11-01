package dk.s180076galgelegmadsstorgaardnielsen;

public class HighscoreManager {
    String secretWord;
    String playerName;
    String guesses;

    public String getGuesses() {
        return guesses;
    }

    public HighscoreManager(String secretWord, String playerName, String guesses) {
        this.secretWord = secretWord;
        this.playerName = playerName;
        this.guesses = guesses;
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
