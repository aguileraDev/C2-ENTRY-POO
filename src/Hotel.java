
/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Hotel extends Lodging  {

    public Hotel(String name, String city, Float rating, Double pricePerNight) {
        super(name, city, rating, pricePerNight);
    }

    @Override
    public void getDetails() {
        System.out.printf("Hotel: %s\nCiudad: %s\nCalificacion: %.2f\nPrecio por noche: $ %.2f\n", getName(), getCity(), getRating(), getPricePerNight());
    }


}
