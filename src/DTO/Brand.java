package DTO;

import java.util.Objects;

public class Brand {
    private int brandId;
    private String brandName;
    public Brand()
    {}
    public Brand(int brandid,String brandname)
    {
        this.brandId = brandid;
        this.brandName = brandname;
    }
    public Brand(Brand d)
    {
        this.brandId=d.brandId;
        this.brandName=d.brandName;
    }
    public int getBrandId()
    {
        return brandId;
    }
    public String getBrandName()
    {
        return brandName;
    }
    @Override
    public String toString()
    {
        return getBrandName();
    }
    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Brand b = (Brand) o;
    return this.brandId == b.brandId;
}

@Override
public int hashCode() {
    return Objects.hash(brandId);
}

}
