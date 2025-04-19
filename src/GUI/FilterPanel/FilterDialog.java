package GUI.FilterPanel;

import GUI.RoundedButton;
import GUI.Theme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FilterDialog extends JDialog{
    private RoundedButton btnapply;
    public FilterDialog(Window window,JPanel pnl)
    {
        super(window,ModalityType.APPLICATION_MODAL);
        init(pnl);
    }
    private void init(JPanel pnl)
    {
        setSize(500,300);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Theme.light1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(Theme.brown,1));
        add(pnl,BorderLayout.CENTER);
        setLocationRelativeTo(null);

        JPanel pnlbtn = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        pnlbtn.setPreferredSize(new Dimension(500,40));
        pnlbtn.setOpaque(false);
        btnapply = new RoundedButton("Áp dụng",20);
        btnapply.setButtonSize(70,30);
        btnapply.setBackground(Theme.brown);
        btnapply.setForeground(Color.white);

        pnlbtn.add(btnapply);
        add(pnlbtn,BorderLayout.SOUTH);

        addEvent();
    }
    public RoundedButton getApplyButton()
    {
        return btnapply;
    }
    private void addEvent()
    {
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnapply)
                    dispose();
            }
        };
        btnapply.addActionListener(al);
    }
}
