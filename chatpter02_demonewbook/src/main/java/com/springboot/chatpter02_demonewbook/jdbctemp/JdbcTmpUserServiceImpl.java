package com.springboot.chatpter02_demonewbook.jdbctemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class JdbcTmpUserServiceImpl implements JdbcTmplUserService{

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    private RowMapper<User> getUserMapper(){
        RowMapper<User> userRowMapper = (ResultSet rs,int rownum)->{
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumByID(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;

    }




    @Override
    public User getUser(Long id) {
        String sql = "select id,username,sex,note from t_user2 where id = ?";
        Object[] params = new Object[]{id};
        System.out.println(sql);
        System.out.println(params[0]);
        System.out.println(getUserMapper());
        User user = jdbcTemplate.queryForObject(sql,params,getUserMapper());
        return user;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "select id,username,sex,note from t_user2"+"where user_name like concat('%',?,'%')"+"and note like concat('%',?,'%')";
        Object[] params = new Object[]{userName ,note};
        List<User> userList = jdbcTemplate.query(sql,params,getUserMapper());
        return userList;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user(username,sex,note) values(?,?,?)";
        return jdbcTemplate.update(sql,user.getUsername(),user.getSex().getId(),user.getNote());
    }

    @Override
    public int updateUser(User user) {
        String sql  = "update t_user2 set username= ?,sex=?,note =?"+"where id = ?";
        return jdbcTemplate.update(sql,user.getUsername(),user.getSex(),user.getNote(),user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from t_user2 where id = ?";
        return jdbcTemplate.update(sql,id);
    }
}
