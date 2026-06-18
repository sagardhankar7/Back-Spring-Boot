package com.sagar.posttry.web;

import com.sagar.posttry.domain.Hotel;
import com.sagar.posttry.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("signup")
public class SignUpController {

    @Autowired
    HotelService hotelService;

    @RequestMapping("create")
    public void create(@RequestBody Hotel hotel) {
        hotelService.createHotel(hotel);
    }
}
