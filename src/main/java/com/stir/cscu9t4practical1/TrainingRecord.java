// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry

    public Entry lookupEntry (String n, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
                return current;
            }
        }
        return null;
    } // lookupEntry with name

    public String[] findAllEntries(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String[] allEntries = new String[tr.size()];
        for(int i = 0; i < allEntries.length; i++) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
                allEntries[i] = current.getEntry();
        }
        return allEntries;
    }

    public boolean removeEntry(Entry e) {
        for (int i = 0; i < tr.size(); i++) {
            if (tr.get(i)==e) {
                tr.remove(i);
                return true;
            }
        }
        return false;
    }
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord