package com.tts.mapsapp.models;

public class Geocoding {
    
    private Geometry geometry;


    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Geocoding() {
    }
    
    @Override
    public String toString() {
        return "Geocoding [geometry=" + geometry + "]";
    }

 

    
}
