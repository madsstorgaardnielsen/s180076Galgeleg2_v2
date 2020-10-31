package dk.s180076galgelegmadsstorgaardnielsen.interfaces;

public interface Observer {
    void update(String wordProgress, String correctWord, int wrongGuesses);
}
