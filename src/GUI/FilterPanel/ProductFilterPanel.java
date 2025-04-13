package GUI.FilterPanel;

import BUS.ProductBUS;
import DTO.Brand;
import DTO.Category;
import DTO.Gender;
import DTO.Material;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductFilterPanel extends JPanel{
    private JComboBox<Category> cbbcat;
    private JComboBox<Material> cbbmat;
    private JComboBox<Brand> cbbbra;
    private JComboBox<Gender>cbbgen;
    private ProductBUS productbus = new ProductBUS();
    public ProductFilterPanel()
    {   
        init();
    }
    private void init()
    {
        setLayout(new GridLayout(4,2,10,10));
        JLabel lblcat = new JLabel("Loại");
        add(lblcat);
        cbbcat = new JComboBox<>();
        add(cbbcat);
        JLabel lblmat = new JLabel("Chất liệu");
        add(lblmat);
        cbbmat = new JComboBox<>();
        add(cbbmat);
        JLabel lblbra = new JLabel("Thương hiệu");
        add(lblbra);
        cbbbra = new JComboBox<>();
        add(cbbbra);
        JLabel lblgen = new JLabel("Giới tính");
        add(lblgen);
        cbbgen = new JComboBox<>();
        add(cbbgen);
        cbbcat.addItem(null);
        for(Category i : productbus.getAllCategory())
        {
            cbbcat.addItem(i);
        }
        cbbmat.addItem(null);
        for(Material i: productbus.getAllMaterial())
        {
            cbbmat.addItem(i);
        }
        cbbbra.addItem(null);
        for(Brand i : productbus.getAllBrand())
        {
            cbbbra.addItem(i);
        }
        cbbgen.addItem(null);
        for(Gender i : productbus.getAllGender())
        {
            cbbgen.addItem(i);
        }
        cbbcat.setSelectedIndex(0);
        cbbmat.setSelectedIndex(0);
        cbbbra.setSelectedIndex(0);
        cbbgen.setSelectedIndex(0);
    }
    public Category getSelectedCategory()
    {
        return (Category)cbbcat.getSelectedItem();
    }
    public Material getSelectedMaterial()
    {
        return (Material)cbbmat.getSelectedItem();
    }
    public Brand getSelectedBrand()
    {
        return (Brand)cbbbra.getSelectedItem();
    }
    public Gender getSelectedGender()
    {
        return (Gender)cbbgen.getSelectedItem();
    }
}
