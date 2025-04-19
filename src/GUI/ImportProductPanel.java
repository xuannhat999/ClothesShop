package GUI;

import DAO.ImportDAO;
import DAO.ImportDetailDAO;
import DAO.PaymentMethodDAO;
import DTO.ImportProduct;
import DTO.Product;
import DTO.Supplier;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ImportProductPanel extends MainPanel{
    private RoundedButton btnsupplier;
    private JComboBox<Supplier> cbbsupplier;
    private int employeeid;
    private List<Product> productlist;
    private JTable tblimport;
    private DefaultTableModel mdlimport;
    private JScrollPane spimport;
    private ImportDAO importdao = new ImportDAO();
    private ImportDetailDAO importdetaildao = new ImportDetailDAO();
    public ImportProductPanel(int employeeid)
    {
        super();
        this.employeeid=employeeid;
        init();
    }
    private void init()
    {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets = new Insets(10,10,10,10);
        pnlcon1.setVisible(false);
        pnlcon3.setVisible(false);

        //remove(pnlcon1);
        revalidate();
        repaint();

        //PANEL 2
        btnsupplier = new RoundedButton("Nhà cung cấp",20);
        btnsupplier.setButtonSize(100, 40);
        btnsupplier.setBackground(Theme.light3);
        gbc.gridx=0;
        gbc.gridy=9;
        gbc.weightx=1;
        gbc.weighty=0;
        pnlcon2.add(btnsupplier,gbc);


        //PANEL 4
        pnlcon4.setLayout(new BorderLayout());
        String columnName[]={"ID phiếu nhập","Tên nhân viên","Ngày nhập","Nhà cung cấp","Tổng tiền","Phương thức thanh toán"};
        mdlimport = new DefaultTableModel(columnName,0);
        tblimport = new JTable(mdlimport);
        spimport = new JScrollPane(tblimport);
        pnlcon4.add(spimport,BorderLayout.CENTER);
        loadImport(importdao.getAllImport());

        spimport.getViewport().setBackground(Theme.light1);
        tblimport.getTableHeader().setBackground(Theme.light2);
        tblimport.setRowHeight(30);
        tblimport.getTableHeader().setPreferredSize(new Dimension(0,40));
        addEvent();

    }
    private void loadImport(List<ImportProduct> il)
    {
        mdlimport.setRowCount(0);
        for(ImportProduct i : il)
        {
            mdlimport.addRow(new Object[]{i.getImportProductId(),
                                            i.getEmployeeId(),
                                            i.getCreatedDate(),
                                            i.getSupplierId(),
                                            i.getTotalAmount(),
                                            PaymentMethodDAO.getPaymentMethodName(i.getPaymentMethod())});
        }
    }
    private void addEvent()
    {
        tblimport.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                setButtonVisible(true);
            }
            
        });
        
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnadd)
                {
                    int importid = importdao.getNextImportId();
                    new AddImportRecord(employeeid, importid);
                }
                else if(e.getSource()==btnupdate)
                {
                    if(tblimport.getRowCount()>=0)
                    {
                        int importid = Integer.parseInt(tblimport.getValueAt(tblimport.getSelectedRow(), 0).toString());
                        new AddImportRecord(employeeid,importid);

                    }
                }
            }
        };
        btnadd.addActionListener(al);
        btnupdate.addActionListener(al);
    }
}
