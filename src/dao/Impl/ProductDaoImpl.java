package dao.Impl;

import Util.ConnectionPool;
import dao.ProductDao;
import entity.Product;
import jdk.nashorn.internal.objects.ArrayBufferView;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import java.io.BufferedWriter;
import java.nio.Buffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
     int num = 0; // 1成功，0失败，默认失败
    /**
     *
     * @param product
     * @return num
     * @throws SQLException
     */
    @Override
    public int addProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "insert into product(name,price,num,imgurl,color,version,category) value (?,?,?,?,?,?,?)";
        Object[] objs = {
                product.getName(),
                product.getPrice(),
                product.getNum(),
                product.getImgurl(),
                product.getColor(),
                product.getVersion(),
                product.getCategory()
        };
        num = runner.update(sql,objs);
        return num;
}

    /**
     *
     * @return List<Product>
     * @throws SQLException
     */
    @Override
    public List<Product> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "select * from product";
        List<Product> products = runner.query(sql, new BeanListHandler<Product>(Product.class));
        return products;
    }

    /**
     *
     * @param id
     * @return products
     * @throws SQLException
     */
    @Override
    public Product findById(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "select * from product where id = ?";
        Product products = runner.query(sql, new BeanHandler<Product>(Product.class),id);
        return products;
    }

    /**
     *
     * @param category
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findByCategory(String category) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "select * from product where category = ? ";
        List<Product> products = runner.query(sql,new BeanListHandler<Product>(Product.class),category);
        return products;
    }

    /**
     *
     * @param product
     * @return num
     * @throws SQLException
     */
    @Override
    public int updateProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "update product set name = ? , price = ? , num = ?" +
                " , imgurl = ? ,version = ?, color = ? , description = ? , category = ? where id = ?";
        //取值
        String name = product.getName();
        double price = product.getPrice();
        int num = product.getNum();
        String imgurl = product.getImgurl();
        String color = product.getColor();
        String version = product.getVersion();
        String category = product.getCategory();
        String description = product.getDescription();
        int id = product.getId();
        //通过 id 查询旧商品信息
        Product oldproduct = runner.query("select * from product where id = ?",new BeanHandler<Product>(Product.class),id);
        //查看要更新的元素是否为空，为空的话则为旧元素，不为空则替换成新元素
        if(name.equals("")||name==null){
            name=oldproduct.getName();
        }if(price==0){
            price = product.getPrice();
        }if(num==0){
            num = product.getNum();
        }if(imgurl.equals("")||imgurl==null){
            imgurl = product.getImgurl();
        }if(color.equals("")||color==null){
            color = product.getColor();
        }if(version.equals("")||version==null){
            version = product.getVersion();
        }if(version.equals("")||version==null){
            version = product.getVersion();
        }
        Object[] objs = {name,price,num,imgurl,version,color,description,category};
        num = runner.update(sql,objs);
        return num;
    }

    @Override
    public int getCount() throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "select count(*) from product";
        Object obj = runner.query(sql, new ScalarHandler());
        num = Integer.parseInt(String.valueOf(obj));
        System.out.println(num);
        return num;
    }

    /**
     *
     * @param category
     * @return
     * @throws SQLException
     */
    @Override
    public List<Object[]> getVersion(String category) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "select p_version.* from product,p_version where category =?  and product.v_id=p_version.id GROUP BY p_version.id";
        List<Object[]> objects = runner.query(sql, new ArrayListHandler(), category);
        return objects;
    }

    /**
     *
     * @param category
     * @return
     * @throws SQLException
     */
    @Override
    public List<Object[]> getColor(String category) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "select p_color.* from product,p_color where category =?  and product.c_id=p_color.id GROUP BY p_color.id";
        List<Object[]> objects = runner.query(sql, new ArrayListHandler(), category);
        return objects;
    }
    public static void main(String[] args){
        ProductDaoImpl i = new ProductDaoImpl();
        try {
            List<Object[]> list =  i.getColor("小米5");
            for (Object[] objects: list){
                System.out.println(objects[1]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
