package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class SizeCheckBox extends JCheckBox{
    private String text;
    private int size;
    public SizeCheckBox(String text,int size){
        this.size=size;
        this.text=text;
        init();
    }
    private void init()
    {
        setText(text);
        setFont(Theme.infofont1);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setUnselectedIcon();
        addEvent();
    }
    private void setUnselectedIcon()
    {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.white);
        g.fillRect(0,0,size,size);

        g.setColor(Color.black);
        g.drawRect(0, 0, size-1,size-1);

        g.dispose();
        setIcon(new ImageIcon(image));
    }
    private void setSelectedIcon()
    {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.white);
        g.fillRect(0,0,size,size);

        g.setColor(Color.cyan);
        g.drawRect(0, 0, size-1,size-1);

        g.dispose();
        setIcon(new ImageIcon(image));
    }
    public void addEvent()
    {
        addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED)
                {
                    setSelectedIcon();
                }
                else setUnselectedIcon();
            }
            
        });
    }
    public String getPSize()
    {
        return getText();
    }

}
