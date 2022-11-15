package bo.edu.ucb.sis213.uberk.dto;

public class CreateUserDto {
   // private Integer user_id;
    private String username;
    //private String name;
    //private String last_name;
    private String password;
    //private String email;
   // private String phone;

    public CreateUserDto() {
    }

    public CreateUserDto(String username, String password) {
        this.username = username;
        this.password = password;
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
