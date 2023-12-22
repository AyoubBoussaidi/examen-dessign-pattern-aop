package ma.boussaidi.adapter;

public class VGAAdapter implements HDMI {
    private VGA vgaDisplay;

    public VGAAdapter(VGA vgaDisplay) {
        this.vgaDisplay = vgaDisplay;
    }

    @Override
    public void display(String content) {
        vgaDisplay.displayVGA(content);
    }
}