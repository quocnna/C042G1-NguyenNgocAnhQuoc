package case_study.service;

import case_study.common.IFile;
import case_study.model.Room;

import java.util.List;

public class RoomManager implements IFile<Room> {

    @Override
    public void Write(Room room) throws Exception {
        System.out.println("room write");
    }

    @Override
    public List<String[]> Read() {
        System.out.println("room read");
        return null;
    }
}
