package GUI;

import BUS.ProductBUS;
import BUS.ProductVariantBUS;
import DAO.ColorDAO;
import DAO.ProductColorDAO;
import DTO.Brand;
import DTO.Category;
import DTO.Gender;
import DTO.Material;
import DTO.PColor;
import DTO.Product;
import DTO.ProductColor;
import DTO.ProductVariant;
import GUI.FilterPanel.AddURLToProductColorPanel;
import GUI.FilterPanel.BigDialog;
import GUI.FilterPanel.FilterDialog;
import GUI.FilterPanel.ProductFilterPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import utils.InputParser;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ProductManagerGUI extends MainPanel{
    private JTextField txfproductid,txfproductname,txfdescription,txfprice;
    private JLabel lblproductid,lblproductname,lblbrand,lbldescription,lblcategory,lblmaterial,lblprice,lblgender,lblcolor;
    private JComboBox <Category> cbbcategory;
    private JComboBox <Material> cbbmaterial;
    private JComboBox <Brand> cbbbrand;
    private JComboBox <Gender> cbbgender;
    private JTable tblproduct;
    private DefaultTableModel mdlproduct;
    private ProductFilterPanel pfp;
    private AddURLToProductColorPanel addurlpnl;
    private FilterDialog filter,addurl;
    private JPanel pnlcolor;
    private ProductBUS productbus = new ProductBUS();
    private List<ColorCheckBox> colorlist = new ArrayList<>();
    private ProductVariantBUS productvariantbus = new ProductVariantBUS();
    private ColorDAO colordao = new ColorDAO();
    private RoundedButton btnaddurl,btnimport;
    private int employeeid;
    public ProductManagerGUI(int employeeid) {
        super();
        this.employeeid = employeeid;
        init();
    
    }
    private void init()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets  = new Insets(5, 5, 5, 5);
        String columnName[] ={"ID","Tên sản phẩm","Mô tả","Thương hiệu","Chất liệu","Giới tính","Danh mục","Giá"};

        // PANEL 1 
        JLabel lblproductinfo = new JLabel("Thông tin sản phẩm");
        lblproductinfo.setFont(new Font("Roboto",Font.BOLD,20));
        lblproductinfo.setBorder(new EmptyBorder(0,0,10,0));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.gridwidth=2;
        pnlcon1.add(lblproductinfo,gbc);

        lblproductid = new JLabel("Mã sản phẩm");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth=1;
        pnlcon1.add(lblproductid,gbc);

        lblproductname = new JLabel("Tên sản phẩm");
        lblproductname.setBorder(new EmptyBorder(0,0,0,0));
        gbc.gridy = 2;
        pnlcon1.add(lblproductname,gbc);

        lbldescription = new JLabel("Mô tả");
        gbc.gridy = 3;
        pnlcon1.add(lbldescription,gbc);

        lblbrand = new JLabel("Thương hiệu");
        gbc.gridy= 4;
        pnlcon1.add(lblbrand,gbc);

        lblmaterial = new JLabel("Chất liệu");
        gbc.gridy = 5;
        pnlcon1.add(lblmaterial,gbc);

        lblgender = new JLabel("Giới tính");
        gbc.gridy = 6;
        pnlcon1.add(lblgender,gbc);

        lblcategory = new JLabel("Danh mục");
        gbc.gridy = 7;
        pnlcon1.add(lblcategory,gbc);

        lblprice = new JLabel("Giá");
        gbc.gridy = 8;
        pnlcon1.add(lblprice,gbc);

        lblcolor = new JLabel("Màu");
        gbc.gridy=9;
        pnlcon1.add(lblcolor,gbc);

        txfproductid = new JTextField();
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx=3;
        pnlcon1.add(txfproductid,gbc);
    
        txfproductname = new JTextField();
        gbc.gridy=2;
        pnlcon1.add(txfproductname,gbc);

        txfdescription = new JTextField();
        gbc.gridy=3;
        pnlcon1.add(txfdescription,gbc);

        cbbbrand = new JComboBox<>();
        gbc.gridy=4;
        pnlcon1.add(cbbbrand,gbc);
        
        cbbmaterial = new JComboBox<>();
        gbc.gridy=5;
        pnlcon1.add(cbbmaterial,gbc);
        
        cbbgender = new JComboBox<>();
        gbc.gridy=6;
        pnlcon1.add(cbbgender,gbc);

        cbbcategory = new JComboBox<>();
        gbc.gridy=7;
        pnlcon1.add(cbbcategory,gbc);

        txfprice = new JTextField();
        gbc.gridy=8;
        pnlcon1.add(txfprice,gbc);

        pnlcolor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlcolor.setOpaque(false);
        gbc.gridy=9;
        pnlcon1.add(pnlcolor,gbc);

        btnaddurl = new RoundedButton("URL hình ảnh",15);
        btnaddurl.setBackground(Theme.light3);
        btnaddurl.setButtonSize(100,30);
        gbc.gridx=2;
        gbc.gridwidth=1;
        gbc.weightx=0;
        pnlcon1.add(btnaddurl,gbc);

        loadJComboBox();
        showProductInfo(false);
        // PANEL 2
        btnimport = new RoundedButton("Nhập hàng", 20);
        btnimport.setButtonSize(100,40);
        btnimport.setBackground(Theme.light4);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.weightx=1;
        gbc.weighty=0;
        pnlcon2.add(btnimport,gbc);
        // PANEL 4

        mdlproduct = new DefaultTableModel(columnName,0);
        tblproduct = new JTable(mdlproduct);
        loadDataTable(productbus.getAllProduct());
        JScrollPane sp = new JScrollPane(tblproduct);
        tblproduct.setDefaultEditor(Object.class,null);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        pnlcon4.add(sp,gbc);

        tblproduct.setRowHeight(30);
        tblproduct.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblproduct.getColumnModel().getColumn(0).setPreferredWidth(30);

        tblproduct.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        sp.getViewport().setBackground(Theme.light1);
        tblproduct.getTableHeader().setBackground(Theme.light2);
        tblproduct.getTableHeader().setPreferredSize(new Dimension(0,40));
        tblproduct.getTableHeader().setFont(new Font("Roboto",Font.BOLD,14));
        tblproduct.setShowVerticalLines(false);
        tblproduct.setGridColor(Theme.brown);


        txfproductid.setEditable(false);
        setEditable(false);
        btnsave.setVisible(false);
        btncancel.setVisible(false);

        pfp = new ProductFilterPanel();
        filter = new FilterDialog(SwingUtilities.getWindowAncestor(this), pfp);
        filter.setVisible(false);

        addurlpnl= new AddURLToProductColorPanel();
        addurl = new FilterDialog(SwingUtilities.getWindowAncestor(this), addurlpnl);
        addurl.setVisible(false);
        addEvent();

    }
    public void showProductInfo(boolean show)
    {
        txfproductid.setVisible(show);
        txfproductname.setVisible(show);
        txfdescription.setVisible(show);
        txfprice.setVisible(show);
        cbbbrand.setVisible(show);
        cbbcategory.setVisible(show);
        cbbmaterial.setVisible(show);
        cbbgender.setVisible(show);
        pnlcolor.setVisible(show);
    }
    public void loadColor(int productid,boolean isAddOrUpdate)
    {
        colorlist.clear();
        pnlcolor.removeAll();
        pnlcolor.revalidate();
        pnlcolor.repaint();
        if(!isAddOrUpdate)
        {
            for(ProductColor i: productvariantbus.getProductColorFromPID(productid))
            {
                ColorCheckBox color = new ColorCheckBox(i.getColorId(), 20);
                pnlcolor.add(color);
            }
        }
        else
        {
            for(PColor i:colordao.getAllColor())
            {
                ColorCheckBox color = new ColorCheckBox(i.getColorId(), 20);
                colorlist.add(color);
                pnlcolor.add(color);
            }
            if(productbus.getProductFromId(productid)!=null)
            {
                for(ColorCheckBox i:colorlist)
                {
                    for(ProductColor j:productvariantbus.getProductColorFromPID(productid))
                    {
                        if(i.getColorId()==j.getColorId())
                        {
                            i.setSelected(true);
                        }
                    }
                }
            }
        }
    }
    public List<ColorCheckBox> getSelectedColor()
    {
        List<ColorCheckBox> selectedcolor= new ArrayList<>();
        for(ColorCheckBox i: colorlist)
        {
            if(i.isSelected())
            {
                selectedcolor.add(i);
            }
        }
        return selectedcolor;
    }
    private void loadDataTable(List<Product>pdl)
    {
        mdlproduct.setRowCount(0);
        for(Product p : pdl)
        {
           mdlproduct.addRow(new Object[]{
            p.getProductId(),
            p.getProductName(),
            p.getDescription(),
            productbus.getBrandFromId(p.getBrandId()).getBrandName(),
            productbus.getMaterialFromId(p.getMaterialId()).getMaterialName(),
            productbus.getGenderFromId(p.getGender()).getGenderName(),
            productbus.getCategoryFromId(p.getCategoryId()).getCategoryName(),
            p.getPrice()
           });

        }
    }
    private void setEditable(boolean e)
    {
        txfproductname.setEditable(e);
        txfdescription.setEditable(e);
        txfprice.setEditable(e);
        cbbbrand.setEnabled(e);
        cbbcategory.setEnabled(e);
        cbbmaterial.setEnabled(e);
        cbbgender.setEnabled(e);
        btnaddurl.setVisible(e);
    }
    public void loadJComboBox()
    {
        for(Brand i : productbus.getAllBrand()){
            cbbbrand.addItem(i);
        }
        for(Category i : productbus.getAllCategory())
        {
            cbbcategory.addItem(i);
        }
        for(Material i : productbus.getAllMaterial())
        {
            cbbmaterial.addItem(i);
        }
        for(Gender i : productbus.getAllGender())
        {
            cbbgender.addItem(i);
        }
    }
    public void loadProductInfo()
    {
        int productid = Integer.parseInt(tblproduct.getValueAt(tblproduct.getSelectedRow(),0).toString());
        Product product = productbus.getProductFromId(productid);
        txfproductid.setText(Integer.toString(product.getProductId()));
        txfproductname.setText(product.getProductName());
        txfdescription.setText(product.getDescription());
        cbbbrand.setSelectedItem(productbus.getBrandFromId(product.getBrandId()));
        cbbcategory.setSelectedItem(productbus.getCategoryFromId(product.getCategoryId()));
        cbbmaterial.setSelectedItem(productbus.getMaterialFromId(product.getMaterialId()));
        cbbgender.setSelectedItem(productbus.getGenderFromId(product.getGender()));
        txfprice.setText(product.getPrice().toString());
        loadColor(productid,false);
    }
    private void addEvent()
    {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnadd)
                {
                    tblproduct.setEnabled(false);
                    showProductInfo(true);
                    btncancel.setVisible(true);
                    btnsave.setVisible(true);
                    txfproductid.setText(Integer.toString(productbus.getNextProductId()));
                    txfproductname.setText("");
                    txfdescription.setText("");
                    txfprice.setText("");
                    cbbbrand.setSelectedIndex(-1);
                    cbbcategory.setSelectedIndex(-1);
                    cbbmaterial.setSelectedIndex(-1);
                    cbbgender.setSelectedIndex(-1);
                    loadColor(Integer.parseInt(txfproductid.getText()),true);
                    setEditable(true);
                }
                else if(e.getSource() == btnupdate)
                {
                    btncancel.setVisible(true);
                    btnsave.setVisible(true);
                    setEditable(true);
                    loadColor(Integer.parseInt(txfproductid.getText()),true);
                    tblproduct.setEnabled(false);
                }
                else if(e.getSource()==btnremove)
                {
                    int productid = Integer.parseInt(txfproductid.getText());
                    List<ProductColor> pcl = productvariantbus.getProductColorFromPID(productid);
                    for(ProductColor i:pcl)
                    {
                        for(ProductVariant j: productvariantbus.getAllProductVariantFromPCID(i.getProductColorId()))
                        {
                            productvariantbus.removeProductVariant(j.getProductVariantId());
                        }
                        productvariantbus.removeProductColor(i.getProductColorId());
                    }
                    productbus.removeProduct(productid);
                    loadDataTable(productbus.getAllProduct());
                    showProductInfo(false);
                    setButtonEnable(false);
                    
                }
                else if(e.getSource()==btncancel)
                {
                    if(productbus.getProductFromId(Integer.parseInt(txfproductid.getText()))!=null)
                    {
                        loadProductInfo();
                    }
                    else showProductInfo(false);
                    setEditable(false);
                    btnsave.setVisible(false);
                    btncancel.setVisible(false);
                    tblproduct.setEnabled(true);
                    setButtonEnable(false);

                }
                else if (e.getSource()== btnsave)
                {

                            int pid =Integer.parseInt(txfproductid.getText());
                            String pname = txfproductname.getText();
                            Category category =((Category)cbbcategory.getSelectedItem());
                            Material material = ((Material)cbbmaterial.getSelectedItem());
                            String des = txfdescription.getText();
                            Brand brand = ((Brand)cbbbrand.getSelectedItem());
                            Gender gender =((Gender)cbbgender.getSelectedItem());
                            if(category == null || brand ==null || material == null || gender == null)
                            {
                                JOptionPane.showMessageDialog(null, "Chưa chọn đầy đủ thông tin");
                                return;
                            }
                            BigDecimal price = InputParser.parseBigDecimal(txfprice.getText(), "Giá sản phẩm");
                            if(price == null)
                            {
                                return;
                            }
                            Product p = new Product(pid,
                                                    pname,
                                                    category.getCategoryId(),
                                                    material.getMaterialId(),
                                                    des,
                                                    price,
                                                    brand.getBrandId(),
                                                    gender.getGenderId()
                            );
                            List<ProductColor> pcl = addurlpnl.getProductColors();

                            if(productbus.getProductFromId(pid)==null)
                            {
                                if(productbus.addProduct(p))
                                {
                                    for(ProductColor i: pcl)
                                    {
                                        if(productvariantbus.addProductColor(i))
                                        {
                                            ProductColor npc = productvariantbus.getProductColorFromPIdColorId(i.getProductId(),i.getColorId());
                                            productvariantbus.addProductVariantFromPC(npc);
                                        }
                                    }
                                    JOptionPane.showMessageDialog(ProductManagerGUI.this,"Thêm sản phẩm thành công");
                                }

                            }
                            else
                            {
                                if(productbus.updateProduct(p))
                                {
                                    for(ProductColor i:pcl)
                                    {
                                        ProductColor j = productvariantbus.getProductColorFromPIdColorId(i.getProductId(),i.getColorId());
                                        if(j!=null)
                                        {
                                            i.setProductColorId(j.getProductColorId());
                                            if(productvariantbus.updateProductColor(i))
                                            {
                                                System.out.print("Updated PC");
                                            }

                                        }
                                        else 
                                        {
                                            if(productvariantbus.addProductColor(i))
                                            {
                                                ProductColor npc = productvariantbus.getProductColorFromPIdColorId(i.getProductId(),i.getColorId());
                                                productvariantbus.addProductVariantFromPC(npc);
                                            }
                                        }
                                    }
                                    JOptionPane.showMessageDialog(ProductManagerGUI.this,"Cập nhật sản phẩm thành công");
                                }
                                
                            }

                            loadDataTable(productbus.getAllProduct());
                            setEditable(false);
                            showProductInfo(false);
                            tblproduct.setEnabled(true);
                            btnsave.setVisible(false);
                            btncancel.setVisible(false);
                            setButtonEnable(false);
                        
                }
                else if(e.getSource() == btnfind)
                {
                    new AccountPanel();
                    loadDataTable(productbus.searchProduct(pfp.getSelectedCategory(),pfp.getSelectedMaterial(),pfp.getSelectedBrand(),pfp.getSelectedGender(),txfsearch.getText()));
                }
                else if(e.getSource()==btnfilter)
                {
                    filter.setVisible(true);
                }
                else if(e.getSource()==btndetail)
                {
                    new ProductDetailPanel(Integer.parseInt(tblproduct.getValueAt(tblproduct.getSelectedRow(), 0).toString()));
                }
                else if(e.getSource() == btnaddurl)
                {
                    
                    addurlpnl.loadData(getSelectedColor(),Integer.parseInt(txfproductid.getText()),txfproductname.getText());
                    addurl.setVisible(true);
                }
                else if(e.getSource() == btnimport)
                {
                    List<Product> pl = new ArrayList<>();
                    for(int i=0;i<tblproduct.getRowCount();i++)
                    {
                        if(tblproduct.getSelectedRow()==i)
                        {
                            pl.add(productbus.getProductFromId(Integer.parseInt(tblproduct.getValueAt(i, 0).toString())));
                        }
                    }
                    ImportProductPanel importpanel = new ImportProductPanel(employeeid);
                    new BigDialog(importpanel);
                }
                
            }      
        };
        btnadd.addActionListener(al);
        btnremove.addActionListener(al);
        btnupdate.addActionListener(al);
        btnsave.addActionListener(al);
        btncancel.addActionListener(al);
        btnfind.addActionListener(al);
        btnfilter.addActionListener(al);
        btndetail.addActionListener(al);
        btnaddurl.addActionListener(al);
        btnimport.addActionListener(al);

        tblproduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                if(tblproduct.getSelectedRow()>=0)
                {
                    showProductInfo(true);
                    loadProductInfo();
                    setButtonEnable(true);
                }
            }
        });

    }




}
