package model;

import java.util.Objects;

public class Product {
    private int id;
    private String brandName;
    private String madeIn;
    private double price;
    private boolean discontinued;
    private String supplier;
    private String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Product(int id){
        this.id= id;
    }

    public Product(int id, String brandName, String madeIn, double price, boolean discontinued, String supplier, String category) {
        this.id = id;
        this.brandName = brandName;
        this.madeIn = madeIn;
        this.price = price;
        this.discontinued = discontinued;
        this.supplier = supplier;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
