package com.company;

import java.util.HashSet;
import java.util.Set;

public final class AstronomicalEntity {
    private final String name;
    private final double orbitalPeriod;
    private final Set<AstronomicalEntity> satellites;

    public AstronomicalEntity(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(AstronomicalEntity moon){
        return this.satellites.add(moon);
    }

    public Set<AstronomicalEntity> getSatellites() {
        return new HashSet<AstronomicalEntity>(this.satellites);
        // creates a new hashset of the satellites
    }

    @Override
    public boolean equals(Object obj) { // careful to override not overload
        if (this == obj) {
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((AstronomicalEntity) obj).getName();
        return this.getName().equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + 57; // guarantees the return of a non-zero number
    }
}
