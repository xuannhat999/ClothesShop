package GUI;

import BUS.FeatureBUS;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FeatureButton extends JButton{
    private FeatureBUS featurebus = new FeatureBUS();
    public FeatureButton(int featureid)
    {
        setText(featurebus.getFeatureById(featureid).getFeatureName());
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBackground(Theme.light2);
        setFont(new Font("Roboto",Font.BOLD,18));
        setPreferredSize(new Dimension(300,75));
        setMaximumSize(new Dimension(300, 75));
        setMinimumSize(new Dimension(300, 75));
        setHorizontalAlignment(LEFT);
        setForeground(Color.darkGray);
        setIconTextGap(15);
        switch(featureid)
        {
            case 1:
                setIcon(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-buy-40.png"));
                setContentAreaFilled(true);
                break;
            case 2:
                setIcon(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-clothes-40.png"));
                break;
            case 3:
                setIcon(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-import-40.png"));
                break;
            case 4:
                setIcon(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-bill-40.png"));
                break;
            case 5:
                setIcon(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-customers-40.png"));
                break;
            case 6:
                setIcon(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-management-40.png"));
                break;

        }
        addEvent();
    }
    private void addEvent()
    {
        MouseListener ml = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(getParent()!=null)
                {
                    for(Component i: getParent().getComponents())
                    {
                        if(i instanceof FeatureButton btn)
                        {
                            btn.setContentAreaFilled(false);
                        }
                    }
                    setContentAreaFilled(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        };
        addMouseListener(ml);
    }
    

}
