package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class CycleEntry extends Entry {
    private String name;
    private Calendar dateAndTime;
    private float distance;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist) {
        super(n, d, m, y, h, min, s, dist);
        // name = n;
        // Calendar inst = Calendar.getInstance();
        // inst.set(y, m-1, d, h, min, s);
        // dateAndTime = inst;
        // distance = dist;
    } //constructor

    public String getEntry () {
        String result = getName()+" cycled " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //getEntry

}
