/**
 * @author Manuel Aguilera / @aguileradev
 */
public abstract class Lodging {

    private String name;
    private String city;
    private Float rating;
    private Double pricePerNight;

    public Lodging(String name, String city, Float rating, Double pricePerNight) {
        this.name = name;
        this.city = city;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
    }

    public abstract void getDetails();

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
}
