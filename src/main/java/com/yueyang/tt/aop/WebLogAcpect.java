package com.yueyang.tt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @program: IdleStudy
 * @description: ①
 * <p>
 * 在类上使用 @Component 注解 把切面类加入到IOC容器中
 * ② 在类上使用 @Aspect 注解 使之成为切面类
 * <p>
 * cglib包是用来动态代理用的,基于类的代理；
 * aspectjrt和aspectjweaver是与aspectj相关的包,用来支持切面编程的；
 * aspectjrt包是aspectj的runtime包；
 * aspectjweaver是aspectj的织入包；
 *
 *  @Pointcut定义的切入点为com.example.aop包下的所有函数做切人，
 *  通过 @Before实现切入点的前置通知，
 *  通过 @AfterReturning记录请求返回的对象。
 * @author: qinxiangyang
 * @create: 2020-05-18 10:56
 **/
@Component
@Aspect
public class WebLogAcpect {


    private Logger logger = LoggerFactory.getLogger(WebLogAcpect.class);


    /**
     * 定义切入点,切入点为com.yueyang.tt以下所有函数
     */
    @Pointcut("execution(public  * com.yueyang.tt..*.*(..))")
    public void webLog() {

    }

    /**
     * 前置通知，在连接点之前执行的通知
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //收到请求，记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();


        //记录请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("URI : " + request.getRequestURI().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }



}