package com.nextlive.framework.widget;

public interface EventListener<T> {
    public abstract void onHandleEvent(Object sender, T data);
}
