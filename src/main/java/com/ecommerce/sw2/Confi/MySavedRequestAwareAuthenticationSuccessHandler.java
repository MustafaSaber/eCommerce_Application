package com.ecommerce.sw2.Confi;

import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.auth.LoggedUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

/*
To remove spring security redirect login
http://www.baeldung.com/securing-a-restful-web-service-with-spring-security
 */
public class MySavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");

        //System.out.println("Authentication Success");
        //LoggedUser userDetails = (LoggedUser) authentication.getPrincipal();
        //User user = userDetails.getUser();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LoggedUser user = (LoggedUser)auth.getPrincipal();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("password" ,  user.getUser().getPasswordHash());
        jsonObject.put("username" ,  user.getUser().getUsername());

        clearAuthenticationAttributes(request);
        response.getWriter().write(jsonObject.toString());
       //System.out.println(user.getUser().getUsername() + " IM NULL ");
       //getRedirectStrategy().sendRedirect(request, response, "/user");
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

}
