package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import DAO.ColorDAO;
import DTO.PColor;

public class ColorPanelRenderer extends JPanel implements TableCellRenderer {
    private ColorDAO colordao = new ColorDAO();
    public ColorPanelRenderer() {
        setOpaque(true); // Đảm bảo vẽ màu nền
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {

        // Mặc định nền trắng
        setBackground(Color.WHITE);

        if (value != null) {
            try {
                int colorid = Integer.parseInt(value.toString());
                PColor color = colordao.getColorFromId(colorid);
                // Nếu là mã hex như #FF0000
                if (color!=null) {
                    setBackground(Color.decode(color.getColorCode()));
                } else {
                    System.out.print("Color id does not esixts");
                }
            } catch (Exception e) {
                setBackground(Color.WHITE);
            }
        }

        return this;
    }
}

