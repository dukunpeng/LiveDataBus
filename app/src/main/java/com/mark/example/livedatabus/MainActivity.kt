package com.mark.example.livedatabus

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 *@author Mark
 *@Date on 2019/3/13
 **/
 class MainActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        click1.setOnClickListener {
            LiveDataBus.get().with("test").value = "我是点1"
        }
        click2.setOnClickListener {
            LiveDataBus.get().post("test","我是点2")
        }
        click3.setOnClickListener {
            LiveDataBus.get().post("test2","我是点3")
            click3.postDelayed({
                startActivity(Intent(application,SencondActivity::class.java))
            },1000)
        }
        LiveDataBus.get().with("test", String::class.java)
            .observe(this, Observer {
                text.text = it
            })

    }

}