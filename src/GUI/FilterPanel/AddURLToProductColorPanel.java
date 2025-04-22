package GUI.FilterPanel;

import BUS.ProductVariantBUS;
import DTO.ProductColor;
import GUI.ColorCheckBox;
import GUI.Theme;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddURLToProductColorPanel extends JPanel{
    private List<ColorCheckBox> colorlist = new ArrayList<>();
    private List<JTextField> txfurl = new ArrayList<>();
    private int productid;
    private String pname;
    private JPanel pnlmain;
    private ProductVariantBUS productvariantbus = new ProductVariantBUS();
    public AddURLToProductColorPanel()
    {
        init();
    }
    private void init()
    {
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(new EmptyBorder(20,10,10,10));
 

    }
    public void loadData(List<ColorCheckBox> colorlist, int pid,String pname)
    {
        this.colorlist=colorlist;
        this.productid=pid;
        this.pname=pname;
        removeAll();
        txfurl.clear();

        JLabel lblpname = new JLabel(pname);
        lblpname.setFont(Theme.infofont1);
        add(lblpname,BorderLayout.NORTH);

        pnlmain = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        pnlmain.setOpaque(false);
        add(pnlmain,BorderLayout.CENTER);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        pnlmain.add(new JLabel("Màu"),gbc);

        gbc.gridx=1;
        pnlmain.add(new JLabel("Đường dẫn hình ảnh(URL)"),gbc);

        int row=1;
        for(ColorCheckBox i: colorlist)
        {
            gbc.gridx=0;
            gbc.gridy=row;
            pnlmain.add(i,gbc);
            i.setSelected(false);
            JTextField txf =new JTextField();
            txfurl.add(txf);
            gbc.gridx=1;
            pnlmain.add(txf,gbc);
            row++;
            ProductColor pc = productvariantbus.getProductColorFromPIdColorId(pid, i.getColorId());
            if(pc!=null)
            {
                txf.setText(pc.getURL());
            }
            revalidate();
            repaint();
        }
    }
    public List<ProductColor> getProductColors()
    {
        List<ProductColor> pcl = new ArrayList<>();
        for(int i=0;i<colorlist.size();i++)
        {
            if(!txfurl.get(i).getText().isEmpty())
            {
                ProductColor pc = new ProductColor(new ProductColor(0,productid,colorlist.get(i).getColorId(),txfurl.get(i).getText()));
                pcl.add(pc);
            }
            else System.out.print("Có URL rỗng!");
        }
        return pcl;
    }   
}
