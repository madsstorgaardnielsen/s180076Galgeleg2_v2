package dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces;

public interface Subject {
    void register(Observer newObserver);

    void unregister(Observer deleteObserver);

    void notifyObservers();
}

