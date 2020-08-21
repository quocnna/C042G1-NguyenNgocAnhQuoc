package case_study.model;
public class House extends Service {
    private Villa.TypeRoom typeRoom;
    private String description;
    private int numberOfFloor;

    public House(String id, String name, double areaUsed, double price, int maxPeople, TypeRent typeRent, TypeBed typeBed, Villa.TypeRoom typeRoom, String description, int numberOfFloor) {
        super(id, name, areaUsed, price, maxPeople, typeRent, typeBed);
        this.typeRoom = typeRoom;
        this.description = description;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa.TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(Villa.TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
