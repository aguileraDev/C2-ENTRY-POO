import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public abstract class Lodging {

    private String name;
    private String city;
    private Float rating;
    private Double pricePerNight;
    private List<Room> rooms;

    public Lodging(String name, String city, Float rating, Double pricePerNight) {
        this.name = name;
        this.city = city;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
        this.rooms = new ArrayList<>();
    }

    public abstract void getDetails();

    public void showRooms() {
        System.out.println("Habitaciones en " + name + ":");
        for (Room item : rooms) {
            System.out.println(item);
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + "\n" +
                "Ciudad: " + city + "\n" +
                "Calificación: " + rating + "\n" +
                "Precio base por noche: $" + pricePerNight;
    }
}
