package com.example.barometer

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.icu.util.DateInterval
import io.flutter.plugin.common.EventChannel

class streamHandler (private val sensorManager: SensorManager, sensorType:Int,private var interval: Int =SensorManager.SENSOR_DELAY_NORMAL ):EventChannel.StreamHandler,SensorEventListener{

    private val sensor =sensorManager.getDefaultSensor(sensorType)
    override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
        TODO("Not yet implemented")
    }

    override fun onCancel(arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        TODO("Not yet implemented")
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}