package org.example;
import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Apartment extends Lodging {
    private String floor;

    public Apartment(String name, String category, String city, Float rating, String floor, LocalDate startDateAvailable, LocalDate endDateAvailable) {
        super(name, category, city, rating, startDateAvailable, endDateAvailable);
        this.floor = floor;
    }

    @Override
    public void getDetails() {
        System.out.printf("Apartamento: %s%nCiudad: %s%nCalificacion: %.1f%n", getName(), getCity(), getRating());
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
