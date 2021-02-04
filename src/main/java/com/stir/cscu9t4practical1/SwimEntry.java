package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SwimEntry extends Entry {

    // additional variables for the swimming entries
    private String where;

    public String getWhere() { return where; }

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String w) {
        super(n, d, m, y, h, min, s, dist);
        where = w;
    }

    // re-define the getEntry to use the additional variable
    public String getEntry () {
        String result = getName()+" swam " + getDistance() + " km " + getWhere() + " in "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //getEntry
}
