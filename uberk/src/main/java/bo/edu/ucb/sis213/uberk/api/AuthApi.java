package bo.edu.ucb.sis213.uberk.api;

import bo.edu.ucb.sis213.uberk.bl.SecurityBl;
import bo.edu.ucb.sis213.uberk.dto.AuthReqDto;
import bo.edu.ucb.sis213.uberk.dto.AuthResDto;
import bo.edu.ucb.sis213.uberk.dto.ResponseDto;
import bo.edu.ucb.sis213.uberk.dto.UserDto;
import bo.edu.ucb.sis213.uberk.util.UberKException;
import org.springframework.web.bind.annotation.*;

//Creando Apis

@RestController
@RequestMapping("/api/v1/auth")
public class AuthApi {

    private SecurityBl securityBl;

    public AuthApi (SecurityBl securityBl){
        this.securityBl=securityBl;
    }

    @GetMapping("/{userId}")
    public UserDto test(@PathVariable(name = "userId") Integer userId){

        return this.securityBl.getUserByPk(userId);
    }

    @PostMapping()
    public AuthResDto authentication(@RequestBody AuthReqDto authReqDto) {
        return securityBl.authenticate(authReqDto);
    }
}
