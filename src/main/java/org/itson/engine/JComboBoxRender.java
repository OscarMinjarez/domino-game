
package org.itson.engine;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author arace
 */
public class JComboBoxRender extends JLabel implements ListCellRenderer {

    Hashtable<Object, ImageIcon> mAvatar;
    ImageIcon imgAvatr = new ImageIcon(new ImageIcon(getClass().getResource("/assets/other/avatar1.png")).getImage()
            .getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));

  
    

    public JComboBoxRender(Hashtable<Object, ImageIcon> mAvatar) {
        this.mAvatar = mAvatar;
    }

   

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (mAvatar.get(value) == null) {
            setIcon(imgAvatr);

        } else {
            setIcon(mAvatar.get(value));
        }
        setText(value.toString());
        return this;
    }

}
