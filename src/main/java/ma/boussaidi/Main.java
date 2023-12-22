package ma.boussaidi;

import ma.boussaidi.adapter.*;
import ma.boussaidi.container.Agent;
import ma.boussaidi.container.Container;
import ma.boussaidi.enums.*;
import ma.boussaidi.container.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
     public static void main(String[] args) {


         Agent agent1 = new Agent("Agent 1");
         Agent agent2 = new Agent("Agent 2");


         Transaction.TransactionBuilder builder = new Transaction.TransactionBuilder();
         builder.id("111");
         builder.date(new Date());
         builder.montant(100.0);
         builder.type(TypeTransaction.ACHAT);
         Transaction transaction ;
         transaction=builder.build();
         List<Transaction> transactions1=new ArrayList<>();
         transactions1.add(transaction);
         agent1.setTransactions(transactions1);
         transaction.addObserver(agent1);
         transaction.addObserver(agent2);
         transaction.createTransaction("123", 100.0, TypeTransaction.ACHAT);
         List<Transaction> transactionsAgent1 = agent1.getTransactions();
         System.out.println("Transactions gérées par Agent 1 : " + transactionsAgent1);



         agent1.displayAgentName();
         agent1.displayTransactions();



         HDMI hdmiDisplay = new HDMIDisplay();
         Container containerHDMI = new Container(hdmiDisplay);
         containerHDMI.addAgent(new Agent("Agent1"));
         containerHDMI.displayContainerState();

         // Utilisation d'un afficheur VGA via l'adapter
         VGA vgaDisplay = new VGADisplay();
         HDMI vgaAdapter = new VGAAdapter(vgaDisplay);
         Container containerVGA = new Container(vgaAdapter);
         containerVGA.addAgent(new Agent("Agent2"));
         containerVGA.displayContainerState();
     }
}

