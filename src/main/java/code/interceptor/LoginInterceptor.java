package code.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String account = (String)request.getSession().getAttribute("account");
        if (account == null || account.equals("")) {
            try {
                response.sendRedirect("/login");    //转到登录页面
            }catch (Exception error){
                error.printStackTrace();
            }

            return false;
        }
        return true;
    }



    /**
     * 在整个请求结束之后被调用
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}