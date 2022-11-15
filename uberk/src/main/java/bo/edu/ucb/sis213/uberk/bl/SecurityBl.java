package bo.edu.ucb.sis213.uberk.bl;

import bo.edu.ucb.sis213.uberk.dao.RoleDao;
import bo.edu.ucb.sis213.uberk.dao.UserDao;
import bo.edu.ucb.sis213.uberk.dto.AuthReqDto;
import bo.edu.ucb.sis213.uberk.dto.AuthResDto;
import bo.edu.ucb.sis213.uberk.dto.UserDto;
import bo.edu.ucb.sis213.uberk.entity.UkRole;
import bo.edu.ucb.sis213.uberk.entity.UkUser;
import bo.edu.ucb.sis213.uberk.util.UberKException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;
import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


@Service
public class SecurityBl {

    public final static String JWT_SECRET = "Luquityxever";
    private UserDao userDao;
    private RoleDao roleDao;

    public SecurityBl(UserDao userDao, RoleDao roleDao){
        this.userDao = userDao;
    }

    public UserDto getUserByPk(Integer userId){
        UkUser ukUser = userDao.findByPrimaryKey(userId);
        // Transformamos la entidad de Base de Datos
        // a un DTO para retornar via API  (Data Transfer Object)
        UserDto userDto = new UserDto(ukUser.getUserId(), ukUser.getUser_name());
        return userDto;
    }

    public AuthResDto authenticate(AuthReqDto credentials) {
        AuthResDto result = new AuthResDto();
        System.out.println("Comenzando proceso de autenticación con: " + credentials);
        String currentPasswordInBCrypt = userDao.findSecretByUsername(credentials.username());
        System.out.println("Se obtuvo la siguiente contraseña de bbdd: " + currentPasswordInBCrypt);
        // Consulto si los passwords coinciden
        if (currentPasswordInBCrypt != null ) {
            System.out.println("Se procede a verificar si las contraseñas coinciden");
            BCrypt.Result bcryptResult = BCrypt.verifyer().verify(credentials.password().toCharArray(), currentPasswordInBCrypt);
            if (bcryptResult.verified) { // Ha sido verificado
                // Procedo a generar el token
                System.out.println("Las constraseñas coinciden se genera el token");
                // Consultamos los roles que tiene el usuario
                List<UkRole> roles = roleDao.findRolesByUsername(credentials.username());
                List<String> rolesAsString = new ArrayList<>();
                for ( UkRole role : roles) {
                    rolesAsString.add(role.getName());
                }
                // Con esto no será necesario refrescar token.
                // FIXME: Error de seguridad, los tokens deberían ser de corta duración.
                result = generateTokenJwt(credentials.username(), 30000, rolesAsString);

            } else {
                System.out.println("Las constraseñas no coinciden");
                throw new UberKException("Forbiden the secret and password are wrong.");
            }
        } else {
            System.out.println("Usuario no existente");
            throw new UberKException("El usuario y contraseña son incorrectos.");
        }
        return result;
    }

    /** Este metodo valida un token JWT y retorna un MrUser
     * @param token
     * @return
     */
    public UkUser validateJwtToken(String jwt) {
        System.out.printf("VAlidando token: " + jwt);
        UkUser result = null;
        try {
            String username = JWT.require(Algorithm.HMAC256(JWT_SECRET))
                    .build()
                    .verify(jwt)
                    .getSubject();
            result = userDao.findByUsername(username);
        } catch (Exception exception){
            throw new UberKException("El usuario y cotraseña son incorrectos.", exception);
        }
        return result;
    }


    /** Este metodo generea tokens JWT */
    private AuthResDto generateTokenJwt(String subject, int expirationTimeInSeconds, List<String> roles) {
        AuthResDto result = new AuthResDto();
        // Generar el token princpial
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            String token = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                    .withClaim("refresh", false)
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 1000)))
                    .sign(algorithm);
            result.setToken(token);
            String refreshToken = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withClaim("refresh", true)
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 1000 * 2)))
                    .sign(algorithm);
            result.setRefresh(refreshToken);
        } catch (JWTCreationException exception){
            throw new UberKException("Error al generar el token", exception);
        }
        return result;
    }

}
