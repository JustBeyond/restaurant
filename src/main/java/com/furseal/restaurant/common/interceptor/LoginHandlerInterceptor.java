package com.furseal.restaurant.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author hejishan
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            /*RbzAdminAcct rbzAdminAcct = (RbzAdminAcct) request.getSession().getAttribute("adminAcct");
            Map<Long, RbzAdminAcct> onlineMobileMap = LoginServiceImpl.onlineMobileMap;
            Long onlineInfoId = (Long) request.getSession().getAttribute("onlineInfoId");
            if (rbzAdminAcct != null && onlineInfoId != null && onlineMobileMap.get(onlineInfoId) != null
                    && onlineMobileMap.get(onlineInfoId).getMobile().equals(rbzAdminAcct.getMobile())) {
                return true;
            }
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/");
            return false;*/
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
