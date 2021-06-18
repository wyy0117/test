package com.wyy.filtertest;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckPermission {

    enum Scope {
        ROSTER, HOST
    }

    Scope[] scope() default {};

    int tokenIndex();
}
