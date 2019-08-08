package servlet;

import Util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "VerifyCodeServlet", urlPatterns = "/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 校验验证码
         * 1. 从session中获取正确的验证码
         * 2. 从表单中获取用户填写的验证码
         * 3. 进行比较！
         * 4. 如果相同，向下运行，否则保存错误信息到request域，转发到login.jsp
         */
        String sessionCode = (String) request.getSession().getAttribute("session_vcode");
        String paramCode = request.getParameter("verifyCode");

        if(!paramCode.equalsIgnoreCase(sessionCode)) {
            request.setAttribute("msg", "验证码错误！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            /*
             * 1. 生成图片
             * 2. 保存图片上的文本到session域中
             * 3. 把图片响应给客户端
             */
            VerifyCode vc = new VerifyCode();
            BufferedImage image = vc.getImage();
            request.getSession().setAttribute("session_vcode", vc.getText());//保存图片上的文本到session域

            VerifyCode.output(image, response.getOutputStream());
        }
}

