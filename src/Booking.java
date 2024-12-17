import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Booking implements IBooking {

    private String firstName;
    private String lastName;
    private String email;
    private String nationality;
    private String phoneNumber;
    private LocalDate birthDate;
    private String estimatedArrivalTime;
    private Lodging lodging;
    private Integer numberOfRooms;



    public Booking(){}

    public Booking(String firstName, String lastName, String email, String nationality, String phoneNumber, String birthDate, String estimatedArrivalTime, Lodging lodging, Integer numberOfRooms) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.birthDate = LocalDate.parse(birthDate);
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.lodging = lodging;
        this.numberOfRooms = numberOfRooms;
    }

    @Override
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
    }

    @Override
    public void reduceRoomAvailability(String roomName, Integer numberOfRoomsToReduce) {
        Room room = lodging.getRooms().stream().filter(rooms -> rooms.getName().equalsIgnoreCase(roomName))
                .findFirst()
                .orElse(null);

        if (room == null) {
            System.out.printf("Error: No se encontró la habitación con el nombre '%s'.%n", roomName);
            return;
        }

        int currentAvailability = room.getAvaibility();

        if (numberOfRoomsToReduce > currentAvailability) {
            System.out.printf("Error: No se pueden reservar %d habitaciones. Solo hay %d disponibles.%n",
                    numberOfRoomsToReduce, currentAvailability);
            return;
        }

        room.setAvaibility(currentAvailability - numberOfRoomsToReduce);

        System.out.printf("Se redujo la disponibilidad de la habitación '%s'. Disponibilidad actual: %d%n",
                room.getName(), room.getAvaibility());
    }
}
