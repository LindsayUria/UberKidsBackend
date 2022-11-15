package bo.edu.ucb.sis213.uberk.dao;

import bo.edu.ucb.sis213.uberk.entity.UserPerson;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserPersonDao {
    @Select("""
            SELECT 'Juan' as name, 'Balderson' as last_name, username
            from 
                uk_user
            WHERE
                user_name = #{username}
                AND status = true
            """)
    UserPerson findByUsername(String username);

}
