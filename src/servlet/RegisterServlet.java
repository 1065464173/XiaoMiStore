package servlet;

import Util.RegexUtil;
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

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取参数
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String comfirmpass = request.getParameter("comfirmpass").trim();
        String phone = request.getParameter("phone").trim();
        String sessionCode = (String) request.getSession().getAttribute("session_vcode");
        String paramCode = request.getParameter("verifyCode").trim();
        //创建实例
        UserdaoImpl userimpl = new UserdaoImpl();
        User user=new User();
        Map<String,Object> map = new HashMap<>();
        PrintWriter out = response.getWriter();
        RegexUtil regex = new RegexUtil();
        //判断
        map.put("state","null");
        if(regex.isChinese(username)){
            map.put("state","errors");
            map.put("msg","用户名不能为汉字");
            out.print(map);
            return;
        }
        if(!password.equals(comfirmpass)){
            map.put("state","errors");
            map.put("msg","两次密码不一致");
            out.print(map);
            return;
        }
        if(!regex.isPhoneNumber(phone)){
            map.put("state","errors");
            map.put("msg","请输入正确的手机号");
            out.print(map);
            return;
        }
        if(!paramCode.equalsIgnoreCase(sessionCode)){
            map.put("state","erorrs");
            map.put("msg","验证码错误");
            out.print(map);
            return;
        }
        //如果前端信息没有错误则进行注册操作
         user.setUsername(username);
         user.setPassword(password);
         user.setPhone(phone);
         int i = 0;
         try {
             i = userimpl.AddUser(user);
         } catch (SQLException e) {
             map.put("state","errors");
             map.put("msg","注册失败");
                e.printStackTrace();
         }
         if(i<1){
             map.put("state","errors");
             map.put("msg","注册失败");
         }else{
             map.put("state","success");
             map.put("msg","注册成功");
         }
        System.out.println(map);
        JSONObject jsonObject = JSONObject.fromObject(map);
        out.print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
