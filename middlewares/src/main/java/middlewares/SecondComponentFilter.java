package middlewares;

import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

import static org.apache.logging.log4j.LogManager.getLogger;

@Component
@Order(2)
public class SecondComponentFilter implements Filter {

    public static Logger LOGGER = getLogger(SecondComponentFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("SecondComponentFilter->doFilter");
    }
}
