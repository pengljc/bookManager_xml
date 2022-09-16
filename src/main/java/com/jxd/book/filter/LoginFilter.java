package com.jxd.book.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        ServletContext context = request.getServletContext();
        String path = context.getInitParameter("unCheckUrl");

        //获取白名单路径
        String[] paths = path.split(",");
        //获取当前路径
        String currPath = request.getServletPath();

        //判断当前路径是否在白名单中
        for (String s : paths) {
            if (currPath.equals(s)) {
                chain.doFilter(req,resp);
                return;
            }
        }

        //不在白名单，验证是否登录，看看session中是否有name属性
        String name = (String)request.getSession().getAttribute("name");

        //如果为空，转发到登录页面
        if (name == null) {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("login.jsp");
            return;
        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
