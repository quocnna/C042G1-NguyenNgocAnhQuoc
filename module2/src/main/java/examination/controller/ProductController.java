package examination.controller;

import com.opencsv.exceptions.CsvException;
import examination.common.Utils;
import examination.common.Validation;
import examination.model.ProductDTO;
import examination.model.ProductExport;
import examination.model.ProductImport;
import examination.service.MainManager;
import examination.service.ProductExportManager;
import examination.service.ProductImportManager;
import java.io.IOException;
import java.util.*;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    public static void DisplayMainMenu() throws Exception {
        System.out.println("1. Add New Product");
        System.out.println("2. Show Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Search Product");
        System.out.println("6. Sort Product");
        System.out.println("7. Exit Program");
        int numberChoice = Integer.parseInt(Utils.GetNumberChoice());
        switch (numberChoice) {
            case 1:
                addNewProduct();
                backMainMenu();
                break;
            case 2:
                //showProducts();
                backMainMenu();
                break;
            case 3:
                //updateProduct();
                backMainMenu();
                break;
            case 4:
                //deleteProduct();
                backMainMenu();
                break;
            case 5:
                //searchProduct();
                backMainMenu();
                break;
            case 6:
                //sortProduct();
                backMainMenu();
                break;
            case 7:
                System.exit(0);
        }
    }

        private static void showProducts() throws IOException, CsvException {
        MainManager<ProductImport> productManager = new MainManager<>(new ProductImportManager());
        productManager.ShowProducts();
    }

    private static void deleteProduct() throws Exception {
        showProducts();
        MainManager<ProductImport> productManager = new MainManager<>(new ProductImportManager());
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
            catch (Exception e){}
        }
        while (true);
        boolean res = productManager.DeleteProduct(code);
        System.out.println(res ? "Deleted product successful" : "Not found productCode for delete");
    }

    private static void addNewProduct() throws Exception {
        System.out.print("Do you want add new Import Product or Export Product (I/E): ");
        String ipAnswer = scanner.nextLine();
        if ("I".equalsIgnoreCase(ipAnswer)){
            MainManager<ProductImport> productManager = new MainManager<>(new ProductImportManager());
            HashMap<String, String> hashMap = Utils.InputFields(ProductImport.class,false);
            int productId = 1;
            List<ProductDTO> productList = productManager.GetProducts();
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
            HashMap<String, String> hashMap = Utils.InputFields(ProductExport.class,false);
            int productId = 1;
            List<ProductDTO> productList = productManager.GetProducts();
            if (productList.size() > 0)
                productId = productList.get(productList.size()-1).getId()+1;

            ProductExport productExport = new ProductExport(productId, hashMap.get("Code"), hashMap.get("Name")
                    ,Double.parseDouble(hashMap.get("Price")),Integer.parseInt(hashMap.get("Quantity")), hashMap.get("Brand")
                    ,Double.parseDouble(hashMap.get("Price Export")),hashMap.get("Country Export"));

            productManager.Write(productExport);
            System.out.println("Adding productExport " + hashMap.get("Name") + " successful");
        }
        else
            System.exit(0);
    }

    private static void backMainMenu() throws Exception {
        System.out.print("Do you back to main menu (Y/N): ");
        String ipAnswer = scanner.nextLine();
        if ("Y".equalsIgnoreCase(ipAnswer))
            DisplayMainMenu();
        else
            System.exit(0);
    }
}
