import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class User {
    private String name;
    private String lastName;
    private String email;
    private String nationality;
    private String phoneNumber;
    private LocalDate birthDate;


    public User(String name, String lastName, String email, String nationality, String phoneNumber, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Persona: " + name + " " + lastName + "\nCorreo electronico: " + email + "\nNacionalidad: " + nationality + "\nTelefono: " + phoneNumber + "\nFecha de nacimiento: " + birthDate;
    }
}
