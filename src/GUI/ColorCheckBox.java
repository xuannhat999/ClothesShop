package GUI;

import DAO.ColorDAO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

public class ColorCheckBox extends JCheckBox{
    private int colorid,size;
    private ColorDAO colordao= new ColorDAO();
    public ColorCheckBox(int colorid,int size)
    {
        this.size=size;
        this.colorid=colorid;
        init();
    }
    private void init()
    {
        setBorder(new EmptyBorder(0,0,0,0));
        setOpaque(false);
        setUnselectedIcon();
        addEvent();
    }
    public void setUnselectedIcon()
    {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.decode(colordao.getColorFromId(colorid).getColorCode()));
        g.fillRect(0,0,size,size);
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(2));
        g.drawRect(0,0 ,size, size);
        g.dispose();
        setIcon(new ImageIcon(image));
    }
    public void setSelectedIcon()
    {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.decode(colordao.getColorFromId(colorid).getColorCode()));
        g.fillRect(0,0,size,size);
        g.setColor(Color.cyan);
        g.setStroke(new BasicStroke(4));
        g.drawRect(0, 0, size, size);
        g.dispose();
        setIcon(new ImageIcon(image));
    }
    public void setUnabled()
    {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.decode(colordao.getColorFromId(colorid).getColorCode()));
        g.fillRect(0,0,size,size);
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(4));
        g.drawRect(0, 0, size, size);
        g.dispose();
        setIcon(new ImageIcon(image));
    }
    public void addEvent()
    {
        addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    setSelectedIcon();
                }
                else if(e.getStateChange()!=ItemEvent.SELECTED)
                {
                    setUnselectedIcon();
                }
            }
            
        });
    }
    public int getColorId()
    {
        return colorid;
    }




}
