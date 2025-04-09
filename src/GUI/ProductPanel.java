package GUI;

import BUS.ProductBUS;
import DTO.Brand;
import DTO.Category;
import DTO.Gender;
import DTO.Material;
import DTO.Product;
import utils.InputParser;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ProductPanel extends MainPanel{
    private JTextField txfproductid,txfproductname,txfdescription,txfprice;
    private JLabel lblproductid,lblproductname,lblbrand,lbldescription,lblcategory,lblmaterial,lblprice,lblgender;
    private JComboBox <Category> cbbcategory;
    private JComboBox <Material> cbbmaterial;
    private JComboBox <Brand> cbbbrand;
    private JComboBox <Gender> cbbgender;
    private JTable tblproduct;
    private DefaultTableModel mdlproduct;
    private ProductBUS productbus = new ProductBUS();
    public ProductPanel(int roleid) {
        super(roleid);
        init();
    }
    private void init()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets  = new Insets(5, 5, 5, 5);
        String columnName[] ={"Mã sản phẩm","Tên sản phẩm","Mô tả","Thương hiệu","Chất liệu","Giới tính","Danh mục","Giá"};

        // PANEL 1

        // PANEL IAMGE

        // PANEL 2 
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
        lblproductname.setBorder(Theme.emptyborder);
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

        loadJComboBox();
        showProductInfo(false);
        
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

        txfproductid.setEditable(false);
        setEditable(false);
        btnsave.setVisible(false);
        btncancel.setVisible(false);
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
                    setEditable(true);
                }
                else if(e.getSource() == btnupdate)
                {
                    btncancel.setVisible(true);
                    btnsave.setVisible(true);
                    setEditable(true);
                    tblproduct.setEnabled(false);
                }
                else if(e.getSource()==btnremove)
                {
                    int productid = Integer.parseInt(txfproductid.getText());
                    productbus.removeProduct(productid);
                    loadDataTable(productbus.getAllProduct());
                    showProductInfo(false);
                    tblproduct.setEnabled(false);
                    
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
                            BigDecimal price =InputParser.parseBigDecimal(txfprice.getText(), "Giá sản phẩm");
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
                            productbus.addProduct(p);
                            productbus.updateProduct(p);
                            loadDataTable(productbus.getAllProduct());
                            setEditable(false);
                            showProductInfo(false);
                            tblproduct.setEnabled(true);
                            btnsave.setVisible(false);
                            btncancel.setVisible(false);
                        
                }
                else if(e.getSource() == btnfind)
                {
                    loadDataTable(productbus.searchProduct(txfsearch.getText()));
                }
            }
            
        };
      
        btnadd.addActionListener(al);
        btnremove.addActionListener(al);
        btnupdate.addActionListener(al);
        btnsave.addActionListener(al);
        btncancel.addActionListener(al);
        btnfind.addActionListener(al);

        tblproduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                if(tblproduct.getSelectedRow()>=0)
                {
                    showProductInfo(true);
                    loadProductInfo();
                    btnupdate.setVisible(true);
                    btnremove.setVisible(true);
                }
            }
        });

    }




}
