package bo.edu.ucb.sis213.uberk.bl;

import bo.edu.ucb.sis213.uberk.dao.RoleDao;
import bo.edu.ucb.sis213.uberk.dao.UserDao;
import bo.edu.ucb.sis213.uberk.dto.AuthReqDto;
import bo.edu.ucb.sis213.uberk.dto.AuthResDto;
import bo.edu.ucb.sis213.uberk.dto.UserDto;
import bo.edu.ucb.sis213.uberk.entity.UkUser;
import org.springframework.stereotype.Service;
import at.favre.lib.crypto.bcrypt.BCrypt;


//Logica de negocio

@Service
public class SecurityBl {

    public final static String JWT_SECRET = "Luquityxever";
    private UserDao userDao;
    private RoleDao roleDao;

    public SecurityBl(UserDao userDao){
        this.roleDao = roleDao;
        this.userDao = userDao;
    }

    public UserDto getUserByPk(Integer userId){
        UkUser ukUser = userDao.findByPrimaryKey(userId);
        // Transformamos la entidad de Base de Datos
        // a un DTO para retornar via API  (Data Transfer Object)
        UserDto userDto = new UserDto(ukUser.getUserId(), ukUser.getUsername());
        return userDto;
    }

    /**
     * Este metodo realiza la autenticacion del sistema, va a buscar
     * el repositorio de BD la contrasena del usuario y la compara con su
     * equivalente en BRCYPT
     * @param credentials
     * @return
     * */

    public AuthResDto authenticate(AuthReqDto credentials) {
        AuthResDto result = new AuthResDto();
        System.out.println("Comenzando proceso de autenticacion con:"+credentials);
        String currentPasswordInBCrypt = userDao.findByUsernameAndPassword(credentials.username());
        System.out.println("Se obtuvo la siguiente contraseña de bbdd: " + currentPasswordInBCrypt);
        //consulto si los passwords coenciden
        System.out.println("Se procede a comparar contrasenas");
        BCrypt.Result bcryptresult = BCrypt.verifyer().verify(credentials.password().toCharArray(),currentPasswordInBCrypt);
        //currentPasswordInBCrypt.equals(credentials.password())
        if (currentPasswordInBCrypt != null){
            //proceso a generar el token
            System.out.println("Se genera el token");
            result.setToken("TEST TOKEN");
            result.setRefresh("TEST REFRESH TOKEN");
        }else {
            System.out.println("Las contrasenas no coenciden");
            throw new RuntimeException("Forbiden the password");
        }
        return  result;
    }

}
