package com.example.tp3;

public class Etablissement {
    private String label;
    private String name;
    private int img;
    private double lon;
    private double lat;

    public Etablissement(String label, String name, int img, double lon, double lat)
    {
        this.label=	label;
        this.name=	name;
        this.img=img;
        this.lon=lon;
        this.lat=lat;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}