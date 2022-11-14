package bo.edu.ucb.sis213.uberk.api;

import bo.edu.ucb.sis213.uberk.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthApi {

    @GetMapping("/{userId}")
    public UserDto test(@PathVariable(name = "userId") Integer userId){
        return new UserDto(1, "admin");
    }
}