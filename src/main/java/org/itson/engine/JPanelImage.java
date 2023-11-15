
package org.itson.engine;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author arace
 */
public class JPanelImage extends JLabel{
    private int x, y;
    private final String path;
    public JPanelImage(JPanel panel, String path){
        this.path = path;
        this.x = panel.getWidth();
        this.y = panel.getHeight();
        this.setSize(x,y);
    }
    public void paint(Graphics g){
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        g.drawImage(img.getImage(),0,0, x, y, null);
    }
}
