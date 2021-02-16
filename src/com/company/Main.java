package com.company;

public class Main {

    public static void main(String[] args) {
    
        Bicycle firstBike = new KidBicycle("David's bike",20);
        Bicycle secondBike = new AdultBicycle("Dad's bike",40);
        System.out.println(((IRun)firstBike).getName());
        System.out.println(((AdultBicycle)secondBike).getSpeed());
        secondBike.accelerate(10);
        System.out.println(((IRun)secondBike).getSpeed());
        secondBike.slowDown(5);
        System.out.println(((IRun)secondBike).getSpeed());



    }
}

interface IRun
{
    String getName();

    float getSpeed();

    float getWeight();

    int getPassengersCount();

    int getWheelsCount();
}

abstract class Mashine implements IRun{

    public final float MIN_SPEED = 0, MAX_SPEED = 80;
    public final int MIN_SEATS = 1, MAX_SEATS = 2;
    protected String name;
    protected float currentSpeed, weight;
    protected int wheelsCount, passengersCount;

    public String getName(){
        return name;
    }

    public Mashine(String name, int speed)
    {
        this.name = name;
        currentSpeed = speed;
    }
}

class Bicycle extends Mashine{


    public Bicycle(String name, int speed) {
        super(name, speed);
        wheelsCount = 2;
        weight = 15;
    }

    public void accelerate(float value)
    {
        currentSpeed += value;
    }

    public void slowDown(float value)
    {
        currentSpeed -= value;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public float getSpeed() {
        return currentSpeed;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public int getPassengersCount() {
        return passengersCount;
    }

    @Override
    public int getWheelsCount() {
        return wheelsCount;
    }
}

class KidBicycle extends Bicycle {
    public KidBicycle(String name, int speed) {
        super(name, speed);
        wheelsCount = 4;
        weight = 10;
    }
}

class AdultBicycle extends Bicycle {
    public AdultBicycle(String name, int speed) {
        super(name, speed);
        wheelsCount = 2;
        weight = 15;
    }
}