package bo.edu.ucb.sis213.uberk.unit;

import bo.edu.ucb.sis213.uberk.bl.SecurityBl;
import bo.edu.ucb.sis213.uberk.dao.UserDao;
import bo.edu.ucb.sis213.uberk.dto.AuthReqDto;
import bo.edu.ucb.sis213.uberk.dto.AuthResDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SecurityBlTest {

    @Test
    void successfulAuthentication() {
//        // Implementación falsa
//          UserDao userDao = Mockito.mock(UserDao.class);

          //AuthResDto response = securityBl.authenticate(new AuthReqDto("admin","123456"));
//        // Nosotros sabemos que para esta prueba se necesita:
//        userDao.findByUsernameAndPassword(credentials.username());
//        // Debido a que es prueba unitaria debemos crear el comportamiento de lo que va a hacer el mock
//        // Cuando se llame a findByUsernameAndPassword con el argumento "admin"
//          Mockito.when(userDao.findSecretByUsername("admin"))
//                  .thenReturn("$2a$12$pigNJzj3QRUXc6LiG7YF2Oi.oC3fEPFB4sOkSm1nAmp6UzWlbZhEm");
//          SecurityBl securityBl = new SecurityBl(userDao);
//          AuthResDto response = securityBl.authenticate(new AuthReqDto("admin", "123456"));
//          Assertions.assertNotNull(response); // Que la respuesta no sea nula
 //         Assertions.assertNotNull(response.getToken()); // Que el token no sea nulo
 //         Assertions.assertNotNull(response.getRefresh()); // Que el refresh token no sea nulo
    }
}

