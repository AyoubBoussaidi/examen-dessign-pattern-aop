package ma.boussaidi.strategy;

import ma.boussaidi.container.Agent;
import ma.boussaidi.container.Transaction;

public interface AgentStrategy {

    void applyStrategy(Transaction transaction, Agent agent);
}

