package com.braun.configue;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
*Class to handle the issues with cyrillic letters in this web app.
* To correctly set up charEncoding Apache Tomcat requires additional set up described here:
* https://stackoverflow.com/questions/138948/how-to-get-utf-8-working-in-java-webapps/138950#138950%5C
*/

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/save", "/", "/new", "/edit", "/delete"})
public class EncodingFilter extends GenericFilterBean {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
}
