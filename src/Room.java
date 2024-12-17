/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Room {
    private String name;
    private String description;
    private Double pricePerNight;
    private Integer avaibility;

    public Room(String name, String description, Double pricePerNight, Integer avaibility) {
        this.name = name;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.avaibility = avaibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Integer getAvaibility() {
        return avaibility;
    }

    public void setAvaibility(Integer avaibility) {
        this.avaibility = avaibility;
    }

    @Override
    public String toString() {
        return "Habitacion: " + name + "\nDescripcion: " + description + "\nPrecio por noche: " + pricePerNight + "\nDisponibilidad: " + avaibility + "\n";
    }
}
