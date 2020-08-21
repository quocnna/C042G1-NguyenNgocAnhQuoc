package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;


//    CREATE database if not exists demo;
//    USE demo;
//
//    create table users (
//            id  int(3) NOT NULL AUTO_INCREMENT,
//    name varchar(120) NOT NULL,
//    email varchar(220) NOT NULL,
//    country varchar(120),
//    PRIMARY KEY (id));
}
