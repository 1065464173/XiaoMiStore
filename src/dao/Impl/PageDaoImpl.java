package dao.Impl;

import Util.ConnectionPool;
import dao.PageDao;
import entity.Page;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sound.midi.Soundbank;
import java.sql.SQLException;
import java.util.List;

public class PageDaoImpl implements PageDao {
    @Override
    public List<Object[]> doPage(Page page,String mysql_table) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        //得到page的开始数据和查询个数（若要得到正确的开始个数，需要前端传入当前页数）
        int totalPage = page.getTotalPage();
        int startData = page.getStartData();
        int singlePageData = page.getSinglePageData();
        System.out.println("分页开始数据："+startData+"分页查询个数："+singlePageData);
        String sql = "select * from " + mysql_table+
                     " limit ?,? ";
        Object[] objs = {startData,singlePageData};
        List<Object[]> list = runner.query(sql, new ArrayListHandler(), objs);
        return list;
    }
    public static void main(String[] args) throws SQLException {
        //test
        PageDaoImpl p = new PageDaoImpl();
        Page page = new Page();
        page.setCurrentPage(1);
        List<Object[]> list =  p.doPage(page,"product");
        for(Object[] objects:list){
            System.out.println(objects[0]+"name："+objects[1]);
        }
    }
}
