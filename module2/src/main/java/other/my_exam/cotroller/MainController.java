package other.my_exam.cotroller;

import com.opencsv.exceptions.CsvException;
import other.my_exam.common.Validation;
import other.my_exam.exception.NotFoundProductException;
import other.my_exam.model.Product;
import other.my_exam.model.ProductExport;
import other.my_exam.model.ProductImport;
import other.my_exam.service.MainManager;
import other.my_exam.service.ProductExportManager;
import other.my_exam.service.ProductImportManager;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    public static void DisplayMainMenu() throws Exception {
        System.out.println("1. Add New Product");
        System.out.println("2. Show Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Search Product");
        System.out.println("6. Sort Product");
        System.out.println("7. Exit Program");
        int numberChoice = Integer.parseInt(getNumberChoice());
        switch (numberChoice) {
            case 1:
                addNewProduct();
                backMainMenu();
                break;
            case 2:
                showProducts();
                backMainMenu();
                break;
            case 3:
                updateProduct();
                backMainMenu();
                break;
            case 4:
                deleteProduct();
                backMainMenu();
                break;
            case 5:
                searchProduct();
                backMainMenu();
                break;
            case 6:
                sortProduct();
                backMainMenu();
                break;
            case 7:
                System.exit(0);
        }
    }

    private static void addNewProduct() throws Exception {
        System.out.print("Do you want add new Import Product or Export Product (I/E): ");
        String ipAnswer = scanner.nextLine();
        if ("I".equalsIgnoreCase(ipAnswer)){
            MainManager<ProductImport> productManager = new MainManager<>(new ProductImportManager());
            HashMap<String, String> hashMap = inputFields(ProductImport.class);
            int productId = 1;
            List<ProductImport> productList = productManager.GetProducts();
            if (productList.size() > 0)
                productId = productList.get(productList.size()-1).getId()+1;

            ProductImport productImport = new ProductImport(productId, hashMap.get("Code"), hashMap.get("Name")
                    ,Double.parseDouble(hashMap.get("Price")),Integer.parseInt(hashMap.get("Quantity")), hashMap.get("Brand")
                    ,Double.parseDouble(hashMap.get("Price Import")),hashMap.get("City Import"),Double.parseDouble(hashMap.get("Tax Import")));

            productManager.Write(productImport);
            System.out.println("Adding productImport " + hashMap.get("Name") + " successful");
        }
        else if("E".equalsIgnoreCase(ipAnswer)) {
            MainManager<ProductExport> productManager = new MainManager<>(new ProductExportManager());
            HashMap<String, String> hashMap = inputFields(ProductExport.class);
            int productId = 1;
            ProductImportManager productImportManager = new ProductImportManager();
            List<String[]> list = productImportManager.Read();
            for (int i = 0; i < list.size(); i++) {
                if(i==list.size()-1){
                    productId= Integer.parseInt(list.get(i)[0]+1);
                }
            }

//            List<ProductExport> productList = productManager.GetProducts();
//            if (productList.size() > 0)
//                productId = productList.get(productList.size()-1).getId()+1;

            ProductExport productExport = new ProductExport(productId, hashMap.get("Code"), hashMap.get("Name")
                    ,Double.parseDouble(hashMap.get("Price")),Integer.parseInt(hashMap.get("Quantity")), hashMap.get("Brand")
                    ,Double.parseDouble(hashMap.get("Price Export")),hashMap.get("Country Export"));
            productManager.Write(productExport);
            System.out.println("Adding productExport " + hashMap.get("Name") + " successful");
        }
        else
            System.exit(0);

//        HashMap<String, String> hashMap = inputFields(Product.class);
//        int productId = 1;
//        List<Product> productList = productManager.GetProducts();
//        if (productList.size() > 0)
//            productId = productList.get(productList.size()-1).getId()+1;
//
//        Product product = new Product(productId, hashMap.get("Name"), hashMap.get("Brand"), Double.parseDouble(hashMap.get("Price")), hashMap.get("Description"));
//        productManager.Write(product);
//        System.out.println("Adding product " + hashMap.get("Name") + " successful");
    }

    private static void showProducts() throws Exception {
        MainManager<ProductImport> productManager = new MainManager<>(new ProductImportManager());
        productManager.ShowProducts();
    }

    private static void updateProduct() throws Exception {
//        productManager.ShowProducts();
//        int count = 0;
//        String id;
//        do {
//            System.out.print(count == 0 ? "Please choise one productId for update: " : "Please input again productId with correct format: ");
//            id = scanner.nextLine();
//        }
//        while (!Validation.Check("Number", id));
//
//        HashMap<String, String> hashMap = inputFields(Product.class);
//        int productId = Integer.parseInt(id);
//        Product product = new Product(productId, hashMap.get("Name"), hashMap.get("Brand"), Double.parseDouble(hashMap.get("Price")), hashMap.get("Description"));
//        boolean res = productManager.UpdateProduct(product);
//        System.out.println(res ? "Updated product successful" : "Not found productId for update");
    }

    private static void deleteProduct() throws Exception {
        MainManager<ProductExport> productManager = new MainManager<>(new ProductExportManager());
        int count = 0;
        String code;
        do {
            try{
                System.out.print(count == 0 ? "Please choise productCode for delete: " : "Please input again productCode: ");
                code = scanner.nextLine();
                count++;
                Validation.Check("CodeProduct",code);
                break;
            }
            catch (NotFoundProductException e){
                e.printStackTrace();
            }
        }
        while (true);
        boolean res = productManager.DeleteProduct(code);
        System.out.println(res ? "Deleted product successful" : "Not found productCode for delete");
    }

    private static void searchProduct() throws IOException, CsvException, NotFoundProductException {
        MainManager<ProductImport> productManager = new MainManager<>(new ProductImportManager());
        int count = 0;
        String name;
        do {
            System.out.print(count == 0 ? "Please input name or code product for search: " : "Please input again name or code product: ");
            name = scanner.nextLine();
            count++;
        }
        while (false);
        List<ProductImport> res = productManager.SearchProductByName(name);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
        System.out.println(res.size()>0 ? "Found products in list" : "Not found");
    }

    private static void sortProduct() throws IOException, CsvException {
//        List<Product> productList = productManager.GetProducts();
//        //Comparator.comparing()
//        // productList.sort((Product p1,Product p2)->p1.getName().compareTo(p2.getName()));
//        productList.sort((Product p1, Product p2) -> {
//            if (p1.getName().equals(p2.getName()))
//                return (int) (p1.getPrice() - p2.getPrice());
//            else
//                return p1.getName().compareTo(p2.getName());
//        });

//        String[] header = {"Id", "Name", "Brand", "Price", "Description"};
//        for (int i = 0; i < header.length; i++) {
//            System.out.print(header[i] + "\t");
//        }
//        System.out.println(System.lineSeparator());
//        for (Product product : productList) {
//            System.out.print(product.getId() + "\t");
//            System.out.print(product.getName() + "\t");
//            System.out.print(product.getBrand() + "\t");
//            System.out.print(product.getPrice() + "\t");
//            System.out.print(product.getDescription() + "\t");
//            System.out.println(System.lineSeparator());
//        }

        // productList.sort(Comparator.comparing(Product::getName));
    }


    private static String getNumberChoice() throws NotFoundProductException, IOException, CsvException {
        String result;
        System.out.print("Please input your choice: ");
        do {
            result = scanner.nextLine();
        } while (!Validation.Check("Price", result));

        return result;
    }

    private static void backMainMenu() throws Exception {
        System.out.print("Do you back to main menu (Y/N): ");
        String ipAnswer = scanner.nextLine();
        if ("Y".equalsIgnoreCase(ipAnswer))
            DisplayMainMenu();
        else
            System.exit(0);
    }

    private static HashMap<String, String> inputFields(Class cls) throws NotFoundProductException, IOException, CsvException {
        HashMap result = new HashMap<String, String>();
        List<Field> fields = getAllFields(cls);
        for (int i = 0; i < fields.size(); i++) {
            if (i == 0)
                continue;
            String fieldName = fields.get(i).getName();
            Pattern pattern = Pattern.compile("(^.)");
            Matcher matcher = pattern.matcher(fieldName);
            if (matcher.find()) {
                String tmp = fieldName.replaceAll("(\\p{javaUpperCase})", " $1");
                String firstChar = matcher.group(1);
                fieldName = tmp.replaceAll("(^.)", firstChar.toUpperCase());
            }
            String value = "";
            if (cls.equals(ProductImport.class) || cls.equals(ProductExport.class)) {
                int count = 0;
                do {
                    System.out.print(count != 0 ? "Please input again " + fieldName + " with correct format: " : "Input " + fieldName + ": ");
                    value = scanner.nextLine();
                    count++;
                } while (!Validation.Check(fieldName, value));
                count = 0;
            }

            result.put(fieldName, value);
        }
        return result;
    }

    private static List<Field> getAllFields(Class clazz) {
        if (clazz == null) {
            return Collections.emptyList();
        }
        List<Field> result = new ArrayList<>(getAllFields(clazz.getSuperclass()));
        List<Field> filteredFields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toList());
        result.addAll(filteredFields);
        return result;
    }
}
