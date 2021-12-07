package com.cdw.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author: cdw
 * @date: 2021/11/27 20:54
 * @description:
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * @param request
     * @param response
     * @param handler  被拦截的控制器对象
     * @return
     * @throws Exception 在控制器方法之前先执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("====preHandle11111============");
//        request.getRequestDispatcher("/tips.jsp").forward(request,response);
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute("username");
        String username = "";
        if (attribute != null) {
            username = (String) attribute;

        }
        if ("zhaosi".equalsIgnoreCase(username))
            return true;
        return false;
    }


    /**
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception 控制器方法之后执行，可以修改原来的执行结果，对请求进行二次处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========postHandle1111=============");
        if (modelAndView != null) {
            modelAndView.addObject("date", new Date());
            modelAndView.setViewName("other");
        }
    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception 最后执行的方法
     *                   执行条件：
     *                   preHandle必须执行
     *                   preHandle必须返回true
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("=======afterCompletion11111===============");
        Object attr = request.getSession().getAttribute("attr");
//        System.out.println(attr);
//        request.getSession().removeAttribute("attr");
//        System.out.println(request.getSession().getAttribute("attr"));
    }
}
