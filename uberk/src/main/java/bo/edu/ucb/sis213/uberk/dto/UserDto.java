package bo.edu.ucb.sis213.uberk.dto;

public class UserDto {
    private Integer userId;
    private String user_name;

    public UserDto(){

    }

    public UserDto(Integer userId, String user_name) {
        this.userId = userId;
        this.user_name = user_name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


}
