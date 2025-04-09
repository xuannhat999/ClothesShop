package DTO;

public class Category {
 private int categoryId;
    private String categoryName;

    public Category(){}
    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(Category d) {
        this.categoryId = d.categoryId;
        this.categoryName = d.categoryName;
    }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    @Override
    public String toString()
    {
        return getCategoryName();
    }
    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Category c = (Category) o;
    return this.getCategoryId() == c.getCategoryId();
}

@Override
public int hashCode() {
    return Integer.hashCode(getCategoryId());
}

}



