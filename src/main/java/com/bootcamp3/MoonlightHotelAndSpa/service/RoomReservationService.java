package com.bootcamp3.MoonlightHotelAndSpa.service;

import com.bootcamp3.MoonlightHotelAndSpa.model.Room;
import com.bootcamp3.MoonlightHotelAndSpa.model.RoomReservation;
import com.bootcamp3.MoonlightHotelAndSpa.model.User;

import java.time.Instant;
import java.util.List;

public interface RoomReservationService {

    void save(RoomReservation roomReservation);

    List<RoomReservation> getByUser(User user);

    List<RoomReservation> getAll();

    List<Room> findRoomByPeriodAndPeople(Instant startDate, Instant endDate, int adults, int kids);

    RoomReservation findReservationByIdAndUserId(Long uid, Long rid);

    RoomReservation findById(Long id);
}
