package com.mark.example.livedatabus;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Mark
 * @Date on 2019/3/8
 **/
public class SencondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TextView(this));
        LiveDataBus.get().with("test2").observe(this, new Observer<Object>() {
            @Override
            public void onChanged(@Nullable Object o) {
                Toast.makeText(SencondActivity.this,"===="+o.toString(),Toast.LENGTH_LONG).show();
            }
        });
        Log.e("","");
    }
}
