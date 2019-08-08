package servlet;

import dao.Impl.UserdaoImpl;
import entity.User;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;

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

@WebServlet(name = "EditUserServlet", urlPatterns = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {
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
        user = (User) request.getSession().getAttribute("user");
        String nickname = request.getParameter("nickname").trim();
        String signature = request.getParameter("signature").trim();
        String hobby = request.getParameter("hobby").trim();
        String phone = request.getParameter("phone").trim();
        String address = request.getParameter("address").trim();

        //添加参数
        user.setPhone(phone);
        user.setNickname(nickname);
        user.setHobby(hobby);
        user.setSignature(signature);
        user.setAddress(address);
        //进行修改操作
        try {
            userimpl.UpdateUser(user);
            map.put("state","success");
            map.put("msg","修改成功");
        } catch (SQLException e) {
            map.put("state","erorrs");
            map.put("msg","修改失败");
            e.printStackTrace();
        }
        System.out.println(map);
        JSONObject jsonObject = JSONObject.fromObject(map);
        out.print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
