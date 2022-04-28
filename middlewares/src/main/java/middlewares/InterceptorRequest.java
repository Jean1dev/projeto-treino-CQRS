package middlewares;

import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.logging.log4j.LogManager.getLogger;

public class InterceptorRequest extends HandlerInterceptorAdapter {

    public static Logger LOGGER = getLogger(InterceptorRequest.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("InterceptorRequest->preHandle");
        return super.preHandle(request, response, handler);
    }
}
