package GUI.Frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.Header;
import GUI.LeftMenu;
import GUI.ProductManagerGUI;
import GUI.ShoppingGUI;
import GUI.Theme;

public class MainFrame extends JFrame {
    private int userid;
    private JPanel header,leftmenu,main;
    private CardLayout cardlayout;
    public MainFrame(int userid)
    {
        this.userid = userid;
        init();
    }
    private void init()
    {
        setSize(1500, 900);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.brown));

        header = new Header(this);
        add(header, BorderLayout.NORTH);

        leftmenu = new LeftMenu(userid);
        add(leftmenu,BorderLayout.WEST);

        cardlayout = new CardLayout();
        main = new JPanel(cardlayout);
        main.add(new ShoppingGUI(userid),"1");
        main.add(new ProductManagerGUI(userid),"2");
        add(main,BorderLayout.CENTER);
        setVisible(true);
    }
    public void changeFeature(String index)
    {
        cardlayout.show(main,index);
    }
}
