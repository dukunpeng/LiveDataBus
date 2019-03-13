package com.mark.example.livedatabus;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * @author Mark
 * @Date on 2019/3/8
 **/
public class MyViewModle extends ViewModel {

   private MutableLiveData<String> text;

   public MutableLiveData<String> getText(){
      if (text==null){
         text  = new MutableLiveData<String>();
      }
      return text;
   }

}
