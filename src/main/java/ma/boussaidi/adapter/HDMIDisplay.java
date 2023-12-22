package ma.boussaidi.adapter;

import ma.boussaidi.Annotation.Log;

public class HDMIDisplay implements HDMI {
    @Override
    @Log
    public void display(String content) {
        System.out.println("Affichage HDMI : " + content);
    }
}