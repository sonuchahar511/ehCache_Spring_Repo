package com.chahar.customannotation;

public class JsonFieldAnnotationApp {

    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("Maruti Suzuki Wagnr");
        car.setModel("7 generation");
        car.setYear("2019");
        car.setColour("White");

        try {
            String serializedCar = new JsonFieldProcessSerializer().serialize(car);
            System.out.println("serializedCar: " + serializedCar);
        } catch (JsonSerializeException e) {
            e.printStackTrace();
        }

    }

}
