package ma.boussaidi.strategy;

import ma.boussaidi.container.Agent;
import ma.boussaidi.container.Transaction;

public class HistoryStrategy implements AgentStrategy {

    @Override
    public void applyStrategy(Transaction transaction, Agent agent) {
        agent.addToHistory(transaction);
    }
}

