package bo.edu.ucb.sis213.uberk.entity;

public class UserPerson {
    private String name;
    private String lastName;
    private String username;

    public UserPerson() {
    }

    public UserPerson(String name, String lastName, String username) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserPerson{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }


}
