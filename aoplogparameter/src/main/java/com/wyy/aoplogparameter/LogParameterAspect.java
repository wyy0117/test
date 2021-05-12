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

    /**
     * 注解在类上时生效
     */
    @Pointcut("@within(LogParameter)")
    public void logClass() {
    }

    @Before("logClass()")
    public void logClassParameter(JoinPoint joinPoint) {
        doLog(joinPoint);
    }

    /**
     * 注解在方法上时生效
     */
    @Pointcut("@annotation(LogParameter)")
    public void logMethod() {
    }

    @Before("logMethod()")
    public void logMethodParameter(JoinPoint joinPoint) {
        doLog(joinPoint);
    }

    private void doLog(JoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        //有缓存，不会每次new一个新的logger对象
        Logger logger = LoggerFactory.getLogger(targetClass);
        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();

        /**
         * 一个方法，log在一行中
         */
        Arrays.stream(args).forEach(arg -> {
            stringBuilder.append(arg.toString());
            stringBuilder.append(",");
        });
        String parameterStr = stringBuilder.substring(0, stringBuilder.length() - 1);
        logger.debug("{}->{}", methodName, parameterStr);
    }
}
