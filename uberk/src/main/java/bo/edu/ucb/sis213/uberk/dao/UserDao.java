package bo.edu.ucb.sis213.uberk.dao;

import bo.edu.ucb.sis213.uberk.entity.UkUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    @Select("""
            select user_id, user_name, name, last_name, password, email, phone,status, tx_date
               tx_username, tx_host
            from 
                uk_user
            WHERE
                user_id = #{userId}
                AND status = true
            """)
    UkUser findByPrimaryKey(Integer userId);

}
