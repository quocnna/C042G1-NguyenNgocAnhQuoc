package other.my_exam.service;

import com.opencsv.exceptions.CsvException;
import other.my_exam.common.IFile;
import other.my_exam.model.Product;
import other.my_exam.model.ProductImport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainManager<T> {
    IFile iFile;

    public MainManager(IFile iFile) {
        this.iFile = iFile;
    }
    public void Write(List<T> t) throws Exception{
        iFile.Write(t);
    }
    public void Write(T t) throws Exception {
        List<T> list = new ArrayList<>();
        list.add(t);
        iFile.Write(list);
    }
    private List<String[]> Read() throws Exception{
        return iFile.Read();
    }
    public List<T> GetProducts() throws IOException, CsvException {
        List<Product> productList = new ArrayList<>();
        List<String[]> list = iFile.Read();
        for (int i = 0; i < list.size(); i++) {
            if(i!=0){
                Product product = new ProductImport();
                product.setId(Integer.parseInt(list.get(i)[0]));
                product.setCode(list.get(i)[1]);
                product.setName(list.get(i)[2]);
                product.setPrice(Double.parseDouble(list.get(i)[3]));
                product.setQuantity(Integer.parseInt(list.get(i)[4]));
                product.setBrand(list.get(i)[5]);
                productList.add(product);
            }
        }
        List<T> res = (List<T>) productList;
        return res;
    }
    public void ShowProducts() throws IOException, CsvException {
        List<String[]> records = iFile.Read();
        for (String[] record : records) {
            Arrays.stream(record).forEach(e -> System.out.print(e + "\t"));
            System.out.println(System.lineSeparator());
        }
    }

    public boolean UpdateProduct(T t) throws Exception {
        boolean res=false;
//        Path productPath = Paths.get(IFile.path + "product.csv");
//        Product product = (Product) t;
//        List<Product> productList = GetProducts();
//        for (int i = 0; i < productList.size(); i++) {
//            if(((Product) t).getId()== productList.get(i).getId()){
//                productList.get(i).setName(((Product) t).getName());
//                productList.get(i).setBrand(((Product) t).getBrand());
//                productList.get(i).setPrice(((Product) t).getPrice());
//                productList.get(i).setDescription(((Product) t).getDescription());
//                res=true;
//                break;
//            }
//        }
//        boolean isExist = Files.exists(productPath);
//        if (isExist)
//            Files.delete(productPath);
//        iFile.Write(productList);
        return res;
    }

    public boolean DeleteProduct(String code) throws Exception {
        boolean res= false;
        Path productPath = Paths.get(IFile.path + "product.csv");
        List<ProductImport> productList = new ArrayList<>();
        List<String[]> list = iFile.Read();
        for (int i = 0; i < list.size(); i++) {
            if(i!=0){
                ProductImport product = new ProductImport();
                product.setId(Integer.parseInt(list.get(i)[0]));
                product.setCode(list.get(i)[1]);
                product.setName(list.get(i)[2]);
                double price =0;
                if (!list.get(i)[3].isEmpty()) {
                    Double.parseDouble(list.get(i)[3]);
                }
                product.setPrice(price);
                product.setQuantity(Integer.parseInt(list.get(i)[4]));
                product.setBrand(list.get(i)[5]);
                double priceImport =0;
                if (!list.get(i)[6].isEmpty()) {
                    Double.parseDouble(list.get(i)[6]);
                }
                product.setPriceImport(priceImport);
                product.setCityImport(list.get(i)[7]);
                double tax =0;
                if (!list.get(i)[8].isEmpty()) {
                    Double.parseDouble(list.get(i)[8]);
                }
                product.setTaxImport(tax);
                productList.add(product);
            }
        }


        for (int i = 0; i < productList.size(); i++) {
            if(code.equals(productList.get(i).getCode())){
                productList.remove(productList.get(i));
                res=true;
                break;
            }
        }
        boolean isExist = Files.exists(productPath);
        if (isExist)
            Files.delete(productPath);
        iFile.Write(productList);
        return res;
    }

    public List<ProductImport> SearchProductByName(String codeOrname) throws IOException, CsvException {
        boolean res = false;
        Path productPath = Paths.get(IFile.path + "product.csv");
        List<ProductImport> productList = new ArrayList<>();
        List<String[]> list = iFile.Read();
        for (int i = 0; i < list.size(); i++) {
            if(i!=0){
                ProductImport product = new ProductImport();
                product.setId(Integer.parseInt(list.get(i)[0]));
                product.setCode(list.get(i)[1]);
                product.setName(list.get(i)[2]);
                double price =0;
                if (!list.get(i)[3].isEmpty()) {
                    Double.parseDouble(list.get(i)[3]);
                }
                product.setPrice(price);
                product.setQuantity(Integer.parseInt(list.get(i)[4]));
                product.setBrand(list.get(i)[5]);
                double priceImport =0;
                if (!list.get(i)[6].isEmpty()) {
                    Double.parseDouble(list.get(i)[6]);
                }
                product.setPriceImport(priceImport);
                product.setCityImport(list.get(i)[7]);
                double tax =0;
                if (!list.get(i)[8].isEmpty()) {
                    Double.parseDouble(list.get(i)[8]);
                }
                product.setTaxImport(tax);
                productList.add(product);
            }
        }

        List<ProductImport> lstSearch = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().contains(codeOrname)|| productList.get(i).getCode().contains(codeOrname)){
                lstSearch.add(productList.get(i));
            }
        }
        return lstSearch;
    }
}
