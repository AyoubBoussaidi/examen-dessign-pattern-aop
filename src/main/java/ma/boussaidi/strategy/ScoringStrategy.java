package ma.boussaidi.strategy;

import ma.boussaidi.container.Agent;
import ma.boussaidi.container.Transaction;
import ma.boussaidi.enums.TypeTransaction;

public class ScoringStrategy implements AgentStrategy {

    @Override
    public void applyStrategy(Transaction transaction, Agent agent) {
        double montant = transaction.getMontant();
        if (transaction.getType() == TypeTransaction.ACHAT) {
            agent.addToBalance(montant);
        } else {
            agent.subtractFromBalance(montant);
        }
    }
}

