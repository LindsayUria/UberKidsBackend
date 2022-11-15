package bo.edu.ucb.sis213.uberk.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.uberk.dao.UserDao;
import bo.edu.ucb.sis213.uberk.dao.UserPersonDao;
import bo.edu.ucb.sis213.uberk.dto.CreateUserDto;
import bo.edu.ucb.sis213.uberk.entity.UkUser;
import bo.edu.ucb.sis213.uberk.entity.UserPerson;

public class UserBl {
    private UserDao userDao;
    private UserPersonDao userPersonDao;

    public UserBl(UserDao userDao, UserPersonDao userPersonDao) {
        this.userDao = userDao;
        this.userPersonDao = userPersonDao;
    }

    public void createUser(CreateUserDto createUserDto) {
        UkUser ukUser = new UkUser();
        ukUser.setUser_name(createUserDto.getUsername());
        // Encrypt secret with BCrypt
        String secret = BCrypt.withDefaults().hashToString(12,
                createUserDto.getSecret().toCharArray());
        ukUser.setPassword(secret);
        this.userDao.createUser(ukUser);
    }

    public UserPerson findByUsername(String username) {
        return userPersonDao.findByUsername(username);
    }

}
