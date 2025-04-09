package DTO;


public class Material {
    private int materialId;
    private String materialName;

    public Material(){}
    public Material(int materialId, String materialName) {
        this.materialId = materialId;
        this.materialName = materialName;
    }
    public Material(Material d) {
        this.materialId = d.materialId;
        this.materialName = d.materialName;
    }

    public int getMaterialId() { return materialId; }
    public void setMaterialId(int materialId) { this.materialId = materialId; }
    public String getMaterialName() { return materialName; }
    public void setMaterialName(String materialName) { this.materialName = materialName; }
    @Override 
    public String toString()
    {
        return getMaterialName();
    }
    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Material m = (Material) o;
    return this.getMaterialId() == m.getMaterialId();
}

@Override
public int hashCode() {
    return Integer.hashCode(getMaterialId());
}

}