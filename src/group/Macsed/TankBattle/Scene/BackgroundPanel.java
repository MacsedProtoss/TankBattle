package group.Macsed.TankBattle.Scene;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
    private static final long serialVersionUID=-7411632419492480055L;
    private Image image;


    public BackgroundPanel(Image image) {
        this.image=image;
        this.setOpaque(false);
    }



    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (image != null) {
            int width=getWidth();
            int height=getHeight();
            g.drawImage(image, 0,0,width,height,this);
        }
    }
}
