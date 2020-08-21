package examination.service;
import com.opencsv.exceptions.CsvException;
import examination.common.IData;
import examination.model.Contact;
import examination.model.ProductDTO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainManager<T> {
    private static Path productPath = Paths.get(IData.path + "product.csv");
    IData iData;

    public MainManager(IData iData) {
        this.iData = iData;
    }

    public void Write(List<T> t) throws Exception{
        iData.Write(t);
    }
    public void Write(T t) throws Exception {
        List<T> list = new ArrayList<>();
        list.add(t);
        iData.Write(list);
    }
    private List<String[]> Read(String fileName) throws Exception{
        return iData.Read(fileName);
    }

    public List<Contact> SearchContact(String phoneOrname) throws IOException, CsvException {
        List<Contact> res = new ArrayList<>();
        List<Contact> contactList = GetContacts();
        for (int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getPhoneNumber().contains(phoneOrname) || contactList.get(i).getFullName().contains(phoneOrname)){
                res.add(contactList.get(i));
            }
        }
        return res;
    }

    public void DeleteContact(String phoneNumber) throws Exception {
        Path contactPath = Paths.get(IData.path + "contact.csv");
        List<Contact> contactList = GetContacts();
        for (int i = 0; i < contactList.size(); i++) {
            if(phoneNumber.equals(contactList.get(i).getPhoneNumber())){
                contactList.remove(contactList.get(i));
                break;
            }
        }
        boolean isExist = Files.exists(contactPath);
        if (isExist)
            Files.delete(contactPath);
        iData.Write(contactList);
    }

    public boolean CheckPhoneNumber(String phoneNumber) throws IOException, CsvException {
        boolean res=false;
        List<Contact> contactList = GetContacts();
        for (int i = 0; i < contactList.size(); i++) {
            if(phoneNumber.equals(contactList.get(i).getPhoneNumber())){
                res=true;
                break;
            }
        }
        return res;
    }

    public boolean UpdateContact(T t) throws Exception {
        boolean res=false;
        Path contactPath = Paths.get(IData.path + "contact.csv");
        Contact contact= (Contact) t;
        List<Contact> contactList = GetContacts();
        for (int i = 0; i < contactList.size(); i++) {
            if(contact.getPhoneNumber().equals(contactList.get(i).getPhoneNumber())){
                contactList.get(i).setContactGroup(contact.getContactGroup());
                contactList.get(i).setFullName(contact.getFullName());
                contactList.get(i).setGender(contact.getGender());
                contactList.get(i).setFullName(contact.getAddress());
                contactList.get(i).setFullName(contact.getBirthday());
                contactList.get(i).setFullName(contact.getEmail());
                res=true;
                break;
            }
        }
        boolean isExist = Files.exists(contactPath);
        if (isExist)
            Files.delete(contactPath);
        iData.Write(contactList);
        return res;
    }

    public List<Contact> GetContacts() throws IOException, CsvException {
        List<Contact> contactList = new ArrayList<>();
        List<String[]> e = iData.Read("contact.csv");
        for (int i = 0; i < e.size(); i++) {
            if(i!=0){
                Contact contact = new Contact(e.get(i)[0],e.get(i)[1], e.get(i)[2], e.get(i)[3],e.get(i)[4],e.get(i)[5],e.get(i)[6]);
                contactList.add(contact);
            }
        }
        return contactList;
    }

    public void ShowContacts() throws IOException, CsvException {
        List<String[]> records = iData.Read("contact.csv");
        for (String[] record : records) {
            Arrays.stream(record).forEach(e -> System.out.print(e + "\t"));
            System.out.println(System.lineSeparator());
        }
    }

    public List<ProductDTO> GetProducts() throws IOException, CsvException {
        List<ProductDTO> productList = new ArrayList<>();
        List<String[]> e = iData.Read("product.csv");
        for (int i = 0; i < e.size(); i++) {
            if(i!=0){
                ProductDTO productDTO= new ProductDTO();
                productDTO.setId(Integer.parseInt(e.get(i)[0]));
                productDTO.setCode(e.get(i)[1]);
                productDTO.setName(e.get(i)[2]);
                productDTO.setPrice(Double.parseDouble(e.get(i)[3]));
                productDTO.setQuantity(Integer.parseInt(e.get(i)[4]));
                productDTO.setBrand(e.get(i)[5]);
                productDTO.setPriceImport(e.get(i)[6].isEmpty()?0:Double.parseDouble(e.get(i)[6]));
                productDTO.setCityImport(e.get(i)[7]);
                productDTO.setTaxImport(e.get(i)[8].isEmpty()?0:Double.parseDouble(e.get(i)[8]));
                productDTO.setPriceExport(e.get(i)[9].isEmpty()?0:Double.parseDouble(e.get(i)[9]));
                productDTO.setCountryExport(e.get(i)[10]);
                productList.add(productDTO);
            }
        }
        return productList;
    }

    public void ShowProducts() throws IOException, CsvException {
        List<String[]> records = iData.Read("product.csv");
        for (String[] record : records) {
            Arrays.stream(record).forEach(e -> System.out.print(e + "\t"));
            System.out.println(System.lineSeparator());
        }
    }


    public boolean DeleteProduct(String code) throws Exception {
        boolean res= false;
        List<ProductDTO> productDTOS = GetProducts();

        for (int i = 0; i < productDTOS.size(); i++) {
            if(code.equals(productDTOS.get(i).getCode())){
                productDTOS.remove(productDTOS.get(i));
                res=true;
                break;
            }
        }
        boolean isExist = Files.exists(productPath);
        if (isExist)
            Files.delete(productPath);
        iData.Write(productDTOS);
        return res;
    }
}
