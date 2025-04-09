package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private int roleid;
    private JPanel header,leftmenu,main;
    private CardLayout cardlayout;
    public MainFrame(int roleid)
    {
        this.roleid = roleid;
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

        leftmenu = new LeftMenu(roleid);
        add(leftmenu,BorderLayout.WEST);

        cardlayout = new CardLayout();
        main = new JPanel(cardlayout);
        main.add(new ProductPanel(roleid),0);
        add(main,BorderLayout.CENTER);
        setVisible(true);
    }
}
