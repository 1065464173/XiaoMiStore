package servlet;

import dao.Impl.ProductDaoImpl;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DetailPageServlet", urlPatterns = "/DetailPageServlet")
public class DetailPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //创建实例
        ProductDaoImpl productimpl = new ProductDaoImpl();
        Product product = new Product();
        List<Product> products =null;
        String image = null;
        String category = null ;


        //获取参数
        int id = Integer.parseInt(request.getParameter("id").trim());

        //根据id查询商品
        try {
            product = productimpl.findById(id);
            image = product.getImgurl();
            category = product.getCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //根据分类查询该分类的所有版本和颜色
        List<Object[]> version = null;
        List<Object[]> color = null;
        try {
            version = productimpl.getVersion(category);
            color = productimpl.getColor(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //查询完毕传到详情页
        request.setAttribute("version",version);
        request.setAttribute("color",color);
        request.setAttribute("category",category);
        request.setAttribute("image", image);
        request.getRequestDispatcher("xiangqing.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
