package org.example.HospitalityManagementSystem.InterfaceDao;

import org.example.HospitalityManagementSystem.ClassEntity.Hotel;

import java.util.List;

public interface HotelDao {
    void addHotel(Hotel hotel);
    Hotel getHotel(int hotelId);
    List<Hotel> getAllHotels();
    void updateHotel(Hotel hotel);
    void deleteHotel(int hotelId);
}
