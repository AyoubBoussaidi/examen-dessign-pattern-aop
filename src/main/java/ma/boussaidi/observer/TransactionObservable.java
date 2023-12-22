package ma.boussaidi.observer;

import ma.boussaidi.container.Agent;
import ma.boussaidi.container.Transaction;

public interface TransactionObservable {
    void addObserver(AgentObserver observer);
    void removeObserver(AgentObserver observer);
    void notifyObservers(Transaction transaction);
}

