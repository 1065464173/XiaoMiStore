package dao.Impl;

import Util.ConnectionPool;
import Util.MD5;
import dao.Userdao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserdaoImpl implements Userdao {

    int num = 0;
    @Override
    public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql="select * from users where username=? and password=?";
        Object[] objs={username,MD5.md5(password)};
        return  runner.query(sql, new BeanHandler<User>(User.class), objs);
    }

    @Override
    public int UpdateUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "update users set password = ? , nickname = ? , phone = ?" +
                " , hobby = ? , address = ? , signature = ? where username = ?";
        //取值
        String password = user.getPassword();
        String nickname = user.getNickname();
        String phone = user.getPhone();
        String hobby = user.getHobby();
        String Address = user.getAddress();
        String signature = user.getSignature();
        String username = user.getUsername();
        //使用username 查找过去信息
        User olduser = runner.query("select * from users where username=?", new BeanHandler<User>(User.class), username);
        //查看要更新的元素是否为空，为空的话则为旧元素，不为空则替换成新元素
        if(password.equals("")||password==null){
            password=olduser.getPassword();
        }if(nickname.equals("")||nickname==null){
            nickname=olduser.getNickname();
        }if(phone.equals("")||phone==null){
            phone=olduser.getPhone();
        }if(hobby.equals("")||hobby==null){
            hobby=olduser.getHobby();
        }if(Address.equals("")||Address==null){
            Address=olduser.getAddress();
        }if(signature.equals("")||signature==null){
            signature=olduser.getSignature();
        }
        Object[] objs = {password,nickname,phone,hobby,Address,signature,username};
        num = runner.update(sql,objs);
        return num;
    }

    @Override
    public int AddUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "insert into users(username,password,phone,updatetime) value (?,?,?,now())";
        Object[] objs = {user.getUsername(),MD5.md5(user.getPassword()),user.getPhone()};
        num = runner.update(sql,objs);
        return num;
    }

    @Override
    public boolean isExist(String username) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "select * from users where username = ?";
        int i = runner.update(sql, username);
        return i>0?true:false;
    }

    @Override
    public User findUserAllMsg(String username) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "select * from users where username = ?";
        return runner.query(sql, new BeanHandler<User>(User.class), username);
    }
}
