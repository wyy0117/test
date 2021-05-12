package com.wyy.aoplogparameter;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class LogParameterAspect {

    @Pointcut("@within(LogParameter)")
    public void logClass() {
    }

    @Before("logClass()")
    public void logClassParameter(JoinPoint joinPoint) {
        doLog(joinPoint);
    }

    private void doLog(JoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        //有缓存，不会每次new一个新的logger对象
        Logger logger = LoggerFactory.getLogger(targetClass);
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg -> {
            logger.debug("{}->{}", methodName, arg.toString());
        });
    }

    @Pointcut("@annotation(LogParameter)")
    public void logMethod() {
    }

    @Before("logMethod()")
    public void logMethodParameter(JoinPoint joinPoint) {
        doLog(joinPoint);
    }
}
