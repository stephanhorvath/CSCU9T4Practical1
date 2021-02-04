package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class CycleEntry extends Entry {
    private String terrain;
    private String tempo;

    public String getTerrain() { return terrain; }
    public String getTempo() { return tempo; }

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String trrn, String t) {
        super(n, d, m, y, h, min, s, dist);
        terrain = trrn;
        tempo = t;
    } //constructor

    //        String expResult = "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n";
    public String getEntry () {
        String result = this.getName()+" cycled " + this.getDistance() + " km in "
                +this.getHour()+":"+this.getMin()+":"+ this.getSec() + " on "
                +this.getDay()+"/"+this.getMonth()+"/"+this.getYear()+" on "
                + getTerrain() + " at " + getTempo() + " tempo\n";
        return result;
    } //getEntry

}
