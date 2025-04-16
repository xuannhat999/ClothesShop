package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class QuantityPanel extends JPanel{
    private int quantity,height;
    private JButton btninquan,btndequan;
    private  JTextField txfquan;

    public QuantityPanel(int height)
    {
        this.height=height;
        this.quantity=0;
        init();
    }
    private void init()
    {
        setPreferredSize(new Dimension(4*height,height));
        setMaximumSize(getPreferredSize());
        setMinimumSize(getPreferredSize());
        setLayout(new BorderLayout());
        setOpaque(false);
        
        txfquan = new JTextField();
        txfquan.setPreferredSize(new Dimension(2*height,height));
        txfquan.setHorizontalAlignment(SwingConstants.CENTER);
        txfquan.setText(Integer.toString(quantity));
        add(txfquan,BorderLayout.CENTER);

        btninquan = new JButton("+");
        btninquan.setFocusPainted(false);
        btninquan.setPreferredSize(new Dimension(height,height));
        add(btninquan,BorderLayout.EAST);

        btndequan = new JButton("-");
        btndequan.setFocusPainted(false);
        btndequan.setPreferredSize(new Dimension(height,height));
        add(btndequan,BorderLayout.WEST);

        addEvent();
    }

    private void addEvent()
    {
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btndequan)
                {
                    if(quantity>0)
                        quantity--;
                    updateDisplayQuantity();
                }
                else if(e.getSource()==btninquan)
                {
                    quantity++;
                    updateDisplayQuantity();
                }
                else if (e.getSource()==txfquan)
                {
                }

                
            }
            
        };
        btninquan.addActionListener(al);
        btndequan.addActionListener(al);
        txfquan.addActionListener(al);

        txfquan.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateQuantityFromTextField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateQuantityFromTextField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        });
    }
    public int getQuan()
    {
        System.out.print(quantity);
        return quantity;
    }
    public void setEditable(boolean status)
    {
        btndequan.setEnabled(status);
        btninquan.setEnabled(status);
        txfquan.setEditable(status);
        if(!status)
            txfquan.setText(Integer.toString(0));
    }
    public JTextField getQuanTextField()
    {
        return txfquan;
    }
    private void updateQuantityFromTextField() {
        String text = txfquan.getText();
        if (text.matches("\\d+")) {
            quantity = Integer.parseInt(text);
        } else {
            // Optional: đặt lại về 0 hoặc báo lỗi
            quantity = 0;
        }
    }
    private void updateDisplayQuantity()
    {
        txfquan.setText(Integer.toString(quantity));
    }
    public void setQuantity(int quan)
    {
        quantity = quan;
        updateDisplayQuantity();
    }
    public void setEditableQuanPanel(boolean a)
    {
        btndequan.setEnabled(a);
        btninquan.setEnabled(a);
        txfquan.setEditable(a);
    }

}
