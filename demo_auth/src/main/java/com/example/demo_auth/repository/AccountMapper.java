package com.example.demo_auth.repository;

import com.example.demo_auth.models.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface AccountMapper {

    @Insert("insert into account (name,login, email, password, creationDate, updateDate) " +
            "values(#{user.name},#{user.login},#{user.email},#{user.password},#{user.creationDate},#{user.updateDate})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    Account create(@Param("user") Account account);

    @Select("select * from account")
    Collection<Account> getAll();

    @Select("select * from account where username = #{username}")
    Account getByUsername(@Param("username") String username);

    @Select("select * from account where id = #{id}")
    Account getById(@Param("id") long id);

    @Update("update Account set name=#{name}, login=#{login}, email=#{email}, updateDate=#{updateDate}" +
            "  where id=#{id}")
    void update(Account account);

    @Delete("delete from account where id = #{id}")
    void delete(@Param("id") long id);
}
