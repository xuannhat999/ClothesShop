package GUI;

import DAO.SupplierDAO;
import DTO.Supplier;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class SupplierPanel extends MainPanel{
    private SupplierDAO supplierdao = new SupplierDAO();
    private JTextField txfid,txfname,txfphone,txfemail,txfaddress;
    private JTable tblsupp;
    private DefaultTableModel mdlsupp;
    private JScrollPane spsupp;
    public SupplierPanel()
    {
        super();
        init();
    }
    private void init()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=2;
        JLabel lblsupp =new JLabel("Nhà cung cấp");
        lblsupp.setFont(Theme.infofont1);
        lblsupp.setBorder(new EmptyBorder(10,10,40,0));        
        pnlcon1.add(lblsupp,gbc);

        JLabel lblid = new JLabel("ID Nhà cung cấp  ");
        gbc.gridy=1;
        gbc.gridwidth=1;
        pnlcon1.add(lblid,gbc);

        JLabel lblname = new JLabel("Tên nhà cung cấp  ");
        gbc.gridy=2;
        pnlcon1.add(lblname,gbc);

        JLabel lblphone = new JLabel("Số điện thoại  ");
        gbc.gridy=3;
        pnlcon1.add(lblphone,gbc);

        JLabel lblemail = new JLabel("Email  ");
        gbc.gridy=4;
        pnlcon1.add(lblemail,gbc);

        JLabel lbladdress = new JLabel("Địa chỉ  ");
        gbc.gridy=5;
        pnlcon1.add(lbladdress,gbc);

        txfid=new JTextField();
        txfid.setPreferredSize(new Dimension(50,30));
        gbc.gridx=1;
        gbc.gridy=1;
        pnlcon1.add(txfid,gbc);
        txfid.setEditable(false);

        txfname = new JTextField();
        txfname.setPreferredSize(new Dimension(300,30));
        gbc.gridy=2;
        pnlcon1.add(txfname,gbc);


        txfphone = new JTextField();
        txfphone.setPreferredSize(new Dimension(300,30));
        gbc.gridy=3;
        pnlcon1.add(txfphone,gbc);

        txfemail = new JTextField();
        txfemail.setPreferredSize(new Dimension(300,30));
        gbc.gridy=4;
        pnlcon1.add(txfemail,gbc);

        txfaddress = new JTextField();
        txfaddress.setPreferredSize(new Dimension(300,30));
        gbc.gridy=5;
        pnlcon1.add(txfaddress,gbc);

        JLabel lblblank = new JLabel();
        gbc.gridy=6;
        gbc.gridwidth=2;
        gbc.weighty=1;
        pnlcon1.add(lblblank,gbc);

        String column[] = {"Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Email","Địa chỉ"};
        mdlsupp= new DefaultTableModel(column,0);
        tblsupp = new JTable(mdlsupp);
        spsupp = new JScrollPane(tblsupp);
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.gridwidth=1;
        pnlcon4.add(spsupp,gbc);
        tblsupp.setRowHeight(30);
        tblsupp.getTableHeader().setPreferredSize(new Dimension(0,40));
        loadSupplierList(supplierdao.getAllSupplier());

        setUpdate(false);
        addEvent();
    }
    public void loadSupplierList(List<Supplier> sl)
    {
        mdlsupp.setRowCount(0);
        for(Supplier i :sl)
        {
            mdlsupp.addRow(new Object[]{i.getSupplierId(),
                                        i.getSupplierName(),
                                        i.getPhone(),
                                        i.getEmail(),
                                        i.getAddress()});
        }
    }
    public void loadSupplierInfo(int supid)
    {
        Supplier sup = supplierdao.getSppulierFromId(supid);
        txfid.setText(Integer.toString(sup.getSupplierId()));
        txfname.setText(sup.getSupplierName());
        txfphone.setText(sup.getPhone());
        txfemail.setText(sup.getEmail());
        txfaddress.setText(sup.getAddress());
    }
    private void addEvent()
    {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnadd)
                {
                    txfid.setText(Integer.toString(supplierdao.getNextSupplierId()));
                    txfname.setText("");
                    txfaddress.setText("");
                    txfphone.setText("");
                    txfemail.setText("");
                    setUpdate(true);
                    showSupplierInfo(true);
                }
                else if(e.getSource()==btnupdate)
                {
                    setUpdate(true);
                    showSupplierInfo(true);
                }
                else if(e.getSource() ==btnsave)
                {
                    Supplier sup = new Supplier(Integer.parseInt(txfid.getText()),txfname.getText(),txfphone.getText(),txfemail.getText(),txfaddress.getText());
                    if(supplierdao.getSppulierFromId(sup.getSupplierId())==null)
                    {
                        supplierdao.addSupplier(sup);
                    }
                    else 
                    {
                        supplierdao.updateSupplier(sup);
                    }
                    setUpdate(false);
                    setButtonEnable(false);
                }
                else if(e.getSource()==btncancel)
                {
                    showSupplierInfo(false);
                    setUpdate(false);
                    setButtonEnable(false);
                }
            }
        };
        btnadd.addActionListener(al);
        btnupdate.addActionListener(al);
        btnsave.addActionListener(al);
        btncancel.addActionListener(al);


        tblsupp.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(tblsupp.getSelectedRow()>=0)
                {
                    int supid = Integer.parseInt(tblsupp.getValueAt(tblsupp.getSelectedRow(),0).toString());
                    loadSupplierInfo(supid);
                    showSupplierInfo(true);
                    setButtonEnable(true);
                }
            }
            
        });
    }
    public void setUpdate(boolean a)
    {
        txfname.setEditable(a);
        txfphone.setEditable(a);
        txfaddress.setEditable(a);
        txfemail.setEditable(a);
        btnsave.setVisible(a);
        btncancel.setVisible(a);
    }
    public void showSupplierInfo(boolean a)
    {
        txfid.setVisible(a);
        txfname.setVisible(a);
        txfphone.setVisible(a);
        txfemail.setVisible(a);
        txfaddress.setVisible(a);
        revalidate();
        repaint();
    }
}
