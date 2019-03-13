package com.mark.example.livedatabus;

import android.arch.lifecycle.MutableLiveData;
import android.os.Looper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @Date on 2019/3/8
 **/
public class LiveDataBus {

    private static LiveDataBus instance;

    private Map<String,MutableLiveData> mLiveDatas;

    private LiveDataBus(){

        mLiveDatas = new HashMap<>();
    }

    public static LiveDataBus get(){
        if (instance==null){
            synchronized (LiveDataBus.class){
                instance = new LiveDataBus();
            }
        }
        return instance;
    }

    public <T> MutableLiveData<T> with(String key,Class<T> classType){

        if (!mLiveDatas.containsKey(key)){

            mLiveDatas.put(key,new CommonMutableLiveData<Object>());
        }
        return  mLiveDatas.get(key);
    }
    public CommonMutableLiveData<Object> with(String key){
        return (CommonMutableLiveData<Object>) with(key,Object.class);
    }

    public <T> void post(String key, T t) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            with(key).setValue(t);
        } else {
            with(key).postValue(t);
        }
    }
}
