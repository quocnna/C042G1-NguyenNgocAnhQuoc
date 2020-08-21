package case_study.model;

public class Villa extends Service {
    private TypeRoom typeRoom;
    private String description;
    private double areaPool;
    private int numberOfFloor;

    public Villa(){
        super();
    }
    public Villa(String id, String name, double areaUsed, double price, int maxPeople, TypeRent typeRent,TypeBed typeBed
    ,TypeRoom typeRoom, String description, double areaPool, int numberOfFloor){
        super(id,name,areaUsed,price,maxPeople,typeRent,typeBed);
        this.typeRoom= typeRoom;
        this.description= description;
        this.areaPool = areaPool;
        this.numberOfFloor= numberOfFloor;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public void showInfo() {

    }

    public enum TypeRoom{
        STANDARD,
        SUPERIOR,
        DELUXE,
        SUITE,
        PRESIDENTIAL
    }
}


