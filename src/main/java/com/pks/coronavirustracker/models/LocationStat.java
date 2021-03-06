package com.pks.coronavirustracker.models;

public class LocationStat {

    private String state = "";
    private String country = "";
    private int latestTotalcases = 0;
    private int diffFromPreviousDay = 0;

    public int getDiffFromPreviousDay() {
        return diffFromPreviousDay;
    }

    public void setDiffFromPreviousDay(int diffFromPreviousDay) {
        this.diffFromPreviousDay = diffFromPreviousDay;
    }



 

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalcases() {
        return latestTotalcases;
    }

    public void setLatestTotalcases(int latestTotalcases) {
        this.latestTotalcases = latestTotalcases;
    }


    @Override
    public String toString() {
        return "LocationStat{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalcases=" + latestTotalcases +
                '}';
    }
}
