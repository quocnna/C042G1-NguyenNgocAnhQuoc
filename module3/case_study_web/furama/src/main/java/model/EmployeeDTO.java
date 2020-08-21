package model;

public class EmployeeDTO {
    private int id;
    private String name;
    private String birthday;
    private String cardid;
    private String phone;
    private String email;
    private String address;
    private double salary;
    private int position_id;
    private String position_name;
    private int education_degree_id;
    private String education_degree_name;
    private int division_id;
    private String division_name;
    private int user_id;
    private String username;

    public EmployeeDTO(int id, String name, String birthday, String cardid, String phone, String email, String address, double salary, int position_id, String position_name, int education_degree_id, String education_degree_name, int division_id, String division_name, int user_id, String username) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cardid = cardid;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.position_id = position_id;
        this.position_name = position_name;
        this.education_degree_id = education_degree_id;
        this.education_degree_name = education_degree_name;
        this.division_id = division_id;
        this.division_name = division_name;
        this.user_id = user_id;
        this.username = username;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public String getEducation_degree_name() {
        return education_degree_name;
    }

    public void setEducation_degree_name(String education_degree_name) {
        this.education_degree_name = education_degree_name;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
