package utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class NumberValidationRenderer extends DefaultTableCellRenderer {
    private final int targetColumn;

    public NumberValidationRenderer(int targetColumn) {
        this.targetColumn = targetColumn;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        String text = (value != null) ? value.toString() : "";
        boolean isValid = true;

        if (column == targetColumn) {
            isValid = isNumber(text);
            if (!isValid) {
                text += " (không hợp lệ)";
            }
        }

        // Gọi super với giá trị đã chỉnh sửa
        Component c = super.getTableCellRendererComponent(table, text, isSelected, hasFocus, row, column);

        // Đổi màu nếu không hợp lệ
        if (!isSelected && column == targetColumn) {
            if (!isValid) {
                c.setBackground(Color.PINK);
                c.setForeground(Color.RED);
            } else {
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
            }
        }

        return c;
    }

    private boolean isNumber(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
