package _12_java_collection_framework.practices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayList_LinkedList {
    static ArrayList<Product> ar = new ArrayList<>();

    private static void create(Product p) {
        ar.add(p);
    }
    private static void read() {
        ar.forEach(e -> System.out.println("Name: "+ e.getName() + " Price: " + e.getPrice()));
    }
    private static void update(Product p, String nameEdit) {
        p.setName(nameEdit);
    }
    private static void delete(Product p) {
        ar.remove(p);
    }
    private static boolean search(ArrayList<Product> ar, String name) {
        final boolean[] res = {false};
        ar.forEach(e -> {
                    if (e.getName().equals(name)) {
                        res[0] =true;
                        return;
                    }
                }
        );
        return res[0];
    }
    private static void sort() {
//        Comparator<Product> c= new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                //return o1.getPrice()<o2.getPrice()?1:-1;
//                return (int)(o1.getPrice()-o2.getPrice());
//            }
//        };
//        Collections.sort(ar,c);
//        Collections.reverse(ar);
        ar.sort((o1,o2)->(int)(o2.getPrice()-o2.getPrice()));
    }

    public static void main(String[] args) {
        System.out.println("Create...");
        Product p1 = new Product(1, "nokia", 200);
        Product p2 = new Product(2, "samsung", 100);
        Product p3 = new Product(3, "iphone", 600);
        Product p4 = new Product(4, "bphone", 50);
        Product p5 = new Product(5, "huwaie", 150);
        create(p1);
        create(p2);
        create(p3);
        create(p4);
        create(p5);
        System.out.println("Update...");
        update(p1, "nokiaEdit");
        delete(p3);
        System.out.println("Search..." + search(ar, "bphone"));
        System.out.println("Sort...");
        sort();
        System.out.println("Read...");
        read();
    }
}

class Product {
    private int id;
    private String name;
    private double price;

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

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
