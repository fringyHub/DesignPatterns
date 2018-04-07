package com.company;

interface Peripheral { void plugIn();}

class HeadPhone implements Peripheral {

    @Override
    public void plugIn() {
        System.out.println("I need 3.5mm HeadPhoneJack to plugin");
    }
}

interface Device { void connect(); }

class Phone implements Device {

    @Override
    public void connect() {
        System.out.println("I have only Type-C port");
    }
}

class Dongle implements Device {

    @Override
    public void connect() {

    }
}

public class AdaptorMain {
}
