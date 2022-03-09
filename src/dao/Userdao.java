package dao;

import entity.User;

import java.sql.SQLException;

public interface Userdao {
//查找用户-账号密码
public  User findUserByUserNameAndPassword(String username, String password) throws SQLException;
//更新用户信息
public int UpdateUser(User user) throws SQLException;
//添加用户
public int AddUser(User user) throws SQLException;
//用户名是否存在
public boolean isExist(String username) throws SQLException;
//查找用户所有信息
public User findUserAllMsg(String username)throws SQLException;
}
