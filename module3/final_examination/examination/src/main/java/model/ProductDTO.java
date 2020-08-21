package model;

public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String color;
    private int category_id;
    private String category_name;

    public ProductDTO(int id, String name, double price, int quantity, String color, int category_id, String category_name) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
