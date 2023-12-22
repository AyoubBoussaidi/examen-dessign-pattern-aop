package ma.boussaidi.strategy;

import ma.boussaidi.container.Agent;
import ma.boussaidi.container.Transaction;

public class DefaultStrategy implements AgentStrategy{
    @Override
    public void applyStrategy(Transaction transaction, Agent agent) {
        System.out.println("default strategy");
    }
}

