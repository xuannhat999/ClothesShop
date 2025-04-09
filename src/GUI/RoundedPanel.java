package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
    private int radius;
    private Color borderColor = Color.BLACK; // Màu viền mặc định
    private int borderWidth = 0; // Độ dày viền mặc định

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false); // Để bo góc hiển thị đúng
    }

    // Thiết lập kích thước panel
    public void setPanelSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setSize(width, height);
        revalidate(); // Cập nhật bố cục
        repaint(); // Vẽ lại panel
    }

    // Thiết lập màu viền
    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    // Thiết lập độ dày viền
    public void setBorderWidth(int width) {
        this.borderWidth = width;
        repaint();
    }

    // Phương thức vẽ viền
    private void drawBorder(Graphics2D g2) {
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderWidth));
        g2.drawRoundRect(borderWidth / 2, borderWidth / 2, getWidth() - borderWidth, getHeight() - borderWidth, radius, radius);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền panel
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Vẽ viền panel
        drawBorder(g2);

        g2.dispose();
        super.paintComponent(g);
    }
}

