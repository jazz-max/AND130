package com.example.and_130;

public class VitalStatistic {
    private double weight;
    private int steps;
    private String dateOfMeasurement;


    public VitalStatistic(double weight, int steps, String dateOfMeasurement) {
        this.weight = weight;
        this.steps = steps;
        this.dateOfMeasurement = dateOfMeasurement;
    }

    @Override
    public String toString() {
        return "вес=" + weight +
                ", шаги=" + steps +
                ", дата измерений='" + dateOfMeasurement ;
    }
}
