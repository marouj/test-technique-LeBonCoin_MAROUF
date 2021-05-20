package com.leboncoin.technicaltest.model;
public class FireFighter {
    private int id;
    private String nom;
    private String team;

    public FireFighter() {
    }

    public FireFighter(int id, String nom, String team) {
        this.id = id;
        this.nom = nom;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    // Usefull for testing and adding methods
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FireFighter that = (FireFighter) o;
        return this.id == that.id || (this.nom.equals(that.nom) && this.team.equals(that.team));
    }
}
