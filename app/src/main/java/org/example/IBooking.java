package org.example;

import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public interface IBooking {

    String updateBooking(String email, LocalDate birthDate);

    Boolean reduceRoomAvailability(Integer id, Integer numberOfRoomsToReduce);


}
