package spring.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private Logger logger;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        logger.error(String.format("Unsuccessful attempt to authenticate user with name:"
                        + " %s and password: %s, %s",
                request.getParameter("username"), request.getParameter("password"),
                exception.getMessage()));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getOutputStream()
                .println(new ObjectMapper().writeValueAsString(Map.of("timestamp",
                        Timestamp.valueOf(LocalDateTime.now()), "exception",
                        exception.getMessage())));
    }
}
