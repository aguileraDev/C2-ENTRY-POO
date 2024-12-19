package org.example;

import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Booking implements IBooking {
    private User user;
    private Lodging lodging;
    private Room room;
    private String estimatedArrivalTime;
    private Integer numberOfRooms;


    public Booking(){}

    public Booking(User user, Lodging lodging, Room room, String estimatedArrivalTime, Integer numberOfRooms) {
        this.user = user;
        this.lodging = lodging;
        this.room = room;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String updateBooking(String email, LocalDate birthDate) {

        return "Reserva modificada";

    }

    @Override
    public Boolean reduceRoomAvailability(Integer id, Integer numberOfRoomsToReduce) {

        Boolean bookingSuccessful = false;

        Room room = lodging.getRooms().stream()
                .filter(rooms -> rooms.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (room == null) {
            System.out.printf("Error: No se encontró la habitación con el nombre '%s'.%n", room.getName());
            bookingSuccessful = false;
        }

        Integer currentAvailability = room.getAvaibility();

        if (numberOfRoomsToReduce > currentAvailability) {
            System.out.printf("Error: No se pueden reservar %d habitaciones. Solo hay %d disponibles.%n",
                    numberOfRoomsToReduce, currentAvailability);
            bookingSuccessful = false;
        }

        room.setAvaibility(currentAvailability - numberOfRoomsToReduce);
        bookingSuccessful = true;

        return bookingSuccessful;
    }

    @Override
    public String toString() {
        return "\nReserva" +
                "\n" + user+
                "\nAlojamiento:" + lodging.getName() +
                "\nHora de llegada:'" + estimatedArrivalTime + '\'' +
                "\n" + room +
                "\nCantidad de habitaciones:" + numberOfRooms;
    }
}
