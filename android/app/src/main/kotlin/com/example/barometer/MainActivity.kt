package com.example.barometer

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity(){
    //var == change it later
    //val to make it as final in dart
    private val PRESSURE_CAHNNEL_NAME="com.julow.barometer/pressure"
    private val METHOD_CHANNEL_NAME= "com.julow.barometer/method"

    private var methodChannel: MethodChannel? = null

   //bring a sensor manager
    private lateinit var sensorManager : SensorManager

    //excute this code in start up of the app

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
    //setup channels
    setupChannels(this,flutterEngine.dartExecutor.binaryMessenger)
    }
    private fun setupChannels(context: Context, messenger: BinaryMessenger){
        sensorManager= context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
       
        methodChannel = MethodChannel(messenger, METHOD_CHANNEL_NAME)
        methodChannel!!.setMethodCallHandler{
                call, result ->
                if(call.method=="isSensorAvailable"){
                    //ask for list that have pressure if it's empty thn we get false
                    result.success(sensorManager!!.getSensorList(Sensor.TYPE_PRESSURE).isNotEmpty())
        }else{
            result.notImplemented()
        }
        }


    }

    override fun onDestroy() {
        tearDownChannels()
        super.onDestroy()
    }


    private fun tearDownChannels(){
        methodChannel!!.setMethodCallHandler(null)
    }



}
