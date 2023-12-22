package ma.boussaidi.observer;

import ma.boussaidi.container.Transaction;

public interface AgentObserver {
    void update(Transaction transaction);
}


