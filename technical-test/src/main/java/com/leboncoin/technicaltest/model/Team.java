package com.leboncoin.technicaltest.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Team {

    private ArrayList<FireFighter> devs;
    private FireFighter currentDev;
    private LocalDate currentDate;
    private boolean updateDev;

    public Team(ArrayList<FireFighter> devs, LocalDate currentDate) {
        this.devs = devs;
        this.currentDate = currentDate;
        // Sort devs by name
        Collections.sort(devs, Comparator.comparing(FireFighter::getNom));
        this.currentDev = devs.get(0);
        this.updateDev = false;
    }

    public List<FireFighter> getDevs() {
        return devs;
    }

    public void setDevs(ArrayList<FireFighter> devs) {
        this.devs = devs;
    }

    public FireFighter getCurrentDev() {
        return currentDev;
    }

    public void setCurrentDev(FireFighter currentDev) {
        this.currentDev = currentDev;
    }

    public boolean addDev(FireFighter fireFighter){
        // Check if the new FireFighter is not already in team
        for(FireFighter f : devs){
            if(f.equals(fireFighter)){
                return false;
            }
        }
        // Then add it and sort again list of devs
        this.devs.add(fireFighter);
        Collections.sort(this.devs, Comparator.comparing(FireFighter::getNom));
        return true;
    }

    public FireFighter updateCurrentFireFighter(LocalDate d){
        // Check if it's a new day
        if(this.currentDate.isBefore(d)){
            this.currentDate = d;
            // Return the next dev
            this.currentDev = (devs.indexOf(this.currentDev)+1) == devs.size() ?  devs.get(0) : devs.get(devs.indexOf(this.currentDev)+1);
        }
        // If it's same day return the same FireFighter
        return this.currentDev;


    }
}
