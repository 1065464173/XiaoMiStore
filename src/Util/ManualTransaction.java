package Util;

import java.sql.Connection;
import java.sql.SQLException;

public class ManualTransaction {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    //获取tl连接
    public static Connection getConnection() throws SQLException {
        //获取threadlocal中的变量，如果不够自动创建副本
        Connection connection = threadLocal.get();
        if (connection == null) {
            //判断是不是第一次连接
            connection = ConnectionPool.getDataSourceByC3P0ByXML().getConnection();
            //是的话再把连接放入本地线程--set（connection）
            threadLocal.set(connection);
        }
        return connection;
    }

    //开启事务
    public static void begintTransaction() throws SQLException {
        //连接
        Connection connection = getConnection();
        //开启手动提交
        connection.setAutoCommit(false);
    }

    //正常，事务提交
    public static void commitTransaction() throws SQLException {
        //连接
        Connection connection = getConnection();
        connection.commit();

    }

    //失败，回滚事务
    public static void rollbackTransaction() throws SQLException {
        //连接
        Connection connection = getConnection();
        connection.rollback();
    }

    //关闭close
    public static void close() throws SQLException {
        //连接
        Connection connection = getConnection();
        if (connection != null) {
            connection.close();
            threadLocal.remove();
            connection = null;
        }
    }
}
