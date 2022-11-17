package bo.edu.ucb.sis213.uberk.bl;

import bo.edu.ucb.sis213.uberk.dao.RoleDao;
import bo.edu.ucb.sis213.uberk.dao.UserDao;
import bo.edu.ucb.sis213.uberk.dto.AuthReqDto;
import bo.edu.ucb.sis213.uberk.dto.AuthResDto;
import bo.edu.ucb.sis213.uberk.dto.UserDto;
import bo.edu.ucb.sis213.uberk.entity.UkUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;
import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.Date;


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


        //currentPasswordInBCrypt.equals(credentials.password())

        if (currentPasswordInBCrypt != null){
            System.out.println("Se procede a comparar contrasenas");
            BCrypt.Result bcryptresult = BCrypt.verifyer().verify(credentials.password().toCharArray(),currentPasswordInBCrypt);
            //consulto si los passwords coenciden
            if (bcryptresult.verified){
                //proceso a generar el token
                System.out.println("Las contrasenas generan token");
                //result.setToken("TEST TOKEN");
                //result.setRefresh("TEST REFRESH TOKEN");
                result = generateTokenJet(credentials.username(), 300, new String[]{"admin","user"});
            }else{
                System.out.println("Las contrasenas no coenciden");
                throw new RuntimeException("Forbiden the password");
            }
        }else {
            System.out.println("El usuario no existe");
            throw new RuntimeException("Forbiden the password");
        }
        return  result;
    }
    /**Este metodo genera tokens JWT*/
    private AuthResDto generateTokenJet(String subject, int expirationTimeInSeconds, String[] roles){
        AuthResDto result = new AuthResDto();
        //generamos el token principal
        try{
            Algorithm algorithm = Algorithm.HMAC256("Neko");
            String token = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withArrayClaim("roles",roles)
                    .withClaim("refresh", false)
                    .withExpiresAt(new Date(System.currentTimeMillis()+(expirationTimeInSeconds *  1000)))
                    .sign(algorithm);
            result.setToken(token);
            String refreshToken = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withClaim("refresh", true)
                    .withExpiresAt(new Date(System.currentTimeMillis()+(expirationTimeInSeconds *  1000 * 2)))
                    .sign(algorithm);
            result.setToken(token);
            result.setRefresh(refreshToken);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error al generar token",exception);
        }
        return result;
    }

}
