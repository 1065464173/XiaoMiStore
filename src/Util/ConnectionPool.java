package Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class ConnectionPool {
    public static DataSource getDataSourceByC3P0ByXML() {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("xiaomistore");

        return c3p0;
    }
}
