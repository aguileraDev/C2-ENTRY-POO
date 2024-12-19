package org.example;

import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Farm extends Lodging{

    Boolean haveCrops;

    public Farm(String name, String category, String city, Float rating, LocalDate startDateAvailable, LocalDate endDateAvailable) {
        super(name, category, city, rating, startDateAvailable, endDateAvailable);
    }

    @Override
    public void getDetails() {
        System.out.printf("Finca: %s %nCalificacion: %.1f%n", getName(), getRating());
    }

    public Boolean getHaveCrops() {
        return haveCrops;
    }

    public void setHaveCrops(Boolean haveCrops) {
        this.haveCrops = haveCrops;
    }
}
