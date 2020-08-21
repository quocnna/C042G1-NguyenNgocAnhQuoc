package case_study.model;

public class Customer {
    private int id;
    private String fullName;
    private String birthday;
    private String gender;
    private String phone;
    private String email;
    private TypeCustomer typeCustomer;
    private String address;
    private Service service;

    public Customer(){ }

    public Customer(int id, String fullName, String birthday, String gender, String phone, String email, TypeCustomer typeCustomer, String address, Service service) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public enum TypeCustomer{
        NORMAL,
        SILVER,
        GOLD,
        DIAMOND
    }
}

