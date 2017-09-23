package challenge;

public class Planet extends AstronomicalEntity {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(AstronomicalEntity moon) {
        if (moon.getKey().getBodyType() == BodyType.MOON) {
            return this.satellites.add(moon);
        } else {
            return false;
        }
    }
}
