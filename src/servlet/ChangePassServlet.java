package servlet;

import Util.MD5;
import dao.Impl.UserdaoImpl;
import entity.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ChangePassServlet", urlPatterns = "/ChangePassServlet")
public class ChangePassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //创建实例
        UserdaoImpl userimpl = new UserdaoImpl();
        User user = new User();
        Map<String,Object> map = new HashMap<>();
        PrintWriter out = response.getWriter();
        //获取参数
        String password = request.getParameter("password").trim();
        String newpassword = request.getParameter("newpassword").trim();
        String confirmpass = request.getParameter("comfirmpass").trim();
        user = (User) request.getSession().getAttribute("user");
        //判断旧密码是否正确
        if(user.getPassword().equals(MD5.md5(password))){
           if(newpassword.equals(confirmpass)){
               //执行修改操作
               try {
                   user.setPassword(newpassword);
                   userimpl.UpdateUser(user);
               } catch (SQLException e) {
                   map.put("state","errors");
                   map.put("msg","数据库操作失败");
                   e.printStackTrace();
               }
               map.put("state","success");
               map.put("msg","密码修改成功");
           }else{
               map.put("state","errors");
               map.put("msg","两次新密码不一致");
           }
        }else{
            map.put("state","errors");
            map.put("msg","旧密码错误");
        }
        System.out.println(map);
        JSONObject jsonObject = JSONObject.fromObject(map);
        out.print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
