package com.example.demo_auth.repository;

import com.example.demo_auth.models.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Mapper
@Repository
public interface RoleMapper {

    @Select("select * from role where id = #{id}")
    Role getById(@Param("id") long id);

    @Select("select * from role where code = #{code}")
    Role getByCode(@Param("code") String  code);

    @Select("select\n" +
            "r.id,\n" +
            "r.code,\n" +
            "r.label\n" +
            "from role r\n" +
            "inner join account_role axr ON (r.id = axr.role_id)\n" +
            "where axr.account_id = #{userId}")
    Set<Role> getByUserId(@Param("userId") Long  userId);
}
