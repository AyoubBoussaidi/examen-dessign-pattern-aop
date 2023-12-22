package ma.boussaidi.container;

import ma.boussaidi.adapter.HDMI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<String, Agent> agents;
    private HDMI display;
    private static Container instance;//instance unique de cette classe

    public Container(HDMI display) {
        agents = new HashMap<>();
        this.display=display;

    }

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container(getInstance().display);
        }
        return instance;
    }
    public void addAgent(Agent agent) {
        agents.put(agent.getNom(), agent);
    }

    public void removeAgent(String nomAgent) {
        agents.remove(nomAgent);
    }

    public Agent getAgent(String nomAgent) {
        return agents.get(nomAgent);
    }

    public void displayAllAgents() {
        System.out.println("Liste des agents dans le conteneur:");
        for (Agent agent : agents.values()) {
            System.out.println("Nom: " + agent.getNom());
        }
    }

    public void displayContainerState() {
        StringBuilder content = new StringBuilder("État du conteneur d'agents :\n");
        for (Agent agent : agents.values()) {
            content.append("Agent ").append(agent.getNom()).append(": ");
            content.append("\n");
        }

        display.display(content.toString());
    }
}



