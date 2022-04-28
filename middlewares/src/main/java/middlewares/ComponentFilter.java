package middlewares;

import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

import static org.apache.logging.log4j.LogManager.getLogger;

@Component
@Order(1)
public class ComponentFilter implements Filter {

    public static Logger LOGGER = getLogger(ComponentFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("ComponentFilter->doFilter");
        //filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        LOGGER.info("ComponentFilter->destroy");
        Filter.super.destroy();
    }
}
