package com.nextlive.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ApiParam {

    public enum Type {
        HEADER, FORM, QUERY
    }

    public Type type() default Type.HEADER;
    public String key();
    public int order() default 0;

}