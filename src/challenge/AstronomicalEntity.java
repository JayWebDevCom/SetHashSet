package challenge;

import java.util.HashSet;
import java.util.Set;

public abstract class AstronomicalEntity {
    private final double orbitalPeriod;
    final Set<AstronomicalEntity> satellites;
    private final Key key;


    public AstronomicalEntity(String name, double orbitalPeriod, BodyType bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = makeKey(name, bodyType);
    }

    public String getName(){
        return this.key.getName();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(AstronomicalEntity moon){
        return this.satellites.add(moon);
    }

    public Set<AstronomicalEntity> getSatellites() {
        return new HashSet<AstronomicalEntity>(this.satellites);
        // creates a new hashset of the satellites
    }

    public static Key makeKey(String name, BodyType bodytype){
        return new Key(name, bodytype);
    }

    public Key getKey() {
        return key;
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
            return this.key.equals(ae.getKey()); // compare by key
        }

        return false;
    }

    @Override
    public final int hashCode() {
        System.out.println("hashcode called");
//        return this.name.hashCode() + 57 + this.bodyType.hashCode(); // guarantees the return of a non-zero number
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return "AstronomicalEntity{" +
                "name='" + this.key.name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", satellites=" + satellites +
                ", bodyType=" + this.key.bodyType +
                '}';
    }

    public static final class Key {
        private String name;
        private BodyType bodyType;

        public Key(String name, BodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType()); // compare by bodyType of the Key
            }
            return false;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "name='" + name + '\'' +
                    ", bodyType=" + bodyType +
                    '}';
        }
    }

    public static enum BodyType {

        STAR(1), PLANET(2), DWARF_PLANET(3), MOON(4), COMET(5), ASTEROID(6);

        int type;

        BodyType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
}
