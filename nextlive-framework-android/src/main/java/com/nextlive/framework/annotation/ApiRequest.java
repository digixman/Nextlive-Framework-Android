package com.nextlive.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//import com.android.volley.Request.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ApiRequest {
    public int method() default 0; //Method.GET;
    public String url() default "";
}
