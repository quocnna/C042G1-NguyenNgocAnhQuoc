package model;

public class Customer {
    private int id;
    private String name;
    private String birthday;
    private String cardid;
    private String phone;
    private String email;
    private String address;
    private int gender;
    private int customer_type_id;
    private int user_id;

    public Customer(int id, String name, String birthday, String cardid, String phone, String email, String address, int gender, int customer_type_id, int user_id) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cardid = cardid;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.customer_type_id = customer_type_id;
        this.user_id = user_id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
