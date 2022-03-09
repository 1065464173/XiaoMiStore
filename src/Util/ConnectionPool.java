package Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    public static DataSource getDataSourceByC3P0ByXML() throws SQLException {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("xiaomistore");
        Connection connection = DriverManager.getConnection("");
        return c3p0;
    }
}
