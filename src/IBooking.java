/**
 * @author Manuel Aguilera / @aguileradev
 */
public interface IBooking {

  /*  String updateBooking(String email,
                         String birthDate,
                         Lodging newLodging,
                         Integer newNumberOfRooms,
                         String newEstimatedArrivalTime);*/

    Boolean reduceRoomAvailability(Integer id, Integer numberOfRoomsToReduce);


}
