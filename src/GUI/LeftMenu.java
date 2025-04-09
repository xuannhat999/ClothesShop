package GUI;

import BUS.FeatureBUS;
import DTO.Feature;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftMenu extends JPanel{
    private int roleid;
    private FeatureBUS featurebus = new FeatureBUS();
    public LeftMenu(int roleid){
        this.roleid = roleid;
        init();
    }
    private void init()
    {
        setPreferredSize(new Dimension(300,900 ));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Theme.light1);
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Theme.brown));
        setOpaque(true);
        loadFeatureButton();
        System.out.println(roleid);
        
    }
    private void loadFeatureButton()
    {
        JLabel lblblank = new JLabel(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-menu-50.png"));
        lblblank.setPreferredSize(new Dimension(300,75));
        lblblank.setMaximumSize(new Dimension(300,75));
        lblblank.setHorizontalAlignment(JLabel.LEFT);
        lblblank.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        add(lblblank);

        for(Feature i: featurebus.getFeatureFromRoleId(roleid))
        {
            FeatureButton featurebutton = new FeatureButton(i.getFeatureId());
            add(featurebutton);
        }
    }
}
