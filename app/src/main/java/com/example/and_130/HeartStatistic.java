package com.example.and_130;

public class HeartStatistic {
    private int highPressure;
    private int lowPressure;
    private int pulse;
    private boolean tahicardia;
    private String dateOfMeasurement;

    public String getDateOfMeasurement() {
        return dateOfMeasurement;
    }

    public HeartStatistic(int highPressure, int lowPressure, int pulse, boolean tahicardia, String dateOfMeasurement) {
        this.highPressure = highPressure;
        this.lowPressure = lowPressure;
        this.pulse = pulse;
        this.tahicardia = tahicardia;
        this.dateOfMeasurement = dateOfMeasurement;
    }

    @Override
    public String toString() {
        return
                "Верхнее давление=" + highPressure +
                ", Нижнее давление=" + lowPressure +
                ", пульс=" + pulse +
                ", тахикардия=" + tahicardia +
                ", дата измерений='" + dateOfMeasurement ;
    }
}
