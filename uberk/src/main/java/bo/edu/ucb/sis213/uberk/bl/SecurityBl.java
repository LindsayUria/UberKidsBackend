package bo.edu.ucb.sis213.uberk.bl;

import bo.edu.ucb.sis213.uberk.dao.UserDao;
import bo.edu.ucb.sis213.uberk.dto.UserDto;
import bo.edu.ucb.sis213.uberk.entity.UkUser;
import org.springframework.stereotype.Service;

@Service
public class SecurityBl {
    private UserDao userDao;

    public SecurityBl(UserDao userDao){
        this.userDao = userDao;
    }

    public UserDto getUserByPk(Integer userId){
        UkUser ukUser = userDao.findByPrimaryKey(userId);
        // Transformamos la entidad de Base de Datos
        // a un DTO para retornar via API  (Data Transfer Object)
        UserDto userDto = new UserDto(ukUser.getUserId(), ukUser.getUser_name());
        return userDto;
    }

}
