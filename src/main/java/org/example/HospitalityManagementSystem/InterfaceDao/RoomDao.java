package org.example.HospitalityManagementSystem.InterfaceDao;

import org.example.HospitalityManagementSystem.ClassEntity.Room;

import java.util.List;

public interface RoomDao {
    void addRoom(Room room);

    Room getRoom(int roomId);
    List<Room> getAllRooms();
    void updateRoom(Room room);
    void deleteRoom(int roomId);
}
