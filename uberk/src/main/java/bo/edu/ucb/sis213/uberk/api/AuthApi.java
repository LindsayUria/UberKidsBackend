package bo.edu.ucb.sis213.uberk.api;

import bo.edu.ucb.sis213.uberk.bl.SecurityBl;
import bo.edu.ucb.sis213.uberk.dto.AuthReqDto;
import bo.edu.ucb.sis213.uberk.dto.AuthResDto;
import bo.edu.ucb.sis213.uberk.dto.ResponseDto;
import bo.edu.ucb.sis213.uberk.dto.UserDto;
import bo.edu.ucb.sis213.uberk.util.UberKException;
import org.springframework.web.bind.annotation.*;

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
    public ResponseDto<AuthResDto> authentication(@RequestBody  AuthReqDto authReqDto) {
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            // Do nothing
        }
        if (authReqDto != null && authReqDto.username() != null && authReqDto.password() != null) {
            // Retorna los tokens, null (porque no hay error), true porque fue exitoso
            try {
                return new ResponseDto<>(securityBl.authenticate(authReqDto), null, true);
            } catch (UberKException ex) {
                return new ResponseDto<>(null, ex.getMessage(), false);
            }
        } else {
            return new ResponseDto<>(null, "Credenciales incorrectas", false);
        }
    }
}
