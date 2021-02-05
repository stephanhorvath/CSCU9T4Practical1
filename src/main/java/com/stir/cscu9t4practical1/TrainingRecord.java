// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public boolean addEntry(Entry e){
        // if list is bigger or equal than one, evaluate
        if (tr.size() >= 1) {
            // check if Entry already exists
            if (!isExistingEntry(e)) {
                // add entry and return true to exit block
                tr.add(e);
                return true;
            } else {
                // return false if entry exists
                System.out.println("Error - entry already exists");
                return false;
            }
        } else {
            // if the list is less than 1, then it is empty, add Entry automatically
            tr.add(e);
            return true;
        }
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

    /**
     * Returns reference to Entry that was found with parameters
     * @param n = name
     * @param d = day
     * @param m = month
     * @param y = year
     * @return
     */
    public Entry lookupEntry (String n, int d, int m, int y) {
        // iterate through list
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            // if entry is found with same name, day, month, year, return that Entry
            if (current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
                return current;
            }
        }
        return null;
    } // lookupEntry with name

    /**
     * Checks if Entry already exists
     * @param existing Entry
     * @return boolean
     */
    public boolean isExistingEntry (Entry existing) {
        // iterate through list
        ListIterator<Entry> iter = tr.listIterator();
        boolean exists = false;
        while (iter.hasNext()) {
            Entry current = iter.next();
            // if Entry has same name, day, month, year and class, it already exists
            if (current.getName().equals(existing.getName()) &&
                current.getDay()==existing.getDay() &&
                current.getMonth()==existing.getMonth() &&
                current.getYear()==existing.getYear() &&
                current.getClass()==existing.getClass()) {
                exists = true;
                break;
            }
        }
        return exists;
    } // isExistingEntry

    /**
     * Returns array of Entry strings
     * @param d = day
     * @param m = month
     * @param y = year
     * @return String[]
     */
    public String[] findAllEntries(int d, int m, int y) {
        // iterate through list
        ListIterator<Entry> iter = tr.listIterator();
        // create new String array with size of original list
        // there cannot be more entries with the same date than total entries in the list
        String[] allEntries = new String[tr.size()];
        for(int i = 0; i < allEntries.length; i++) {
            Entry current = iter.next();
            // compare day/month/year and add it's getEntry to array
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
                allEntries[i] = current.getEntry();
        }
        return allEntries;
    }

    /**
     * Receives an Entry and removes it from the list
     * @param e = Entry
     * @return boolean
     */
    public boolean removeEntry(Entry e) {
        // iterate through list
        for (int i = 0; i < tr.size(); i++) {
            // as 'e' is a reference and not a value,
            // exact Entry object can be found and removed with index
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