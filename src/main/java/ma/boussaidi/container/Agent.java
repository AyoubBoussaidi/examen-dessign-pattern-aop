package ma.boussaidi.container;



import ma.boussaidi.Annotation.Log;
import ma.boussaidi.observer.AgentObserver;
import ma.boussaidi.strategy.AgentStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent implements AgentObserver {
    private String nom;
    private List<Transaction> transactions;
    private AgentStrategy strategy;

    private double balance;
    private List<Transaction> history;
    public Agent(String nom) {
        this.nom = nom;
        this.transactions = new ArrayList<>();
    }

    public void setStrategy(AgentStrategy strategy) {
        this.strategy = strategy;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public AgentStrategy getStrategy() {
        return strategy;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public void setHistory(List<Transaction> history) {
        this.history = history;
    }
@Log
    public void displayAgentName() {
        System.out.println("Nom de l'agent : " + nom);
    }

    public void displayTransactions() {
        System.out.println("Transactions de l'agent " + nom + ":");
        for (Transaction transaction : transactions) {
            System.out.println("ID: " + transaction.getId() + ", Montant: " + transaction.getMontant() +
                    ", Type: " + transaction.getType() + ", Date: " + transaction.getDate());
        }
    }

    public Transaction getMaxAmountTransaction() {
        return transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getMontant))
                .orElse(null);
    }
    private void applyStrategy(Transaction transaction) {
        if (strategy != null) {
            strategy.applyStrategy(transaction, this);
        }
    }

    public void addToBalance(double amount) {
        balance += amount;
    }

    public void subtractFromBalance(double amount) {
        balance -= amount;
    }

    public void addToHistory(Transaction transaction) {
        if (history == null) {
            history = new ArrayList<>();
        }
        history.add(transaction);
    }
    @Override
    public void update(Transaction transaction) {

        System.out.println("Agent " + nom + " a reçu une nouvelle transaction : " + transaction.getId());
        applyStrategy(transaction);
        transactions.add(transaction);
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}

