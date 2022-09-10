package com.bootcamp3.MoonlightHotelAndSpa;

import com.bootcamp3.MoonlightHotelAndSpa.enumeration.RoomType;
import com.bootcamp3.MoonlightHotelAndSpa.enumeration.RoomView;
import com.bootcamp3.MoonlightHotelAndSpa.exception.RoomNotFoundException;
import com.bootcamp3.MoonlightHotelAndSpa.model.Room;
import com.bootcamp3.MoonlightHotelAndSpa.repository.RoomRepository;
import com.bootcamp3.MoonlightHotelAndSpa.service.impl.RoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RoomServiceImplTest {

    @Mock
    RoomRepository roomRepository;

    RoomServiceImpl roomService;

    @BeforeEach
    public void setUp() {
        roomService = new RoomServiceImpl(roomRepository);
    }

    @Test
    public void verifyFindRoomByIdSuccess() {
        Long id = 5L;
        roomRepository.findById(id);
        verify(roomRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindRoomByIdThrowsException() {
        String expectedMessage = "Room with id:5 not found";

        RoomNotFoundException ex = assertThrows(RoomNotFoundException.class,
                () -> roomService.findRoomById(5L));

        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    public void verifySave() {
        Room room = Room.builder().build();
        roomRepository.save(room);
        verify(roomRepository, times(1)).save(room);
    }

    @Test
    public void verifyGetAllRooms() {
        roomRepository.findAll();
        verify(roomRepository, times(1)).findAll();

    }

    @Test
    public void verifyUpdateRoom() {
        Double expectedUpdatePrice = 150.80;

        Room room = new Room();
        room.setTitle(RoomType.STANDARD);
        room.setImage("some_picture.jpg");
        room.setImages(new HashSet<>());
        room.setDescription("Standard room with sea view");
        room.setArea(24);
        room.setRoomView(RoomView.SEA);
        room.setPeople(2);
        room.setPrice(220.0);
        room.setCount(2);

        room.setPrice(expectedUpdatePrice);

        assertEquals(expectedUpdatePrice, room.getPrice());
    }

    @Test
    public void verifyDeleteById () {
        Long id = 5L;
        roomRepository.deleteById(5L);
        verify(roomRepository,times(1)).deleteById(id);

    }
}
