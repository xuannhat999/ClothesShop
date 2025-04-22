package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Header extends JPanel{
    private JButton btnclose,btnmax,btnmin;
    private JFrame frame;
    private boolean isMax = false;
    private int fw,fh;
    public Header(JFrame frame)
    {
        this.frame=frame;
        fw=frame.getWidth();
        fh=frame.getHeight();
        init();
    }
    private void init()
    {
        setPreferredSize(new Dimension(fw,40));
        setLayout(new BorderLayout());
        setBackground(Theme.brown);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.brown));

        JPanel pnlbtn = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,0));
        pnlbtn.setOpaque(false);

        btnmin = new JButton("➖");
        btnmin = customButton(btnmin);
        pnlbtn.add(btnmin);

        btnmax= new JButton("☐");
        btnmax = customButton(btnmax);
        pnlbtn.add(btnmax);

        btnclose = new JButton("⨉");
        btnclose = customButton(btnclose);
        pnlbtn.add(btnclose);

        
        add(pnlbtn,BorderLayout.EAST);

        addEvent();
    }
    public JButton customButton(JButton btn)
    {
        btn.setPreferredSize(new Dimension(50,40));
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setFont(new Font("Roboto",Font.BOLD,12));
        btn.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Theme.brown));
        return btn;
    }
    public void addEvent()
    {
        MouseListener ml = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == btnclose)
                {
                    frame.dispose();
                }
                else if(e.getSource()==btnmax)
                {
                    if(isMax==false)
                    {
                        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                        isMax=true;
                    }
                    else 
                    {
                        frame.setSize(fw,fh);
                        frame.setLocationRelativeTo(null);
                        isMax=false;
                    }
                }
                else if(e.getSource()==btnmin)
                {
                    frame.setState(Frame.ICONIFIED);
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
        btnclose.addMouseListener(ml);
        btnmax.addMouseListener(ml);
        btnmin.addMouseListener(ml);
    }
}
