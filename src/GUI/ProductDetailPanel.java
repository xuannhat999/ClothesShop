package GUI;

import BUS.ProductBUS;
import BUS.ProductVariantBUS;
import DAO.ColorDAO;
import DTO.Product;
import DTO.ProductColor;
import DTO.ProductVariant;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ProductDetailPanel extends JDialog{
    private int productid;
    private JTable tblproductv;
    private DefaultTableModel mdlproductv;
    private JScrollPane spproductv;

    private ProductBUS productbus = new ProductBUS();
    private ProductVariantBUS productvariantbus = new ProductVariantBUS();
    private ColorDAO colordao = new ColorDAO();
    public ProductDetailPanel(int productid)
    {
        this.productid = productid;
        init();
    }
    public void init()
    {
        setSize(1000,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Theme.light1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel pnlinfo = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        pnlinfo.setOpaque(false);
        Product p = productbus.getProductFromId(productid);
        JLabel pname = new JLabel(p.getProductName());
        pname.setFont(Theme.infofont1);
        pnlinfo.add(pname);
        add(pnlinfo,BorderLayout.NORTH);

        JPanel pnltbl = new JPanel(new BorderLayout());
        pnltbl.setOpaque(false);
        pnltbl.setBorder(new EmptyBorder(20,20,20,20));
        String columnName[] = {"Màu","S","M","L","XL"};
        mdlproductv = new DefaultTableModel(columnName,0);
        tblproductv = new JTable(mdlproductv);
        tblproductv.getColumnModel().getColumn(0).setCellRenderer(new ColorPanelRenderer());
        spproductv = new JScrollPane(tblproductv);
        pnltbl.add(spproductv,BorderLayout.CENTER);
        add(pnltbl,BorderLayout.CENTER);
        loadProductVariant(productvariantbus.getProductColorFromPID(productid));

        tblproductv.setRowHeight(40);
        tblproductv.getTableHeader().setPreferredSize(new Dimension(0,40));
        tblproductv.getTableHeader().setBackground(Theme.light2);
        spproductv.getViewport().setBackground(Color.white);
        tblproductv.getColumnModel().getColumn(0).setWidth(40);
        setVisible(true);
    }
    public void loadProductVariant(List<ProductColor> pcl)
    {
        mdlproductv.setRowCount(0);
        for(ProductColor i: pcl)
        {   
            int squan=0,mquan=0,lquan=0,xlquan =0;
            List<ProductVariant> pvl = productvariantbus.getAllProductVariantFromPCID(i.getProductColorId());
            for(ProductVariant j : pvl)
            {
                System.out.print(j.getProductColorId());
                if(j.getSize().equals("S"))
                {
                    squan = j.getQuantity();
                }
                else if(j.getSize().equals("M"))
                {
                    mquan = j.getQuantity();
                }
                else if(j.getSize().equals("L"))
                {
                    lquan = j.getQuantity();
                }
                else
                {
                    xlquan =j.getQuantity();
                }
            }
            mdlproductv.addRow(new Object[]{i.getColorId(),squan,mquan,lquan,xlquan});
        }
    }
}
