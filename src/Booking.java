import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Booking implements IBooking {

    private User user;
    private Lodging lodging;
    private String estimatedArrivalTime;
    private Integer numberOfRooms;


    public Booking(){}

    public Booking(User user, Lodging lodging, String estimatedArrivalTime, Integer numberOfRooms) {
        this.user = user;
        this.lodging = lodging;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.numberOfRooms = numberOfRooms;
    }

  /*   @Override
    public String updateBooking(String email, String birthDate, Lodging newLodging, Integer newNumberOfRooms,
                                String newEstimatedArrivalTime) {

        if (this.email.equals(email) && this.birthDate.equals(LocalDate.parse(birthDate))) {
            this.lodging = newLodging;
            this.numberOfRooms = newNumberOfRooms;
            this.estimatedArrivalTime = newEstimatedArrivalTime;

            return "Reserva actualizada con éxito";
        } else {
            return "Reserva no encontrada para este usuario";
        }
    }*/

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
}
