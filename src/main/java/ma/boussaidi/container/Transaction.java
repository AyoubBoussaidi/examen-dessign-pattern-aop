package ma.boussaidi.container;

import ma.boussaidi.enums.TypeTransaction;
import ma.boussaidi.observer.AgentObserver;
import ma.boussaidi.observer.TransactionObservable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction implements TransactionObservable{
    private String id;
    private Date date;
    private double montant;
    private TypeTransaction type;

    private List<AgentObserver> observers = new ArrayList<>();

    public Transaction(TransactionBuilder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = builder.type;
    }

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public TypeTransaction getType() {
        return type;
    }


    @Override
    public void addObserver(AgentObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AgentObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Transaction transaction) {
        for (AgentObserver observer : observers) {
            observer.update(transaction);
        }
    }
    public void createTransaction(String id, double montant, TypeTransaction type) {
        Transaction newTransaction = new TransactionBuilder()
                .montant(12)
                .type(TypeTransaction.ACHAT)
                .date(new Date())
                .build();

        notifyObservers(newTransaction);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", type=" + type +
                ", observers=" + observers +
                '}';
    }

    public static class TransactionBuilder  {
        private String id;
        private Date date;
        private double montant;
        private TypeTransaction type;

        public TransactionBuilder() {
        }

        public TransactionBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TransactionBuilder date(Date date) {
            this.date = date;
            return this;
        }

        public TransactionBuilder montant(double montant) {
            this.montant = montant;
            return this;
        }

        public TransactionBuilder type(TypeTransaction type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }

    }}