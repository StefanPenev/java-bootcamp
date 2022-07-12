package com.bootcamp3.MoonlightHotelAndSpa.exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.bootcamp3.MoonlightHotelAndSpa.constant.ExceptionConstant.ACCESS_DENIED_LOGIN_FIRST;

@Component
public class CustomHttp403ForbiddenEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        response.getWriter().print(ACCESS_DENIED_LOGIN_FIRST);
    }
}
