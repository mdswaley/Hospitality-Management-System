package org.example.HospitalityManagementSystem.InterfaceDao;

import org.example.HospitalityManagementSystem.ClassEntity.Guest;

import java.util.List;

public interface GuestDao {
    void addGuest(Guest guest);
    Guest getGuest(int guestId);
    List<Guest> getAllGuests();
    void updateGuest(Guest guest);
    void deleteGuest(int guestId);
}
