package ma.boussaidi.adapter;

public class VGADisplay implements VGA {
    @Override
    public void displayVGA(String content) {
        System.out.println("Affichage VGA : " + content);
    }
}
