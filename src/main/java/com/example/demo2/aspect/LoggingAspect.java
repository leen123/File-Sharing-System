package com.example.demo2.aspect;

//import org.apache.log4j.Logger;

import com.example.demo2.model.entity.resours.Logging;
import com.example.demo2.repository.LoggingRepository;
import com.example.demo2.services.LoggingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;


@Aspect
@Component
public class LoggingAspect extends OncePerRequestFilter {

    @Autowired
    private ServletWebServerApplicationContext server;
    @Autowired
    private LoggingService loggingService;
    private String currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }

   //private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    Logger log = Logger.getLogger(String.valueOf(LoggingAspect.class));
    @Pointcut(" execution(* com.example.demo2.controller.AuthController.*(..) )" +
    "|| execution(* com.example.demo2.controller.FileController.*(..) )" +
            " || execution(* com.example.demo2.controller.GroupsController.*(..) )" +
            " || execution(* com.example.demo2.controller.UserController.*(..) )")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();

      //  log.info("method invoked " + className + " : " + methodName + "()" + "arguments : " + mapper.writeValueAsString(array) + " user: " + currentUser() + " port " + server.getWebServer().getPort() );
        return pjp.proceed();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(requestWrapper, responseWrapper);
        long timeTaken = System.currentTimeMillis() - startTime;
        if(loggingService.rateApiDay()>1000) throw new ServletException();

        String requestBody = getStringValue(requestWrapper.getContentAsByteArray(),
                request.getCharacterEncoding());
        String responseBody = getStringValue(responseWrapper.getContentAsByteArray(),
                response.getCharacterEncoding());
        Logging logging =Logging.builder().method(request.getMethod()).requestUri(request.getRequestURI()).requestPayload(requestBody).responseCode(response.getStatus()).timeTaken(timeTaken).build();
        loggingService.save(logging);
        logger.info(
                "FINISHED PROCESSING : METHOD="+request.getMethod()+";\n REQUESTURI="+request.getRequestURI()+"; REQUEST PAYLOAD="+requestBody+";\n RESPONSE CODE="+response.getStatus()+"; RESPONSE="+responseBody+"; TIM TAKEN="+timeTaken);
        responseWrapper.copyBodyToResponse();
    }

    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
        try {
            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}