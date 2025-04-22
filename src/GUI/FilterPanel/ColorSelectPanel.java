package GUI.FilterPanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.ProductVariantBUS;
import DTO.ProductColor;
import DTO.ProductVariant;
import GUI.ColorCheckBox;
import GUI.Theme;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class ColorSelectPanel extends JPanel{
    private List<ColorCheckBox> colorlist = new ArrayList<>();
    private int pid;
    private ProductVariantBUS pvb = new ProductVariantBUS();
    
    public ColorSelectPanel()
    {

    }
    public void loadColor(int pid)
    {
        removeAll();
        colorlist.clear();
        this.pid=pid;


        setOpaque(false);
        setBorder(new EmptyBorder(20,20,20,20));
        setLayout(new BorderLayout());
        JLabel lblcolor = new JLabel("Chọn màu sản phẩm ");
        lblcolor.setFont(Theme.infofont1);
        lblcolor.setBorder(new EmptyBorder(20,20,0,0));
        add(lblcolor,BorderLayout.NORTH);
        JPanel pnlmain = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlmain.setOpaque(false);
        add(pnlmain,BorderLayout.CENTER);
        List<ProductColor> pcl = pvb.getProductColorFromPID(pid);
        for(ProductColor i:pcl)
        {

            ColorCheckBox j = new ColorCheckBox(i.getColorId(), 50);
            j.setContentAreaFilled(false);
            j.setOpaque(false);
            colorlist.add(j);
            pnlmain.add(j);
        }
    }
    public List<ProductColor> getProductColor()
    {
        List<ProductColor> pcl =new ArrayList<>();
        for(ColorCheckBox i: colorlist)
        {
            if(i.isSelected())
            {
                pcl.add(pvb.getProductColorFromPIdColorId(pid, i.getColorId()));
            }
        }
        return pcl;
    }

}
