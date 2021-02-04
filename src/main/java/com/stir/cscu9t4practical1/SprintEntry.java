package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SprintEntry extends Entry {
    // additional variables for the sprinting entries
    private int repetitions;
    private int recovery;

    public int getRepetitions() { return repetitions; }
    public int getRecovery() { return recovery; }

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
        // pass to super constructor
        super(n, d, m, y, h, min, s, dist);
        repetitions = rep;
        recovery = rec;
    } //constructor

    // re-define the getEntry to use the additional variables
    public String getEntry () {
        String result = getName() +" sprinted " + getRepetitions() + "x" + (int)getDistance() + "m in "
                +getHour()+":"+getMin()+":"+ getSec() + " with " + getRecovery() + " minutes recovery on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //getEntry
}
