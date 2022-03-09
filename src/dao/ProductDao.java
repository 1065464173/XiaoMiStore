package dao;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    //增加商品
    public int addProduct(Product product)throws SQLException;
    //查找所有信息
    public List<Product> findAll() throws SQLException;
    //用ID查找
    public Product findById(int id) throws SQLException;
    //用类别查询
    public List<Product> findByCategory(String category) throws SQLException;
    //更新商品信息
    public int updateProduct(Product product) throws SQLException;
    //查询所有商品的数量
    public int getCount()throws SQLException;
    //查询同一类型手机的所有版本
    public List<Object[]> getVersion(String category)throws SQLException;
    //查询同一类型手机的所有颜色
    public List<Object[]> getColor(String category)throws SQLException;

}
