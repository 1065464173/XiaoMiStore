package service.impl;

import dao.Impl.PageDaoImpl;
import dao.Impl.ProductDaoImpl;
import entity.Page;
import service.PageService;

import java.sql.SQLException;
import java.util.List;

public class PageServiceImpl implements PageService {
    /**
     * 分页对象中必须包含该数据库的总数据量，当前页数
     * 这些信息必须在servlet中用set方法载入
     * @param page
     * @param mysql_table
     * @return
     */
    @Override
    public List<Object[]> dopage(Page page,String mysql_table) {
        //创建实例
        ProductDaoImpl productdaoimpl = new ProductDaoImpl();
        PageDaoImpl pagedaoimpl = new PageDaoImpl();
        List<Object[]> list = null;
        int dangqianyeshu = 1;
        //获取参数
        int totalData = page.getTotalData();//数据库总数据量
        int totalPage = page.getTotalPage();//总页数自动得出
        //开始分页数据查询
        try {
            list = pagedaoimpl.doPage(page,mysql_table);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
