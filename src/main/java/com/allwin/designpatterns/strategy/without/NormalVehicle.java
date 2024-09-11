package com.allwin.designpatterns.strategy.without;

public class NormalVehicle extends Vehicle {

    public NormalVehicle() {

    }

    @Override
    public void drive() {
        System.out.println( "Driving normally!!!" );
    }

    @Override
    public void display() {
        System.out.println("Normal Vehicle");
    }
}
