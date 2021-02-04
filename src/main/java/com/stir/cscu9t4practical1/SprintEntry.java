package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SprintEntry extends Entry {
    private int repetitions;
    private int recovery;

    public int getRepetitions() { return repetitions; }
    public int getRecovery() { return recovery; }

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
        super(n, d, m, y, h, min, s, dist);
        repetitions = rep;
        recovery = rec;
    } //constructor

    public String getEntry () {
        String result = getName()+" sprinted for " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //getEntry
}
