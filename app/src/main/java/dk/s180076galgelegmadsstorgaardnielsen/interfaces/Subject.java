package dk.s180076galgelegmadsstorgaardnielsen.interfaces;

public interface Subject {
    void register(Observer newObserver);

    void unregister(Observer deleteObserver);

    void notifyObservers();
}

