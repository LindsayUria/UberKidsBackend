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

    @Select("""
            select password
            from 
                uk_user
            WHERE
                user_name= #{username}
                AND status = true
            """)
    String findByUsernameAndPassword(String username);

    @Select("""
            select user_id, user_name, name, last_name, password, email, phone,status, tx_date
               tx_username, tx_host
            from 
                uk_user
            WHERE
                user_name = #{username}
                AND status = true
            """)
    UkUser findByUsername(String username);

    @Select("""
            select password
            from 
                uk_user
            WHERE
                user_name = #{username} 
                AND status = true
            """)
    String findSecretByUsername(String username);

    @Insert("""
      INSERT INTO
       uk_user (user_name, name, last_name, password, email, phone, status, tx_host, tx_date, tx_username)
      VALUES (
      #{username},#{name},#{lastname},#{password},#{email},#{phone},true,'localhost',now(),'admin')  
            """)
    void createUser (UkUser ukUser);

}
