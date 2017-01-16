package com.rmtd.melo.myobserver;

/**
 * Created by melo on 2017/1/16.
 * 观察者
 */
public interface Observer<T> {
    void onUpdate(Observable<T> observable, T data);
}
