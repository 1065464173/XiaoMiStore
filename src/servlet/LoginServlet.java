package servlet;

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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="LoginServlet", urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);

        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取参数
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String sessionCode = (String) request.getSession().getAttribute("session_vcode");
        String paramCode = request.getParameter("verifyCode").trim();
        //创建实例
        UserdaoImpl userimpl = new UserdaoImpl();
        User user;
        Map<String,Object> map = new HashMap<>();
        PrintWriter out = response.getWriter();
        //登录
        try {
            user = userimpl.findUserByUserNameAndPassword(username,password);
            if(user!=null){
                map.put("state","success");
                map.put("msg","登录成功");
//                ServletContext application=this.getServletContext();
//                application.setAttribute("user",user);
                request.getSession().setAttribute("user",user);
//                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            if(user==null){
                map.put("state","erorrs");
                map.put("msg","登录失败：账号密码错误");
            }
            if(!paramCode.equalsIgnoreCase(sessionCode)){
                map.put("state","erorrs");
                map.put("msg","验证码错误");
            }

        }catch (Exception e){
            map.put("state","erorrs");
            map.put("msg","系统错误");
            e.printStackTrace();
        }
        System.out.println(map);
        JSONObject jsonObject = JSONObject.fromObject(map);
        out.print(jsonObject);


//        request.getRequestDispatcher("login.jsp").forward(request,response);

    }
}
