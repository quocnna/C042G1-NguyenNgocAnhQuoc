package case_study.model;

import java.util.List;

public class Room extends Service {
    private List<ServiceAccompanied> serviceFree;

    public List<ServiceAccompanied> getServiceFree() {
        return serviceFree;
    }

    public Room(String id, String name, double areaUsed, double price, int maxPeople, TypeRent typeRent, TypeBed typeBed, List<ServiceAccompanied> serviceFree) {
        super(id, name, areaUsed, price, maxPeople, typeRent, typeBed);
        this.serviceFree = serviceFree;
    }

    @Override
    public void showInfo() {

    }
}
