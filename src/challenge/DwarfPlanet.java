package challenge;

public class DwarfPlanet extends AstronomicalEntity{

    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.DWARF_PLANET);
    }

    // no need to override add satellite
}
