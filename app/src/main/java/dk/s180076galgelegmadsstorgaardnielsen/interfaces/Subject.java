package dk.s180076galgelegmadsstorgaardnielsen.interfaces;

public interface Subject {
    void addObserver(Observer obs);

    void deleteObserver(Observer obs);

    void notifyObservers();
}

