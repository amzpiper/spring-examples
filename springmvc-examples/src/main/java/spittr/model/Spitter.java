package spittr.model;
import javax.validation.constraints.*;

public class Spitter {

    private Long id;

    public Spitter() {
    }

    public Spitter(Long id, @NotNull @Size(min = 2, max = 30, message = "{firstName.size}") String firstName, @NotNull @Size(min = 2, max = 30, message = "{lastName.size}") String lastName, @NotNull @Size(min = 5, max = 16, message = "{username.size}") String username, @NotNull @Size(min = 5, max = 25, message = "{password.size}") String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    @NotNull
    @Size(min = 2,max = 30,message = "{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min = 2,max = 30,message = "{lastName.size}")
    private String lastName;

    @NotNull
    @Size(min = 5,max = 16,message = "{username.size}")
    private String username;

    @NotNull
    @Size(min = 5,max = 25,message = "{password.size}")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
