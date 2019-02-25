package org.wlgzs.agro_achievement.filter;

import org.slf4j.LoggerFactory;
import org.wlgzs.agro_achievement.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:胡亚星
 * @createTime 2019-02-25 9:09
 * @description:
 **/
public class AdminFilter implements Filter {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("后台过滤器启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        logger.info("后台过滤");
        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        System.out.println(url);
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(1);
        }
        System.out.println(url);
        HttpSession session = httpRequest.getSession();
        User adminUser = (User) session.getAttribute("adminUser");
        if (adminUser != null) {
            System.out.println("后台通过");
            // session存在
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        } else {
            System.out.println("后台未通过");
            // session不存在 准备跳转失败
            httpResponse.sendRedirect("../LogUser/toLogin");
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
