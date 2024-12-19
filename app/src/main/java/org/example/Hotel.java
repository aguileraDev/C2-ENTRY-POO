package org.example;
import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Hotel extends Lodging  {

    public Hotel(String name, String category, String city, Float rating,LocalDate entryDate, LocalDate endDate) {
        super(name, category, city, rating, entryDate, endDate);
    }

    @Override
    public void getDetails() {
        System.out.printf("Hotel: %s\nCiudad: %s\nCalificacion: %.2f\n", getName(), getCity(), getRating());
    }


}
