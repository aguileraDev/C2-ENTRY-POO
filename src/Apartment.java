/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Apartment extends Lodging {
    public Apartment(String name, String city, Float rating, Double pricePerNight) {
        super(name, city, rating, pricePerNight);
    }

    @Override
    public void getDetails() {
        System.out.printf("Apartamento: %s%nCiudad: %s%nCalificacion: %.1f%nPrecio por noche: %.2f%n", getName(), getCity(), getRating(), getPricePerNight());
    }
}
