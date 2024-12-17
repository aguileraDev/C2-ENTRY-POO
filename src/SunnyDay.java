/**
 * @author Manuel Aguilera / @aguileradev
 */
public class SunnyDay extends Lodging {
    public SunnyDay(String name, String city, Float rating, Double pricePerNight) {
        super(name, city, rating, pricePerNight);
    }

    @Override
    public void getDetails() {
        System.out.printf("\nDia de sol: %s\nCiudad: %s\nCalificacion: %s\nPrecio por noche: %s\n", getName(), getCity(), getRating(), getPricePerNight());
    }
}
