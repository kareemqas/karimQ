package com.example.karimq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.FirebaseAnalytics.Param
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    private lateinit var button1 : Button
    private lateinit var button2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        analytics = Firebase.analytics
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)


        button1.setOnClickListener {

            selectContent("1","kareem","qasir")
        }
        button2.setOnClickListener {
            trackscreenEevent()
        }
    }
    fun selectContent (ID : String,name : String,content : String){

        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
            param(Param.ITEM_ID,ID)
            param(Param.ITEM_NAME,name)
            param(Param.CONTENT_TYPE,content)
        }



    }
    fun trackscreenEevent(){
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
            param(Param.SCREEN_NAME,"Main")
            param(Param.SCREEN_CLASS,"MainActivity")
        }
    }
}