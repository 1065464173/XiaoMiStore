package dao;

import entity.Page;

import java.sql.SQLException;
import java.util.List;

public interface PageDao {
    public List<Object[]> doPage(Page page, String mysql_table) throws SQLException;
}
