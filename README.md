# PrasheebaB

Ex 1 : Behavioral Design Patterns:StrategyPattern.java,ObserverPattern.java

       Creational Design Patterns:Singleton Pattern.java,FactoryMethodPattern.java
       
       Structural Design Patterns:AdapterPattern.java,DecoratorPattern.java
       
1.Behavioral Design Patterns:
Observer Pattern: Demonstrated by a weather station system where multiple display units (observers) update when the weather changes.
Strategy Pattern: Demonstrated by a payment system that processes different payment methods.

2.Creational Design Patterns:
Singleton Pattern: Demonstrated by a logger system ensuring only one instance of the logger is used.
Factory Method Pattern: Demonstrated by a notification system that creates different types of notifications (email, SMS).

3.Structural Design Patterns:
Adapter Pattern: Demonstrated by an image viewer application that displays different image formats using a common interface.
Decorator Pattern: Demonstrated by a text editor that adds different features (bold, italic) to a text.

Ex 2 : 4. Smart Home System Programming Exercise:
 Problem Statement
 Create a simulation for a Smart Home System that allows the user to control different smart devices such as lights, thermostats, and door 
locks via a central hub. The user should be able to set schedules, automate tasks, and view the status of each device.

 Functional Requirements
 1. Initialize the Smart Home System with different devices, each having their own unique ID and type (light, thermostat, door lock).
 2. Implement features to:
 Turn devices on/off
 Schedule devices to turn on/off at a particular time
 Automate tasks based on triggers (e.g., turning off lights when the thermostat reaches a certain temperature)
 3. Optional: Provide the ability to add or remove devices dynamically.
    
 Key Focus
 1. Behavioral Pattern: Use the Observer Pattern to update all devices when a change occurs in the system.
 2. Creational Pattern: Use the Factory Method for creating instances of different smart devices.
 3. Structural Pattern: Use the Proxy Pattern to control access to the devices.
 4. OOP: Ensure strong encapsulation, modularity, and the application of inheritance and polymorphism.
