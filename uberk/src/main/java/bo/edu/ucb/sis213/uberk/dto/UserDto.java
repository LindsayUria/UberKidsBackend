package bo.edu.ucb.sis213.uberk.dto;

public class UserDto {
    private Integer userId;
    private String username;

    public UserDto(){

    }

    public UserDto(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser_name() {
        return username;
    }

    public void setUser_name(String user_name) {
        this.username = username;
    }


}
