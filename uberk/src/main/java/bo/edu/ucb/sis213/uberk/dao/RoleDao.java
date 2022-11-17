package bo.edu.ucb.sis213.uberk.dao;

import bo.edu.ucb.sis213.uberk.entity.UkRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleDao {
    @Select("""
            SELECT role.role_id, role.name, role.status, role.tx_date, role.tx_username, role.tx_host
            FROM uk_role role
                     JOIN uk_role_group role_group ON role_group.role_id = role.role_id
                     JOIN uk_group_user group_user ON group_user.group_id = role_group.group_id
                     JOIN uk_user usr ON usr.user_id = group_user.user_id
            WHERE usr.user_name = #{username}
              AND role.status = true
              AND role_group.status = true
              AND group_user.status = true
              AND usr.status = true
            """)
    public List<UkRole> findRolesByUsername(String username);
}
