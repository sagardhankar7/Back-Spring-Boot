package com.sagar.posttry.services;

import com.sagar.posttry.domain.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {

    List<Hotel> hotelList = new ArrayList<>();
    Map<String , Hotel> hashMap = new HashMap<>();
    public void createHotel(Hotel hotel) {
        hotelList.add(hotel);
        hashMap.put(hotel.getId(), hotel);
    }

    public Hotel getHotelById(String id) {
        if (hashMap.containsKey(id)) return hashMap.get(id);
        else return null;
    }
}
