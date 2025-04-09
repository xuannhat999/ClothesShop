package utils;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class InputParser {

    public static BigDecimal parseBigDecimal(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " không được để trống!");
            return null;
        }

        try {
            return new BigDecimal(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, fieldName + " không hợp lệ!");
            return null;
        }
    }
}
