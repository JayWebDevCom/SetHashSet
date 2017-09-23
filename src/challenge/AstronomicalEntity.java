package challenge;

import java.util.HashSet;
import java.util.Set;

public final class AstronomicalEntity {
    private final String name;
    private final double orbitalPeriod;
    private final Set<AstronomicalEntity> satellites;
    private final BodyType bodyType;

    public AstronomicalEntity(String name, double orbitalPeriod, BodyType bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatelite(AstronomicalEntity moon){
        return this.satellites.add(moon);
    }

    public Set<AstronomicalEntity> getSatellites() {
        return new HashSet<AstronomicalEntity>(this.satellites);
        // creates a new hashset of the satellites
    }

    @Override
    public final boolean equals(Object obj) { // careful to override not overload
        if (this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());

        if (obj instanceof AstronomicalEntity) {
            AstronomicalEntity ae = (AstronomicalEntity) obj;
            if (this.name.equals(ae.getName())){
                return this.bodyType == ae.getBodyType();
            }
        }

        return false;
    }

    @Override
    public final int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + 57 + this.bodyType.hashCode(); // guarantees the return of a non-zero number
    }

    @Override
    public String toString() {
        return "AstronomicalEntity{" +
                "name='" + name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
              //  ", satellites=" + satellites +
                ", bodyType=" + bodyType +
                '}';
    }
}
