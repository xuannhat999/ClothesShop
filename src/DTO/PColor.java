package DTO;

public class PColor {
    private int colorId;
    private String colorName;
    private String colorCode;

    public PColor(){}
    public PColor(int colorId, String colorName,String colorCode) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.colorCode = colorCode;
    }

    public PColor(PColor d) {
        this.colorId = d.colorId;
        this.colorName = d.colorName;
        this.colorCode =d.colorCode;
    }

    public int getColorId() { return colorId; }
    public void setColorId(int colorId) { this.colorId = colorId; }
    public String getColorName() { return colorName; }
    public void setColorName(String colorName) { this.colorName = colorName; }
    public String getColorCode(){return colorCode;}

    @Override
    public String toString()
    {
        return colorName;
    }
}
