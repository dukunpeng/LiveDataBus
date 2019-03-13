package com.mark.konwledge.konwledgestack

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mark.example.livedatabus.LiveDataBus
import com.mark.example.livedatabus.R
import com.mark.example.livedatabus.SencondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
                startActivity(Intent(application, SencondActivity::class.java))
            },1000)
        }
        LiveDataBus.get().with("test", String::class.java)
            .observe(this, Observer {
                text.text = it
            })



}
}