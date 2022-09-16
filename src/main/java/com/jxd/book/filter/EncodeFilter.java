package com.jxd.book.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class EncodeFilter implements Filter {
    private FilterConfig filterConfig = null;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String encode = filterConfig.getInitParameter("encode");

        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
        //获取当前请求路径
        String path = request.getServletPath();
        //取出最后四个字符
        String str = path.substring(path.length() - 4);

        if (!".jsp".equals(str)) {
//            request.setCharacterEncoding(encode);
//            response.setContentType("");
            req.setCharacterEncoding(encode);
            resp.setContentType("text/html;charset=" + encode);

        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }

}
