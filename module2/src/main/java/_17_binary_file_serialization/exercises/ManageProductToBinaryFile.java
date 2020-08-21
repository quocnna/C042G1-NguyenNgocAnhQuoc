package _17_binary_file_serialization.exercises;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ManageProductToBinaryFile {
    private static final String path="Module2/src/main/java/_17_binary_file_serialization/exercises/product.bn";
    public static void main(String[] args) {
        Product p = new Product(1, "iPhone X","Apple", 999.99,"des1");
        Field[] f= p.getClass().getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].getName());
        }
//        try {
//            addProductToFile(new Product(3,"new","new",123.45,"new"));
//            readProductsFromFile();
//           // System.out.println(searchProductByName("iPhone"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    private static void addProductToFile(Product p) throws IOException {
        if(!Files.exists(Paths.get(path)))
            Files.createFile(Paths.get(path));
        ProductDAO dao = ProductDAO.getInstance();
        dao.add(p);
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream o = new ObjectOutputStream(fos);
        o.writeObject(dao.listAll());
        o.close();
    }
    private static void readProductsFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream i = new ObjectInputStream(fis);
        List<Product> r =(List<Product>)i.readObject();
        r.stream().forEach(p->{
            System.out.println(p.getName());
        });
    }
    private static boolean searchProductByName(String name){
        ProductDAO dao = ProductDAO.getInstance();
        return dao.searchByName(name);
    }
}
class Product implements Serializable {
    private int id;
    private String name;
    private String brand;
    private double price;
    private String description;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Product(int id) {
        this.id = id;
    }
    public Product(int id, String name, String brand, double price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }
}
class ProductDAO{
    private static ProductDAO instance;
    private static List<Product> data = new ArrayList<>();
    static {
        data.add(new Product(1, "iPhone X","Apple", 999.99,"des1"));
        data.add(new Product(2, "XBOX 360", "Microsoft",329.50,"des2"));
    }
    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    public List<Product> listAll() {
        return new ArrayList<Product>(data);
    }

    public int add(Product product) {
        int newId = data.size() + 1;
        product.setId(newId);
        data.add(product);

        return newId;
    }

    public Product get(int id) {
        Product productToFind = new Product(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }

    public boolean searchByName(String name){
        return data.stream().filter(p->p.getName().contains(name)).findFirst().isPresent();
    }

    public boolean delete(int id) {
        Product productToFind = new Product(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }

        return false;
    }

    public boolean update(Product product) {
        int index = data.indexOf(product);
        if (index >= 0) {
            data.set(index, product);
            return true;
        }
        return false;
    }
}