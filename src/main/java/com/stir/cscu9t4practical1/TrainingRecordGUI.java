// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.util.regex.Pattern;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    String[] entryTypes = {"Cycle", "Sprint", "Swim"};
    String[] terrainTypes = {"dirt", "asphalt", "track" };
    String[] tempoTypes = {"easy", "moderate", "intense"};
    String[] whereOptions = {"pool", "outdoors"};

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField rep = new JTextField(2);
    private JTextField rec = new JTextField(2);
    private JComboBox entryType = new JComboBox(entryTypes);
    private JComboBox terrainType = new JComboBox(terrainTypes);
    private JComboBox tempoType = new JComboBox(tempoTypes);
    private JComboBox where = new JComboBox(whereOptions);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labrep = new JLabel(" Repetitions :");
    private JLabel labrec = new JLabel(" Recovery :");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton removeEntry = new JButton("Remove Entry");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(entryType);
        entryType.addActionListener(this);
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(terrainType);
        add(tempoType);
        add(labrep);
        add(rep);
        rep.setEditable(true);
        labrep.setVisible(false);
        rep.setVisible(false);
        add(labrec);
        add(rec);
        rec.setEditable(true);
        labrec.setVisible(false);
        rec.setVisible(false);
        add(where);
        where.setVisible(false);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(removeEntry);
        removeEntry.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            String type = (String) entryType.getSelectedItem();
            // call nameValidator to match with valid regex
            if(nameValidator() && timeValidator() && dateValidator()) {
                message = addEntry(type);
            } else {
                message = "Invalid Input, please try again";
            }
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            // message = "Not Implemented Yet";
            message = findAllEntries();
        }
        if (event.getSource() == removeEntry) {
            removeEntry();
        }
        if (event.getSource() == entryType) {
            if (entryType.getSelectedItem().equals("Cycle")) {
                labrep.setVisible(false);
                rep.setVisible(false);
                labrec.setVisible(false);
                rec.setVisible(false);
                where.setVisible(false);
                labdist.setText("Distance (km):");
                terrainType.setVisible(true);
                tempoType.setVisible(true);
            } else if (entryType.getSelectedItem().equals("Sprint")) {
                terrainType.setVisible(false);
                tempoType.setVisible(false);
                where.setVisible(false);
                labdist.setText("Distance (m):");
                labrep.setVisible(true);
                rep.setVisible(true);
                labrec.setVisible(true);
                rec.setVisible(true);
            } else {
                labrep.setVisible(false);
                rep.setVisible(false);
                labrec.setVisible(false);
                rec.setVisible(false);
                terrainType.setVisible(false);
                tempoType.setVisible(false);
                labdist.setText("Distance (km):");
                where.setVisible(true);

            }
        }

        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        Entry e = entryTypeGenerator(n, m, d, y, km, h, mm, s);
        boolean success = myAthletes.addEntry(e);
        if (success) {
            return message;
        } else {
            message = "Record already exists - unable to add";
        }
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String findAllEntries() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up all entries ...");
        String[] entries = myAthletes.findAllEntries(d, m , y);
        String concatEntries = "";
        for (int i = 0; i < entries.length; i++) {
            concatEntries = concatEntries + entries[i] + "\n";
        }
        return concatEntries;
    }

    public void removeEntry() {
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("removing entry ...");
        Entry entryToRemove = myAthletes.lookupEntry(n, d, m, y);
        boolean success = myAthletes.removeEntry(entryToRemove);
        if (success) {
            outputArea.setText("Entry successfully removed.");
        } else {
            outputArea.setText("Entry either not found or unable to be removed");
        }
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

    public Entry entryTypeGenerator(String n, int m, int d, int y, float km, int h, int mm, int s) {
        Entry entry;
        if (entryType.getSelectedItem().equals("Cycle")) {
            String terrain = String.valueOf(terrainType.getSelectedItem());
            String tempo = String.valueOf(tempoType.getSelectedItem());
            entry = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
        } else if (entryType.getSelectedItem().equals("Sprint")) {
            int repetitions = Integer.parseInt(rep.getText());
            int recovery = Integer.parseInt(rec.getText());

            entry = new SprintEntry(n, d, m, y, h, mm, s, km, repetitions, recovery);
        } else {
            String w = String.valueOf(where.getSelectedItem());
            entry = new SwimEntry(n, d, m, y, h, mm, s, km, w);
        }
        return entry;
    }

    public boolean nameValidator() {
        boolean proceed = false;
        String n = name.getText();
        Pattern pattern;
        // regex pattern - must start with A-Z and have only a-z and spaces
        pattern = Pattern.compile("^[A-Z][a-z]*\\s[A-Z][a-z]*$");
        if(pattern.matcher(n).matches()) {
            // returns true if name matches regex
            proceed = true;
            return proceed;
        }
        // return false if name does not match regex
        return proceed;
    }

    public boolean timeValidator() {
        boolean proceed = false;
        String h = hours.getText();
        String m = mins.getText();
        String s = secs.getText();
        Pattern pattern;
        // regex pattern - match the boundary starting from 0 to 9,
        // then from [0 to 5] first digit followed  by [0 to 9] second digit,
        // in case someone inputs 0, 00 up to 59, and finally 60
        pattern = Pattern.compile("([0-9]|[0-5][0-9]|60)");
        if(pattern.matcher(h).matches() && pattern.matcher(m).matches() && pattern.matcher(s).matches()) {
            // returns true if name matches regex
            proceed = true;
            return proceed;
        }
        // return false if numbers do not match regex
        return proceed;
    }

    public boolean dateValidator() {
        boolean proceed = false;
        String d = day.getText();
        String m = month.getText();
        String y = year.getText();
        Pattern patternDay;
        Pattern patternMonth;
        Pattern patternYear;
        // match might have preceding 0, from 1 to 9, 1st digit 1 OR 2, 2nd digit 0 to 9, or 30 OR 31
        patternDay = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])$");
        // match might have preceding 0, from 1 to 9, 1st digit 1, 2nd digit 0 to 2
        patternMonth = Pattern.compile("^(0?[1-9]|1[0-2])$");
        // match 19 or 20, followed by two of 0 to 9
        patternYear = Pattern.compile("^(?:19|20)[0-9]{2}$");
        if(patternDay.matcher(d).matches() && patternMonth.matcher(m).matches() && patternYear.matcher(y).matches()) {
            // returns true if each pattern matches valid range
            proceed = true;
            return proceed;
        }
        // return false if dates do not match regex
        return proceed;
    }

} // TrainingRecordGUI

