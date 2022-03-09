package com.company;

public class Country {
    public String getShortState() {
        return shortState;
    }

    public void setShortState(String shortState) {
        this.shortState = shortState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getFullVat() {
        return fullVat;
    }

    public void setFullVat(double fullVat) {
        this.fullVat = fullVat;
    }

    public double getReducedVat() {
        return reducedVat;
    }

    public void setReducedVat(double reducedVat) {
        this.reducedVat = reducedVat;
    }

    public boolean isSpecialVat() {
        return specialVat;
    }

    public void setSpecialVat(boolean specialVat) {
        this.specialVat = specialVat;
    }

    public Country(String shortState, String state, double fullVat, double reducedVat, boolean specialVat) {
        this.shortState = shortState;
        this.state = state;
        this.fullVat = fullVat;
        this.reducedVat = reducedVat;
        this.specialVat = specialVat;
    }

    String shortState;
    String state;
    double fullVat;
    double reducedVat;
    boolean specialVat;

    @Override
    public String toString() {
        return "Country{" +
                "shortState='" + shortState + '\'' +
                ", state='" + state + '\'' +
                ", fullVat=" + fullVat +
                ", reducedVat=" + reducedVat +
                ", specialVat=" + specialVat +
                '}';
    }
}
