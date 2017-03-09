package com.lee.demo.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Controller的日志切面（@Order(N)指定优先级，N小的切面优先执行，N可以为负数）
 * 使用方法：
 * 1）添加依赖spring-boot-starter-aop
 * 2）application.properties中可根据需要配置相关属性
 * 3）编写该Aspect
 *
 * 参考：http://412887952-qq-com.iteye.com/blog/2305333
 *
 * Created by hzlifan on 2017/3/9.
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

    private static final Logger logger    = LoggerFactory.getLogger(WebLogAspect.class);

    // 开始时间
    private ThreadLocal<Long>   beginTime = new ThreadLocal<Long>();

    /**
     * 切入所有Controller里面的公共方法
     */
    @Pointcut("execution(public * com.lee.demo.springboot.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 在切面之前执行
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录开始时间
        beginTime.set(System.currentTimeMillis());

        logger.info("aspect before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                    + joinPoint.getSignature().getName());
        logger.info("METHOD_ARGS : " + Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            logger.info(paraName + ": " + request.getParameter(paraName));
        }
    }

    /**
     * 在切面返回内容之后进行（打印结果、计算耗时）
     */
    @AfterReturning(pointcut = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) {
        logger.info("aspect after returning, ret = " + ret);
        logger.info("duration = {} millis", (System.currentTimeMillis() - beginTime.get()));
    }

}
