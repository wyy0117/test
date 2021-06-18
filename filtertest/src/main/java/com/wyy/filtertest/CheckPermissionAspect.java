package com.wyy.filtertest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckPermissionAspect {

    @Pointcut("@annotation(CheckPermission)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void checkPermission(JoinPoint joinPoint) {
        CheckPermission checkPermission = ((MethodSignature) joinPoint.getSignature()).getMethod().getDeclaredAnnotation(CheckPermission.class);
        if (checkPermission != null) {
            int tokenIndex = checkPermission.tokenIndex();
            Object[]  args = joinPoint.getArgs();
            String token = args[tokenIndex].toString();
            System.out.println("token = " + token);
            CheckPermission.Scope[] scopes = checkPermission.scope();
            for (CheckPermission.Scope scope : scopes) {
                System.out.println("scope.name() = " + scope.name());
            }
        }
    }
}
