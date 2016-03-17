package com.example.yolanda.ws;

/**
 * Created by Yolanda on 17/03/2016.
 */
public interface CallbackListener {
    void onSuccess(String methodname, Object o);
    void onFails(String methodname, Object o);
}
