package servlet;

import dao.Impl.PageDaoImpl;
import dao.Impl.ProductDaoImpl;
import entity.Page;
import entity.Product;
import service.impl.PageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductPageServlet", urlPatterns = "/ProductPageServlet")
public class ProductPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //创建实例
        Page page = new Page();
        ProductDaoImpl productdaoimpl = new ProductDaoImpl();
        PageServiceImpl pageService = new PageServiceImpl();
        //获取总数量
        int totalData = 0;
        try {
            totalData= productdaoimpl.getCount();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //设置参数
        page.setTotalData(totalData);
        page.setTotalPage(page.getTotalPage());
        //查看当前页数
        int currentPage = 1;
        if (request.getParameter("currentPage")== null) {//当前页数如果为空就为首页
            currentPage = 1;
        }  if (request.getParameter("currentPage") != null) {//当前页数如果不为空则获取当前页数
            currentPage = (Integer.parseInt(request.getParameter("currentPage")));
        }
        if(currentPage<1) {//为首页时，点击上一页也是首页
            currentPage = 1;
        }
        if(currentPage>page.getTotalPage()) {//为尾页时，点击下一页也是尾页（当前页数等于总页数）
            currentPage=page.getTotalPage();
        }
        page.setCurrentPage(currentPage);


        //分页查询并重置页数
        List<Object[]> products = pageService.dopage(page,"product");
        System.out.println("（currentPage）当前页数为："+page.getCurrentPage());


        request.setAttribute("products",products);
        request.setAttribute("page",page);
        request.getRequestDispatcher("liebiao.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
