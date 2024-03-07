import 'dart:async';
import 'dart:ffi';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() => runApp(const MyApp());

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  //multiples async call
  static const methodchannel = MethodChannel('com.julow.barometer/method');
  static const pressureChannel = EventChannel("com.julow.barometer/pressure");

  String _sensorAvailable = 'unknown';
  double _pressureReading = 0;

  StreamSubscription? pressureSubsciption;

  Future<void> _checkAvailablity() async {
    print("btn pressed");
    try {
      var available = await methodchannel.invokeMethod('isSensorAvailable');
      setState(() {
        print(available);
        _sensorAvailable = available.toString();
      });
    } catch (e) {
      print(e);
    }
  }

  _startReading() {
    pressureSubsciption =
        pressureChannel.receiveBroadcastStream().listen((event) {
      setState(() {
        _pressureReading = event;
      });
    });
  }

  _stopReading() {
    setState(() {
      _pressureReading = 0;
    });
    try {
      pressureSubsciption!.cancel();
    } catch (e) {}
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Material App',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Material App Bar'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text('Sensor Available ?: $_sensorAvailable'),
              ElevatedButton(
                onPressed: () => _checkAvailablity(),
                child: Text('Chcek Sensor available'),
              ),
              SizedBox(
                height: 16,
              ),
              Text('sensor Reading : $_pressureReading'),
              ElevatedButton(
                onPressed: _startReading,
                child: Text('start REading'),
              ),
              ElevatedButton(
                onPressed: _stopReading,
                child: Text('stop REading'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
