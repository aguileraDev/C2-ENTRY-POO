package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public abstract class Lodging {

    private String name;
    private String category;
    private String city;
    private Float rating;
    private LocalDate startDateAvailable;
    private LocalDate endDateAvailable;
    private List<Room> rooms;
    private List<Booking> bookings;

    private final Double DISCOUNT_LOW_SEASON = 0.92;
    private final Double SURCHARGE_HIGH_SEASON = 1.10;
    private final Double SURCHARGE_LOW_SEASON = 1.15;

    public Lodging() {
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public Lodging(String name, String category, String city, Float rating, LocalDate startDateAvailable, LocalDate endDateAvailable) {
        this.name = name;
        this.category = category;
        this.city = city;
        this.rating = rating;
        this.startDateAvailable = startDateAvailable;
        this.endDateAvailable = endDateAvailable;
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
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

/*    public Double calculateStayCost(LocalDate startDate, LocalDate endDate) {

        final Long numberOfDays = ChronoUnit.DAYS.between(startDate, endDate);

        if (numberOfDays <= 0) {
            throw new IllegalArgumentException("La fecha de salida debe ser posterior a la fecha de inicio.");
        }

        Double totalCost = numberOfDays;

        if(startDate.getDayOfMonth() > 24 && endDate.getDayOfMonth()< 31){
            totalCost *= SURCHARGE_HIGH_SEASON;
        }else if(startDate.getDayOfMonth() >=10 && startDate.getDayOfMonth() <= 15) {
            totalCost *= SURCHARGE_LOW_SEASON;
        }else if(startDate.getDayOfMonth() >= 5 && endDate.getDayOfMonth() <=10) {
            totalCost *= DISCOUNT_LOW_SEASON;
        }

        return totalCost;
    }*/


    public LocalDate getStartDateAvailable() {
        return startDateAvailable;
    }

    public void setStartDateAvailable(LocalDate startDateAvailable) {
        this.startDateAvailable = startDateAvailable;
    }

    public LocalDate getEndDateAvailable() {
        return endDateAvailable;
    }

    public void setEndDateAvailable(LocalDate endDateAvailable) {
        this.endDateAvailable = endDateAvailable;
    }

    public List<Booking> getBookings() {
        return bookings;
    }


    public void addBooking(Booking booking) {
        this.bookings.add(booking);
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

    public List<Room> getRooms() {
        return rooms;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    @Override
    public String toString() {
        return "Nombre: " + name + "\n" +
                "Ciudad: " + city + "\n" +
                "Calificación: " + rating + "\n";
    }

}
