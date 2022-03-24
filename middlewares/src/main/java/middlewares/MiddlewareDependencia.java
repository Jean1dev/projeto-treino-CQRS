package middlewares;

import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.logging.log4j.LogManager.getLogger;

public class MiddlewareDependencia extends OncePerRequestFilter {

    public static Logger LOGGER = getLogger(MiddlewareDependencia.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("MiddlewareDependencia->doFilterInternal");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
