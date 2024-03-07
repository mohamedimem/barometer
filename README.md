# Barometer

[Pressure Sensor](docs/Pressure%20Sensor%20e483001ea92a4732aa5bfab73a0cce5e.csv)

## Pressure sensor in Flutter

I’ve spent the past year knowing about   “How to use access Sensor in Flutter” and “how to use JAVA/KOTLIN with flutter” … i always what in to try that.

So here i am today using it Flutter and Kotlin to get the value of Pressure Sensor of the device.

I will break down step by step what i did and what i Learned:

# how to set this up as an Expert

- create Flutter project
- go to “android” Folder in your main flutter project , Right-click , and “open with Android Studio”

# now You Have Android Studio in Front of you

- we will write the code in Kotlin so don’t worry if you don’t know much about it
1. we declare variable for method_channel_Name using (val==final)
2. now we’re gonna create a function called setupChannels() : will return yes or false for the availability of pressure sensor

we will use SensorManager you can read more about it here

[https://developer.android.com/reference/android/hardware/SensorManager](https://developer.android.com/reference/android/hardware/SensorManager)

1. call the setup channels on the main function in KOTLIN which is : configureFlutterEngine (will be overrided)
2. create a function for destrying the method channel and call it in “ondestroy()”

- [ ]  search more about some functionallity and data type in Kotlin
