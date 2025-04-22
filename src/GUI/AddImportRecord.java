package GUI;

import BUS.ProductBUS;
import BUS.ProductVariantBUS;
import DAO.ColorDAO;
import DAO.ImportDAO;
import DAO.ImportDetailDAO;
import DAO.PaymentMethodDAO;
import DAO.SupplierDAO;
import DTO.ImportProduct;
import DTO.ImportProductDetail;
import DTO.PaymentMethod;
import DTO.Product;
import DTO.ProductColor;
import DTO.ProductVariant;
import DTO.Supplier;
import GUI.FilterPanel.ColorSelectPanel;
import GUI.FilterPanel.FilterDialog;
import GUI.FilterPanel.ProductFilterPanel;
import utils.NumberValidationRenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AddImportRecord extends JDialog{
    private int employeeid,imid;
    private JTable tblproduct,tblproductv;
    private DefaultTableModel mdlproduct,mdlproductv;
    private JScrollPane spproduct, spproductv;
    private RoundedPanel pnlinfo;
    private JPanel pnlproduct,pnlproductv,pnlbtn;
    private JComboBox<Supplier> cbbsupplier;
    private JTextField txfimid,txfemid,txftotal,txfdate,txfsearch;
    private JComboBox<PaymentMethod> cbbpay;
    private RoundedButton btnadd,btnremove,btnback,btnsave,btnfilter,btnfind;

    private SupplierDAO supplierdao = new SupplierDAO();
    private ImportDAO importdao = new ImportDAO();
    private ImportDetailDAO importdetaildao = new ImportDetailDAO();
    private ProductBUS productbus = new ProductBUS();
    private ProductVariantBUS productvariantbus = new ProductVariantBUS();
    private PaymentMethodDAO paydao = new PaymentMethodDAO();
    private ColorDAO colordao = new ColorDAO();
    private ProductFilterPanel pfp;
    private FilterDialog fd,cd;
    private ColorSelectPanel csp;

    public AddImportRecord(int employeeid,int imid)
    {
        this.employeeid =employeeid;
        this.imid=imid;
        init();
    }
    private void init()
    {
        setSize(1200,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.insets = new Insets(10,10,10,10);

        pnlinfo = new RoundedPanel(20);
        pnlinfo.setBackground(Theme.light1);
        pnlinfo.setBorderColor(Theme.brown);
        pnlinfo.setBorderWidth(1);
        pnlinfo.setBorder(new EmptyBorder(10,10,10,10));
        pnlinfo.setLayout(new GridBagLayout());
        pnlinfo.setPreferredSize(new Dimension(1200,300));
        pnlinfo.setMaximumSize(new Dimension(1200,300));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=2;
        add(pnlinfo,gbc);

        pnlproduct = new JPanel(new BorderLayout());
        pnlproduct.setOpaque(false);
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.weightx=1;
        gbc.weighty=3;
        add(pnlproduct,gbc);

        pnlproductv = new JPanel(new BorderLayout());
        pnlproductv.setOpaque(false);
        gbc.gridx=1;
        gbc.weightx=1;
        add(pnlproductv,gbc);

        pnlbtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlbtn.setMinimumSize(new Dimension(1200,60));
        pnlbtn.setOpaque(false);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.weighty=0;
        gbc.gridwidth=2;
        add(pnlbtn,gbc);

        // COMPONENT
            // PANEL INFO 
            JLabel lblimport = new JLabel("Thông tin phiếu nhập");
            lblimport.setFont(Theme.infofont1);
            lblimport.setBorder(new EmptyBorder(10,10,50,0));
            gbc.gridx=0;
            gbc.gridwidth=2;
            gbc.gridy=0;
            gbc.weightx=1;
            gbc.weighty=0;
            pnlinfo.add(lblimport,gbc);

            JLabel lblimportid = new JLabel("ID Phiếu nhập:  ");
            gbc.gridy=1;
            gbc.gridwidth=1;
            pnlinfo.add(lblimportid,gbc);

            JLabel lblemployeeid = new JLabel("Mã nhân viên:  ");
            gbc.gridy=2;
            pnlinfo.add(lblemployeeid,gbc);

            JLabel lblsupplier = new JLabel("Nhà cung cấp:  ");
            gbc.gridy=3;
            pnlinfo.add(lblsupplier,gbc);

            JLabel lbldate = new JLabel("Ngày nhập");
            gbc.gridy=4;
            pnlinfo.add(lbldate,gbc);

            JLabel lblpay = new JLabel("Phương thức thanh toán:  ");
            gbc.gridy=5;
            pnlinfo.add(lblpay,gbc);

            JLabel lbltotal = new JLabel("Tổng tiền:  ");
            gbc.gridy=6;
            pnlinfo.add(lbltotal,gbc);

            txfimid = new JTextField();
            gbc.gridx=1;
            gbc.gridy=1;
            gbc.weightx=2;
            pnlinfo.add(txfimid,gbc);
            txfimid.setEditable(false);

            txfemid = new JTextField();
            gbc.gridy=2;
            pnlinfo.add(txfemid,gbc);

            cbbsupplier = new JComboBox<>();
            gbc.gridy=3;
            pnlinfo.add(cbbsupplier,gbc);

            
            txfdate = new JTextField();
            gbc.gridy=4;
            pnlinfo.add(txfdate,gbc);
            
            cbbpay = new JComboBox<>();
            gbc.gridy=5;
            pnlinfo.add(cbbpay,gbc);
            loadJComboBox();
            txftotal = new JTextField();
            gbc.gridy=6;
            pnlinfo.add(txftotal,gbc);
            txftotal.setEditable(false);

            setInfo();
            // PANEL PRODUCT
            String columnName[] ={"ID Sản phẩm","Tên sản phẩm","Thương hiệu","Chất liệu","Danh mục","Giá"};
            mdlproduct= new DefaultTableModel(columnName,0);
            tblproduct = new JTable(mdlproduct);
            spproduct = new JScrollPane(tblproduct);
            pnlproduct.add(spproduct,BorderLayout.CENTER);

            tblproduct.setRowHeight(30);
            tblproduct.getTableHeader().setBackground(Theme.light2);
            spproduct.getViewport().setBackground(Theme.light1);
            tblproduct.setShowVerticalLines(false);
            tblproduct.getColumnModel().getColumn(0).setWidth(10);
            loadProduct(productbus.getAllProduct());

            JPanel pnlbot1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlbot1.setOpaque(false);
            pnlproduct.add(pnlbot1,BorderLayout.SOUTH);
            
            btnadd = new RoundedButton("Thêm vào phiếu nhập", 20);
            btnadd.setButtonSize(200, 30);
            btnadd.setBackground(Theme.brown);
            btnadd.setForeground(Color.white);
            pnlbot1.add(btnadd);

            JPanel pnltop1  = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnltop1.setOpaque(false);
            pnlproduct.add(pnltop1,BorderLayout.NORTH);

            txfsearch = new JTextField();
            txfsearch.setPreferredSize(new Dimension(250,35));
            pnltop1.add(txfsearch);
            
            btnfind = new RoundedButton("", 15);
            btnfind.setButtonSize(35, 35);
            btnfind.setBackground(Theme.brown);
            ImageIcon findicon = new ImageIcon("icon/icons8-search-30.png");
            btnfind.setIcon(findicon);
            pnltop1.add(btnfind);

            btnfilter = new RoundedButton("", 15);
            btnfilter.setButtonSize(35, 35);
            btnfilter.setBackground(Theme.light2);
            btnfilter.setBorderColor(Theme.brown);
            btnfilter.setBorderWidth(1);
            ImageIcon filtericon = new ImageIcon("icon/icons8-filter-30.png");
            btnfilter.setIcon(filtericon);
            pnltop1.add(btnfilter);

            // PANEL PRODUCT VARIANT
            String columnName2[]={"Mã sản phẩm","Tên sản phẩm","Màu","Size","Số lượng","Giá"};
            mdlproductv = new DefaultTableModel(columnName2,0);
            tblproductv=new JTable(mdlproductv);
            tblproductv.getColumnModel().getColumn(4).setCellRenderer(new NumberValidationRenderer(4));
            spproductv = new JScrollPane(tblproductv);
            pnlproductv.add(spproductv,BorderLayout.CENTER);
            tblproductv.setRowHeight(30);
            tblproductv.getTableHeader().setBackground(Theme.light2);
            tblproductv.setShowVerticalLines(false);
            tblproductv.setBackground(Theme.light1);
            spproductv.getViewport().setBackground(Theme.light1);

            loadImportDetail(importdetaildao.getDetailsByImportId(imid));

            JPanel pnlbot2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlbot2.setOpaque(false);
            pnlproductv.add(pnlbot2,BorderLayout.SOUTH);

            btnremove = new RoundedButton("Xóa", 20);
            btnremove.setButtonSize(150, 30);
            btnremove.setBackground(Theme.light3);
            btnremove.setBorderWidth(1);
            btnremove.setBorderColor(Theme.brown);
            pnlbot2.add(btnremove);
        // PANEL BUTTON

        btnback = new RoundedButton("Quay lại",20);
        btnback.setButtonSize(250, 40);
        btnback.setBackground(Theme.light3);
        btnback.setBorderWidth(1);
        btnback.setBorderColor(Theme.brown);
        pnlbtn.add(btnback);

        btnsave = new RoundedButton("Lưu",20);
        btnsave.setButtonSize(250, 40);
        btnsave.setBackground(Theme.brown);
        btnsave.setForeground(Color.white);
        pnlbtn.add(btnsave);
        
        pfp = new ProductFilterPanel();
        fd = new FilterDialog(SwingUtilities.getWindowAncestor(this), pfp);

        csp = new ColorSelectPanel();
        cd = new FilterDialog(SwingUtilities.getWindowAncestor(this), csp);
        addEvent();
        setVisible(true);
    }
    public void loadJComboBox()
    {
        cbbpay.addItem(null);
        for(PaymentMethod i : PaymentMethodDAO.getAllPaymentMethod())
        {
            cbbpay.addItem(i);
        }
        cbbsupplier.addItem(null);
        for(Supplier i: supplierdao.getAllSupplier())
        {
            
            cbbsupplier.addItem(i);
        }
    }
    public void addEvent()
    {
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnadd)
                {
                    if(tblproduct.getSelectedRow()>=0)
                    {
                        csp.loadColor(Integer.parseInt(tblproduct.getValueAt(tblproduct.getSelectedRow(), 0).toString()));
                        cd.setVisible(true);
                    }
                }
                else if(e.getSource()==btnfilter)
                {
                    fd.setVisible(true);
                }
                else if(e.getSource() == btnfind)
                {
                    loadProduct(productbus.searchProduct(pfp.getSelectedCategory(),pfp.getSelectedMaterial(),pfp.getSelectedBrand(), pfp.getSelectedGender(), txfsearch.getText()));
                }
                else if(e.getSource()==cd.getApplyButton())
                {
                    List<ProductColor> pcl = csp.getProductColor();
                    for(ProductColor i:pcl)
                    {
                        for(ProductVariant j :productvariantbus.getAllProductVariantFromPCID(i.getColorId()))
                        {
                            Product p = productvariantbus.getProductFromProductVariantId(j.getProductVariantId());
                            mdlproductv.addRow(new Object[]{p.getProductId(),p.getProductName(),colordao.getColorFromId(i.getColorId()),j.getSize(),0,p.getPrice()});
                        }
                    } 
                }
                else if(e.getSource()==btnsave)
                {
                    for(ImportProductDetail i: importdetaildao.getDetailsByImportId(imid))
                    {
                        importdetaildao.removeImportDetail(i.getImportDetailId());
                    }

                }
            }
            
        };
        cd.getApplyButton().addActionListener(al);
        btnadd.addActionListener(al);
        btnfind.addActionListener(al);
        btnfilter.addActionListener(al);
        btnsave.addActionListener(al);
    }
    public void loadProduct(List<Product> pl)
    {
        mdlproduct.setRowCount(0);
        for(Product i:pl)
        {
            mdlproduct.addRow(new Object[]{i.getProductId(),
                                            i.getProductName(),
                                            productbus.getBrandFromId(i.getBrandId()).getBrandName(),
                                            productbus.getMaterialFromId(i.getMaterialId()).getMaterialName(),
                                            productbus.getCategoryFromId(i.getCategoryId()).getCategoryName(),
                                            i.getPrice()
                                        });
        }
    }
    public void addProductToImportDetail(int productid)
    {
        
    }
    public void loadImportDetail(List<ImportProductDetail> idl)
    {
        mdlproductv.setRowCount(0);
        for(ImportProductDetail i: idl)
        {
            ProductVariant pv = productvariantbus.getProductVariantFromId(i.getProductVariantId());
            ProductColor pc = productvariantbus.getProductColorFromPCId(pv.getProductColorId());
            Product p = productvariantbus.getProductFromProductVariantId(pv.getProductVariantId());
            mdlproductv.addRow(new Object[]{p.getProductId(),p.getProductName(),colordao.getColorFromId(pc.getColorId()),pv.getSize(),i.getQuantity(),i.getAmount()});
        }
    }
    public void setInfo()
    {
        ImportProduct importp = importdao.getImportById(imid);
        if(importp!=null)
        {
            txfemid.setText(Integer.toString(importp.getEmployeeId()));
            txftotal.setText(importp.getTotalAmount().toString());
            cbbsupplier.setSelectedItem(supplierdao.getSppulierFromId(importp.getSupplierId()));
            cbbpay.setSelectedIndex(importp.getPaymentMethod());
            txfdate.setText(importp.getCreatedDate().toString());
        } 
        else 
        {
            txfemid.setText(Integer.toString(employeeid));
            txfdate.setText(LocalDate.now().toString());
        }
        txfimid.setText(Integer.toString(imid));
    }
    public ImportProductDetail getImportDetailFromTable()
    {
        ImportProductDetail ipd = new ImportProductDetail();
        for(int i=0;i<tblproductv.getRowCount();i++)
        {
            int pid = Integer.parseInt(tblproductv.getValueAt(i, 0).toString());
            int colorid = Integer.parseInt(tblproductv.getValueAt(i, 2).toString());
            String size = tblproductv.getValueAt(i,3).toString();
            int quantity = Integer.parseInt(tblproductv.getValueAt(i, 4).toString());
        
            BigDecimal amount = (BigDecimal)(tblproductv.getValueAt(i, 5));
            ProductVariant pv = productvariantbus.getProductVariantFromPCIdAndSize(productvariantbus.getProductColorFromPIdColorId(pid, colorid).getProductColorId(), size);
            ipd =new ImportProductDetail(0,imid,pv.getProductVariantId(),quantity,amount);
        }
        return ipd;
    }

}
