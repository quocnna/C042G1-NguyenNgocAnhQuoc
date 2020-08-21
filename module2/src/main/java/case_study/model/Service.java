package case_study.model;

public abstract class Service {
    private String id;
    private String name;
    private double areaUsed;
    private double price;
    private int maxPeople;
    private TypeRent typeRent;
    private TypeBed typeBed;

    public Service(){

    }
    public Service(String id, String name, double areaUsed, double price, int maxPeople, TypeRent typeRent, TypeBed typeBed) {
        this.id = id;
        this.name = name;
        this.areaUsed = areaUsed;
        this.price = price;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
        this.typeBed = typeBed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public TypeRent getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(TypeRent typeRent) {
        this.typeRent = typeRent;
    }

    public TypeBed getTypeBed(){
        return typeBed;
    }

    public void setTypeBed(TypeBed typeBed){
        this.typeBed = typeBed;
    }
    public abstract void showInfo();

    public enum TypeRent {
        DAY,
        MONTH,
        YEAR
    }
    public enum TypeBed{
        SINGLE,
        DOUBLE,
        TRIPLE,
        EXTRA_BED,
        QUAD,
        QUEEN,
        KING,
        TWIN
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                '}';
    }
}


