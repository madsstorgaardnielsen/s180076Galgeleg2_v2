package dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces;

public interface Observer {
    void update(boolean isWon, boolean isLost, String guess, int wrongGuesses, String correctWord, String playerName);
}
