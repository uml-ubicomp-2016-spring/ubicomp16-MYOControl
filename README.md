Progress Report for UbiComp Project 

Group Members : 1) Siddhant Jaiswal 2) Saurabh Bindal 

Guidance by Professor Guenling Chen

Upto Week 3/21 Work done for the project was ..

Various Ideas for the Project were discussed with the professor for Ubicomp

Some of the Ideas Suggested were :

a) Intelligent Alarm system - Android App

b) Baby Tracker 

c) Activity suggestor at Workplaces.

d) Safe Driving (Camera App)- to awake user in case he falls asleep while driving.

After looking into various aspects concerning implementation, feasibility and Ubiquitous requiement of the Project

we along with the Professor decided to make use of the Myo to control an Android App  (https://www.myo.com/)


Week Progress : 3/21 to 3/27

Worked on Project to build camera on android App and use Myo ( https://www.myo.com/ )
to control the camera .

Made a  Ppt file with videos documenting the Progress.


Week Progress Report : 3/28 to  4/4 

Professor pointed out the lack of need to control camera with MYO ,suggested 
using Myo to control a Custom built Gallery on Android..

Project is split in 2 parts ,

a) Building an android photo gallery app - to be completed by Saurabh Bindal

b) Use the Myo given by professor to control the functionality of Photo Gallery App - to be completed by Siddhant Jaiswal



Saurabh-Code has been update for Gallery provided by Saurabh.


Siddhant - was able to succesfully connect myo with MYO Music App to control Spotify Music.

Myo Music App is provided by Thalmic Apps on their website, 
Installed this App to Familiarize myself with Myo connection with Android app
and the interface (as uptil now had used Myo to connect with desktop applications only).

Week Progress Report : 4/4 to  4/11

Saurabh-Code has been update for Gallery provided by Saurabh. Uploadled java.zip havin 4 jave files- ImageAdapter.java, MainActivity.java,MovingUnit.java and MovingView.java



Siddhant -Used helloWorld App given on Myo.com  to study connections and libraries on my part as Gallery app is being created by Saurabh(Team member)
MyDemo app successfully concects MyoControl with my android phone and is able to read gestures on the app.
(Will show it in class to Professor on 4/11.2016)
Will upload the code on github soon of MyoDemo (As code is borrowed from Myo.com no point uploading it)


Week Progress Report : 4/11 to 4/18


Siddhant - Was successfully able to use the code provided by Team member Saurabh Bindal (Compiled in Eclipse) in Android Studio.
Gallery App on Android has been connected with MYO. Currently the app is able to select images by gesturing left and right wave motion on MYO and selecting the appropriate Image by holding the fist gesture (Also have kept the code to see which gesture user is currently holding).
Work remaining is to somehow integrate the zoom fucntionality on a gesture from MYO , so that user is able to select the image and Zoom it too all using MYO.. 

The current code updated is under folder SID-MYO Gallery .. It is compiled code which successfullly generates an APK on mobile when used with usb debugging and run on Android Studio. Code does not run on Android Studio (AVD manager) Emulator as it requires Bluetooth connection which is not there on Emulator ..

References used till now to Compile the Code & understand Myo Working :

1)https://pathofacoder.com/2016/03/18/lets-write-code-for-myo-armband-android/

2) https://developer.thalmic.com/start/

3) https://developer.thalmic.com/docs/api_reference/android/_hello_world_activity_8java-example.html

Along with various other YouTube videos, StackOverflow to learn Android and Gallery App functionality


Week Progress Report : 4/19 to 4/25

Siddhant - Looked at various methods, approaches (codes) to implement Zoom functionality in the Gallery App.
Found Android Gallery functionality code which had required zoom functionality along with other features not required for our project.
Tried many times and was able to successfully implement zoom and sync it with Myo Spread Finger Gesture ..
Also to reset the Set zoom using close fist gesture which is a recognized gesture by MYO.

Looked at ways to change the android Icon launcher and have changed the App logo from simple Android Logo to UML Riverhawk logo for screen with various densiities ...

Current code is updated along with the zoom functionality and icon change on Github and is named Sid-Myo Gallery 2.0.

Saurabh: Worked on inputs provided by SIddhant while integrating  myo feature pointed towards some updates in movingview.java and movingunit.java file.
