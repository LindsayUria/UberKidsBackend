package bo.edu.ucb.sis213.uberk.dto;

public class CreateUserDto {
    private String username;
    private String secret;

    public CreateUserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
