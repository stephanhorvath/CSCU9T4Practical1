package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SwimEntry extends Entry {

    private String where;

    public String getWhere() { return where; }

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String w) {
        super(n, d, m, y, h, min, s, dist);
        where = w;
    }


//        String expResult = "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n";

    public String getEntry () {
        String result = getName()+" swam " + getDistance() + " km " + getWhere() + " in "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //getEntry
}
