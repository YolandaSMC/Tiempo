package com.example.yolanda.ws;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Yolanda on 17/03/2016.
 */
public class AsyncCall extends AsyncTask<Object,Long,Object> {
    private String methodName;
    private Class<?>[] paramsClass;
    private CallbackListener listener;
    private long delaytime;

    public AsyncCall(String methodName, Class<?>[] paramsClass, CallbackListener listener, long delaytime) {
        this.methodName = methodName;
        this.paramsClass = paramsClass;
        this.listener = listener;
        this.delaytime = 0;
    }

    @Override
    protected Object doInBackground(Object... params) {
        if(this.delaytime>0){
            try {
                Thread.currentThread();
                Thread.sleep(delaytime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Method m=DataHandler.class.getDeclaredMethod(this.methodName,this.paramsClass);
            return  m.invoke(null,params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        if(o!=null){
            this.listener.onSuccess(this.methodName,o);
        }else{
            this.listener.onFails(this.methodName,o);
        }
        super.onPostExecute(o);
    }
}
