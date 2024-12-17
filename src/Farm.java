/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Farm extends Lodging{
    public Farm(String name, String city, Float rating, Double pricePerNight) {
        super(name, city, rating, pricePerNight);
    }

    @Override
    public void getDetails() {
        System.out.printf("Finca: %s %nCalificacion: %.1f%nEstadia por dia: %.2f%n", getName(), getRating(), getPricePerNight());
    }
}
